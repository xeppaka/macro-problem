package com.xeppaka

import scala.quoted.*

object Annotations {
  inline def getAnnotations[T]: List[Any] = ${ getAnnotationsImpl[T] }

  def getAnnotationsImpl[T: Type](using quotes: Quotes): Expr[List[Any]] = {
    import quotes.reflect.*

    val tpe: TypeRepr = TypeRepr.of[T]

    Expr.ofList {
      tpe.typeSymbol.primaryConstructor.paramSymss.flatten.flatMap(field => field.annotations).map { an => an.asExpr }
    }
  }
}
