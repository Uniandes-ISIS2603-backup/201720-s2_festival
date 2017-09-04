# Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-festival-de-cine)
  - [Recurso Silla](#recurso-silla)
    - [GET /sillas](#get-/sillas)
    - [GET /sillas/{id}](#get-/sillas/{id})
    - [POST /sillas](#post-/sillas)
    - [PUT /sillas/{id}](#put-/sillas/{id})
    - [DELETE /sillas/{id}](#delete-/sillas/{id})
    - [GET sillas/{sillasid}/boleta](#get-sillas/{sillasid}/boleta)
    - [POST sillas/{sillasid}/boleta](#post-sillas/{sillasid}/boleta)
    - [PUT sillas/{sillasid}/boleta](#put-sillas/{sillasid}/boleta)
    - [DELETE sillas/{sillasid}/boleta](#delete-sillas/{sillasid}/boleta)
    - [GET sillas/{sillasid}/función](#get-sillas/{sillasid}/función)
    - [POST sillas/{sillasid}/función](#post-sillas/{sillasid}/función)
    - [PUT sillas/{sillasid}/función](#put-sillas/{sillasid}/función)
    - [DELETE sillas/{sillasid}/función](#delete-sillas/{sillasid}/función)
  - [Recurso Crítica](#recurso-crítica)
    - [GET /críticas](#get-/críticas)
    - [GET /críticas/{id}](#get-/críticas/{id})
    - [POST /críticas](#post-/críticas)
    - [PUT /críticas/{id}](#put-/críticas/{id})
    - [DELETE /críticas/{id}](#delete-/críticas/{id})
    - [GET críticas/{críticasid}/función](#get-críticas/{críticasid}/función)
    - [POST críticas/{críticasid}/función](#post-críticas/{críticasid}/función)
    - [PUT críticas/{críticasid}/función](#put-críticas/{críticasid}/función)
    - [DELETE críticas/{críticasid}/función](#delete-críticas/{críticasid}/función)
    - [GET críticas/{críticasid}/crítico](#get-críticas/{críticasid}/crítico)
    - [POST críticas/{críticasid}/crítico](#post-críticas/{críticasid}/crítico)
    - [PUT críticas/{críticasid}/crítico](#put-críticas/{críticasid}/crítico)
    - [DELETE críticas/{críticasid}/crítico](#delete-críticas/{críticasid}/crítico)


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

[Volver arriba](#tabla-de-contenidos)
