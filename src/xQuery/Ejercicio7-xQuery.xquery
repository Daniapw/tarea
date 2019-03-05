<html>

<head>

    <title>Ejercicio 7 XQuery Daniel Ruiz Hidalgo</title>

</head>

<body>

    {for $superheroe in doc('Ejercicio-xQuery.xml')/marvel/superheroe
    return 
    <div style="margin-top:10px">
        <table align="center" border="1">
        
            <tr>
            
                <td colspan="2" style="text-align:center">
                
                    <p><b>{data($superheroe/@nombre)}</b></p>
                
                </td>
            
            </tr>
        
                
            <tr>
            
                <td>
                
                    <p><b>Poderes</b></p>
                
                </td>
               
               <td>
                
                    <p>{data($superheroe/@poderes)}</p>
                
               </td>
               
            </tr>
        
            <tr>
            
                <td>
                
                    <p><b>Amigos</b></p>
                
                </td>
               
               <td>
                
                    <p>{data($superheroe/@amigos)}</p>
                
               </td>
               
            </tr>
            <tr>
            
                <td>
                
                    <p><b>Nivel</b></p>
                
                </td>
               
               <td>
                
                    <p>{data($superheroe/@nivel)}</p>
                
               </td>
               
            </tr>
            
        </table>
        
    </div>
    }
    
</body>

</html>