<marvel>{
for $superheroe in doc('Ejercicio-xQuery.xml')/marvel/superheroe
where contains(lower-case($superheroe/@poderes), 'fuerza')
and contains($superheroe/@amigos, "Iron Man")
return $superheroe
}
</marvel>