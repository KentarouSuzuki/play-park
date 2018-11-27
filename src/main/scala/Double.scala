import akka._
import akka.actor._
import akka.stream._
import akka.stream.scaladsl._


object Double extends App{
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  import system.dispatcher


  val source = Source(1 to 100)
  val doubleFlow = Flow[Int].map(_ * 2)
  val sink = Sink.foreach[Int](println)

  val flowGraph = RunnableGraph.fromGraph(GraphDSL.create(){implicit builder: GraphDSL.Builder[NotUsed] =>
    import GraphDSL.Implicits._
    source ~> doubleFlow ~> sink
    ClosedShape
  })

  flowGraph.run()
}
