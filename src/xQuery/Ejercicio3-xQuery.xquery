<marvel>{
for $superheroe in doc('Ejercicio-xQuery.xml')/marvel/superheroe
where contains($superheroe/@poderes, 'fuerza')
or contains($superheroe/@poderes, 'Fuerza')
and contains($superheroe/@amigos, "Iron Man")
return $superheroe
}
</marvel>