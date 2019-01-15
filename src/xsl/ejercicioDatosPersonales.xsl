<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="iso-8859-1"/>
	<xsl:template match="/alumno">
	
		<table border="1px">
			<tr>
				<th>Nombre</th>
				<th>DNI</th>
				<th>Dirección</th>
				<th>Telefono</th>
			</tr>
			<tr>
				
				<xsl:apply-templates/>
				
			</tr>
		</table>
		
	</xsl:template>
	
	<!-- Template de nombre -->
	<xsl:template match="nombre">
		
		<td><xsl:value-of select="."/></td>
		<td><xsl:value-of select="../@dni"/></td>
	
	</xsl:template>
	
	<!-- Template direccion -->
	<xsl:template match="direccion">
		
		<td>
			<table border="1px">
			
				<xsl:apply-templates/>
				
			</table>
		</td>
		
	</xsl:template>
	
	<!-- Template direccion/calle -->
	<xsl:template match="direccion/calle">
		
		<tr>
			<th>Calle</th>
			<td><xsl:value-of select="."/></td>
		</tr>
		
	</xsl:template>
	
	<!-- Template direccion/numero -->
	<xsl:template match="direccion/numero">
		
		<tr>
			<th>Número</th>
			<td><xsl:value-of select="."/></td>
		</tr>
		
	</xsl:template>
	
	<!-- Template direccion/ciudad -->
	<xsl:template match="direccion/ciudad">
		
		<tr>
			<th>Ciudad</th>
			<td><xsl:value-of select="."/></td>
		</tr>
		
	</xsl:template>
	
	<!-- Template direccion/provincia -->
	<xsl:template match="direccion/provincia">
		
		<tr>
			<th>Provincia</th>
			<td><xsl:value-of select="."/></td>
		</tr>
		
	</xsl:template>
	
	<!-- Template de telefono -->
	<xsl:template match="telefono">
		
		<td><xsl:value-of select="."/></td>
	
	</xsl:template>
</xsl:stylesheet>