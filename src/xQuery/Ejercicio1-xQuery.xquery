<marvel>{
for $superheroe in doc('Ejercicio-xQuery.xml')/marvel/superheroe
where ends-with($superheroe/@nombre, 'a')
return $superheroe
}
</marvel>