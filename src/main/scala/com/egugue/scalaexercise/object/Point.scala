package com.egugue.scalaexercise.`object`

/**
  * Created by htoyama on 2017/01/21.
  */
object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
}

class Point(x: Int, y: Int)
