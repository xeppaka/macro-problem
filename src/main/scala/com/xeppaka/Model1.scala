package com.xeppaka

import com.xeppaka.MyAnnotation

object Model1 {
  def f1: Unit = println("f1")
}

final case class Model1(@MyAnnotation(st = "test") @MyAnnotationScala color: String)
