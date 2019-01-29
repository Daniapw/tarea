<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="iso-8859-1"/>
	
	<xsl:template match="/gormitis">
	
		<html>
		<head>
		<style>
			<xsl:call-template name="css"/>
		</style>
		</head>
		
		<body>
			
			<!-- Primera tabla -->
			<div id="tabla1">	
			
				<table border="2 px solid">
					<tr id="filaTitulos">
						<th></th>
						<th>Gormiti</th>
						<th>Tribu</th>
					</tr>
					<xsl:for-each select="gormiti">
						<xsl:choose>
							<xsl:when test="position() mod 2 = 1">
								<xsl:call-template name="gormitiTabla">
									
									<xsl:with-param name="color">#b7cff7</xsl:with-param>
									<xsl:with-param name="imagen"><xsl:value-of select="."/></xsl:with-param>
									<xsl:with-param name="tribu"><xsl:value-of select="@tribu"/></xsl:with-param>
								
								</xsl:call-template>
							</xsl:when>
							
							<xsl:otherwise>
								
								<xsl:call-template name="gormitiTabla">
									
									<xsl:with-param name="color">#ffffff</xsl:with-param>
									<xsl:with-param name="imagen"><xsl:value-of select="."/></xsl:with-param>
									<xsl:with-param name="tribu"><xsl:value-of select="@tribu"/></xsl:with-param>
								
								</xsl:call-template>
							
							</xsl:otherwise>
							
						</xsl:choose>
					</xsl:for-each>
				
				</table>
			</div><br></br>
			
			<!-- Segunda tabla -->
			<div id="divMapa">
				
				<table id="tablaMapa" border="1px solid">
					<xsl:attribute name="background"><xsl:value-of select = "tablero/@url"/></xsl:attribute>
					
					<!-- Fila 1 -->
					<tr>
						
						<xsl:call-template name="celda">
							
							<xsl:with-param name="x">1</xsl:with-param>						
							<xsl:with-param name="y">1</xsl:with-param>						
						
						</xsl:call-template>
					
						<xsl:call-template name="celda">
							
							<xsl:with-param name="x">2</xsl:with-param>						
							<xsl:with-param name="y">1</xsl:with-param>						
						
						</xsl:call-template>

						<xsl:call-template name="celda">
							
							<xsl:with-param name="x">3</xsl:with-param>						
							<xsl:with-param name="y">1</xsl:with-param>						
						
						</xsl:call-template>						
						
					</tr>
					
					<!-- Fila 2 -->
					<tr>
						
						<xsl:call-template name="celda">
							
							<xsl:with-param name="x">1</xsl:with-param>						
							<xsl:with-param name="y">2</xsl:with-param>						
						
						</xsl:call-template>
					
						<xsl:call-template name="celda">
							
							<xsl:with-param name="x">2</xsl:with-param>						
							<xsl:with-param name="y">2</xsl:with-param>						
						
						</xsl:call-template>

						<xsl:call-template name="celda">
							
							<xsl:with-param name="x">3</xsl:with-param>						
							<xsl:with-param name="y">2</xsl:with-param>						
						
						</xsl:call-template>						
						
					</tr>
					
					<!-- Fila 3 -->
					<tr>
						
						<xsl:call-template name="celda">
							
							<xsl:with-param name="x">1</xsl:with-param>						
							<xsl:with-param name="y">3</xsl:with-param>						
						
						</xsl:call-template>
					
						<xsl:call-template name="celda">
							
							<xsl:with-param name="x">2</xsl:with-param>						
							<xsl:with-param name="y">3</xsl:with-param>						
						
						</xsl:call-template>

						<xsl:call-template name="celda">
							
							<xsl:with-param name="x">3</xsl:with-param>						
							<xsl:with-param name="y">3</xsl:with-param>						
						
						</xsl:call-template>						
						
					</tr>
				</table>
			
			
			
			
			</div>			
		</body>
		
		</html>
	
	
	</xsl:template>
	
	<!-- Template primera tabla -->
	<xsl:template name="gormitiTabla">
		<xsl:param name="color"/>
		<xsl:param name="imagen"/>
		<xsl:param name="tribu"/>
	
		<tr>
				
			<xsl:attribute name="bgcolor"><xsl:value-of select="$color"/></xsl:attribute>			
			<td class="td1"> <b><xsl:value-of select="position()"/></b></td>
			<td class="tdImagenes"><img src="{$imagen}"/></td>
			<td><xsl:value-of select="$tribu"/></td>
		</tr>
		
	</xsl:template>
	
	
	
	<!-- Template tabla mapa -->
	
	<xsl:template name="celda">
		<xsl:param name="x"/>
		<xsl:param name="y"/>
		
		<td>
			<xsl:for-each select="tablero/gormitiEnMapa">
			
				<xsl:choose>
				
					<xsl:when test="@x = $x and @y = $y and @tribu ='volcan'">
					
						<img src="{../../gormiti[1]/.}"/>
					
					</xsl:when>
				
					<xsl:when test="@x = $x and @y = $y and @tribu ='agua'">
					
						<img src="{../../gormiti[2]/.}"	/>
					
					</xsl:when>
					
					<xsl:when test="@x = $x and @y = $y and @tribu ='aire'">
					
						<img src="{../../gormiti[3]/.}"	/>
					
					</xsl:when>

					<xsl:when test="@x = $x and @y = $y and @tribu ='bosque'">
					
						<img src="{../../gormiti[4]/.}"	/>
					
					</xsl:when>

					<xsl:when test="@x = $x and @y = $y and @tribu ='montana'">
					
						<img src="{../../gormiti[5]/.}"	/>
					
					</xsl:when>
				</xsl:choose>
			</xsl:for-each>	
		
		</td>
	
	</xsl:template>
	
	
	
	<!-- Template css -->
	<xsl:template name="css">
		<!-- CSS de la primera tabla -->
		#tabla1{
		
			margin:auto;
			width:50%;
			
			
		}
		
		#tabla1 table{
		
			border-color: #7aacff;
			border-collapse: collapse;
			font-size:16px;
			font-family:'Arial', Helvetica,sans-serif;
		}
		
		#tabla1 tr{
			
			border-bottom: 2px solid  #7aacff;
			
		
		}
		
		#tabla1 img{
		
		 	width:80%;
		 	
		}
		
		
		#filaTitulos{
		
			color:white;
			background-color: #2176ff;
			font-weight:bold;
			
			
		}
		
		.td1{
			border-color:white;
			width:30px;
			text-align:center;
			vertical-align:top;
			font-weight:bold;
		}
		
		.tdImagenes{
			
			border-right: 1px solid white;
			width: 20%;
			text-align:center;
		}
		
		<!-- CSS de la segunda tabla -->
		#divMapa{
			
			margin:auto;
			width:70%;
			height: 85%;	
		}
		
		
		
		#tablaMapa{
			
			background-repeat: no-repeat;
			background-size:100%;
			border-collapse:collapse;
			border-color: black;
			text-align:center;
			width:100%;
			height:100%;
			
		}
		
		#tablaMapa td{
			
			width:33%;
			
		}
		
		
		#tablaMapa img{
			
			width:40%;
			
		}
		
	</xsl:template>
</xsl:stylesheet>