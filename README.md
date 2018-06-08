# scala-sparkhelloworld
Hola mundo con el framework Spark escrito en scala. Muestra como montar un cluster con un maestro y un trabajador, ejecutar una aplicación en ellos y dividir tareas.


instalar JDK 1.8
instalar Python 3.6 y 2.7 (por si acaso)

----------PARA COMPILAR EL PROYECTO------------

SOLO SI NO HAY INTERNET EN TU PC
	copiar la carpeta cache a C:\Users\<nombreUsuario>\.ivy2\
	a veces necesita llamarse local en vez de cache

Si hay internet en tu pc:
	abrir intellij y abrir el proyecto Spark1
	instalar plugin SBT si es que no viene ya instalado
	en la barra de herramientas que hay arriba derecha
	abrir desplegable de menu "build" y elegir "Edit configurations..."
	añadir con cruz verde una configuracion de "sbt" y en Tasks poner "clean compile package"
	ejecutar con flecha "play" verde

------------------------------------------------

copia el winutils de 32 o 64 bits, dependiendo de tu Windows, en la carpeta Hadoop\bin\
establece la variable de entorno HADOOP_HOME apuntando a <estaCarpeta>\Hadoop
en mi caso ha sido: C:\Users\ElPutoAmo\IdeaProjects\Spark1\Hadoop
copiar spark1_2.11-0.1.jar que esta en ...blablabla...Spark1\target\scala-2.11
a la carpeta de spark en mi caso:
C:\Users\ElPutoAmo\Desktop\spark-2.3.0-bin-hadoop2.7\bin

abre una powershell
ve a la carpeta ...blablabla...Spark1\Hadoop\bin:
cd C:\Users\ElPutoAmo\IdeaProjects\Spark1\Hadoop\bin
ejecuta el cambio de permisos:
./winutils.exe chmod 777 tmp\hive


---MAESTRO---

abre una powershell
ve a la carpeta de spark, en mi caso:
cd .\Desktop\spark-2.3.0-bin-hadoop2.7\bin
ejecuta el servidor spark maestro
.\spark-class org.apache.spark.deploy.master.Master
copiar la direccion IP de este servidor maestro


---TRABAJADOR---

abre una powershell
ve a la carpeta de spark
ejecuta un trabajador
.\spark-class org.apache.spark.deploy.worker.Worker spark://<direccionIPMaestro>:7077


---APLICACION---

abre una powershell
ve a la carpeta de spark
ejecuta el script para que cargue nuestro programa de tutorial
./spark-submit --class Ejecutor --master spark://<direccionIPMaestro>:7077 spark1_2.11-0.1.jar


deberia haber creado la carpeta prueba1 con dos archivos:
part-00000 y part-00001 (abrir con bloc notas)
