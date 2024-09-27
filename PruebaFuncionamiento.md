# Pruebas de funcionamiento

En este documento observará las pruebas que se realizaron para corroborar la funcionalidad del programa una vez que éste se ejecuta desde la clase `Main.java`.
El orden de distribución del documento está especificado en el apartado [Funcionalidades](#Funcionalidades).
## Funcionalidades

1. [Encriptar](#encriptar)
2. [Desencriptar](#desencriptar)
3. [Fuerza Bruta](#fuerza-bruta)
4. [Salir](#salir)


### Encriptar
Para realizar un encriptado se empleó lo siguiente:

- **Ruta del archivo fuente:** `src/toEncrypt.txt`. Este documento contiene un cuento titulado La biblioteca de Babel escrito por Jorge Luis Borges.Tiene un tamaño de 16KB. 
- **Clave para el Cifrado César:** **5**
- **Ruta del archivo destino:** `src/toDecrypt.txt`. En esta ruta se guardará el texto encriptado.

A continuación se ilustra una prueba de funcionamiento. Los datos ingresados por el usuario se muestran en líneas discontinuas.
>Bienvenido al Encriptador
>1. Encriptar
>2. Desencriptar
>3. Fuerza Bruta
>4. Análisis Estadístico
>
>   Para salir presione cualquier tecla
   > >1
>
>Ingrese la ruta del archivo fuente
> >src/toEncrypt.txt
>
>Ingrese la ruta del archivo destino
> 
>>src/toDecrypt.txt
> 
>Archivo creado exitosamente src\toDecrypt.txt  
> Ingrese la clave  
>> 5 
> 
> Clave válida  
> Datos ingresados correctamente  
> Lectura realizada con éxito  
> Escritura realizada con éxito

En seguida puede observar un fragmento del archivo `toEncrypt.txt`.
>LA BIBLIOTECA DE BABEL    
Jorge Luis Borges    
El universo (que otros llaman la Biblioteca) se compone de un número indefinido, y
tal vez infinito, de galerías hexagonales, con vastos pozos de ventilación en el medio,
cercados por barandas bajísimas. Desde cualquier hexágono se ven los pisos inferiores y
superiores: interminablemente. La distribución de las galerías es invariable. Veinte
anaqueles, a cinco largos anaqueles por lado, cubren todos los lados menos dos; su altura,
que es la de los pisos, excede apenas la de un bibliotecario normal. Una de las caras libres
da a un angosto zaguán, que desemboca en otra galería, idéntica a la primera y a todas. A
izquierda y a derecha del zaguán hay dos gabinetes minúsculos. Uno permite dormir de
pie; otro, satisfacer las necesidades finales. Por ahí pasa la escalera espiral, que se abisma
y se eleva hacia lo remoto. En el zaguán hay un espejo, que fielmente duplica las
apariencias. Los hombres suelen inferir de ese espejo que la Biblioteca no es infinita (si
lo fuera realmente ¿a qué esa duplicación ilusoria?); yo prefiero soñar que las superficies
bruñidas figuran y prometen el infinito... La luz procede de unas frutas esféricas que
llevan el nombre de lámparas. Hay dos en cada hexágono: transversales. La luz que
>emiten es insuficiente, incesante.

y aquí el mismo fragmento, pero del archivo `toDecrypt.txt`.
>QF?GNGQNTYJHF?IJ?GFGJQ  
Otwlj?Qznx?Gtwljx  
Jq?zsnÁjwxt?-vzj?tywtx?qqfrfs?qf?Gngqntyjhf¿?xj?htrutsj?ij?zs?s rjwt?nsijknsnit)?Ó
yfq?ÁjÚ?nsknsnyt)?ij?lfqjwÑfx?mjÍfltsfqjx)?hts?Áfxytx?utÚtx?ij?Ájsynqfhnñs?js?jq?rjint)
hjwhfitx?utw?gfwfsifx?gfoÑxnrfx(?Ijxij?hzfqvznjw?mjÍÜltst?xj?Ájs?qtx?unxtx?nskjwntwjx?Ó
xzujwntwjx;?nsyjwrnsfgqjrjsyj(?Qf?inxywngzhnñs?ij?qfx?lfqjwÑfx?jx?nsÁfwnfgqj(?ajnsyj
fsfvzjqjx)?f?hnsht?qfwltx?fsfvzjqjx?utw?qfit)?hzgwjs?ytitx?qtx?qfitx?rjstx?itx¡?xz?fqyzwf)
vzj?jx?qf?ij?qtx?unxtx)?jÍhjij?fujsfx?qf?ij?zs?gngqntyjhfwnt?stwrfq(?Zsf?ij?qfx?hfwfx?qngwjx
if?f?zs?fsltxyt?ÚflzÜs)?vzj?ijxjrgthf?js?tywf?lfqjwÑf)?niüsynhf?f?qf?uwnrjwf?Ó?f?ytifx(?F
nÚvznjwif?Ó?f?ijwjhmf?ijq?ÚflzÜs?mfÓ?itx?lfgnsjyjx?rns xhzqtx(?Zst?ujwrnyj?itwrnw?ij
unj¡?tywt)?xfynxkfhjw?qfx?sjhjxnifijx?knsfqjx(?Utw?fmÑ?ufxf?qf?jxhfqjwf?jxunwfq)?vzj?xj?fgnxrf
Ó?xj?jqjÁf?mfhnf?qt?wjrtyt(?Js?jq?ÚflzÜs?mfÓ?zs?jxujot)?vzj?knjqrjsyj?izuqnhf?qfx
fufwnjshnfx(?Qtx?mtrgwjx?xzjqjs?nskjwnw?ij?jxj?jxujot?vzj?qf?Gngqntyjhf?st?jx?nsknsnyf?-xn
qt?kzjwf?wjfqrjsyj?3f?vzü?jxf?izuqnhfhnñs?nqzxtwnf»¿¡?Ót?uwjknjwt?xt!fw?vzj?qfx?xzujwknhnjx
gwz!nifx?knlzwfs?Ó?uwtrjyjs?jq?nsknsnyt(((?Qf?qzÚ?uwthjij?ij?zsfx?kwzyfx?jxküwnhfx?vzj
qqjÁfs?jq?strgwj?ij?qÜrufwfx(?MfÓ?itx?js?hfif?mjÍÜltst;?ywfsxÁjwxfqjx(?Qf?qzÚ?vzj
>jrnyjs?jx?nsxzknhnjsyj)?nshjxfsyj(

Puede observarse que el archivo ha sido encriptado con éxito, en el siguiente apartado observaremos la desencriptación.


### Desencriptar
Para realizar un desencriptado se consideraron los siguientes datos:

- **Ruta del archivo fuente:** `src/toDecrypt.txt`. Este documento contiene el cuento encriptado de La biblioteca de Babel.
- **Clave para el Cifrado César:** **5**
- **Ruta del archivo destino:** `src/toEncrypt.txt`. En esta ruta se guardará el texto desencriptado.

A continuación se ilustra una prueba de funcionamiento. Los datos ingresados por el usuario se muestran en lineas discontinuas.
>Bienvenido al Encriptador
>1. Encriptar
>2. Desencriptar
>3. Fuerza Bruta
>4. Análisis Estadístico
    >
    >   Para salir presione cualquier tecla
> >2
>
>Ingrese la ruta del archivo fuente
> >src/toDecrypt.txt
>
>Ingrese la ruta del archivo destino
>
>>src/toEncrypt.txt
>
>Archivo creado exitosamente src\toEncrypt.txt  
> Ingrese la clave
>> 5
>
> Clave válida  
> Datos ingresados correctamente  
> Lectura realizada con éxito  
> Escritura realizada con éxito

En seguida puede observar un fragmento del archivo `toDecrypt.txt`.
>Izwfsyj?rzhmt?ynjrut?xj?hwjÓñ?vzj?jxtx?qngwtx?nrujsjywfgqjx?htwwjxutsiÑfs?f?qjslzfx
uwjyüwnyfx?t?wjrtyfx(?Jx?Ájwifi?vzj?qtx?mtrgwjx?rÜx?fsynlztx)?qtx?uwnrjwtx
gngqntyjhfwntx)?zxfgfs?zs?qjslzfoj?fxfÚ?inkjwjsyj?ijq?vzj?mfgqfrtx?fmtwf¡?jx?Ájwifi?vzj
zsfx?rnqqfx?f?qf?ijwjhmf?qf?qjslzf?jx?infqjhyfq?Ó?vzj?stÁjsyf?unxtx?rÜx?fwwngf)?jx
nshtruwjsxngqj(?Ytit?jxt)?qt?wjunyt)?jx?Ájwifi)?ujwt?hzfywthnjsyfx?injÚ?uÜlnsfx?ij
nsfqyjwfgqjx?RHa?st?uzjijs?htwwjxutsijw?f?snsl s?nintrf)?utw?infqjhyfq?t?wzinrjsyfwnt
vzj?xjf(?Fqlzstx?nsxnszfwts?vzj?hfif?qjywf?utiÑf?nskqznw?js?qf?xzgxnlznjsyj?Ó?vzj?jq?Áfqtw
ij?RHa?js?qf?yjwhjwf?qÑsjf?ij?qf?uÜlnsf?C6?st?jwf?jq?vzj?uzjij?yjsjw?qf?rnxrf?xjwnj?js
tywf?utxnhnñs?ij?tywf?uÜlnsf)?ujwt?jxf?Áflf?yjxnx?st?uwtxujwñ(?Tywtx?ujsxfwts?js
hwnuytlwfkÑfx¡?zsnÁjwxfqrjsyj?jxf?htsojyzwf?mf?xnit?fhjuyfif)?fzsvzj?st?js?jq?xjsynit?js
>vzj?qf?ktwrzqfwts?xzx?nsÁjsytwjx(

y aquí un el mismo fragmento, pero del archivo `toEncrypt.txt`.
>Durante mucho tiempo se creyó que esos libros impenetrables correspondían a lenguas
pretéritas o remotas. Es verdad que los hombres más antiguos, los primeros
bibliotecarios, usaban un lenguaje asaz diferente del que hablamos ahora; es verdad que
unas millas a la derecha la lengua es dialectal y que noventa pisos más arriba, es
incomprensible. Todo eso, lo repito, es verdad, pero cuatrocientas diez páginas de
inalterables MCV no pueden corresponder a ningún idioma, por dialectal o rudimentario
que sea. Algunos insinuaron que cada letra podía influir en la subsiguiente y que el valor
de MCV en la tercera línea de la página 71 no era el que puede tener la misma serie en
otra posición de otra página, pero esa vaga tesis no prosperó. Otros pensaron en
criptografías; universalmente esa conjetura ha sido aceptada, aunque no en el sentido en
>que la formularon sus inventores.

Puede observarse que el archivo ha sido desencriptado con éxito, en el siguiente apartado observaremos la desencriptación por fuerza bruta.


### Fuerza Bruta
Para realizar un desencriptado por fuerza bruta se consideraron los siguientes datos:

- **Ruta del archivo fuente:** `src/toDecrypt.txt`. Este documento contiene el cuento encriptado de La biblioteca de Babel.
- **Ruta del archivo destino:** `src/toEncrypt.txt`. En esta ruta se guardará el texto desencriptado.

A continuación se ilustra una prueba de funcionamiento. Los datos ingresados por el usuario se muestran en lineas discontinuas.
>Bienvenido al Encriptador
>1. Encriptar
>2. Desencriptar
>3. Fuerza Bruta
>4. Análisis Estadístico
    >
    >   Para salir presione cualquier tecla
> >3
>
>Ingrese la ruta del archivo a desencriptar
> >src/toDecrypt.txt
>
>Ingrese la ruta del archivo destino
>
>>src/toEncrypt.txt
>
>Lectura realizada con éxito  
> Llave encontrada: 5  
> Escritura realizada con éxito  
> Archivo Descifrado con éxito

En seguida puede observar un fragmento del archivo `toDecrypt.txt`.
>Fhfgt?ij?jxhwngnw?nsknsnyf(?St?mj?nsyjwutqfit?jxj?fiojynÁt?utw?zsf?htxyzrgwj?wjyñwnhf¡
inlt?vzj?st?jx?nqñlnht?ujsxfw?vzj?jq?rzsit?jx?nsknsnyt(?Vznjsjx?qt?ozÚlfs?qnrnyfit)
utxyzqfs?vzj?js?qzlfwjx?wjrtytx?qtx?htwwjitwjx?Ó?jxhfqjwfx?Ó?mjÍÜltstx?uzjijs
nshtshjgngqjrjsyj?hjxfw)?qt?hzfq?jx?fgxzwit(?Vznjsjx?qf?nrflnsfs?xns?qÑrnyjx)?tqÁnifs?vzj
qtx?ynjsj?jq?s rjwt?utxngqj?ij?qngwtx(?dt?rj?fywjÁt?f?nsxnszfw?jxyf?xtqzhnñs?ijq?fsynlzt
uwtgqjrf;?Qf?gngqntyjhf?jx?nqnrnyfif?Ó?ujwnñinhf(?Xn?zs?jyjwst?Ánfojwt?qf?fywfÁjxfwf?js
hzfqvznjw?inwjhhnñs)?htruwtgfwÑf?fq?hfgt?ij?qtx?xnlqtx?vzj?qtx?rnxrtx?Átq rjsjx?xj
wjunyjs?js?jq?rnxrt?ijxtwijs?-vzj)?wjujynit)?xjwÑf?zs?twijs;?jq?Twijs¿(?Rn?xtqjifi?xj
fqjlwf?hts?jxf?jqjlfsyj?jxujwfsÚf(  
>KNS

y aquí el mismo fragmento, pero del archivo `toEncrypt.txt`.
>Acabo de escribir infinita. No he interpolado ese adjetivo por una costumbre retórica;
digo que no es ilógico pensar que el mundo es infinito. Quienes lo juzgan limitado,
postulan que en lugares remotos los corredores y escaleras y hexágonos pueden
inconcebiblemente cesar, lo cual es absurdo. Quienes la imaginan sin límites, olvidan que
los tiene el número posible de libros. Yo me atrevo a insinuar esta solución del antiguo
problema: La biblioteca es ilimitada y periódica. Si un eterno viajero la atravesara en
cualquier dirección, comprobaría al cabo de los siglos que los mismos volúmenes se
repiten en el mismo desorden (que, repetido, sería un orden: el Orden). Mi soledad se
alegra con esa elegante esperanza.  
>FIN

Puede observarse que el archivo ha sido desencriptado con éxito.

### Salir
 Si desea terminar el programa, ingrese cualquier caracter por teclado que no esté en el menú, no olvide presionar **Enter**.
 >Para salir presione cualquier tecla
 >>R
 > >
 >Hasta Luego