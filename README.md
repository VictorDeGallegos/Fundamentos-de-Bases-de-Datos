# Fundamentos-de-Bases-de-Datos 👨🧑💬🗣💻📊

Repositorio de prácticas y ejercicios de La asignatura de Fundamentos de Bases de Datos semestre 2022-1

- [Fundamentos-de-Bases-de-Datos 👨🧑💬🗣💻📊](#fundamentos-de-bases-de-datos-)
  - [**Practica02**](#practica02)
    - [1.Repositorio 📦](#1repositorio-)
    - [2.Practica ​💻​👩‍💻​🕙​📆​](#2practica-)
    - [3.Reporte 📋](#3reporte-)
    - [4.Preguntas ❔](#4preguntas-)

## **Practica02**

### 1.Repositorio 📦

Victor creará un repositorio privado en github y les mandara a cada uno
solicitud para hacerlos colaboradores, dicho repositorio se creará junto con
2 ramas (Main y Develop) y el resto creará su propia rama con su nombre

- **Main** :
  - En esta rama irá todo el código y documentación que
entregamos por lo que no se tocará sino hasta el final.

- **Develop** :
  - Esta es la rama de (desarrollo) donde cada uno de nosotros
tendremos que hacer merge de la rama personal que le corresponda
a cada uno de nosotros

- **Rama Personal** :
  - Esta es la rama que debe crear cada uno de
nosotros con su nombre `ejemplo: RamaVictor` y donde trabajarán y
realizarán los cambios que ustedes quieran.

`Sugerencia:` Si no tienen mucha experiencia usando git vean [tutoriales](https://www.youtube.com/watch?v=8Ay_gSQlL5s&ab_channel=EscapeSchool), de manejo y creación de ramas en git, o preguntar a los demás integrantes del equipo

### 2.Practica ​💻​👩‍💻​🕙​📆​

**Descripcion**

Nixut necesita almacenar información sobre los clientes, proveedores,
productos y categorías que actualmente están dentro de la tienda. La
información que se capturara se utilizará más adelante para poblar la base
de datos una vez que esté creada. Por lo tanto deben tener cuidado al
momento de concretar las entidades que se utilizaran para este trabajo.
El prototipo debe permitir para los: clientes, proveedores, productos y
categorías:

- a) Agregar
- b) Consultar
- c) Editar
- d) Eliminar

`Sugerencia:` (Se debe tener en cuenta la relación que existe entre las entidades.)

La información capturada tiene que persistir, por lo que el sistema debe
guardar y leer la información en archivos .CSV, se tomará cuenta cómo se
organizan estos archivos .CSV para almacenar la información.

**¿Qué tenemos?** ✔

El ayudante nos proporcionó unas clases que hacen una parte del programa solicitado que nos
permite:

- Agregar un operador ya especificado
- Ver ese operador agregado

**¿Qué nos falta?** 😱

El programa que el ayudante nos proporciono solo agrega un operador debemos cambiar el tipo
de operador por cliente y así tener los 2 puntos ya mencionados anteriormente por lo que nos
faltaría

- Editar
- Eliminar

y Hacer persistente este programa, es decir que una vez que lo cerremos y volvamos a abrir la
informacion guardada por última vez siga siendo interactiva

**Reparticion de trabajo** 😱

Para hacer mas rapido la elaboración de la práctica propongo que terminemos los dos métodos
faltantes del archivo [EjemploPractica2](https://drive.google.com/file/d/1Tk-TnOpv-JqtDKGIcyAym64wJIj70THk/view) que son

- Editar
- Eliminar

Somos 5 integrantes por lo tanto propongo que hasta el jueves 14 todos intentemos hacer
cualquiera de los 2 métodos faltantes y en cuanto le funcione a alguno del equipo notificarlo
para seguir avanzando porque según él [CasoDeUsoReducido.pdf](https://drive.google.com/file/d/10PZWZTAGzZGz6oxIm2XxfKB-mnKHuFJQ/view) nuestro programa en
particular necesitará lo siguiente:

- Clientes: Nombre completo, CURP, Dirección, Género, Fecha de
nacimiento, edad, email, password, método de pago, puntos de
promociones
- Proveedores: Razon social, RFC, Dirección, Multiples Teléfonos de
contacto
- Productos: Precio, Unidades disponibles en inventario, Descripcion
del producto, Nombre del archivo de imagen asociada, y Descuento(si
es que tiene)
- Categorias: Categorías: Nombre, Descripción detallada de la categoria, Numero
de productos en una categoría

`Sugerencia:` (Preguntar al ayudante si estos son los datos que debe de llenar nuestra base de datos o solo es un
ejemplo para inventar los nuestros)

### 3.Reporte 📋

*Haremos un google doc para realizarlo*

Debemos entregar un reporte en formato pdf que se llame Practica02, donde se incluya
el análisis de requerimientos que realizamos sobre el caso de uso reducido
[CasoDeUsoReducido.pdf](https://drive.google.com/file/d/10PZWZTAGzZGz6oxIm2XxfKB-mnKHuFJQ/view)

### 4.Preguntas ❔

*Haremos un google doc para realizarlo*

Además en el reporte debemos contestar lo siguiente:

- Menciona 5 diferencias entre almacenar la información utilizando un sistema de
  archivos a almacenarla utilizando una base de datos. (cada uno dará 1 diferencia)

- Describe cual es más conveniente utilizar (sistema de archivos o base de
  datos) .(Todos pondremos que creemos que es más conveniente y al final llegamos a una

---
⌨️ con ❤️ por [Victor Gallegos](https://github.com/VictorDeGallegos)🧑🏻 ,  [Carlos Cruz](https://github.com/CarlosCruzRangel)🧑🏼 [Demian Jimenez](https://github.com/demian35)🧑🏻
