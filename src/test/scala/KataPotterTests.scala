import org.scalatest.FunSuite;

class KataPotterTests extends FunSuite {

  val c = new KataPotter

  test("zero book should return 0.00") {
    assert(c.price(List()) === 0.00)
  }

  test("one book should return 8.00") {
    val book1 = new Book1
    assert(c.price(List(book1)) === 8.00)
  }

  test("two SAME books should cost 16.00") {
    val book1 = new Book1
    assert(c.price(List(book1, book1)) === 16.00)
  }

  test("two DIFFERENT books should cost 15.20") {
    val book1 = new Book1
    val book2 = new Book2
    assert(c.price(List(book1, book2)) === 15.20)
  }

  test("three SAME books should cost 24.00") {
    val book1 = new Book1
    assert(c.price(List(book1, book1, book1)) === 24.00)
  }

  test("three DIFFERENT books should cost 21.60") {
    val book1 = new Book1
    val book2 = new Book2
    val book3 = new Book3
    assert(c.price(List(book1, book2, book3)) === 21.60)
  }

  test("four SAME books should cost 32.00") {
    val book1 = new Book1
    assert(c.price(List(book1, book1, book1, book1)) === 32.00)
  }

  test("four DIFFERENT books should cost 25.60") {
    val book1 = new Book1
    val book2 = new Book2
    val book3 = new Book3
    val book4 = new Book4
    assert(c.price(List(book1, book2, book3, book4)) === 25.60)
  }

  test("five SAME books should cost 40.00") {
    val book1 = new Book1
    assert(c.price(List(book1, book1, book1, book1)) === 32.00)
  }

  test("five DIFFERENT books should cost 30.00") {
    val book1 = new Book1
    val book2 = new Book2
    val book3 = new Book3
    val book4 = new Book4
    val book5 = new Book5
    assert(c.price(List(book1, book2, book3, book4, book5)) === 30.00)
  }

  test("complex test") {
    val book1 = new Book1
    val book2 = new Book2
    val book3 = new Book3
    val book4 = new Book4
    val book5 = new Book5
    assert(c.price(List(book1, book1, book2, book2, book3, book3, book4, book5)) === 51.20)
  }

  test("more complex test") {
    val book1 = new Book1
    val book2 = new Book2
    val book3 = new Book3
    val book4 = new Book4
    val book5 = new Book5
    assert(c.price(List(book1, book1, book1, book2, book3, book4, book4, book5, book5, book5)) === 66.40)
  }

  test("test case from kata docs") {
    val book1 = new Book1
    val book2 = new Book2
    val book3 = new Book3
    val book4 = new Book4
    val book5 = new Book5
    assert(c.price(List(book1, book1, book2, book2, book3, book3, book4, book5)) === 51.20)
  }
}

//it("Edge Case") {
//  price(List(1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5)) should be(141.2)
//}
//
