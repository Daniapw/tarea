<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="iso-8859-1"/>
		
	<xsl:template match="/callejero">
		<html>
		<head>
		</head>
		
		<body>
		
			<div id="primeraTabla">
			
				<table border="1px">
				
					<xsl:apply-templates/>
				
				</table>
			
			</div>
			
		</body>
		
		</html>
		
		
	</xsl:template>
</xsl:stylesheet>