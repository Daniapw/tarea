<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="iso-8859-1"/>
		
	<xsl:template match="/periodico">
		<html>
			
			<xsl:call-template name="headYCSS"/>
		
		<body>
		 <div style="width: 1000px; margin: 0 auto;">
		 
		 	<!-- Logo -->
	         <div style="width: 1000px;"><img src="{@logo}" width="997" height="115"/></div>
	         
	        <!-- Menu -->
	         <div id="menu" style="width: 1000px; margin: 0px; padding: 0px;">
				
				<ul>
					<!-- Bucle para hacer los elementos del menu -->
				 	<xsl:for-each select="menu/enlace">
				 		
				 		<xsl:choose>
				 		
				 			<!-- Cuando la posicion del elemento enlace es impar se llamara a la template "menu"
				 			con el valor #DDE640 para el parametro color -->
				 			<xsl:when test="position() mod 2 = 1">
				 			
				 				<xsl:call-template name="menu">
				 					
				 					<xsl:with-param name="color">#DDE640</xsl:with-param>
				 				
				 				</xsl:call-template>
				 			
				 			</xsl:when>	
				 			
				 			<!-- Si no es impar se le llamara con el color #F27E2B -->
				 			<xsl:otherwise>
				 			
				 				<xsl:call-template name="menu">
				 					
				 					<xsl:with-param name="color">#F27E2B</xsl:with-param>
				 				
				 				</xsl:call-template>
				 			
				 			</xsl:otherwise>
				 		
				 		</xsl:choose>
				 	
				 	</xsl:for-each>
				</ul>	
				
	         </div>
	         
	         <!-- Noticias -->
	         <div style="width: 700px; float: left;">
	         	
	         	<!-- Bucle para las noticias -->
	         	<xsl:for-each select="noticias/noticia">
	         		
					<xsl:choose>
						<!-- Si el atributo dobleAncho es "s" se llamara a la template clase con el parametro noticiaDobleAncho -->
						<xsl:when test="@dobleAncho = 's'">
					
							<xsl:call-template name="noticias">
								
								<xsl:with-param name="clase">noticiaDobleAncho</xsl:with-param>
								
							</xsl:call-template>
							
						</xsl:when>
						
						<!-- Si el atributo dobleAncho es "n" se llamara a la template clase con el parametro noticia -->
						<xsl:otherwise>
						
							<xsl:call-template name="noticias">
								
								<xsl:with-param name="clase">noticia</xsl:with-param>
								
							</xsl:call-template>
					
						</xsl:otherwise>
						
					</xsl:choose>
	         	
	         	</xsl:for-each>
	         	
	         </div>
	         
	         <!-- Anuncios -->
	         <div style="width: 295px; float: right;">
	         
	         	<!-- Bucle para los anuncios -->
	         	<xsl:for-each select="publicidad/anuncio">
	         		
	         		<!-- Se ordenaran segun el valor del atributo orden -->
	         		<xsl:sort select="@orden" order="descending"/>
	         		
	         			<div class="divPublicidad">
	         			
	         				<img src="{@imagen}" width="280px"/>
	         			
	         			</div>
	         	
	         	</xsl:for-each>
	         
	         </div>
	         
		</div>
		</body>
		</html>
	
	</xsl:template>

	<!-- Template del menu -->
	<xsl:template name="menu">
		<xsl:param name="color"/>
	   	
        <li style="background: {$color};"><a href="@href"><xsl:value-of select="."/></a></li>
            
	</xsl:template>
	
	<!-- Template de noticias -->
	<xsl:template name="noticias">
		<xsl:param name="clase"/>
		
			 <div class="{$clase}">
			 
			 	<h2><xsl:value-of select="titular"/></h2>
			 	<h4><xsl:value-of select="subtitular"/></h4>
				<img src="{@imagen}"/><br></br>
				<span class="fechaNoticia">Publicado el <xsl:value-of select="@fecha"></xsl:value-of></span>
				<span class="comentariosNoticia"><xsl:value-of select="@comentarios"/> comentarios</span>
			
			</div>
	
	</xsl:template>
	
	<!-- Template del head y css -->
	<xsl:template name="headYCSS">
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
     	<title>El mundo yesterday</title>
     	<style type="text/css">
	         body {
	         font-family: Arial;
	         font-size: 12px;
	         }
	         
	         ol, ul
	         {
	         margin-top: 10px;
	         margin-left: 0px;
	         }
	         
	         #menu li
	         {
	         margin-left: 0px;
	         display: inline;
	         list-style-type: none;
	         padding: 10px 50px;
	         }
	         
	         .noticia {
	         /* border: #000 solid 1px; */
	         padding: 10px 5px;
	         float: left; 
	         width: 338px;
	         }
	         
	         .noticia img {
	         width: 338px;
	         }
	         
	         .noticiaDobleAncho {
	         /* border: #000 solid 1px; */
	         padding: 10px 5px;
	         float: left; 
	         width: 690px;
	         }
	         
	         .noticiaDobleAncho img {
	         width: 690px;
	         }
	         
	         .fechaNoticia {
	         color: #A3A34B;
	         }
	         
	         .comentariosNoticia {
	         color: #A3A34B;
	         padding-left: 20px;
	         }
	         
	         .divPublicidad {
	         /* border: #000 solid 1px; */
	         padding: 10px 5px;
	         float: right; 
	         width: 280px;                    }
	         }
	         
	         .divPublicidad img {
	         width: 200px;
	         }
		</style>
		</head>	
	
	</xsl:template>
	
</xsl:stylesheet>