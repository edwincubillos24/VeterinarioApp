# VeterinarioApp
#POO
1. ¿Qué es un objeto? Es una instancia de una clase
2. ¿Qué es una clase? Es la base de la encapsulación, es una coleccin de variables combinado con un conjunto de funciones
   con el objetivo de modelar objetos o situaciones de la vida real.
3. ¿Qué es herencia? La herencia permite que una clase pueda heredar los atributos de otra clase, por ejemplo si se tiene 
   una clase llamada "Persona" con los atributos nombre y edad, se puede crear una clase "Estudiante" que herede los atributos
   de Persona y adicionar mas atributos.
4. ¿Qué es polimorfismo? Es la posibilidad de definir clases diferentes que tienen metodos y atributos denominados de forma 
   identica
5. ¿Qué significa la palabra clave static? se utiliza en una clase y permite el acceso a metodos y atributos de una clase sin
   necesidad de instanciar la clase
6. ¿Cuáles son las diferencias entre interfaces, clases abstractas, clases e instancias? una interfaz es un medio con el que 
   se pueden comunicar varios objetos no relacionados, las clases abstractas son clases que no pueden ser instanciadas, una 
   clase puede ser instanciada
7. ¿Qué son los diferentes niveles de acceso en los atributos y métodos? Descríbalos. Los niveles de acceso son las 
   restricciones que tiene los datos para ser accedidos y se aplican tanto para las clases, objetos, metodos y atributos
   
   MODIFICADOR    CLASE   PACKAGE   SUBCLASE  TODOS
   public         si      si        si        si
   protected      si      si        si        no
   no especifico  si      si        no        no  
   private        si      no        no        no   
   
8. ¿Qué es sobrecarga y sobreescritura de métodos? La sobrecarga de métodos permite tener dos o más funciones con el mismo
   nombre pero diferente funcionalidad, la sobreescritura de métodos permite redefinir un metodo de una clase que ha heredado 
   de su clase padre
9. ¿Qué es inmutabilidad? Es cuando no se puede modificar el estado de un objeto una vez se ha creado 
10 ¿Cómo se maneja o controla una excepción? Para manejarlos se puede utilizar un Try-Catch
11.¿Qué significa “Paso por valor” y “Paso por referencia”? En el paso por valor se pasa una copia de la variable al método o
   función, si el valor es modificado dentro de la función solo se modifica en ella, pero cuando se pasa por referencia se 
   pasa el valor original, si se modifica dentro de la función se modifica el valor original

#POO
1. ¿Qué es un Activity? Es uno de los principales componentes de una aplicación formada por una interfaz de usuario y un 
   código que en java o kotlin que controla la interacción con la interfaz
2. ¿Cuál es el ciclo de vida de un Activity? Esta compuesto por 7 metodos: onCreate, onStart, onResume, onPause, onStop, 
   onRestart y onDestroy y 4 estados: Activa (Running), visible (Paused), parada (Stopped) y destruida (Destroyed)
3. ¿Qué es un Fragment y cuál es su relación con las Actividades? Un Fragment es una interfaz de usuario que puede añadirse,  
   reemplazarse o eliminarse de forma independiente al resto de los elementos de la actividad, esto permite dividir la interfaz
   en varias porciones de forma que se pueda diseñar diversas configuraciones de pantalla: tamaño y orientación
4. ¿Qué es un Content Provider y para qué se utiliza? Un Content Provider es un mecanismo que permite compartir información
   entre diferentes aplicaciones sin mostrar detalle del almacenamiento interno, estructura o implementación
5. ¿Qué es el Android Manifest? Es un archivo donde se registra la configuación de la aplicación.
6. ¿Cuál es la estructura de un proyecto Android? Es la forma como se organizan los archivos y paquetes de la aplicación 
   hay tres componentes principales, una carpeta manfiest donde se almacena el Android Manifest, una carpeta java donde van
   los archivos de java o kotlin con la lógica de la aplicación y la carpeta res donde van todos los recursos de la aplicación
7. ¿Qué es el build.gradle? Es un archivo que permite la compilación y construcción del proyecto.
8. ¿Qué es un layout? Es un contenedor en el cual se organizan diferentes widgets como Buttons, EditText, TextView, etc
9. ¿Nombre algunos tipos de layout? ConstraintLayout, FrameLayout, RelativeLayout, LinearLayout, TableLayout
10.¿Qué es un View? Es la clase base a partir de la cual se crean los elementos de una interfaz de usuario, contiene numerosas
   subclases, cada una con funciones específicas
11.¿Qué es un Intent? Un intent es una descripción abstracta de una operación a ser realizada como: Abrir otras actividades
   Iniciar o detener servicios, enviar broadcast, compartir información entre actividades.
12.¿Qué es un AsyncTask? Es un mecanismo que tiene Android para realizar tareas asincrónicas, estas tareas se ejecutan en un
   hilo diferente al principal
13.¿Cuál es la relación entre un AsyncTask y una Actividad? Normalemente el resultado de una AsyncTask se publica en la 
   actividad donde fue llamado.
14.¿Qué es ANR y como lo evitas? ANR es un tipo de error "Aplicación no responde" y se produce cuando el subproceso de IU se 
   bloquea durante demasiado tiempo
15.¿Qué es un Services? Un Service permite ejecutar tareas en segundo plano, normalmente se usan para tareas de larga duración
