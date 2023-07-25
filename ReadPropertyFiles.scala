import scala.io.Source
import java.util.Properties
//import scala.collection.JavaConverters._
import scala.jdk.CollectionConverters._

object SqlQueryExecutor {

  def readConfigFile(filePath: String): Properties = {
    val properties = new Properties()
    val reader = Source.fromFile(filePath)
    properties.load(reader.bufferedReader())
    reader.close()
    properties
  }

  def executeSqlQuery(sqlQuery: String): Unit = {
    // Implement the code to execute the SQL query against your database here.
    // This will depend on the database and the Scala database library or connector you are using.
    // For example, you can use Scala's JDBC or a third-party library like Quill or Slick.
  }

  def main(args: Array[String]): Unit = {
    val configFile = "queries.properties"
    val properties = readConfigFile(configFile)

    properties.stringPropertyNames().asScala.foreach { key =>
       val value: String = properties.getProperty(key)
        // Do something with the key-value pair
        println(s"$key -> $value")
     }
  }
}
