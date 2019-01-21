<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="iso-8859-1"/>
	
	<xsl:template match="/ordenadores">
		<xsl:for-each select="ordenador">
			
			<table border="1px" style="border-collapse:collapse">
				
				<tr>
					<th colspan="5">Ordenador</th>
				</tr>
				
				<tr>
					
					<th>Procesador</th>
					<th>RAM</th>
					<th>ROM</th>
					<th>HDD</th>
					<th>Transporte</th>
				
				</tr>
			
				<tr>
					<td> <xsl:value-of select="procesador/@generacion"/> - <xsl:value-of select="procesador"/> </td>
					
					<xsl:apply-templates select="RAM | ROM | HDD"/>
					
					<td>
						
						<table border="1px" style="border-collapse:collapse">
							<tr>
								<th>Localidad</th>
								<th>Fecha</th>
							</tr>
							
							<xsl:for-each select="transporte/localidad">
								
								<tr>
									<td><xsl:value-of select="."/></td>
									<td><xsl:value-of select="@fechaSalida"/></td>
								</tr>
								
							</xsl:for-each>
						
						</table>
					
					</td>
				</tr>
			
			</table><br></br>
		
		</xsl:for-each>
	</xsl:template>
	
	<xsl:template match="RAM | ROM | HDD">
		
		<td>
			<table border ="1px" style="border-collapse:collapse">
				
				<tr>
					<th>Tipo</th>
					<td><xsl:value-of select="tipo"/></td>
				</tr>
				
				<tr>
					<th>Capacidad</th>
					<td><xsl:value-of select="capacidad"/></td>
				</tr>				
				
			
			</table>
		</td>
	
	</xsl:template>
	
</xsl:stylesheet>