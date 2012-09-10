import org.scalatest.FunSuite;

class KataPotterGroupBooksTests extends FunSuite {

  val c = new KataPotter

  test("list not requiring grouping should return original list") {
    val book1 = new Book1
    val book2 = new Book2
    val book3 = new Book3
    val book4 = new Book4
    val book5 = new Book5

    val books = List[Book](book1, book2, book3, book4, book5)

    assert(c.groupBooks(books, List()) === List(Set(book1, book2, book3, book5, book4)))
  }

  test("list of two same books should return list of two sets") {
    val book1 = new Book1
    val books = List[Book](book1, book1)

    assert(c.groupBooks(books, List()) === List(Set(book1), Set(book1)))
  }

  test("list of three same books should return list of three sets") {
    val book1 = new Book1
    val books = List[Book](book1, book1, book1)

    assert(c.groupBooks(books, List()) === List(Set(book1), Set(book1), Set(book1)))
  }
}
