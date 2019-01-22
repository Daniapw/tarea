<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="iso-8859-1"/>
	
	<xsl:template match="/gormitis">
	
		<html>
		
		<body>
				
			<table border="1px">
				
				<th></th>
				<th>Gormiti</th>
				<th>Tribu</th>
				
				<xsl:for-each select="gormiti">
					
					<xsl:call-template name="gormitiTabla">
					
						<xsl:with-param name="imagen"><xsl:value-of select="."/></xsl:with-param>
						<xsl:with-param name="tribu"><xsl:value-of select="@tribu"/></xsl:with-param>
					
					</xsl:call-template>
				
				</xsl:for-each>
			
			</table>
			
			
		</body>
		
		</html>
	
	
	</xsl:template>
	
	<xsl:template name="gormitiTabla">
		<xsl:param name="imagen"/>
		<xsl:param name="tribu"/>
	
		<tr>
			<td></td>
			<td><img src="{$imagen}"/></td>
			<td><xsl:value-of select="$tribu"/></td>
		</tr>
		
	</xsl:template>
</xsl:stylesheet>