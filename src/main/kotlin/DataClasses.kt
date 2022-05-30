import kotlinx.serialization.Serializable

@Serializable
data class Student(
    var fio: String, //ФИО студента
    var groupId: Int,
    var subgroup: Int, //подгруппа
    // айди студента
    var id: Int
)



@Serializable
data class Group(
    var name: String,// Имя группы
    var id: Int,
    // Подгруппы
    var subgroup1: List<String>,
    var subgroup2: List<String>
)

@Serializable
    data class Task(
var subjectName: String,
var name: String,// Название пары
var description: String, //тема пары
var type: TaskType,
var maximumMark: Double,
var id: Int,
val madeTask: List<Completed>
)

@Serializable
data class Completed (
    val student: Student,
    var grade1 : Double
        )

@Serializable
data class Rank(
    var subjectName: String,// Название предмета
val subjectValue : List<ValSubject>
)

@Serializable
data class ValSubject (
    val Value : Double,
    val TaskTypeName : String
        )






