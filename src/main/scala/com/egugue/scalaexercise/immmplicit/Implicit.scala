package com.egugue.scalaexercise.immmplicit

/**
  * Created by htoyama on 2017/01/21.
  */
object Implicit {

  def main(args: Array[String]): Unit = {
    if (1) {
      println("1 is true.")
    }

    println("foo".smile())
    println("foo".sad())

    {
      implicit val str: String = "implicit"

      println(connectTwoString("foo")("bar"))
      println(connectTwoString("foo"))
    }

    {
      val sum1 = sum(List("foo", "bar", "baz"))
      println(sum1)

      val sum2 = sum(List(1, 10, 100))
      println(sum2)
    }

  }

  implicit def intToBoolean(x: Int): Boolean = x != 0

  //implicit def enrichString(str: String): RichString = RichString(str)

  implicit class RichString(str: String) {
    def smile(): String = str + ":)"

    def sad(): String = str + ":("
  }

  def connectTwoString(str1: String)(implicit str2: String): String = str1 + " " + str2

  def sum[A](list: List[A])(implicit m: Additive[A]): A = list.foldLeft(m.zero)((x, y) => m.plus(x, y))

  implicit object StringAdditive extends Additive[String] {
    override def plus(a: String, b: String): String = a + " " + b

    override def zero: String = "zero"
  }

  implicit object IntAd extends Additive[Int] {
    override def plus(a: Int, b: Int): Int = a + b

    override def zero: Int = 0
  }

  trait Additive[A] {
    def plus(a: A, b: A): A

    def zero: A
  }
}


/*
class RichString(value: String) {
  def smile(): String = value + ":)"
}

object RichString {
  def apply(value: String): RichString = new RichString(value)
}
*/

