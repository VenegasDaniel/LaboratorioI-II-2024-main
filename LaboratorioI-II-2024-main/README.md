
# Laboratorio I-2024
## <sup>Asignatura: Patrones de Software y Programación </sup> <br><sup>Profesor: Daniel San Martín</sup> <br> <sup> Daniel Venegas Sanhueza:</sup>
<hr>
Dado el enunciado a continuación, implemente el patrón de diseño que usted considere necesario
para dar solución al requerimiento. Además, explique porqué escogió el patrón, cual es su característica
donde se clasifica el patrón y porqué da solución a la problemática.
<hr>

# Enunciado

Una empresa de desarrollo de software ha sido contratada para implementar una 
solución que gestione el acceso a una biblioteca digital de recursos multimedia y sus
usuarios. La bilioteca incluye imágenes, vídeos y documentos donde algunos podrían encontrarse protegidos.

El sistema debe permitir buscar usuarios en distintas fuentes de datos. Además, se debe controlar 
el acceso a los archivos multimedia que están protegidos. Solo usuarios con los permisos adecuados deben 
poder abrir y visualizar los archivos protegidos.

Su tarea es diseñar una solución que permita lo siguiente:

 * Buscar un usuario en la base de datos, si este no existe, el sistema debe buscar 
en el archivo *externo.csv* de manera transparente. La clase *Util* contiene el método para 
buscar usuarios en archivos csv.
 * Controlar el acceso a los archivos protegidos para asegurar que solo usuarios con 
permisos válidos puedan visualizarlos. El sistema debe mostrar mensajes que indicando si existen 
los permisos o no, de acuerdo al archivo asignado por defecto.

## Guías

1. Utilize el paquete interfaz para implementar las interfaces que estime conveniente.
2. Puede modificar todo el código para lograr su propósito si estima conveniente. 

<hr>

## Explicación

Se nos pidio realizar una busqueda de usuarios en una base de datos, los cuales en el sistema contienen
permisos para la visualizacion de los recursos. cosa que para el patron proxy esta hecho, crea una 
capa intermedia que controla el acceso a los datos y a los recursos multimedia. Este patrón es 
particularmente útil cuando se quiere implementar un control de acceso (nuestro caso), 
optimizar recursos o realizar operaciones adicionales antes o después de que una acción sea ejecutada,
sin modificar el objeto real. Lo otro que hace optimo a este patron, es que no necesita conocer la logica de 
de busqueda de usuarios, podemos agregar futuras modificaciones sin tocar el codigo ya hecho.


<hr>