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
	         	
	         	<for-each select="noticias/noticia">
	         		
	         		<div></div>
	         		
	         	
	         	</for-each>
	         	
	         </div>
	         
		</div>
		</body>
		</html>
	
	</xsl:template>


	<xsl:template name="menu">
		<xsl:param name="color"/>
	   	
        <li style="background: {$color};"><a href="@href"><xsl:value-of select="."/></a></li>
            
	</xsl:template>
	
	
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