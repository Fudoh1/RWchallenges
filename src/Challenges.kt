import java.util.*
import kotlin.properties.Delegates

enum class Animals {
    CAT,DOG,RAT,BIRD,HAMSTER
}

enum class Cage {
    SMALL,MEDIUM,LARGE;
}
data class Student(val firstName: String, val lastName: String)

object StudentReigstry{
    val allStudents = mutableListOf<Student>()

    fun addStudent(student: Student) {
        allStudents.add(student)
    }
    fun removeStudent(student: Student) {
        allStudents.remove(student)
    }
}
data class Course(var className: String) {
    val courseDescription : String by lazy {
        "Course ${className} taught by $teacherName"
    }
    var room: String by Delegates.observable("No Room") {
            property, oldValue, newValue ->
        println("New value is $newValue")
    }
    private lateinit var teacherName: String

    fun setTeacherName(teacher : String) {
        this.teacherName = teacher
    }
}
class Kurs(var className: String){
    lateinit var teacherName: String

    fun setTeacher(teacher: String) {
        teacherName = teacher
    }
}
interface Shape {
    fun draw()
    var height : Int
    var width : Int}
class Circle(override var height : Int,override var width : Int) : Shape {
    override fun draw() {
        println("Drawing a  Circle")
    }

}

class Line(override var height : Int,override var width : Int) : Shape {
    override fun draw() {
        println("Drawing a  Line")
    }
}

fun printShape(shape: Shape){
    shape.draw() }

fun main() {
    println("------BOOLEANS------")

    val myAge = 20
    val isTeenager = myAge >=13 && myAge <= 19
    println("Am I teenager = $isTeenager")

    val theirAge = 30
    val bothTeenager = theirAge >= 13 && theirAge <= 19 && isTeenager
    println("bothTeenagers $bothTeenager")

    val student = "Fuad"
    val author = "Kevin Moore"
    val authorIsStudent = student==author
    println("Is student author $authorIsStudent")

    if (myAge >= 13 && myAge <= 19) {
        val newAge = myAge + 1
        println("Teenager, newAge = $newAge")
    }else {
        println("Not a teenager")
    }

    val answer = if(myAge >= 13 && myAge <= 19) "Teenager" else "Not teenager"
    println(answer)

 //********************************************************************************************************************
    println("------ARRAYS------")

    var players = arrayOf("Alice", "Bob", "Dan", "Eli", "Frank")

    println("Index of Dan = ${players.indexOf("Dan")}")

    players = arrayOf("Anna", "Brian", "Craig", "Dan", "Donna", "Eli", "Franklin")
    val scores = arrayOf(2, 2, 8, 6, 1, 2, 1)

    var index = 0
    for (player in players) {
        println("${index + 1}. $player - ${scores[index]}")
        index++
    }
    players.forEachIndexed { index, player ->
        println("${index + 1}. $player - ${scores[index]}")
    }
//*********************************************************************************************************************
    println("------LISTS------")

    val states = mutableListOf("VA", "CA", "WA", "LA")

    states.add("OH")
    println(states)


    fun printStates(states : List<String>) {

        for (i in 0..states.size-1) {
            if (i != 3) {
                println("$i ${states[i]}")
            }
        }
    }

    printStates(states)
//*********************************************************************************************************************
    println("------PAIRS AND TRIPLES------")
    val constantpair = Pair(10,6)
    val (month,day) = constantpair

    println("Month = $month Day = $day")

    val triple = Triple(10,6,2001)
//*********************************************************************************************************************
  println("------WHILE LOOPS------")
    var counter = 0
    while (counter < 10) {
        println("counter is $counter")
        counter += 1
    }

    var count = 0
    var roll = 0
    val random = Random()
    do {
        roll = random.nextInt(6)
        count += 1
        println("After $count roll(s), roll is $roll")
    } while (roll != 0)
//*********************************************************************************************************************
    println("------FOR LOOPS------")
    val range = 1..10
    for (i in range) {
        val square = i * i
        println("$square")
    }

    for (i in range) {
        val squareRoot = Math.sqrt(i.toDouble())
        println("$squareRoot")
    }

    var sum = 0
    for (row in 0..8)
        if (row % 2 == 1) {
            for (column in 0..8) {
                sum += row * column
            }
        }
    println("$sum")
//*********************************************************************************************************************
    println("------MAPS------")
    var Fuad = mutableMapOf("Name" to "Fuad","Profession" to "Programer","Country" to "BiH","State" to "ZDK", "City" to "Tesanj" )

    Fuad["City"] = "Albuquerque"
    Fuad["State"] = "New Mexico"
    Fuad["Country"] = "USA"

    fun printLocation(person : Map<String,String>) {
        val Kanton = if (person.containsKey("State")) person["State"] else ""
        val Grad = if (person.containsKey("City")) person["City"] else ""
        println("Pearson live in $Kanton,$Grad")
    }
    printLocation(Fuad)
//*********************************************************************************************************************
    println("------WHEN STATEMENTS------")
    when (myAge) {
        in 0..2 ->
            println("Infant")
        in 3..12 ->
            println("Child")
        in 13..19 ->
            println("Teenager")
        in 20..39 ->
            println("Adult")
        in 40..60 ->
            println("Middle aged")
        in 61..110 ->
            println("Elderly")
        else ->
            println("Invalid age")
    }


    val pair = Pair("Kevin", 40)
    when (pair.second) {
        in 0..2 ->
            println("${pair.first} is a infant")
        in 3..12 ->
            println("${pair.first} is a child")
        in 13..19 ->
            println("${pair.first} is a teenager")
        in 20..39 ->
            println("${pair.first} is an adult")
        in 40..60 ->
            println("${pair.first} is a middle aged")
        in 61..110 ->
            println("${pair.first} is a elderly")
        else ->
            println("Invalid age")
    }

    val personsAge = when (myAge) {
        in 0..2 ->
            "Infant"
        in 3..12 ->
            "Child"
        in 13..19 ->
            "Teenager"
        in 20..39 ->
            "Adult"
        in 40..60 ->
            "Middle aged"
        in 61..110 ->
            "Elderly"
        else ->
            "Invalid age"
    }

    println(personsAge)
//*********************************************************************************************************************
    println("------NULLABLES INTRODUCTION------")
    var myFavoriteSong: String? = "The Final Countdown"

    fun printFavoriteSong(song : String?) {
        println(song)
    }

    printFavoriteSong(myFavoriteSong)
    myFavoriteSong = null
    printFavoriteSong(myFavoriteSong)
//*********************************************************************************************************************
    println("-----MORE NULLABLES------")
    fun nullables(){
    val myFavoriteSong : String ? = "The Final Countdown"

    myFavoriteSong?.let {println(myFavoriteSong)} ?: println("I don’t have a favorite song.")


    fun printNickname (nickname: String?) {
        print("Your nickname is: ")
        nickname?.let {println(nickname)} ?: println("No nickname")
    }
    printNickname( null)

}
    println(nullables())
//*********************************************************************************************************************
    println("------INTRODUCTION TO FUNCTIONS------")

    fun printFullName(firstName: String, lastName: String) {
        println(firstName + " " + lastName)
    }

    printFullName(firstName = "Kevin", lastName = "Moore")

    printFullName("Kevin", "Moore")


    fun calculateFullName(firstName: String, lastName: String): String {
        return firstName + " " + lastName
    }

    val fullName = calculateFullName("Kevin", "Moore")
    println(fullName)

    fun calculateFullNameWithLength(firstName: String, lastName: String): Pair<String, Int> {
        val fullName = firstName + " " + lastName
        return Pair(fullName, fullName.length)
    }

    val fullNameLength = calculateFullNameWithLength("Kevin", "Moore").second
    println("$fullNameLength")
//*********************************************************************************************************************
 println("------CLASSES------")
    class MovieList(val genre: String) {

        private val movies = ArrayList<String>()

        fun addMovie(movie : String) {
            movies.add(movie)
        }

        fun print() {
            println("Movie List: $genre ")
            for (movie in movies) {
                print(movie + " ")
            }
            println("")
        }
    }
    class MovieGoer {
        private var movieList = HashMap<String, MovieList>()

        fun addGenre( genre: String) {
            movieList[genre] = MovieList(genre)
        }


        fun movieListFor(genre: String) : MovieList? {
            return movieList[genre]
        }

        fun addMovie(genre: String, movie : String) {
            if (!movieList.containsKey(genre)) {
                addGenre(genre)
            }
            movieList[genre]?.addMovie(movie)
        }
    }

        val jane = MovieGoer()
        val john = MovieGoer()

        jane.addMovie("Action", "Rambo")
        jane.addMovie("Action", "Terminator")
        john.addMovie("Action", "Die Hard")
        john.movieListFor("Action")?.print()
        jane.movieListFor("Action")?.print()
        println("------")


        class Tshirt(var size : Int,var color : Int, var price : Double) {}

        class Address(var number: String,var street : String,var city : String,var zip : String){}

        class ShoppingCart(var tshirts : List<Tshirt>,var address: Address) {
            fun totalPrice() : Double {
                var total : Double = 0.0
                for(tshirt in tshirts){
                    total += tshirt.price
                }
                return total
            }
        }
        class User(var name : String,var email : String,var shoppingCart : ShoppingCart) {

        }
        val tshirt1 = Tshirt(16,1,10.99)
        val tshirt2 = Tshirt(18,1,12.99)
        val address = Address("10","Seaside","City of Lights","99747")
        val cart = ShoppingCart(arrayListOf(tshirt1,tshirt2), address)
        val user = User("Sam","someemail@aol.com",cart)
        println("Shopping Card total ${cart.totalPrice()}")
//*********************************************************************************************************************
    println("------DATA CLASSES------")
    data class Student(val firstname : String,val lastname : String,val grade : Char)

    var Sam = Student("Sam","Gamgee",'A')

    var Sam2 = Sam.copy(grade = 'B')

    println(Sam)
    println("------")
    println(Sam2)
//*********************************************************************************************************************
println("------ENUMS------")

    fun addAnimalToCage (animals : Animals , cage : Cage ) {
        println("The $animals is in the $cage cage")

    }

        addAnimalToCage(Animals.BIRD,Cage.SMALL)
        addAnimalToCage(Animals.CAT,Cage.MEDIUM)
        addAnimalToCage(Animals.DOG,Cage.LARGE)
        addAnimalToCage(Animals.RAT,Cage.SMALL)
        addAnimalToCage(Animals.HAMSTER,Cage.SMALL)
//*********************************************************************************************************************
    println("------SINGLETONS------")
    val Giosetta = Student("Giosetta","Jamshed")
    val Heard = Student("Heard","Petronella")
    StudentReigstry.addStudent(Giosetta)
    StudentReigstry.addStudent(Heard)
    StudentReigstry.allStudents.forEach {
        println(it.firstName + " " + it.lastName)
    }
//*********************************************************************************************************************
    println("------PROPERTIES------")
    val course = Course("Math")
    course.setTeacherName("Ms Price")
    course.room = "Library"
    println("Course description ${course.courseDescription}")
    println("Course is ${course}")
//*********************************************************************************************************************
    println("------LAMBDAS------")

    val values = listOf<Int>(24,5,10,4)
    println(values.filter { it > 5 }.sum())
    println("------")
    data class Person(val name: String, val age: Int)
    val sam = Person("Sam", 30)
    val(name,age) = sam
    println("$name is $age years old")
    println("------")

    val names = mapOf<String, Int>("John" to 34, "Fred" to 24, "Sam" to 30, "Suzzy" to 29)
    for ((name,age) in names){
        println("$name is $age years old")
    }
//*********************************************************************************************************************
    println("------LATEINIT------")
    val Kurs = Kurs("Math")
    Kurs.setTeacher("Ms Price")

    println(Kurs.teacherName)
//*********************************************************************************************************************
println("------INTERFACES------")
    val circle = Circle(10, 10)
    val line = Line(10,10)
    printShape(circle)
    printShape(line)
//*********************************************************************************************************************
    println("------GENERICS------")
    fun <myItem> printItem(item: myItem) {
        println(item)
    }
    printItem("test")
    printItem(1)
    println("------")


    fun <T> printList(list : List<T>) {
        for (item in list) {
            println("List item : $item")}
    }

    printList(listOf("Fuad","Semir","Ajdin"))
    }





