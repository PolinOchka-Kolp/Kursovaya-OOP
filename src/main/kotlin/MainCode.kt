import org.litote.kmongo.*
import org.litote.kmongo.getCollection
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import java.io.File

val mStudents = mongoDatabase.getCollection<Student>()
val mGroups = mongoDatabase.getCollection<Group>()
val mTasks = mongoDatabase.getCollection<Task>()
val mRanks = mongoDatabase.getCollection<Rank>()

// Просмотр веса задач для предмета
fun lookSubject(choice: Int) {
    val taskValue = mRanks.find().toList()
    println(taskValue[choice].subjectName)
    for (i in 0..2) {
        val b = i + 1
        print("\n$b.${taskValue[choice].subjectValue[i].TaskTypeName} " +
                "${taskValue[choice].subjectValue[i].Value}")
    }
}

// Просмотр веса задач
fun look() {
    println("Выберите предмет\n" +
            "1. ООП\n" +
            "2. ТОАПС\n" +
            "3. ЕиС\n" +
            "4. Главный экран\n")

    when (readLine()!!.toInt()) {
        1 -> {
            lookSubject(0)
        }
        2 -> {
            lookSubject(1)
        }
        3 -> {
            lookSubject(2)
        }
        4 -> main()
        else -> {
            print("Введено неверно, повторите попытку\n")
        }
    }
}

fun countRank(){
    var maxValueTOAPS: Double = 0.0
    var maxValueOOP: Double = 0.0
    var maxValueEiS: Double = 0.0

    val taskValue = mRanks.find().toList()
    val task = mTasks.find().toList()
    val student = mStudents.find().toList()

    for (i in 0..2) {
        maxValueOOP += mRanks.find().toList()[0].subjectValue[i].Value
        maxValueTOAPS += mRanks.find().toList()[1].subjectValue[i].Value
        maxValueEiS+= mRanks.find().toList()[2].subjectValue[i].Value
    }

    val TOAPS : Array<Int> = arrayOf(0,0,0)
    val OOP : Array<Int> = arrayOf(0,0,0)
    val EiS : Array<Int> = arrayOf(0,0,0)

    //считаем рейтинг
    for (i in 0..2) {
        TOAPS[i] = ((
                (taskValue[0].subjectValue[0].Value /5 * task[0].madeTask[i].grade1)             //лаба
                 +  (taskValue[0].subjectValue[1].Value /5 * task[1].madeTask[i].grade1)         //лекц
                        + (taskValue[0].subjectValue[2].Value /5 * 0)                            //кср
        ) / maxValueTOAPS * 100).toInt()
       OOP[i] = ((
                (taskValue[0].subjectValue[0].Value /5 * task[0].madeTask[i].grade1)             //лаба
                        + (taskValue[0].subjectValue[1].Value /5 * task[1].madeTask[i].grade1)   //лекц
                        + (taskValue[0].subjectValue[2].Value /5 * 0)                            //кср
                ) / maxValueOOP * 100).toInt()
        EiS [i] = ((
                (taskValue[0].subjectValue[0].Value /5 * task[0].madeTask[i].grade1)                //лаба
                        + (taskValue[0].subjectValue[1].Value /5 * task[1].madeTask[i].grade1)      //лекц
                        + (taskValue[0].subjectValue[2].Value /5 * 0)                                //кср
                ) / maxValueEiS * 100).toInt()
    }
    File("Рейтинг_20м.html").writeText(
        StringBuilder().appendHTML()
            .html {
                style = "background-color: ##FFFFF0; color: #000000;"
                body {
                    table {
                        thead() {
                            tr {
                                +"-------------------------текущая кн------------------------"
                                td {
                                    +"Студенты"
                                }
                                td {
                                    +"ООП"
                                }
                                td {
                                    +"ТОАПС"
                                }
                                td {
                                    +"ЕиС"
                                }
                            }
                        }

                        for (i in 0..2) {
                            tr {

                                td {
                                    +"${student[i].fio}" //ФИО
                                }
                                td {
                                    +"${OOP[i]}"
                                }
                                td {
                                    +"${TOAPS[i]}"
                                }
                                td {
                                    +"${EiS[i]}"
                                }
                            }
                        }
                    }
                }
            }.toString()
    )
}

// Функция обновления
fun setSubjectValue(subjectName: String, TaskTypeName: String, Value: Double) =
    mRanks.updateOne(
        and(
            Rank::subjectName eq subjectName,
            Rank::subjectValue / ValSubject::TaskTypeName eq TaskTypeName
        ),
        setValue(Rank::subjectValue.posOp / ValSubject::Value, Value)
    )

// Изменение веса  задач
fun changeVal(choice: Int) {
    println("Вес заданий на данный момент: ")
    if (choice == 1) lookSubject(0)
    if (choice == 2) lookSubject(1)
    if (choice == 3) lookSubject(2)
    println("\nВыберите тип задания (Лекция, Лабораторная работа, Практика, КСР, КРБ):\n")
    val taskType = readLine()!!.toString()
    println("Введите значение, на которое изменить (в формате числа с плавающей запятой):\n")
    val value = readLine()!!.toDouble()

    if (choice == 1) {
        val subjectName = "\"Объектно-ориентированное программирование\""
        setSubjectValue(subjectName, taskType, value)
    }
    if (choice == 2) {
        val subjectName = "\"Электроника и схемотехника\""
        setSubjectValue(subjectName, taskType, value)
    }
    if (choice == 0) {
        val subjectName = "\"Теор. основы АПС\""
        setSubjectValue(subjectName, taskType, value)
    }
}

fun change () {
    print("Выберете предмет\n" +
            "1. ООП \n" +
            "2. ТОАПС \n" +
            "3. ЕиС \n"+
            "4. Главный экран \n")

    when (readLine()!!.toInt()) {
        1 -> {
            changeVal(1)
        }
        2 -> {
            changeVal(2)
        }
        3 -> {
            changeVal(3)
        }
        4 -> main()
        else -> {
            println("Введено неверно, повторите попытку")
        }
    }
}

fun main () {
    var exitTrigger: Int = 0;
    while (exitTrigger == 0) {
        println("\nВыберите действие:\n" +
                "1. Рассчитать рейтинг и посмотреть таблицу\n" +
                "2. Посмотреть вес задач по определенному предмету\n"+
                "3. Изменить вес задачи\n"+
                "4. Выйти из терминала\n")

        when (readLine()!!.toInt()) {
            1 -> countRank()
            2 -> look()
            3 -> change()
            4 -> exitTrigger = 1
            else -> {
                println("Неверный ввод. Попробуйте еще раз \n")
            }
        }
    }
}

