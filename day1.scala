import scala.util.control._
import scala.io.Source

object Main {
  def rock_it_mass(m: Int): Int = {
    var sum : Int = 0
    var mass : Int = m
    val loop = new Breaks;
    loop.breakable {
      while ( true ) {
        mass = (mass / 3f).floor.toInt - 2
        if ( mass <= 0 ) {
          loop.break
        }
        sum += mass
      }
    }
    return sum
  }

  def sum(xs: List[Int]): Int = {
    xs match {
      case x :: tail => x + sum(tail)
      case Nil => 0
    }
  }

  def allMasses(fileName: String): List[Int] = {
    var masses : List[Int] = List()
    Source.fromFile(fileName).getLines.foreach{ line =>
      masses = line.toInt :: masses
    }
    return masses
  }

  def main(args: Array[String]): Unit = {
    val all = allMasses("input/day1.txt")
    val rocketed = all.map { mass => rock_it_mass(mass) }
    val massSum = sum(rocketed)
    println(massSum)
  }
}
