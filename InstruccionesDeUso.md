# Cifrado César

Este programa realiza un **Cifrado César** mediante archivos `.txt` de un tamaño máximo de **500 MB**. Para iniciar el programa, debes ejecutarlo desde `Main.java`. A continuación, se describe el menú que aparece en la consola, junto con sus funcionalidades y cómo utilizarlas.

## Menú

1. [Encriptar](#encriptar)
2. [Desencriptar](#desencriptar)
3. [Fuerza Bruta](#fuerza-bruta)
4. [Análisis Estadístico](#análisis-estadístico)

   [Salir](#salir)

### Encriptar

Para encriptar un archivo necesitas:

- **Ruta del archivo fuente:** Asegúrate de que la ruta contenga el nombre del archivo a encriptar y la extensión `.txt`.
- **Clave para el Cifrado César:** Debe ser un número entero entre 1 y 25.
- **Ruta del archivo destino:** Asegúrate de que la ruta contenga el nombre del archivo donde se almacenará el texto encriptado. Si el archivo no existe, el programa lo creará automáticamente.

**Pasos para encriptar:**

1. En el menú, presiona el número **1**.
2. Ingresa la ruta del archivo a encriptar.
3. Ingresa la ruta destino para el archivo encriptado.
4. Proporciona la clave.

Si los datos ingresados son válidos, verás el mensaje:
> "Datos ingresados correctamente"

Si el proceso de encriptación se ha realizado con éxito, verás en pantalla:
> "Lectura realizada con éxito"
>
> "Escritura realizada con éxito"

Ahora puedes revisar tu archivo encriptado en la ruta de destino que ingresaste. ¡Disfruta enviando mensajes a tus amigos!

### Desencriptar

Para desencriptar un archivo necesitas:

- **Ruta del archivo fuente:** Asegúrate de que la ruta contenga el nombre del archivo a desencriptar y la extensión `.txt`.
- **Clave para el Cifrado César:** Debe ser un número entero entre 1 y 25, y debe ser el mismo que se utilizó para la encriptación.
- **Ruta del archivo destino:** Asegúrate de que la ruta contenga el nombre del archivo donde se almacenará el texto desencriptado. Si el archivo no existe, el programa lo creará automáticamente.

**Pasos para desencriptar:**

1. En el menú, presiona el número **2**.
2. Ingresa la ruta del archivo a desencriptar.
3. Ingresa la ruta destino para el archivo desencriptado.
4. Proporciona la clave.

Si los datos ingresados son válidos, verás el mensaje:
> "Datos ingresados correctamente"

Si el proceso de desencriptación se ha realizado con éxito, verás en pantalla:
> "Lectura realizada con éxito"
>
> "Escritura realizada con éxito"

Ahora puedes revisar tu archivo desencriptado en la ruta de destino que ingresaste. ¡Lee los mensajes secretos que te han enviado tus amigos!

### Fuerza Bruta

¿Olvidaste la clave de encriptación de tu último mensaje? ¡No te preocupes! La opción **Fuerza Bruta** te ayudará a descifrar el mensaje, sin importar el motivo por el cual no la tengas.

Para desencriptar un archivo con fuerza bruta necesitas:

- **Ruta del archivo fuente:** Asegúrate de que la ruta contenga el nombre del archivo a desencriptar y la extensión `.txt`.
- **Ruta del archivo destino:** Asegúrate de que la ruta contenga el nombre del archivo donde se almacenará el texto desencriptado. Si el archivo no existe, el programa lo creará automáticamente.
- **Paciencia.**

**Pasos para desencriptar con fuerza bruta:**

1. En el menú, presiona el número **3**.
2. Ingresa la ruta del archivo a desencriptar.
3. Ingresa la ruta destino para el archivo desencriptado.

Si el proceso se realiza con éxito, verás en pantalla:
> "Lectura realizada con éxito"
>
> "Llave encontrada: clave" (indica la clave empleada para desencriptar)
>
> "Escritura realizada con éxito"
>
> "Archivo descifrado con éxito"

Ahora puedes revisar tu archivo desencriptado en la ruta de destino que ingresaste. ¡La próxima vez, asegúrate de tener la clave contigo, ya que esto puede tardar un poco!

### Análisis Estadístico

Próximamente.

### Salir

Para salir, ingresa cualquier carácter que no corresponda a un número en el menú. No olvides presionar **Enter**.