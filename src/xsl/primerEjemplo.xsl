<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="iso-8859-1"/>
	
	<!-- Template principal -->
	<xsl:template match="/navidad">
		<html>
		<head></head>
		
		<body>
		
			<ul>
			
				<xsl:apply-templates/>
				
			</ul>
		
		</body>
		
		</html>
	
	
	</xsl:template>
	
	<!-- Template de almuerzo -->
	<xsl:template match="almuerzo">
	
		<li>Primer plato: <xsl:value-of select="primerPlato"/></li>
		<li>Segundo plato: <xsl:value-of select="segundoPlato"/></li>
		<li>Postre: <xsl:value-of select="postre"/></li>
		<li>Bebida: <xsl:value-of select="bebida"/></li>
		<li>Sobremesa: <xsl:apply-templates select="sobremesa"/></li>
	
	</xsl:template>
	
	<!-- Template de sobremesa -->
	<xsl:template match="sobremesa">
	
		<ol>
			<li><xsl:value-of select="primeraCopa"/></li>
			<li><xsl:value-of select="segundaCopa"/></li>
			<li><xsl:value-of select="terceraCopa"/></li>
		</ol>

	</xsl:template>
	
</xsl:stylesheet>