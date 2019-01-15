<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="iso-8859-1"/>
	<xsl:template match="/biblioteca">
		<html>
		
		<head>
		</head>
		<body>

			<xsl:for-each select="libro">
			<xsl:sort select="titulo" order="descending"/>
				<table width = "30%" border="1px">
					<tr>
						<th>Título</th>
						<th>Autor</th>
						<th>Fecha de publicación</th>
					</tr>
					<tr>
						<td><xsl:value-of select="titulo"/></td>
						<td><xsl:value-of select="autor"/>-<xsl:value-of select="autor/@fechaNacimiento"/></td>
						<td><xsl:value-of select="fechaPublicacion/@año"/></td>
					</tr>
				</table><br/>			
			</xsl:for-each>
		
		</body>
		
		</html>
	</xsl:template>
</xsl:stylesheet>