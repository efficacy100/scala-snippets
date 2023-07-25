import scala.io.Source

object SqlQueryExecutor {

  def readConfigFile(filePath: String): String = {
    Source.fromFile(filePath).mkString
  }

  def replaceVariables(sqlQuery: String, variables: Map[String, String]): String = {
    variables.foldLeft(sqlQuery) { case (query, (varName, value)) =>
      query.replaceAll("\\$\\{" + varName + "\\}", value)
    }
  }

  def executeSqlQuery(sqlQuery: String): Unit = {
    // Implement the code to execute the SQL query against your database here.
    // This will depend on the database and the Scala database library or connector you are using.
    // For example, you can use Scala's JDBC or a third-party library like Quill or Slick.
  }

  def main(args: Array[String]): Unit = {
    val configFile = "queries.conf"
    val configContent = readConfigFile(configFile)

    // Variables to replace in the SQL queries
    val variables = Map(
      "value" -> "42",
      "value1" -> "John",
      "value2" -> "Doe"
    )

    // Split the configContent into individual SQL queries
    val queries = configContent.split(";").map(_.trim)

    queries.foreach { query =>
      if (query.nonEmpty) {
        println(f" query received is  ${query}  ")
      }
    }
  }
}
