package org.functionalkoans.forscala

import org.functionalkoans.forscala.support.KoanSuite
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class AboutInfixTypes extends KoanSuite {

  koan("""We can make a type infix, meaning that the type can be displayed in complement
           between two types in order to make a readable delaration""") {
    case class Person(name: String)
    class Loves[A, B](val a: A, val b: B)

    def announceCouple(couple: Person Loves Person) = {
      //Notice our type: Person loves Person!
      couple.a.name + " is in love with " + couple.b.name
    }

    val romeo = new Person("Romeo")
    val juliet = new Person("Juliet")

    announceCouple(new Loves(romeo, juliet)) should be(__)
  }

  koan("""Of course we can make this a bit more elegant by creating an infix operator
           |  method to use with our infix type""") {

    case class Person(name: String) {
      def loves(person: Person) = new Loves(this, person)
    }

    class Loves[A, B](val a: A, val b: B)

    def announceCouple(couple: Person Loves Person) = {
      //Notice our type: Person loves Person!
      couple.a.name + " is in love with " + couple.b.name
    }

    val romeo = new Person("Romeo")
    val juliet = new Person("Juliet")

    announceCouple(romeo loves juliet) should be(__)
  }


}