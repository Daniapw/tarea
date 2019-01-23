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
			
			<div id="tabla1">	
			
				<table border="1 px">
					
					<th></th>
					<th>Gormiti</th>
					<th>Tribu</th>
					
					<xsl:for-each select="gormiti">
						<xsl:choose>
							<xsl:when test="position() mod 2 = 1">
								<xsl:call-template name="gormitiTabla">
									
									<xsl:with-param name="color">#afceff</xsl:with-param>
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
			</div>			
		</body>
		
		</html>
	
	
	</xsl:template>
	
	<xsl:template name="gormitiTabla">
		<xsl:param name="color"/>
		<xsl:param name="imagen"/>
		<xsl:param name="tribu"/>
	
		<tr>
				
			<xsl:attribute name="bgcolor"><xsl:value-of select="$color"/></xsl:attribute>			
			<td class="td1"> <b><xsl:value-of select="position()"/></b></td>
			<td><img src="{$imagen}"/></td>
			<td><xsl:value-of select="$tribu"/></td>
		</tr>
		
	</xsl:template>
	
	<xsl:template name="css">
		
		#tabla1{
		
			margin:auto;
			width:50%;
			
		}
		
		#tabla1 table{
		
			text-align:center;
			
		}
		
		
		#tabla1 img{
		
		 	width:20%;
		 	
		}
		
		.td1{
			
			width:40px;
			text-align:left;
			
		}
		
		
	</xsl:template>
</xsl:stylesheet>