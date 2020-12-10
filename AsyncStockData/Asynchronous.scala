import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure,Success}
import scala.io.Source.fromURL

object Asynchronous extends App {

  val starttime = currenttime

  val url1 = "https://www.url1.com"
  val url2 = "https://www.url2.com"
  val url3 = "https://www.url3.com"

  val data1 : Future[String] = getdata(url1)
  val data2 = getdata(url2)
  val data3 = getdata(url3)

  val result: Future[(String, String, String)] = for {
    appl <- data1
    timese <- data2
    applmet <- data3
  } yield (appl, timese, applmet)

  result.onComplete {
    case Success(res) => {
      val totaltime = deltatime(starttime)
      println(s"total time is ${totaltime}")
      println(s"result is \n $res")
    }
    case Failure(e) => e.printStackTrace()
  }

  sleep(5000)

  def sleep(sleeptime: Long) : Unit = Thread.sleep(sleeptime)

  def getdata(sym : String) : Future[String] = Future {
    println(s"Sending requrest to $sym")
    val json = fromURL(sym).mkString
    json
  }

  def currenttime = System.currentTimeMillis()
  def deltatime(dtime : Long) = currenttime - dtime
}
