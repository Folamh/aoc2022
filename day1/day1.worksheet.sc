val input = os.read(os.pwd / "day1" / "input.txt")  /*>  : String = """91955496273283643703319971771659730721771011867814080646…  */
val elves = input.split("\n\n").map(_.split("\n").map(_.toInt).sum)  /*>  : Array[Int] = Array(41525,33253,53181,22456,49979,69…  */
println("Part 1: " + elves.max)  /*>  Part 1: 69281  */
println("Part 2: " + elves.sorted.takeRight(3).sum)  /*>  Part 2: 201524  */
