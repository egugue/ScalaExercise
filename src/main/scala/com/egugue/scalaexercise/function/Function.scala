package com.egugue.scalaexercise.function

/**
  * Created by htoyama on 2017/01/21.
  */
object Function {

  def main(args: Array[String]): Unit = {
    //
    val add = (x: Int, y: Int) => x + y
    println(add(1, 2))

    val curriedAdd = (x: Int) => (y: Int) => x + y
    println(curriedAdd(1)(2))

    //
    println(double(2, x => x * x))

    //
    around(
      () => println("set up"),
      () => println("do somethingl"),
      () => println("tear down")
    )

    around(
      () => println("set up"),
      () => throw new RuntimeException(),
      () => println("tear down")
    )
  }

  def double(n: Int, f: Int => Int):Int = f(f(n))

  def around(init: () => Unit, body: () => Any, fin: () => Unit): Unit = {
    init()
    try {
      body()
    } finally {
      fin()
    }
  }
}