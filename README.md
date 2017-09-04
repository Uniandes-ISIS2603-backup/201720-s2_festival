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
    - [GET /funciones/{funcionesid}/criticas](#get-funcionesidcriticas)
    - [GET /funciones/{funcionesid}/criticas/{criticasid}](#get-funcionesidcriticasid)
    - [POST /funciones/{funcionesid}/criticas](#post-funcionesidcriticas)
    - [PUT /funciones/{funcionasid}/criticas/{criticasid}](#put-funcionesidcriticasid)
    - [DELETE /funciones/{funcionesid}/criticas/{criticasid}](#delete-funcionesidcriticasid)
    - [GET /funciones/{funcionesid}/sillas](#get-funcionesidsillas)
    - [GET /funciones/{funcionesid}/sillas/{sillasid}](#get-funcionesidsillasid)
    - [POST /funciones/{funcionesid}/sillas](#post-funcionesidsillas)
    - [PUT /funciones/{funcionasid}/sillas/{sillasid}](#put-funcionesidsillasid)
    - [DELETE /funciones/{funcionesid}/sillas/{sillasid}](#delete-funcionesidsillasid)
    

# API Rest
## Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /festival_cine/api/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

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
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor en el header `X-Total-Count` y los registros se envían en el cuerpo del mensaje como un arreglo.

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
Cada Silla en la colección tiene embebidos los siguientes objetos: Boleta.

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
Cada Calificación en la colección tiene los siguientes objetos: Boleta.

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




[Volver arriba](#tabla-de-contenidos)
