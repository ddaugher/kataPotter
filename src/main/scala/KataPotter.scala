class KataPotter {

  val PERCENTAGEOFF = Map[Int, Double](1 -> 1.0, 2 -> 0.95, 3 -> 0.90, 4 -> 0.80, 5 -> 0.75)

  //  def calculatePrice(list: Seq[Book]): Double = {
  //
  //    (list.distinct.size) match {
  //      case (2) => return 2 * 8.00 * DISCOUNTS(2)
  //      case (3) => return 3 * 8.00 * DISCOUNTS(3)
  //      case (4) => return 4 * 8.00 * DISCOUNTS(4)
  //      case (5) => return 5 * 8.00 * DISCOUNTS(5)
  //      case (_) => return list.size * 8.00 * DISCOUNTS(1)
  //    }

  def calculatePrice(groups: List[Set[Book]]): Double = {
    groups.foldLeft(0.0) {
      (result, current) => result + current.size * 8 * PERCENTAGEOFF(current.size)
    }
  }

  def price(books: List[Book]): Double = {
    val bookGroups = groupBooks(books, List())

    println(bookGroups)

    calculatePrice(bookGroups)
  }

  def groupBooks(books: List[Book], groups: List[Set[Book]]): List[Set[Book]] = {
    if (books.isEmpty) {
      groups
    } else {
      val group = findGroupForBook(groups, books.head)

      if (group.isEmpty) {
        groupBooks(books.tail, Set(books.head) :: groups)
      } else {
        val groupWithAddedBook = group.get + books.head
        val filteredGroups = groups.filterNot(_ eq group.get)
        groupBooks(books.tail, groupWithAddedBook :: filteredGroups)
      }
    }
  }

  def findGroupForBook(groups: List[Set[Book]], book: Book): Option[Set[Book]] = {
    val possibleGroups = gatherPossibleGroups(groups, book)
    if (possibleGroups.isEmpty) {
      None
    } else {
      val cheapestGroup = determineCheapestGroup(groups, possibleGroups, book: Book)
      Option(cheapestGroup)
    }
  }

  def determineCheapestGroup(groups: List[Set[Book]], possibleGroups: List[Set[Book]], book: Book): Set[Book] = {
    possibleGroups.minBy({
      group =>
        val groupsMinusCurrentGroup: List[Set[Book]] = groups.filterNot(_ == group)
        val groupPlusBook = group + book
        val newGroups: List[Set[Book]] = groupPlusBook :: groupsMinusCurrentGroup
        calculatePrice(newGroups)
    })
  }

  def gatherPossibleGroups(groups: List[Set[Book]], book: Book): List[Set[Book]] = {
    groups.filter(_.contains(book) == false)
  }
}

trait Book {
}

class Book1 extends Book {}

class Book2 extends Book {}

class Book3 extends Book {}

class Book4 extends Book {}

class Book5 extends Book {}
