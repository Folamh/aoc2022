import scala.collection.mutable.ListBuffer
val input = os.read.lines(os.pwd / "day3" / "input.txt")
val compartments = input.map(line => line.toList.splitAt(line.length / 2))
val intersect = compartments.map{case (left, right) => convert(left.intersect(right).distinct)}
val groups = group(input.iterator)
println("Part 1: " + intersect.flatten.sum)
println("Part 2: " + groups.map(packs => packs.tail.foldLeft(packs.head.toList){(a, b) => a.intersect(b)}).map(convert).flatten.sum)

def group(lines: Iterator[String]) = {
  val groups = ListBuffer.empty[List[String]]
  while(lines.hasNext) {
    groups += lines.take(3).toList
  }
  groups.toList
}

def convert(list: List[Char]) = {
  list.map(c => {
    val i = c.toInt
    if (i >= 96) i - 96
    else i - 38 
  })
}
