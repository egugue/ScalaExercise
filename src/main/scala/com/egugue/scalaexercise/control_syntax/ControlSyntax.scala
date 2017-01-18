package com.egugue.scalaexercise.control_syntax

import java.security.SecureRandom

import scala.util.Random

/**
  * Created by htoyama on 2017/01/19.
  */
object ControlSyntax {

  def question1(age: Int)(isSchoolStarted: Boolean): String = {
    if (1 <= age && age <= 6 && isSchoolStarted) {
      "Infant"
    } else {
      "Not infant"
    }
  }

  def loopFrom0To9(): Unit = {
    var i = 1
    do {
      println(i)
      i = i + 1
    } while (i < 10)
  }

  def question2() = {
    for (i <- 1 to 1000) {
      val list = new Random(new SecureRandom())
        .alphanumeric
        .take(5)
        .toList

      val result = list match {
        case List(a, b, c, d, _) => List(a, b, c, d, a).mkString
      }

      println(result)
    }
  }

  def main(args: Array[String]): Unit = {
    val answer1 = question1(1)(isSchoolStarted = true)
    println(answer1)

    loopFrom0To9()

    question2()
  }
}
