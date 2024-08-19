package com.xeppaka

import scala.quoted.*

object Annotations {
  inline def getAnnotations[T]: List[Any] = ${ getAnnotationsImpl[T] }

  def getAnnotationsImpl[T: Type](using quotes: Quotes): Expr[List[Any]] = {
    import quotes.reflect.*

    val tpe: TypeRepr = TypeRepr.of[T]

    tpe.typeSymbol.primaryConstructor.paramSymss.flatten.flatMap(field => field.annotations).map { an =>
      val t = tpe.memberType(an.symbol.owner)
      println(t.typeSymbol.companionModule.fullName)
      t.typeSymbol.companionModule.fullName
    }.foreach(println)

    Expr.ofList {
      List.empty
      //tpe.typeSymbol.primaryConstructor.paramSymss.flatten.flatMap(field => field.annotations).filter(_.symbol.isAbstractType).map(_.asExpr)
    }
  }
}
