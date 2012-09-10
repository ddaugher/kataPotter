import org.scalatest.FunSuite;

class KataPotterDetermineCheapestGroupTests extends FunSuite {

  val c = new KataPotter

  test("") {
    val book1 = new Book1
    val book2 = new Book2
    val book3 = new Book3
    val book4 = new Book4
    val book5 = new Book5

    val set1 = Set[Book](book1, book2)
    val set2 = Set[Book](book4, book1, book3)
    val set3 = Set[Book](book4, book5)

    val possibleGroups = List(set1, set2, set3)
    assert(c.determineCheapestGroup(List(), possibleGroups, book3) === Set(book4))
  }
}
