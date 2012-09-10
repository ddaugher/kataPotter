import org.scalatest.FunSuite;

class KataPotterFindGroupForBookTests extends FunSuite {

  val c = new KataPotter

  test("should return None if possible groups is empty") {
    val book1 = new Book1
    val set1 = Set[Book](book1)
    assert(c.findGroupForBook(List(set1), book1) === None)
  }

  test("should return cheapest group") {
    val book1 = new Book1
    val book2 = new Book2
    val book3 = new Book3
    val book4 = new Book4
    val book5 = new Book5

    val set1 = Set[Book](book1, book2)
    val set2 = Set[Book](book3, book4)
    val set3 = Set[Book](book4, book5)
    assert(c.findGroupForBook(List(set1, set2, set3), book1) === Some(set2))
  }
}
