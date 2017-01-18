package com.egugue.scalaexercise.basic

/**
  * @see https://dwango.github.io/scala_text/basic.html
  */
object Basic {

  def question1(amount: Int)(anualInterestRate: Double)(month: Int): Double = {
    amount * (anualInterestRate / 12) * month
  }

  def question2() = {
    //Skip
  }

  def main(args: Array[String]): Unit = {
    val answer1 = question1(3950000)(0.023)(8)
    println("the answer of question 1 is " + answer1)
  }

}
