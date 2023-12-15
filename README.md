# smart-job
Registro de Usuarios

Para ejecutar el servicio descargue el codigo fuente desde el repositorio de github con este link
https://github.com/acostafelix/smart-job.git

Importe el servicio en el IDE de su preferencia y ejecute el servicio.

El servicio levanta en el puerto 8081 por lo que el endpoint para registrar usuarios se encuentra en la siguiente ruta: 

```bash
http://localhost:8081/api/v1/smart-job/usuario
```

El contrato que espera el servicio es el siguiente:

```bash
{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "Smartjob@portal20",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        },
        {
            "number": "1234568",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}
```

El Password debe cumplir con las siquientes caracteristicas: 

El largo debe estar entre 8 y 20 caracteres 
Debe contener un caracter en mayuscula, uno en minuscula un digito
Debe contener alguno de estos caracteres: !@#$%&*()-+=^

Ademas la expresion regular para validar el password puede ser configurada en el properties modificando el atributo 

smart-job:
  password:
    expresion:

Al levantar el servicio queda disponible la base de datos H2 ubicada en el siguiente endpoint:

```bash
http://localhost:8081/h2-console/
```

Es una base de datos configurada en memoria llamada mydb, los datos de conexion se encuentran en el archivo application.yml dentro de la carpeta resorces las tablas que utiliza el servicio estan definidas en el archivo data.sql ubicado en el paquete resources.

Tambien esta disponible la documentacion del servicio a traves de swagger, se puede acceder en el siguiente endpoint:

```bash
http://localhost:8081/swagger-ui.html
```


