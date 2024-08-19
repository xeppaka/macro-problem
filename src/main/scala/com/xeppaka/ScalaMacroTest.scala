package com.xeppaka

import scala.quoted.*

object ScalaMacroTest {
  @main def main() = {
    Annotations.getAnnotations[Model1].foreach(println)
  }
}
