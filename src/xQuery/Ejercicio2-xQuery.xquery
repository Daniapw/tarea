<marvel>{
for $superheroe in doc('Ejercicio-xQuery.xml')/marvel/superheroe
where contains($superheroe/@poderes, 'fuerza')
or contains($superheroe/@poderes, 'Fuerza')
return $superheroe
}
</marvel>