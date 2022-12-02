val input = os.read.lines(os.pwd / "day2" / "input.txt")
val matches1 = input.map(_.split(" ").map(convert1).toList).toList
val matches2 = input.map(_.split(" ").map(convert2).toList).toList

println("Part 1: " + matches1.map(score1).sum)
println("Part 2: " + matches2.map(score2).sum)

def convert1(symbol: String) =
  symbol match {
    case "A" | "X" => Rock
    case "B" | "Y" => Paper
    case "C" | "Z" => Scissors
  }

def score1(game: List[Throws]) = 
  game match {
    case Rock :: Rock :: Nil => Draw.points + Rock.points
    case Rock :: Paper :: Nil => Win.points + Paper.points
    case Rock :: Scissors :: Nil => Lose.points + Scissors.points
    case Paper :: Rock :: Nil => Lose.points + Rock.points
    case Paper :: Paper :: Nil => Draw.points + Paper.points
    case Paper :: Scissors :: Nil => Win.points + Scissors.points
    case Scissors :: Rock :: Nil => Win.points + Rock.points
    case Scissors :: Paper :: Nil => Lose.points + Paper.points
    case Scissors :: Scissors :: Nil => Draw.points + Scissors.points
  }

def convert2(symbol: String) = 
  symbol match {
    case "A" => Rock
    case "B" => Paper
    case "C" => Scissors
    case "X" => Lose
    case "Y" => Draw
    case "Z" => Win
  }

def score2(game: List[Any]) = 
  game match {
    case Rock :: Draw :: Nil => Draw.points + Rock.points
    case Rock :: Win :: Nil => Win.points + Paper.points
    case Rock :: Lose :: Nil => Lose.points + Scissors.points
    case Paper :: Lose :: Nil => Lose.points + Rock.points
    case Paper :: Draw :: Nil => Draw.points + Paper.points
    case Paper :: Win :: Nil => Win.points + Scissors.points
    case Scissors :: Win :: Nil => Win.points + Rock.points
    case Scissors :: Lose :: Nil => Lose.points + Paper.points
    case Scissors :: Draw :: Nil => Draw.points + Scissors.points
  }

trait Result {
  val points: Int
}
object Win extends Result {
  val points: Int = 6
}
object Lose extends Result {
  val points: Int = 0
}
object Draw extends Result {
  val points = 3
}

trait Throws {
  val points: Int
}
object Rock extends Throws {
  val points: Int = 1
}
object Paper extends Throws {
  val points: Int = 2
}
object Scissors extends Throws {
  val points: Int = 3
}