package com.xeppaka

import scala.quoted.*

object Reflection {
  inline def upateMethod[T]: List[Any] = ${ upateMethodImpl[T] }

  def upateMethodImpl[T: Type](using quotes: Quotes): Expr[List[Any]] = {
    import quotes.reflect.*

    val tpe: TypeRepr = TypeRepr.of[T]
    Expr.ofList {
      tpe.typeSymbol.companionModule.methodMembers.map(s => Expr(s.fullName))
    }
  }
}
