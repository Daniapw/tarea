<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="iso-8859-1"/>
		
	<xsl:template match="/primerDia1DAW">
		
		<html>
			<xsl:call-template name="css"/>
		<head>
		</head>
		
		<body>
		
			<!-- Horario -->
			<div id="horario">
				<table id="horario" border="1px solid">
				
					<xsl:apply-templates select="horario/dia"/>
				
				</table>
			</div>
			<br></br>
			
			<!-- Diagrama clase -->
			
			<div id="diagrama">
			
				<table id="diagrama" border="1px solid">
					
					<!-- Fila 1 -->
						<xsl:call-template name="bucleForFila">
							<xsl:with-param name="i">1</xsl:with-param>
						</xsl:call-template>
				
				</table>
			
			</div>
		</body>
		
		</html>
		
	</xsl:template>
	
	
	<!-- Template horario -->
	<xsl:template match="horario/dia">

		<tr>
		
			<td class="dia"><xsl:value-of select="@desc"/></td>
			
			<xsl:for-each select="hora">
				<xsl:sort select="@orden" order="ascending"/>
				<xsl:choose>
					<xsl:when test=". = 'ENT DES'">
						<xsl:call-template name="hora">
							<xsl:with-param name="materia">EDD</xsl:with-param>
						</xsl:call-template>
					</xsl:when>

					<xsl:when test=". = 'FOL'">
						<xsl:call-template name="hora">
							<xsl:with-param name="materia">FOL</xsl:with-param>
						</xsl:call-template>
					</xsl:when>
	
					<xsl:when test=". = 'PROG'">
						<xsl:call-template name="hora">
							<xsl:with-param name="materia">PROGR</xsl:with-param>
						</xsl:call-template>
					</xsl:when>
					
					<xsl:when test=". = 'SIST INF'">
						<xsl:call-template name="hora">
							<xsl:with-param name="materia">SINF</xsl:with-param>
						</xsl:call-template>
					</xsl:when>
					
					<xsl:when test=". = 'LMSGI'">
						<xsl:call-template name="hora">
							<xsl:with-param name="materia">LDM</xsl:with-param>
						</xsl:call-template>
					</xsl:when>
		
					<xsl:when test=". = 'BBDD'">
						<xsl:call-template name="hora">
							<xsl:with-param name="materia">BDD</xsl:with-param>
						</xsl:call-template>
					</xsl:when>
				</xsl:choose>
			</xsl:for-each>
		</tr>
	
	</xsl:template>
	
	<!-- Template hora -->
	<xsl:template name="hora">
		<xsl:param name="materia"/>
		
		<td class="{$materia}"><xsl:value-of select="."/></td>
	
	</xsl:template>
	
	<!-- Template diagrama de la clase -->
	<xsl:template name="diagrama">
		<xsl:param name="x"/>
		<xsl:param name="y"/>
		
		<td>
			<!-- Bucle para ver si hay una pared, ventana o puerta -->
			<xsl:for-each select="estructuraAula/bloque">
			
				<xsl:if test="$x = @x and $y=@y">
					
					<xsl:call-template name="tipoColor">
						<xsl:with-param name="tipo"><xsl:value-of select="@tipo"/></xsl:with-param>
					</xsl:call-template>
					
					<xsl:value-of select="@tipo"/>
				</xsl:if>	
			</xsl:for-each>
			
			<!-- Bucle para ver si hay un alumno/a -->
			<xsl:for-each select="alumnado/alumno">
			
				<xsl:choose>
				
					<xsl:when test="$x = @x and $y=@y and @sexo = 'M'">
						
						<xsl:attribute name="bgcolor">lightblue</xsl:attribute>
						<img src="{../imagen[1]/.}"/>
						<xsl:value-of select="."/>
					
					</xsl:when>
					
					<xsl:when test="$x = @x and $y=@y and @sexo = 'H'">
					
						<xsl:attribute name="bgcolor">#ff7272</xsl:attribute>
						<img src="{../imagen[2]/.}"/>
						<xsl:value-of select="."/>						
					
					</xsl:when>
				</xsl:choose>
			
			</xsl:for-each>
		</td>
	</xsl:template>
  
  <!-- Bucle for -->
  <xsl:template name="bucleForFila">
  	<xsl:param name="i"/>
  	<xsl:if test="$i &lt;= 11">
  		<tr>
	  		<xsl:call-template name="bucleForColumna">
	  			<xsl:with-param name="i"><xsl:value-of select="$i"/></xsl:with-param>
	  			<xsl:with-param name="j">1</xsl:with-param>
	  		</xsl:call-template>
	  		<xsl:call-template name="bucleForFila">
	  			<xsl:with-param name="i"><xsl:value-of select="$i + 1"/></xsl:with-param>
	  		</xsl:call-template>
  		</tr>
  	</xsl:if>
  </xsl:template>
	
  <!-- Bucle for para columna -->
  <xsl:template name="bucleForColumna">
  	<xsl:param name="i"/>
  	<xsl:param name="j"/> 
  	<xsl:if test="$j &lt;= 8">
  		<xsl:call-template name="diagrama">
  			<xsl:with-param name="x"><xsl:value-of select="$j"/></xsl:with-param>
  			<xsl:with-param name="y"><xsl:value-of select="$i"/></xsl:with-param>
  		</xsl:call-template>
  		<xsl:call-template name="bucleForColumna">
  			<xsl:with-param name="i"><xsl:value-of select="$i"/></xsl:with-param>
  			<xsl:with-param name="j"><xsl:value-of select="$j + 1"/></xsl:with-param>
  		</xsl:call-template>
  	</xsl:if>
  </xsl:template>
  
  
	<!-- Template para el tipo de celda -->
	<xsl:template name="tipoColor">
		<xsl:param name="tipo"/>
		
		<xsl:for-each select="/primerDia1DAW/estructuraAula/color">
			
			<xsl:if test="$tipo = @tipo">

				<xsl:attribute name="bgcolor"><xsl:value-of select="."/></xsl:attribute>
	
			</xsl:if>
			
		</xsl:for-each>
		
	</xsl:template>
	
	
	<!-- CSS -->
	<xsl:template name="css">
		
		<style>
			
			<!-- Tabla horario -->
			#horario{
			
				margin:auto;
				text-align:center;
				
			}
			
			#horario table{
			
				border-collapse:collapse;
			
			}
			
			.dia{
			
				font-weight:bold;
			
			}
			
			.EDD{
				
				color:darkgreen;
				
			}
			
			.FOL{
				
				color:orange;
				
			}
			
			.BDD{
				
				color:red;
				
			}
			
			.SINF{
				
				color:blue;
				
			}
		
			.PROGR{
				
				color:darkred;
				
			}
			
			.LDM{
				
				color:magenta;
				
			}
			
			<!-- Tabla diagrama -->
			
			#diagrama{
				
				text-align:center;
				margin:auto;
				
			}
			
			#diagrama table{
				
				border-collapse:collapse;
				
			}
			
			#diagrama table td{
			
				height:60px;
				width:80px;
			}
			
			#diagrama table tr{
				height: 60px;
			}
			
			#diagrama img{
				width:60px;
			}
		</style>
	
	</xsl:template>
</xsl:stylesheet>