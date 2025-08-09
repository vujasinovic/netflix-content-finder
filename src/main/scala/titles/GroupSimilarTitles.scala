package titles

object GroupSimilarTitles extends App {

  def groupTitles(inputs: List[String]): Iterable[List[String]] = {
    val result = scala.collection.mutable.Map[List[Int], List[String]]()
    val aString = "a";

    for (input <- inputs) {
      var count = List.fill(26) {
        0
      }

      for (i <- 0 until input.length) {
        val index: Int = input.codePointAt(i) - aString.codePointAt(0)
        val value = count(index) + 1
        count = count.updated(index, value)
      }

      if (result.contains(count))
        result(count) = result(count) :+ input
      else
        result(count) = List(input)
    }

    result.values
  }

  var titles = List("duel", "dule", "speed", "spede", "seedp", "deul", "cars")
  var gt = groupTitles(titles)
  var query = "spede"

  for (g <- gt)
    if (g.contains(query))
      print(g)

}
