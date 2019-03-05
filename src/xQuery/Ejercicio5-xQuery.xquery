<marvel>{
for $marvel in doc('Ejercicio-xQuery.xml')/marvel
let $media := avg($marvel/superheroe/@nivel)
return <mediaNivel>{data($media)}</mediaNivel>}
</marvel>