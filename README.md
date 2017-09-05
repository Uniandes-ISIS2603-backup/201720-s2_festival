# Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-festival-de-cine)
	- [Recurso Silla](#recurso-silla)
		- [GET /sillas](#get-sillas)
		- [GET /sillas/{id}](#get-sillasid)
		- [POST /sillas](#post-sillas)
		- [PUT /sillas/{id}](#put-sillasid)
		- [DELETE /sillas/{id}](#delete-sillasid)
		- [GET sillas/{sillasid}/boleta](#get-sillassillasidboleta)
		- [POST sillas/{sillasid}/boleta](#post-sillassillasidboleta)
		- [PUT sillas/{sillasid}/boleta](#put-sillassillasidboleta)
		- [DELETE sillas/{sillasid}/boleta](#delete-sillassillasidboleta)
		- [GET sillas/{sillasid}/función](#get-sillassillasidfunción)
		- [POST sillas/{sillasid}/función](#post-sillassillasidfunción)
		- [PUT sillas/{sillasid}/función](#put-sillassillasidfunción)
		- [DELETE sillas/{sillasid}/función](#delete-sillassillasidfunción)
	- [Recurso Espectador](#recurso-espectadores)
		- [GET /espectadores](#get-espectadores)
		- [GET /espectadores/{id}](#get-espectadoresid)
		- [POST /espectadores](#post-espectadores)
		- [PUT /espectadores/{id}](#put-espectadoresid)
		- [DELETE /espectadores/{id}](#delete-espectadoresid)
		- [GET espectadores/{espectadoresid}/boleta](#get-espectadoresespectadoresidboleta)
		- [POST espectadores/{espectadoresid}/boleta](#post-espectadoresespectadoresidboleta)
		- [PUT espectadores/{espectadoresid}/boleta](#put-espectadoresespectadoresidboleta)
		- [DELETE espectadores/{espectadoresid}/boleta](#delete-espectadoresespectadoresidboleta)
		- [GET espectadores/{espectadoresid}/función](#get-espectadoresespectadoresidfunción)
		- [POST espectadores/{espectadoresid}/función](#post-espectadoresespectadoresidfunción)
		- [PUT espectadores/{espectadoresid}/función](#put-espectadoresespectadoresidfunción)
		- [DELETE espectadores/{espectadoresid}/función](#delete-espectadoresespectadoresidfunción)
	- [Recurso Crítico](#recurso-critico)
		- [GET /criticos](#get-criticos)
		- [GET /criticos/{id}](#get-criticosid)
		- [POST /criticos](#post-criticos)
		- [PUT /criticos/{id}](#put-criticosid)
		- [DELETE /criticos/{id}](#delete-criticosid)
		- [GET /criticos/{criticosid}/critica](#get-criticoscriticosidcritica)
		- [POST /criticos/{criticosid}/critica](#post-criticoscriticosidcritica)
		- [PUT /criticos/{criticosid}/critica](#put-criticoscriticosidcritica)
		- [DELETE /criticos/{criticosid}/critica](#delete-criticoscriticosidcritica)
		- [GET /criticos/{criticosid}/pelicula](#get-criticoscriticosidpelicula)
		- [POST /criticos/{criticosid}/pelicula](#post-criticoscriticosidpelicula)
		- [PUT /criticos/{criticosid}/pelicula](#put-criticoscriticosidpelicula)
		- [DELETE /criticos/{criticosid}/pelicula](#delete-criticoscriticosidpelicula)
	- [Recurso Crítica](#recurso-crítica)
		- [GET /críticas](#get-críticas)
		- [GET /críticas/{id}](#get-críticasid)
		- [POST /críticas](#post-críticas)
		- [PUT /críticas/{id}](#put-críticasid)
		- [DELETE /críticas/{id}](#delete-críticasid)
		- [GET críticas/{críticasid}/función](#get-críticascríticasidfunción)
		- [POST críticas/{críticasid}/función](#post-críticascríticasidfunción)
		- [PUT críticas/{críticasid}/función](#put-críticascríticasidfunción)
		- [DELETE críticas/{críticasid}/función](#delete-críticascríticasidfunción)
		- [GET críticas/{críticasid}/crítico](#get-críticascríticasidcrítico)
		- [POST críticas/{críticasid}/crítico](#post-críticascríticasidcrítico)
		- [PUT críticas/{críticasid}/crítico](#put-críticascríticasidcrítico)
		- [DELETE críticas/{críticasid}/crítico](#delete-críticascríticasidcrítico)
	- [Recurso Calificacion](#recurso-calificacion)
		- [GET /calificaciones](#get-calificaciones)
		- [GET /calificaciones/{id}](#get-calificacionesid)
		- [POST /calificaciones](#post-calificaciones)
		- [PUT /calificaciones/{id}](#put-calificacionesid)
		- [DELETE /calificaciones/{id}](#delete-calificacionesid)
	- [Recurso Funcion](#recurso-funcion)
		- [GET /funciones](#get-funciones)
		- [GET /funciones/{id}](#get-funcionesid)
		- [POST /funciones](#post-funciones)
		- [PUT /funciones/{id}](#put-funcionesid)
		- [DELETE /funciones/{id}](#delete-funcionesid)
		- [GET /funciones/{funcionesid}/criticas](#get-funciones/{funcionesid}/criticas)
		- [GET /funciones/{funcionesid}/criticas/{criticasid}](#get-funciones/{funcionesid|/criticas/{criticasid})
		- [GET /funciones/{funcionesid}/sillas](#get-funcionesidsillas)
		- [GET /funciones/{funcionesid}/sillas/{sillasid}](#get-funcionesidsillasid)
		- [POST /funciones/{funcionesid}/sillas](#post-funcionesidsillas)
		- [PUT /funciones/{funcionasid}/sillas/{sillasid}](#put-funcionesidsillasid)
		- [DELETE /funciones/{funcionesid}/sillas/{sillasid}](#delete-funcionesidsillasid)
	
	- [Recurso Teatro](#recurso-teatro)
	        - [GET /teatros](#get-teatros)
		- [GET /teatros/{id}](#get-teatrosid)
		- [POST /teatros](#post-teatros)
		- [PUT /teatros/{id}](#put-teatros)
	- [Recurso Abono](#recurso-abono)
		- [GET /abonos](#GET-/abonos)
		- [GET /abonos/{id}](#GET-/abonos/{id})
		- [POST /abonos](#POST-/abonos)
		- [PUT /abonos/{id}](#PUT-/abonos/{id})
		- [DELETE /abonos/{id}](#DELETE-/abonos/{id})
		- [GET abonos/{abonosid}/espectador](#GET-/abonos/{id}/espectador)
		- [GET abonos/{abonosid}/boletas](#GET-/abonos/{abonosid}/boletas)
		- [GET abonos/{abonosid}/boletas/{boletasid}](#GET-/abonos/{abonosid}/boletas/{boletasid})
		- [POST abonos/{abonosid}/boletas/{boletasid}](#POST-/abonos/{abonosid}/boletas/{boletasid})
		- [POST abonos/{abonosid}/boletas](#POST-/abonos/{abonosid}/boletas)
		- [PUT abonos/{abonosid}/boletas/{boletasid}](PUT-/abonos/{abonoid}/boletas/{boletaid})
		- [DELETE abonos/{abonosid}/boletas] (#DELETE-/abonos/{abonosid}/boletas)
		- [DELETE abonos/{abonosid}/boletas/{boletasid}] (#DELETE-/abonos/{abonosid}/boletas7{boletasid})
	- [Recurso Boleta](#recurso-boleta)
		- [GET /boletas](#GET-/boleta)
		- [GET /boletas/{id}](#GET-/boletas/{id})
		- [POST /boletas](#POST-/boletas)
		- [PUT /boletas/{id}](#PUT-/boletas/{id})
		- [DELETE /boletas/{id}](#DELETE-/boletas/{id})
		- [GET boletas/{boletasid}/calificacion](#GET-/boletas/{boletasid}/calificacion)
		- [POST abonos/{boletasid}/calificacion/{calificacionid}](#POST-/abonos/{boletasid}/calificacion/{calificacionid})
		- [PUT abonos/{boletasid}/calificacion](#PUT-/boletas/{boletasid}/calificacion)
		- [DELETE boletas/{boletasid}/calificacion](#DELETE-/boletas/boletasid/calificacion)
		- [GET boletas/{boletasid}/silla](#GET-/boletas/{boletasid}/silla)
		- [POST boletas/{boletasid}/silla](#POST-/boletas/{boletasid}/silla)
		- [PUT boletas/{boletasid}/silla](#PUT-/boletas/{boletasid}/silla)
		- [DELETE boletas/{boletasid}/silla](#DELETE-/boletas/{boletasid}/silla)
		- [GET boletas/{boletasid}/espectador](#GET-/boletas/{boletasid}/espectador)
		- [POST boletas/{boletasid}/espectador](#POST-/boletas/{boletasid}/espectador)
		- [PUT boletas/{boletasid}/espectador](#PUT-/boletas/{boletasid}/espectador)	
    	- [Recurso Sala](#recurso-sala)
		- [GET /salas](#get-salas)
		- [GET /salas/{id}](#get-salasid)
		- [POST /salas](#post-salas)
		- [PUT /salas/{id}](#put-salasid)
		- [DELETE /salas/{id}](#delete-salasid)
		- [GET /salas/{id}/teatro](#get-salas/{salasid}/teatro)
		- [GET /salas/{id}/funciones](#get-salasidfunciones)
		- [GET /salas/{salasid}/funcinoes/{funcinoesid}](#get-salasidfuncionesid)
		- [POST /salas/{id}/funciones](#post-salasfunciones)
		- [PUT /salas/{salasid}/funciones/{funcionesid}](#put-salasfuncionesid)
		- [DELETE /salas/{salasid}/funciones](#delete-salasidfunciones)
		- [DELETE /salas/{salasid}/funciones/{funcionesid}](#delete-salasidfuncionesid)
	- [Recurso Patrocinador](#recurso-patrocinador)
		- [GET /patrocinadores](#get-patrocinadores)
		- [GET /patrocinadores/{id}](#get-patrocinadoresid)
		- [POST /patrocinadores](#post-patrocinadores)
		- [PUT /patrocinadores/{id}](#put-patrocinadoresid)
		- [DELETE /patrocinadores/{id}](#delete-patrocinadoresid)
		- [GET /patrocinadores/{id}/festivales](#get-patrocinadores/{patrocinadorid}/festivales)
		- [GET /patrocinadores/{patrocinadorid}/festivales/{festivalid}](#get-patrocinadores/{patrocinadorid}/festivales/{festivalid})
		- [POST /patrocinadores/{id}/festivales](#post-patrocinadoridfestivales)
		- [PUT /patrocinadores/{patrocinadorid}/festivales/{festivalid}](#put-patrocinadoridfestivalid)
		- [DELETE /patrocinadores/{patrocinadorid}/festivales/{festivalid}](#delete-patrocinadoridfestivalid)

# API Rest
## Introducción
La comunicación entre critico y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una 
propiedad de un objeto JSON. Todos los servicios se generan en la URL /festival_cine/api/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada 
registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor 
en el header `X-Total-Count` y los registros se envían en el cuerpo del mensaje como un arreglo.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
[{}, {}, {}, {}, {}, {}]
```

## API de la aplicación festival de cine

### Recurso Silla

El objeto Silla tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    reservada: '' /*Tipo Boolean*/,
    tarifa: '' /*Tipo Double*/,
    esPreferencial: '' /*Tipo Boolean*/,
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    boleta: {
        id: '' /*Tipo Long*/,    
    },
    función: {
        horaInicio: '' /*Tipo Date*/,
        horaFin: ''/*Tipo Date*/,
        id: '' /*Tipo Long*/
    }
}
```



#### GET /sillas

Retorna una colección de objetos Silla en representación Detail.
Cada Silla en la colección tiene embebidos los siguientes objetos: Boleta y Función.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Silla en [representaciones Detail](#recurso-silla)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /sillas/{id}

Retorna un objeto Silla en representación Detail.
Cada Silla en la colección tiene los siguientes objetos: Boleta y Función.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Silla a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Silla en [representaciones Detail](#recurso-silla)
404|No existe un objeto Silla con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /sillas

Es el encargado de crear objetos Silla.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Silla que será creado|Sí|[Representación Detail](#recurso-silla)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Silla ha sido creado|[Representación Detail](#recurso-silla)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Silla|Mensaje de error

#### PUT /sillas/{id}

Es el encargado de actualizar objetos Silla.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Silla a actualizar|Sí|Integer
body|body|Objeto Silla nuevo|Sí|[Representación Detail](#recurso-silla)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Silla actualizado|[Representación Detail](#recurso-silla)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Silla|Mensaje de error

#### DELETE /sillas/{id}

Elimina un objeto Silla.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Silla a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET sillas/{sillasid}/boleta

Retorna una Boleta asociada a un objeto Silla en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
sillasid|Path|ID del objeto Silla a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Boleta en [representación Detail](#recurso-boleta)
500|Error consultando boleta |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST sillas/{sillasid}/boleta
Asocia un objeto Boleta a un objeto Silla.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
sillasid|PathParam|ID del objeto Silla al cual se asociará el objeto Boleta|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Boleta asociado|[Representación Detail de Boleta](#recurso-boleta)
500|No se pudo asociar el objeto Boleta|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT sillas/{sillasid}/boleta

Es el encargado de remplazar la Boleta asociada a un objeto Silla.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
sillasid|Path|ID del objeto Silla cuya asociación será remplazada|Sí|Integer
body|body|Objeto Boleta|Sí|[Representación Detail](#recurso-boleta)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó el objeto|Objeto Boleta en [Representación Detail](#recurso-boleta)
500|No se pudo remplazar el objeto|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE sillas/{sillasid}/boleta

Remueve un objeto Boleta de un objeto Silla.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
sillasid|Path|ID del objeto Silla asociado al objeto Boleta|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET sillas/{sillasid}/función

Retorna una Función asociada a un objeto Silla en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
sillasid|Path|ID del objeto Silla a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Función en [representación Detail](#recurso-función)
500|Error consultando función |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST sillas/{sillasid}/función
Asocia un objeto Función a un objeto Silla.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
sillasid|PathParam|ID del objeto Silla al cual se asociará el objeto Función|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Función asociado|[Representación Detail de Función](#recurso-función)
500|No se pudo asociar el objeto Función|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT sillas/{sillasid}/función

Es el encargado de remplazar la Función asociada a un objeto Silla.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
sillasid|Path|ID del objeto Silla cuya asociación será remplazada|Sí|Integer
body|body|Objeto Función|Sí|[Representación Detail](#recurso-función)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó el objeto|Objeto Función en [Representación Detail](#recurso-función)
500|No se pudo remplazar el objeto|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE sillas/{sillasid}/función

Remueve un objeto Función de un objeto Silla.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
sillasid|Path|ID del objeto Silla asociado al objeto Función|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

[Volver arriba](#tabla-de-contenidos)



### Recurso Crítico

El objeto Crítico tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    nombre: '' /*Tipo String*/,
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    critica: {
        id: '' /*Tipo Long*/,  
		comentario: '' /*Tipo String*/,
    },
    pelicula: {
        nombre: '' /*Tipo String*/,
        generos: [{genero1: '' /*Tipo String*/},{genero2: '' /*Tipo String*/}, {generoN: '' /*Tipo String*/}] /*Tipo JsonList*/,
        duracionMinutos: '' /*Tipo Integer*/,
		director: '' /*Tipo String*/,
		creditos: '' /*Tipo Integer*/,
		pais: '' /*Tipo String*/,
		id: '' /*Tipo String*/,
		corto: '' /*Tipo String*/,
    }, 
	festival: {
		id: '' /*Tipo Long*/,
		nombre: '' /*Tipo String*/,
		horaInicio: '' /*Tipo Date/*,
		horaFin: '' /*Tipo Date/*
		patrocinador: '' /*Tipo String/*
	},
	
}
```



#### GET /criticos

Retorna una colección de objetos Crítico en representación Detail.
Cada Crítico en la colección tiene embebidos los siguientes objetos: Crítica y Película.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Crítico en [representaciones Detail](#recurso-criticos)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /criticos/{id}

Retorna un objeto Crítico en representación Detail.
El Crítico en la colección tiene los siguientes objetos: Crítica, Festival y Película.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Crítico a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Crítico en [representaciones Detail](#recurso-criticos)
404|No existe un objeto Crítico con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /criticos

Es el encargado de crear objetos Crítico.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Crítico que será creado|Sí|[Representación Detail](#recurso-critico)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Crítico ha sido creado|[Representación Detail](#recurso-critico)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Crítico|Mensaje de error

#### PUT /criticos/{id}

Es el encargado de actualizar objetos Crítico.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Crítico a actualizar|Sí|Integer
body|body|Objeto Crítico nuevo|Sí|[Representación Detail](#recurso-critico)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Crítico actualizado|[Representación Detail](#recurso-critico)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Crítico|Mensaje de error

#### DELETE /criticos/{id}

Elimina un objeto Crítico.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Crítico a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET criticos/{criticosid}/critico

Retorna un Crítico asociado a un objeto Crítico en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquemaw
:--|:--|:--|:--|:--
criticosid|Path|ID del objeto Crítico a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Crítico en [representación Detail](#recurso-critico)
500|Error consultando critico|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST criticos/{criticosid}/critico
Asocia un objeto Crítico a un objeto Crítico.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
criticosid|PathParam|ID del objeto Crítico al cual se asociará el objeto Crítico|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Crítico asociado|[Representación Detail de Crítico](#recurso-critico)
500|No se pudo asociar el objeto Crítico|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT criticos/{criticosid}/critico

Es el encargado de remplazar la Crítico asociada a un objeto Crítico.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
criticosid|Path|ID del objeto Crítico cuya asociación será remplazada|Sí|Integer
body|body|Objeto Crítico|Sí|[Representación Detail](#recurso-critico)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó el objeto|Objeto Crítico en [Representación Detail](#recurso-critico)
500|No se pudo remplazar el objeto|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE criticos/{criticosid}/critico

Remueve un objeto Crítico de un objeto Crítico.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
criticosid|Path|ID del objeto Crítico asociado al objeto Crítico|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET criticos/{criticosid}/critica

Retorna una Crítica asociada a un objeto Crítico en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
criticosid|Path|ID del objeto Crítico a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Función en [representación Detail](#recurso-función)
500|Error consultando función |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST criticos/{criticosid}/critica
Asocia un objeto Crítica a un objeto Crítico.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
criticosid|PathParam|ID del objeto Crítico al cual se asociará el objeto Crítica|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Crítica asociado|[Representación Detail de Crítica](#recurso-critica)
500|No se pudo asociar el objeto Crítica|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT criticos/{criticosid}/critica

Es el encargado de remplazar la Crítica asociada a un objeto Crítico.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
criticosid|Path|ID del objeto Crítico cuya asociación será remplazada|Sí|Integer
body|body|Objeto Crítica|Sí|[Representación Detail](#recurso-critica)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó el objeto|Objeto Crítica en [Representación Detail](#recurso-critica)
500|No se pudo remplazar el objeto|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE criticos/{criticosid}/critica

Remueve un objeto Crítica de un objeto Crítico.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
criticosid|Path|ID del objeto Crítico asociado al objeto Crítica|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET criticos/{criticosid}/pelicula

Retorna una Película asociada a un objeto Crítico en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
criticosid|Path|ID del objeto Crítico a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Película en [representación Detail](#recurso-función)
500|Error consultando función |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST criticos/{criticosid}/pelicula
Asocia un objeto Película a un objeto Crítico.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
criticosid|PathParam|ID del objeto Crítico al cual se asociará el objeto Película|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Película asociado|[Representación Detail de Película](#recurso-pelicula)
500|No se pudo asociar el objeto Película |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT criticos/{criticosid}/pelicula

Es el encargado de remplazar la Película asociada a un objeto Crítico.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
criticosid|Path|ID del objeto Crítico cuya asociación será remplazada|Sí|Integer
body|body|Objeto Película|Sí|[Representación Detail](#recurso-pelicula)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó el objeto|Objeto Película en [Representación Detail](#recurso-pelicula)
500|No se pudo remplazar el objeto|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE criticos/{criticosid}/pelicula

Remueve un objeto Película de un objeto Crítico.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
criticosid|Path|ID del objeto Crítico asociado al objeto Película|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

[Volver arriba](#tabla-de-contenidos)


### Recurso Espectador

El objeto Espectador tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    nombre: '' /*Tipo String*/,
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    critica: {
        id: '' /*Tipo Long*/,  
		comentario: '' /*Tipo String*/,
    },
    pelicula: {
        nombre: '' /*Tipo String*/,
        generos: [{genero1: '' /*Tipo String*/},{genero2: '' /*Tipo String*/}, {generoN: '' /*Tipo String*/}] /*Tipo JsonList*/,
        duracionMinutos: '' /*Tipo Integer*/,
		director: '' /*Tipo String*/,
		creditos: '' /*Tipo Integer*/,
		pais: '' /*Tipo String*/,
		id: '' /*Tipo String*/,
		corto: '' /*Tipo String*/,
    }, 
	festival: {
		id: '' /*Tipo Long*/,
		nombre: '' /*Tipo String*/,
		horaInicio: '' /*Tipo Date/*,
		horaFin: '' /*Tipo Date/*
		patrocinador: '' /*Tipo String/*
	},
	
}
```



#### GET /espectadores

Retorna una colección de objetos Espectador en representación Detail.
Cada Espectador en la colección tiene embebidos los siguientes objetos: Crítica, Festival y Película.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Espectador en [representaciones Detail](#recurso-espectadores)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /espectadores/{id}

Retorna un objeto Espectador en representación Detail.
El Espectador en la colección tiene los siguientes objetos: Crítica, Festival y Película.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Espectador a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Espectador en [representaciones Detail](#recurso-espectadores)
404|No existe un objeto Espectador con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /espectadores

Es el encargado de crear objetos Espectador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Espectador que será creado|Sí|[Representación Detail](#recurso-espectador)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Espectador ha sido creado|[Representación Detail](#recurso-espectador)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Espectador|Mensaje de error

#### PUT /espectadores/{id}

Es el encargado de actualizar objetos Espectador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Espectador a actualizar|Sí|Integer
body|body|Objeto Espectador nuevo|Sí|[Representación Detail](#recurso-espectador)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Espectador actualizado|[Representación Detail](#recurso-espectador)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Espectador|Mensaje de error

#### DELETE /espectadores/{id}

Elimina un objeto Espectador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Espectador a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET espectadores/{espectadoresid}/espectador

Retorna un Espectador asociado a un objeto Espectador en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquemaw
:--|:--|:--|:--|:--
espectadoresid|Path|ID del objeto Espectador a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Espectador en [representación Detail](#recurso-espectador)
500|Error consultando espectador|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST espectadores/{espectadoresid}/espectador
Asocia un objeto Espectador a un objeto Espectador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
espectadoresid|PathParam|ID del objeto Espectador al cual se asociará el objeto Espectador|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Espectador asociado|[Representación Detail de Espectador](#recurso-espectador)
500|No se pudo asociar el objeto Espectador|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT espectadores/{espectadoresid}/espectador

Es el encargado de remplazar la Espectador asociada a un objeto Espectador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
espectadoresid|Path|ID del objeto Espectador cuya asociación será remplazada|Sí|Integer
body|body|Objeto Espectador|Sí|[Representación Detail](#recurso-espectador)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó el objeto|Objeto Espectador en [Representación Detail](#recurso-espectador)
500|No se pudo remplazar el objeto|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE espectadores/{espectadoresid}/espectador

Remueve un objeto Espectador de un objeto Espectador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
espectadoresid|Path|ID del objeto Espectador asociado al objeto Espectador|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET espectadores/{espectadoresid}/critica

Retorna una Crítica asociada a un objeto Espectador en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
espectadoresid|Path|ID del objeto Espectador a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Función en [representación Detail](#recurso-función)
500|Error consultando función |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST espectadores/{espectadoresid}/critica
Asocia un objeto Crítica a un objeto Espectador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
espectadoresid|PathParam|ID del objeto Espectador al cual se asociará el objeto Crítica|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Crítica asociado|[Representación Detail de Crítica](#recurso-critica)
500|No se pudo asociar el objeto Crítica|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT espectadores/{espectadoresid}/critica

Es el encargado de remplazar la Crítica asociada a un objeto Espectador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
espectadoresid|Path|ID del objeto Espectador cuya asociación será remplazada|Sí|Integer
body|body|Objeto Crítica|Sí|[Representación Detail](#recurso-critica)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó el objeto|Objeto Crítica en [Representación Detail](#recurso-critica)
500|No se pudo remplazar el objeto|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE espectadores/{espectadoresid}/critica

Remueve un objeto Crítica de un objeto Espectador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
espectadoresid|Path|ID del objeto Espectador asociado al objeto Crítica|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

[Volver arriba](#tabla-de-contenidos)


//---------------------------------------------------------------------------------------//
### Recurso Crítica

El objeto Crítica tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    comentario: '' /*Tipo String*/,
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    crítico: {},
    función: {
        horaInicio: '' /*Tipo Date*/,
        horaFin: ''/*Tipo Date*/,
        id: '' /*Tipo Long*/
    }
}
```



#### GET /críticas

Retorna una colección de objetos Crítica en representación Detail.
Cada Crítica en la colección tiene embebidos los siguientes objetos: Crítico y Función.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Crítica en [representaciones Detail](#recurso-crítica)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /críticas/{id}

Retorna un objeto Crítica en representación Detail.
Cada Crítica en la colección tiene los siguientes objetos: Crítico y Función.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Crítica a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Crítica en [representaciones Detail](#recurso-crítica)
404|No existe un objeto Crítica con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /críticas

Es el encargado de crear objetos Crítica.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Crítica que será creado|Sí|[Representación Detail](#recurso-crítica)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Crítica ha sido creado|[Representación Detail](#recurso-crítica)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Crítica|Mensaje de error

#### PUT /críticas/{id}

Es el encargado de actualizar objetos Crítica.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Crítica a actualizar|Sí|Integer
body|body|Objeto Crítica nuevo|Sí|[Representación Detail](#recurso-crítica)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Crítica actualizado|[Representación Detail](#recurso-crítica)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Crítica|Mensaje de error

#### DELETE /críticas/{id}

Elimina un objeto Crítica.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Crítica a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET críticas/{críticasid}/función

Retorna una Función asociada a un objeto Crítica en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
críticasid|Path|ID del objeto Crítica a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Función en [representación Detail](#recurso-función)
500|Error consultando función |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST críticas/{críticasid}/función
Asocia un objeto Función a un objeto Crítica.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
críticasid|PathParam|ID del objeto Crítica al cual se asociará el objeto Función|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Función asociado|[Representación Detail de Función](#recurso-función)
500|No se pudo asociar el objeto Función|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT críticas/{críticasid}/función

Es el encargado de remplazar la Función asociada a un objeto Crítica.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
críticasid|Path|ID del objeto Crítica cuya asociación será remplazada|Sí|Integer
body|body|Objeto Función|Sí|[Representación Detail](#recurso-función)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó el objeto|Objeto Función en [Representación Detail](#recurso-función)
500|No se pudo remplazar el objeto|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE críticas/{críticasid}/función

Remueve un objeto Función de un objeto Crítica.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
críticasid|Path|ID del objeto Crítica asociado al objeto Función|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET críticas/{críticasid}/crítico

Retorna una Crítico asociada a un objeto Crítica en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
críticasid|Path|ID del objeto Crítica a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Crítico en [representación Detail](#recurso-crítico)
500|Error consultando crítico |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST críticas/{críticasid}/crítico
Asocia un objeto Crítico a un objeto Crítica.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
críticasid|PathParam|ID del objeto Crítica al cual se asociará el objeto Crítico|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Crítico asociado|[Representación Detail de Crítico](#recurso-crítico)
500|No se pudo asociar el objeto Crítico|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT críticas/{críticasid}/crítico

Es el encargado de remplazar la Crítico asociada a un objeto Crítica.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
críticasid|Path|ID del objeto Crítica cuya asociación será remplazada|Sí|Integer
body|body|Objeto Crítico|Sí|[Representación Detail](#recurso-crítico)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó el objeto|Objeto Crítico en [Representación Detail](#recurso-crítico)
500|No se pudo remplazar el objeto|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE críticas/{críticasid}/crítico

Remueve un objeto Crítico de un objeto Crítica.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
críticasid|Path|ID del objeto Crítica asociado al objeto Crítico|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

### Recurso Calificacion

El objeto Calificación tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    calificacion: '' /*Tipo double/*
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    boleta: {
      id: '' /*Tipo long/*
    }
}
```
#### GET /calificaciones

Retorna una colección de objetos Calificacion en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Calificacion en [representaciones Detail](#recurso-calificacion)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /calificaciones/{id}

Retorna un objeto Calificación en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Calificacion a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Calificacion en [representaciones Detail](#recurso-calificacion)
404|No existe un objeto Calificacion con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /calificaciones

Es el encargado de crear objetos Calificacion.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Calificacion que será creado|Sí|[Representación Detail](#recurso-calificacion)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Calificacion ha sido creado|[Representación Detail](#recurso-calificacion)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Calificacion|Mensaje de error

#### PUT /calificaciones/{id}

Es el encargado de actualizar objetos Calificacion.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Calificacion a actualizar|Sí|Integer
body|body|Objeto Calificacion nuevo|Sí|[Representación Detail](#recurso-calificacion)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Calificacion actualizado|[Representación Detail](#recurso-silla)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Calificacion|Mensaje de error
404|No existe un objeto calificacion con el ID solicitado. | Mensaje de error

#### DELETE /calificaciones/{id}

Elimina un objeto Calificacion.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Calificacion a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
404|No existe un objeto calificacion con el ID solicitado. | Mensaje de error




### Recurso Funcion

El objeto Función tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    horaInicio: '' /*Tipo Date/*,
    horaFin: '' /*Tipo Date/*
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    sala: {
      id: '' /*Tipo long/*,
      nombre: '' /*Tipo String/*
    },
    pelicula: {
      id: '' /*Tipo long/*,
      nombre: '' /*Tipo String/*,
      generos: '' /*Tipo ArrayList<String>/*,
      duracionMinutos: '' /*Tipo int/*,
      director: '' /*Tipo String/*,
      creditos: '' /*Tipo String/*,
      pais: '' /*Tipo String/*,
      corto: '' /*Tipo String/*
    }
}
```

#### GET /funciones

Retorna una colección de objetos Funcion en representación Detail.


#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Funcion en [representaciones Detail](#recurso-funcion)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /funciones/{id}

Retorna un objeto Calificación en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Funcion a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Funcion en [representaciones Detail](#recurso-funcion)
404|No existe un objeto Funcion con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /funciones

Es el encargado de crear objetos Funcion.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Funcion que será creado|Sí|[Representación Detail](#recurso-funcion)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Funcion ha sido creado|[Representación Detail](#recurso-funcion)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Funcion|Mensaje de error

#### PUT /funciones/{id}

Es el encargado de actualizar objetos Funcion.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Funcion a actualizar|Sí|Integer
body|body|Objeto Funcion nuevo|Sí|[Representación Detail](#recurso-funcion)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Funcion actualizado|[Representación Detail](#recurso-silla)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Funcion|Mensaje de error
404|No existe un objeto funcion con el ID solicitado. | Mensaje de error

#### DELETE /funciones/{id}

Elimina un objeto Funcion.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Funcion a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
404|No existe un objeto funcion con el ID solicitado. | Mensaje de error

#### GET /funciones/{funcionesid}/criticas

Retorna una colección de objetos Crítica en representación Detail.


#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Crítica en [representaciones Detail](#recurso-critica)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error
404|No existe un objeto Funcion con el ID solicitado|Mensaje de error

#### GET /funciones/{funcionesid}/criticas/{criticasid}

Retorna un objeto Crítica en representación Detail.


#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
funcionesid|Path|ID del objeto Funcion a consultar|Sí|Integer
criticasid|Path|ID del objeto Crítica a consiltar|Si|Integer 

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Crítica en [representaciones Detail](#recurso-critica)
404|No existe un objeto Funcion con el ID solicitado|Mensaje de error
404|No existe un objeto Crítica con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error


#### GET /funciones/{funcionesid}/sillas

Retorna una colección de objetos Silla en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Silla en [representaciones Detail](#recurso-silla)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error
404|No existe un objeto Funcion con el ID solicitado|Mensaje de error

#### GET /funciones/{funcionesid}/sillas/{sillasid}

Retorna un objeto Silla en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
funcionesid|Path|ID del objeto Funcion a consultar|Sí|Integer
sillaid|Path|ID del objeto Silla a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Silla en [representaciones Detail](#recurso-calificacion)
404|No existe un objeto Funcion con el ID solicitado|Mensaje de error
404|No existe un objeto Silla con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /funciones/{funcionesid}/sillas

Es el encargado de crear objetos Sillas.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Silla que será creada|Sí|[Representación Detail](#recurso-calificacion)
funcionesid|Path|ID del objeto Funcion a consultar|Sí|Integer


#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Calificacion ha sido creado|[Representación Detail](#recurso-calificacion)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Calificacion|Mensaje de error
404|No existe un objeto Funcion con el ID solicitado|Mensaje de error

#### PUT /funciones/{funcionesid}/sillas/{sillasid}

Es el encargado de actualizar objetos Silla dentro de un objeto Funcion.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Calificacion a actualizar|Sí|Integer
body|body|Objeto Calificacion nuevo|Sí|[Representación Detail](#recurso-calificacion)
funcionesid|Path|ID del objeto Funcion a consultar|Sí|Integer
sillaid|Path|ID del objeto Silla a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Calificacion actualizado|[Representación Detail](#recurso-silla)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Calificacion|Mensaje de error
404|No existe un objeto Funcion con el ID solicitado|Mensaje de error
404|No existe un objeto Silla con el ID solicitado|Mensaje de error

#### DELETE /funciones/{funcionesid}/sillas/{sillasid}

Elimina un objeto Silla en un objeto Funcion.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
funcionesid|Path|ID del objeto Funcion a consultar|Sí|Integer
sillaid|Path|ID del objeto Silla a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
404|No existe un objeto Funcion con el ID solicitado|Mensaje de error
404|No existe un objeto Silla con el ID solicitado|Mensaje de error


### Recurso Teatro

El objeto teatro tiene dos representaciones JSON

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
   nombre: '' /*Tipo String*/,
}
```

#### Representación Detail
```javascript
{
        // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    festival: {},
    sala: {
          id: '' /*Tipo Long*/
          nombre: '' /*Tipo String*/,
    }

}
```

#### GET /teatros
Retorna una colección de objetos Teatro en representación Detail. Cada Teatro en la colección tiene embebidos los siguientes objetos: Festival y sala.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Teatro en [representaciones Detail](#recurso-Teatro)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /teatros/{id}

Retorna un objeto Teatro en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Teatro a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Teatro en [representaciones Detail](#recurso-teatros)
404|No existe un objeto Teatro con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /teatros

Es el encargado de crear objetos Teatro.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Teatro que será creado|Sí|[Representación Detail](#recurso-teatro)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Teatro ha sido creado|[Representación Detail](#recurso-teatro)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Teatro|Mensaje de error

#### PUT /teatros/{id}

Es el encargado de actualizar objetos Teatro.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Teatro a actualizar|Sí|Integer
body|body|Objeto Teatro nuevo|Sí|[Representación Detail](#recurso-Teatro)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Teatro actualizado|[Representación Detail](#recurso-sala)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Teatro|Mensaje de error
404|No existe un objeto Teatro con el ID solicitado. | Mensaje de error

#### DELETE /teatros/{id}

Elimina un objeto Teatro.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Teatro a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
404|No existe un objeto funcion con el ID solicitado. | Mensaje de error

#### GET /teatros/{teatrosid}/salas

Retorna una colección de objetos Teatro en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Teatro en [representaciones Detail](#recurso-teatro)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error
404|No existe un objeto Teatro con el ID solicitado|Mensaje de error

#### GET /teatros/{teatrosid}/salas/{salasid}

Retorna un objeto Sala en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
teatrosid|Path|ID del objeto Teatro a consultar|Sí|Integer
salasid|Path|ID del objeto Sala a consultar|Si|Integer 

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Sala en [representaciones Detail](#recurso-sala)
404|No existe un objeto Teatro con el ID solicitado|Mensaje de error
404|No existe un objeto Sala con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error


#### GET /teatros/{teatrosid}/salas

Retorna una colección de objetos Sala representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Sala[representaciones Detail](#recurso-sala)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error
404|No existe un objeto Funcion con el ID solicitado|Mensaje de error

#### GET /teatrosonesid}/salaslasid

Retorna un objeto Sala reprentacion Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
teatrosid|Path|ID del objeto Teatro a consultar|Si|Integer
salasid|Path|ID del objeto Sala consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Sala en [representaciones Detail](#recurso-sala)
404|No existe un objeto Teatro  solicitado|Mensaje de error
404|No existe un objeto Sala con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /teatros/{teatrosid}/sala

Es el encargado de crear objetos Sala.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Sala  será creado||[Representación Detail](#recurso-sala)
funcionesid|Path|ID del objeto Teatro  a consultar|Sí|Integer


#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Sala ha sido creado|[Representación Detail](#recurso-sala)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Sala |Mensaje de error
404|No existe un objeto Teatro  con el ID solicitado|Mensaje de error

#### PUT/teatros/{teatrosid}/sala

Es el encargado de actualizar objetos Sala dentro de un objeto Teatro.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Sala  a actualizar|Sí|Integer
body|body|Objeto Sala  nuevo|Sí|[Representación Detail](#recurso-sala)
teatrosid|Path|ID del objeto Teatro a consultar|Sí|Integer
salasid|Path|ID del objeto Sala a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Sala  actualizado|[Representación Detail](#recurso-sala)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Sala |Mensaje de error
404|No existe un objeto Teatro con el ID solicitado|Mensaje de error
404|No existe un objeto Sala con el ID solicitado|Mensaje de error

#### DELETE /teatros/{teatrosid}/salas/{salasid}

Elimina un objeto Sala en un objeto Teatro.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
teatros|Path|ID del objeto  Teatro a consultar|Sí|Integer
salasid|Path|ID del objeto Sala a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
404|No existe un objeto Teatro  con el ID solicitado|Mensaje de error
404|No existe un objeto Sala con el ID solicitado|Mensaje de error

### Recurso Festival

El objeto Festival tiene dos representaciones JSON

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
   nombre: '' /*Tipo String*/,
   horaInicio: '' /*Tipo Date/*,
    horaFin: '' /*Tipo Date/*
    patrocinador: '' /*Tipo String/*
}
```

#### Representación Detail
```javascript
{
          // todo lo de la representación Minimum más los objetos Minimum con relación simple.
     teatro: {
          id: '' /*Tipo Long*/
          nombre: '' /*Tipo String*/,
    }
pelicula: {
      id: '' /*Tipo long/*,
      nombre: '' /*Tipo String/*,
      generos: '' /*Tipo ArrayList<String>/*,
      duracionMinutos: '' /*Tipo int/*,
      director: '' /*Tipo String/*,
      creditos: '' /*Tipo String/*,
      pais: '' /*Tipo String/*,
      corto: '' /*Tipo String/*
    }
Espectador:{
direccion: '' /*Tipo String/*,
}
Patrocinador:{
  patrocinio: '' /*Tipo double/*,
      NIT: '' /*Tipo Long/*,
}

}
```

#### GET /festivales
Retorna una colección de objetos Festival en representación Detail. Cada Festival en la colección tiene embebidos los siguientes objetos: Teatro, Pelicula, Espectador y Patrocinador.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Festival en [representaciones Detail](#recurso-Festival)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /festivales/{id}

Retorna un objeto Festival en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Festival a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Festival en [representaciones Detail](#recurso-festival)
404|No existe un objeto Festival con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /festivales

Es el encargado de crear objetos Festival.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Festival que será creado|Sí|[Representación Detail](#recurso-festival)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Festival ha sido creado|[Representación Detail](#recurso-festival)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Festival|Mensaje de error

#### PUT /festivales/{id}

Es el encargado de actualizar objetos Festival

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Festival a actualizar|Sí|Integer
body|body|Objeto Festival nuevo|Sí|[Representación Detail](#recurso-festival)

#### Respuesta
Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Festival actualizado|[Representación Detail](#recurso-festival)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Festival |Mensaje de error
404|No existe un objeto Festival  con el ID solicitado. | Mensaje de error

#### DELETE /festivales/{id}

Elimina un objeto Festival.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Festival a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
404|No existe un objeto Festival con el ID solicitado. | Mensaje de error

#### GET /festivales/{festivalesid}/teatros

Retorna una colección de objetos Teatro en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Festival en [representaciones Detail](#recurso-teatro)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error
404|No existe un objeto Festival con el ID solicitado|Mensaje de error

#### GET /festvivales/{festivalesid}/teatros/{teatrosid}

Retorna un objeto Teatro en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
funcionesid|Path|ID del objeto Festival a consultar|Sí|Integer
criticasid|Path|ID del objeto Teatro a consultar|Si|Integer 

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Teatro en [representaciones Detail](#recurso-teatro)
404|No existe un objeto Festival con el ID solicitado|Mensaje de error
404|No existe un objeto Teatro con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error


#### GET /festivales/{festivalesid}/teatros

Retorna una colección de objetos Teatro representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Teatro [representaciones Detail](#recurso-teatro)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error
404|No existe un objeto Festival con el ID solicitado|Mensaje de error

#### GET /festivalesid}/teatrosid

Retorna un objeto Teatro reprentacion Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
festivalesid|Path|ID del objeto Festival  a consultar|Si|Integer
teatrosid|Path|ID del objeto Teatro consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Teatro en [representaciones Detail](#recurso-teatro)
404|No existe un objeto Festival D solicitado|Mensaje de error
404|No existe un objeto Teatro con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /festivales/{festivalesid}/teatrosid

Es el encargado de crear objetos Teatro.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Teatro será creado||[Representación Detail](#recurso-sala)
funcionesid|Path|ID del objeto Festival  a consultar|Sí|Integer


#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Teatro ha sido creado|[Representación Detail](#recurso-teatro)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Teatro |Mensaje de error
404|No existe un objeto Festival con el ID solicitado|Mensaje de error

#### PUT/festivales/{festivalesid}/teatros

Es el encargado de actualizar objetos Teatro dentro de un objeto Festival.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Teatro  a actualizar|Sí|Integer
body|body|Objeto Teatro  nuevo|Sí|[Representación Detail](#recurso-teatro)
festivalesid|Path|ID del objeto Festival a consultar|Sí|Integer
teatrosid|Path|ID del objeto Teatro a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Teatro  actualizado|[Representación Detail](#recurso-teatro)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Teatro |Mensaje de error
404|No existe un objeto Festival con el ID solicitado|Mensaje de error
404|No existe un objeto Teatro con el ID solicitado|Mensaje de error

#### DELETE /festivales/{festivalesid}/teatros/{teatrosid}

Elimina un objeto Teatro en un objeto Festival.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
festivalesid|Path|ID del objeto  Festival a consultar|Sí|Integer
teatros|Path|ID del objeto Teatro a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
404|No existe un objeto Festival con el ID solicitado|Mensaje de error
404|No existe un objeto Teatro con el ID solicitado|Mensaje de error

[Volver arriba](#tabla-de-contenidos)

### Recurso Abono
El objeto Abono tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    espectador: '' /*Tipo Espectador*/,
    boletas: [10] /*Tipo Boleta*/
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
}
```

#### GET /abonos

Retorna una colección de objetos Abono en representación Detail
Cada Abono en la colección tiene embebidos los siguientes objetos: Espectador, Boleta

#### Parámetros

#### N/A

####Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-abono)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /abonos/{id}

Retorna una colección de objetos Abono en representación Minimum.
Cada Abono en la colección tiene los siguientes objetos: Espectador, Boleta.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Abono a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Abono en [representaciones Detail](#recurso-abono)
404|No existe un objeto Abono con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /abonos

Es el encargado de crear objetos Abono.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Abono que será creado|Sí|[Representación Detail](#recurso-abono)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Abono ha sido creado|[Representación Detail](#recurso-abono)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Abono|Mensaje de error

#### PUT /abonos/{id}

Es el encargado de actualizar objetos Abono.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Abono a actualizar|Sí|Integer
body|body|Objeto Abono nuevo|Sí|[Representación Detail](#recurso-abono)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Abono actualizado|[Representación Detail](#recurso-abono)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Abono|Mensaje de error

### DELETE /abonos/{id}

Elimina un objeto Abono.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Abono a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET /abonos/{abonosid}/espectador

Retorna un objeto Espectador asociado a un objeto Abono en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Abono a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|objeto Espectador en [representación Detail](#recurso-espectador)
500|Error consultando espectadores |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET abonos/{abonosid}/boletas

Retorna una colección de objetos Boleta asociados a un objeto Abono en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Abono cuya boleta se quiere consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Boleta en [representación Detail](#recurso-boleta)
500|Error consultando boletas |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error


#### GET abonos/{abonosid}/boletas/{boletasid}

Retorna un objeto Boleta asociados a un objeto Abono en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
abonosid|Path|ID del objeto Abono a consultar|Sí|Integer
boletasid|Path|ID del objeto Boleta a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Boleta en [representación Detail](#recurso-boleta)
404|No existe un objeto Boleta con el ID solicitado asociado al objeto Abono indicado |Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST abonos/{abonosid}/boletas/{boletasid}

Asocia un objeto Boleta a un objeto Abono.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
abonosid|PathParam|ID del objeto Abono al cual se asociará el objeto Boleta|Sí|Integer
boletassid|PathParam|ID del objeto Boleta a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Boleta asociado|[Representación Detail de Boleta](#recurso-boleta)
500|No se pudo asociar el objeto Boleta|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST abonos/{abonosid}/boletas/

Asocia una colección de 10 objetos Boleta a un objeto Abono

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
abonosid|PathParam|ID del objeto Abono al cual se asociará el objeto Boleta|Sí|Integer
boletassid|PathParam|ID del objeto Boleta a asociar|Sí|Integer
boletassid|PathParam|ID del objeto Boleta a asociar|Sí|Integer
boletassid|PathParam|ID del objeto Boleta a asociar|Sí|Integer
boletassid|PathParam|ID del objeto Boleta a asociar|Sí|Integer
boletassid|PathParam|ID del objeto Boleta a asociar|Sí|Integer
boletassid|PathParam|ID del objeto Boleta a asociar|Sí|Integer
boletassid|PathParam|ID del objeto Boleta a asociar|Sí|Integer
boletassid|PathParam|ID del objeto Boleta a asociar|Sí|Integer
boletassid|PathParam|ID del objeto Boleta a asociar|Sí|Integer
boletassid|PathParam|ID del objeto Boleta a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Boleta asociados|[Representación Detail de Boleta](#recurso-boleta)
500|No se pudo asociar los objetos Boleta|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE abono/{abonosid}/boletas/

Remueve una colección de objetos Boleta de un objeto Abono

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
abonosid|Path|ID del objeto Abono asociado al objeto Boleta|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error


#### PUT abonos/{abonosid}/boletas/{boletasid}

Es el encargado de actualizar un objeto Boleta asociada a un objeto Abono.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
abonossid|Path|ID del objeto Abono cuyo objeto será remplazado|Sí|Integer
boletasid|path|Objeto Boleta nuevo|Sí|[Representación Detail](#recurso-boleta)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se actualizo el objeto|Objeto Boleta en [Representación Detail](#recurso-boleta)
500|No se pudo actualizar|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE abonos/{abonosid}/boletas/

Remueve una colección de objetos Boleta asociados a un objeto Abono.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
abonoid|Path|ID del objeto Abono asociado al objeto Boleta|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objetos removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE abonos/{abonosid}/boletas/{boletasid}

Remueve un objeto Boleta asociado a un objeto Abono.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
abonoid|Path|ID del objeto Abono asociado al objeto Boleta|Sí|Integer
boletaid|Path|ID del objeto Boleta a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

[Volver arriba](#tabla-de-contenidos)
### Recurso Boleta
El objeto Boleta tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    espectador: '' /*Tipo Espectador*/,
    calificacion: '' /*Tipo Calificacion*/,
	silla: ''/*Tipo Silla*/
}
```


#### GET /boletas

Retorna una colección de objetos Boleta en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-boleta)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /boletas/{id}

Retorna una colección de objetos Boleta en representación Detail.
Cada Boleta en la colección tiene los siguientes objetos: Editorial.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Boleta a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Boleta en [representaciones Detail](#recurso-boleta)
404|No existe un objeto Boleta con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error


#### POST /boletas

Es el encargado de crear objetos Boleta.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Boleta que será creado|Sí|[Representación Detail](#recurso-boleta)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Boleta ha sido creado|[Representación Detail](#recurso-boleta)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Boleta|Mensaje de error

#### PUT /boletas/{id}

Es el encargado de actualizar objetos Boleta.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Boleta a actualizar|Sí|Integer
body|body|Objeto Boleta nuevo|Sí|[Representación Detail](#recurso-boleta)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Boleta actualizado|[Representación Detail](#recurso-boleta)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Boleta|Mensaje de error


#### DELETE /boletas/{id}

Elimina un objeto Boleta.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Boleta a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET boletas/{boletasid}/espectador

Retorna un objeto Espectador asociado a un objeto Boleta en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Boleta a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Boleta en [representación Detail](#recurso-boleta)
500|Error consultando espectadores |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET boletas/{boletasid}/calificacion

Retorna una colección de objetos Calificacion asociados a un objeto Boleta en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Boleta a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Calificacion en [representación Detail](#recurso-Calificacion)
500|Error consultando calificacion |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST abonos/{boletasid}/calificacion/{calificacionid}

Asocia un objeto Calificacion a un objeto Boleta.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
boletasid|PathParam|ID del objeto Boleta al cual se asociará el objeto Calificacion|Sí|Integer
calificacionid|PathParam|ID del objeto Calificacion a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Calificacion asociado|[Representación Detail de Calificacion](#recurso-calificacion)
500|No se pudo asociar el objeto Calificacion|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT abonos/{boletasid}/calificacion

Método encargado de reemplazar el objeto Calificación asociado a un objeto Boleta.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
boletasid|PathParam|ID del objeto Boleta al cual se asociará el objeto Calificacion|Sí|Integer
|body|body|objeto Calificacion|si|[representación Detail] (#recurso-calificacion)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la calificacion|Objeto Calificacion en [Representación Detail](#recurso-calificacion)
500|No se pudo remplazar el objeto.|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE boletas/{boletasid}/calificacion

Remueve un objeto Calificacion de un objeto Boleta.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
boletasid|Path|ID del objeto Boleta asociado al objeto Calificacion|Sí|Integer


#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

- [GET /boletas/{boletasid}/silla](#GET-/boletas/{boletasid}/silla)
		- [POST /boletas/{boletasid}/silla](#GET-/boletas/{boletasid}/silla)
		- [PUT /boletas/{boletasid}/silla](#GET-/boletas/{boletasid}/silla)
		- [DELETE /boletas/{boletasid}/silla](#GET-/boletas/{boletasid}/silla)
		
#### GET boletas/{boletasid}/sillas

Retorna un objeto Silla asociado a un objeto Boleta en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Silla a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Silla en [representación Detail](#recurso-silla)
500|Error consultando sillas |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST boletas/{boletasid}/sillas/{sillasid}

Asocia un objeto Silla a un objeto Boleta.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
boletasid|PathParam|ID del objeto Boleta al cual se asociará el objeto Silla|Sí|Integer
sillasid|PathParam|ID del objeto Silla a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Silla asociado|[Representación Detail de Silla](#recurso-silla)
500|No se pudo asociar el objeto Silla|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT abonos/{boletasid}/sillas

Método encargado de reemplazar el objeto Silla asociado a un objeto Boleta.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
boletasid|PathParam|ID del objeto Boleta al cual se asociará el objeto Silla|Sí|Integer
|body|body|objeto Silla|si|[representación Detail] (#recurso-silla)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó el objeto Silla|Objeto Silla en [Representación Detail](#recurso-silla)
500|No se pudo remplazar el objeto|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE boletas/{boletasid}/sillas

Remueve un objeto Silla de un objeto Boleta.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
boletasid|Path|ID del objeto Boleta asociado al objeto Silla|Sí|Integer


#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET boletas/{boletasid}/espectadores

Retorna un objeto Espectador asociado a un objeto Espectador en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Espectador a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Espectador en [representación Detail](#recurso-espectador)
500|Error consultando espectadores |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST boletas/{boletasid}/espectadores/{espectadoresid}

Asocia un objeto Espectador a un objeto Boleta.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
boletasid|PathParam|ID del objeto Boleta al cual se asociará el objeto Espectador|Sí|Integer
espectadoresid|PathParam|ID del objeto Espectador a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Espectador asociado|[Representación Detail de Espectador](#recurso-espectador)
500|No se pudo asociar el objeto Espectador|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT abonos/{boletasid}/espectadores

Método encargado de reemplazar el objeto Espectador asociado a un objeto Boleta.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
boletasid|PathParam|ID del objeto Boleta al cual se asociará el objeto Espectador|Sí|Integer
|body|body|objeto Espectador|si|[representación Detail] (#recurso-espectador)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó el objeto Espectador|Objeto Espectador en [Representación Detail](#recurso-espectador)
500|No se pudo remplazar el objeto|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

### Recurso Sala

El objeto Sala tiene dos representaciones JSON

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    nombre: '' /*Tipo String*/,
}
```

#### Representación Detail
```javascript
{
          // todo lo de la representación Minimum más los objetos Minimum con relación simple.
     teatro: {
          id: '' /*Tipo Long*/
          nombre: '' /*Tipo String*/,
     }
     funcion: {
      id: '' /*Tipo Long*/,
      horaInicio : '' /*Tipo Date*/,
      horaFin: '' /*Tipo Date*/,
    }

}
```
#### GET /salas

Retorna una colección de objetos Sala en representación Detail
Cada Sala incluye un teatro y funciones.

#### Parámetros
N/A

####Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-sala)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /salas/{id}

Retorna una Sala en representación Detail
Incluye un teatro y funciones.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Sala a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Sala en [representaciones Detail](#recurso-sala)
404|No existe un objeto con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /salas

Se crea un nuevo objeto Sala

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Sala que será creado|Sí|[Representación Detail](#recurso-sala)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Sala ha sido creado|[Representación Detail](#recurso-sala)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear la Sala|Mensaje de error

#### PUT /salas/{id}

Es el encargado de actualizar objetos Sala.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID de la Sala a actualizar|Sí|Integer
body|body|Objeto Sala nuevo|Sí|[Representación Detail](#recurso-sala)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Sala actualizado|[Representación Detail](#recurso-abono)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Abono|Mensaje de error

#### DELETE /salas/{id}

Elimina un objeto Sala.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID de la Sala a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET /salas/{id}/teatro

Retorna un objeto Teatro asociado a la sala consultada por id en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID de la Sala a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|objeto Teatro en [representación Detail](#recurso-teatro)
500|Error de consulta |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET /salas/{id}/funciones

Retorna una colección de objetos Funcion asociados a la Sala en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID de la Sala cuyas funciones se quieren consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Funcion en [representación Detail](#recurso-funcion)
500|Error consultando boletas |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error


#### GET /salas/{salasid}/funciones/{funcionesid}

Retorna un objeto funcion asociado a una Sala en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
salasid|Path|ID del objeto Sala a consultar|Sí|Integer
funcionesid|Path|ID del objeto Funcion a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Funcion en [representación Detail](#recurso-funcion)
404|No existe un objeto Funcion con el ID solicitado asociado al objeto Sala indicado |Mensaje de error
404|No existe un objeto Sala con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST /salas/{id}/funciones/

Asocia una o más Funciones a una Sala.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|PathParam|ID de la Sala al cual se asociará la Funcion|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Funcion asociada|[Representación Detail de Funcion](#recurso-funcion)
500|No se pudo asociar el objeto Funcion|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT salas/{salasid}/funciones/{funcionesid}

Es el encargado de actualizar una Funcion asociada a una Sala.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
salasid|Path|ID de la Sala cuya función será remplazada|Sí|Integer
funcionesid|path|Nueva Funcion|Sí|[Representación Detail](#recurso-funcion)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se actualizo el objeto|Objeto funcion en [Representación Detail](#recurso-funcion)
500|No se pudo actualizar|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE /sala/{salasid}/funciones/

Remueve todas las funciones de una Sala.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
salasid|Path|ID de la Sala|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Funciones removidas|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE /sala/{salasid}/funciones/{funcionesid}

Remueve una Funcion de una Sala

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
salasid|Path|ID de la Sala|Sí|Integer
funcionesid|Path|ID de la Funcion|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|funcion removida|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
### Recurso Patrocinador

El objeto Patrocinador tiene dos representaciones JSON

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    nombre: '' /*Tipo String*/,
    patrocinio: '' /*Tipo Double*/,
    NIT: '' /*Tipo Long*/,
}
```

#### Representación Detail
```javascript
{
          // todo lo de la representación Minimum más los objetos Minimum con relación simple.
     festival: {
      id: '' /*Tipo long*/,
      nombre: '' /*Tipo String*/
      fechaInicio : '' /*Tipo Date*/,
      fechaFin: '' /*Tipo Date*/,
    }

}
```

#### GET /patrocinadores

Retorna una colección de objetos Patrocinador en representación Detail
Cada Patrocinador incluye uno o más Festivales.

#### Parámetros
N/A

####Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de Patrocinadores [representaciones Detail](#recurso-patrocinador)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /patrocinadores/{id}

Retorna un Patrocinador en representación Detail
Incluye uno o más festivales.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Patrocinador a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Patrocinador en [representaciones Detail](#recurso-patrocinador)
404|No existe un objeto con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /patrocinadores

Se crea un nuevo objeto Patrocinador

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Patrocinador que será creado|Sí|[Representación Detail](#recurso-patrocinador)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Patrocinador ha sido creado|[Representación Detail](#recurso-patrocinador)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el Patrocinador|Mensaje de error

#### PUT /patrocinadores/{id}

Es el encargado de actualizar objetos Patrocinador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del Patrocinador a actualizar|Sí|Integer
body|body|Objeto Patrocinador nuevo|Sí|[Representación Detail](#recurso-patrocinador)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|Objeto Patrocinador actualizado|[Representación Detail](#recurso-abono)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el Patrocinador|Mensaje de error

#### DELETE /patrocinadores/{id}

Elimina un objeto Patrocinador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del Patrocinador a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET /patrocinadores/{id}/festivales

Retorna una colección de objetos Festival asociados al Patrocinador en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del Patrocinador cuyos festivales se quieren consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Festival en [representación Detail](#recurso-festival)
500|Error consultando patrocinadores |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error


#### GET /patrocinadores/{patrocinadoresid}/festivales/{festivalesid}

Retorna un objeto Festival asociado a un Patrocinador en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
patrocinadoresid|Path|ID del objeto Patrocinador a consultar|Sí|Integer
festivalesid|Path|ID del objeto Festival a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Festival en [representación Detail](#recurso-festival)
404|No existe un objeto Festival con el ID solicitado asociado al objeto Patrocinador indicado |Mensaje de error
404|No existe un objeto Patrocinador con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST /patrocinadores/{id}/festivales/

Asocia uno o más festivales a un Patrocinador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|PathParam|ID del Patrocinador al cual se asociará el Festival|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Festival asociado|[Representación Detail de Festival](#recurso-festival)
500|No se pudo asociar el objeto Festival|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT patrocinadores/{patrocinadoresid}/festivales/{festivalesid}

Es el encargado de actualizar un Festival asociado a un Patrocinador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
patrocinadoresid|Path|ID del Patrocinador cuya función será remplazada|Sí|Integer
festivalesid|path|Nuevo Festival|Sí|[Representación Detail](#recurso-festival)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se actualizo el objeto|Objeto Festival en [Representación Detail](#recurso-festival)
500|No se pudo actualizar|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE /patrocinador/{patrocinadoresid}/festivales/

Remueve todos los Festivales de un Patrocinador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
patrocinadoresid|Path|ID del Patrocinador|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Festivales removidos|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE /patrocinador/{patrocinadoresid}/festivales/{festivalesid}

Remueve un Festival de un Patrocinador

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
patrocinadoresid|Path|ID del Patrocinador|Sí|Integer
festivalesid|Path|ID del Festival|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Festival removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
