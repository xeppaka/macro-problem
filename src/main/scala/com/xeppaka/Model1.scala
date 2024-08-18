package com.xeppaka

import com.xeppaka.app.MyAnnotation

final case class Model1(@MyAnnotation(st = "test") color: String)
