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
			
				<table border="3 px solid">
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
			<td class="tdImagenes"><img src="{$imagen}"/></td>
			<td><xsl:value-of select="$tribu"/></td>
		</tr>
		
	</xsl:template>
	
	<xsl:template name="css">
		
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
			
			border:2px solid #7aacff;
			
		
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
			
			width:30px;
			text-align:center;
			vertical-align:top;
			font-weight:bold;
		}
		
		.tdImagenes{
		
			width: 20%;
			text-align:center;
		}
		
	</xsl:template>
</xsl:stylesheet>