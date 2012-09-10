import org.scalatest.FunSuite;

class KataPotterGatherPossibleGroupsTests extends FunSuite {

  val c = new KataPotter

  test("should return empty list when no candidate List[Set[Book]] supplied") {
    val book1 = new Book1

    val x = c.gatherPossibleGroups(List(), book1)

    assert(x === List())
  }

  test("should return current List of Sets when requested book is null") {
    val book1 = new Book1
    val book2 = new Book2
    val set1 = Set[Book](book1)
    val set2 = Set[Book](book2)
    val x = c.gatherPossibleGroups(List(set1, set2), null)

    assert(x === List(Set(book1), Set(book2)))
  }

  test("should properly return list of possible groups") {
    val book1 = new Book1
    val book2 = new Book2
    val book3 = new Book3
    val book4 = new Book4
    val book5 = new Book5

    val set1 = Set[Book](book1, book2)
    val set2 = Set[Book](book3, book4)
    val set3 = Set[Book](book4, book5)

    val x = c.gatherPossibleGroups(List(set1, set2, set3), book1)

    assert(x === List(set2, set3))
  }

  test("should return all supplied sets when requested element can fit in all") {
    val book1 = new Book1
    val book2 = new Book2
    val book3 = new Book3
    val book4 = new Book4
    val book5 = new Book5

    val set1 = Set[Book](book1, book2)
    val set2 = Set[Book](book4)
    val set3 = Set[Book](book4, book5)

    val x = c.gatherPossibleGroups(List(set1, set2, set3), book3)

    assert(x === List(set1, set2, set3))
  }

  test("should return empty list of sets when requested element will not fit in any") {
    val book1 = new Book1
    val book2 = new Book2
    val book3 = new Book3
    val book4 = new Book4
    val book5 = new Book5

    val set1 = Set[Book](book1, book2, book3)
    val set2 = Set[Book](book4, book3)
    val set3 = Set[Book](book4, book5, book3)

    val x = c.gatherPossibleGroups(List(set1, set2, set3), book3)

    assert(x === List())
  }
}
