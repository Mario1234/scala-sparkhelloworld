
import org.apache.spark._

object Ejecutor{
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark Pi")
    val contextoSpark = new SparkContext(conf)
    val slices = if (args.length > 0) args(0).toInt else 2
    val x = contextoSpark.parallelize(List("spark", "rdd", "example", "sample", "example"), slices)
    val y = x.map((_, 1))
    var cadena = ""
    for(elem <- (y.collect))cadena+=elem._1 +"-"+ elem._2
    println(cadena)
    //res0: Array[(String, Int)] = Array((spark,1), (rdd,1), (example,1), (sample,1), (example,1))

    // Another example of making tuple with string and it's length
    val z = x.map(x => (x, x.length))
    //(z.collect).foreach{print(_._1+"-"+_._2)}
//    cadena=""
//    for(elem <- z.collect)cadena+=elem._1 +"-"+ elem._2
//    println(cadena)
    z.saveAsTextFile("prueba1")
    //res0: Array[(String, Int)] = Array((spark,5), (rdd,3), (example,7), (sample,6), (example,7))
    contextoSpark.stop()
  }
}