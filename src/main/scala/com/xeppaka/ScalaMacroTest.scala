package com.xeppaka

object ScalaMacroTest {
  @main def main() = {
    Annotations.getAnnotations[Model1].foreach(println)
  }
}