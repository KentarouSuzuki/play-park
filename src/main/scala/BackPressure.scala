import akka._
import akka.actor._
import akka.stream._
import akka.stream.scaladsl._

object BackPressure extends App{
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  import system.dispatcher

  val source = Source(1 to 10)
  val toStringFlow = Flow[Int].map {e =>
    println(s"$e to string")
    e.toString
  }
  val sleepFlow = Flow[String].map { e =>
    Thread.sleep(5000)
    e
  }
  val sink = Sink.foreach[String](e => println(s"sink $e"))

  val flowGraph = RunnableGraph.fromGraph(GraphDSL.create(){implicit builder: GraphDSL.Builder[NotUsed] =>
    import GraphDSL.Implicits._
    source ~> toStringFlow  ~> sleepFlow ~> sink
    ClosedShape
  })

  flowGraph.run()
}
