<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="iso-8859-1"/>
	
	<!--Template Principal-->
	<xsl:template match="/ligaEndesa">
		<html>
		<head>
			<title>Baloncesto</title>
			
		<style>
			
			li{

				color:red;
				font-weight:bold;
				font-size:22px;
			}

		</style>
		
		</head>
		
		<body>
		
			<ol type="I">
				
				<xsl:apply-templates select="fechaCreacion"/>
				<xsl:apply-templates select="nombreCompleto"/>
			</ol>
		
		
		
		</body>
		
		</html>
		
		
	</xsl:template>
	
	<!-- Template fecha -->
	<xsl:template match="fechaCreacion">
		
		<li> <xsl:value-of select="."/> </li>
		
	</xsl:template>
	
	<!-- Template nombre -->
	<xsl:template match="nombreCompleto">
		
		<li> <xsl:value-of select="."/> </li>
		
	</xsl:template>
	
	<!-- Template equipos -->
	<xsl:template match="equipos">
		
		<table>
			<tr>
				<td>Nombre:</td>
			</tr>
			
			<tr>
				<td><xsl:value-of select="nombreEquipo0"/></td>
			</tr>
		
		</table>
		
	</xsl:template>
	
	
</xsl:stylesheet>