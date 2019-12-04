import scala.util.matching.Regex

object Main {
  def tests(pw : Int) : Boolean = {
    var chrs = pw.toString.split("")

    val a = chrs(0)
    val b = chrs(1)
    val c = chrs(2)
    val d = chrs(3)
    val e = chrs(4)
    val f = chrs(5)
    
    return allIncreasing(a, b, c, d, e, f) &&
      containsRepeat(a, b, c, d, e, f)
  }

  def tests2(pw : Int) : Boolean = {
    var chrs = pw.toString.split("")

    val a = chrs(0)
    val b = chrs(1)
    val c = chrs(2)
    val d = chrs(3)
    val e = chrs(4)
    val f = chrs(5)
    
    return allIncreasing(a, b, c, d, e, f) &&
      containsNonAdjacentRepeat(pw.toString)
  }

  def allIncreasing(a : String, b : String, c : String, d : String, e : String, f : String) : Boolean = {
    return a <= b && b <= c && c <= d && d <= e && e <= f
  }
  
  def containsRepeat(a : String, b : String, c : String, d : String, e : String, f : String) : Boolean = {
    return a == b || b == c || c == d || d == e || e == f
  }

  def containsNonAdjacentOf(pw : String, chr : String) : Boolean = {
    return (pw contains (chr * 2)) && !(pw contains (chr * 3))
  }
  def containsNonAdjacentRepeat(pw : String) : Boolean = {
    return containsNonAdjacentOf(pw, "1") ||
      containsNonAdjacentOf(pw, "2") ||
      containsNonAdjacentOf(pw, "3") ||
      containsNonAdjacentOf(pw, "4") ||
      containsNonAdjacentOf(pw, "5") ||
      containsNonAdjacentOf(pw, "6") ||
      containsNonAdjacentOf(pw, "7") ||
      containsNonAdjacentOf(pw, "8") ||
      containsNonAdjacentOf(pw, "9") ||
      containsNonAdjacentOf(pw, "0")
  }

  def main(args: Array[String]): Unit = {
    val from = 134564
    val to = 585159
    var matches = 0
    for (i <- from to to) {
      if (tests(i)) {
        matches += 1
      }
    }
    println("matches", matches)

    matches = 0
    for (i <- from to to) {
      if (tests2(i)) {
        matches += 1
      }
    }
    // 1634 too high
    // 1306 correct
    println("matches 2", matches)
  }
}