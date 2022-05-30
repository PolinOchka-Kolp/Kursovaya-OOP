
fun data() {
    //добавляем студентов в БД
    // айди группы 20м - 20

    mStudents.insertOne(
        Student(
            "Колпакова Полина Евгеньевна",
            20101,
            2,
            101)
    )
    mStudents.insertOne(
        Student(
            "Тумакова Вероника Игоревна",
            20102,
            1,
            102)
    )
    mStudents.insertOne(
        Student(
            "Селезнёв Дмитрий Сергеевич",
            20103,
            1,
            103)
    )


// ----- Group -----

    mGroups.insertOne(
        Group("20м",
            20,
            arrayListOf("Тумакова В.И", "Селезнёв Д.С."),
            arrayListOf("Колпакова П.Е.")
        )
    )

// оценки и задания по ООП

    mTasks.insertOne(
        Task(
            "OOP",
            "Лекция 1",
            "Collections",
            TaskType.Lecture,
            5.0,
            1001,
            listOf(
                Completed(
                    Student("Колпакова Полина Евгеньевна",  20101, 2, 101),
                    5.0),
                Completed(
                    Student("Тумакова Вероника Игоревна",   20102, 1, 102),
                    4.0),
                Completed(
                    Student("Селезнёв Дмитрий Сергеевич",   20103, 1, 103),
                    2.0)
        )
    )
    )

    mTasks.insertOne(
        Task(
            "OOP",
            " Лабораторная 1",
            "Collections",
            TaskType.Laboratornaya,
            5.0,
            1002,
            listOf(
                Completed(
                    Student("Колпакова Полина Евгеньевна",  20101, 2, 101),
                    5.0),
                Completed(
                    Student("Тумакова Вероника Игоревна",  20102, 1, 102),
                    4.0),
                Completed(
                    Student("Селезнёв Дмитрий Сергеевич",   20103, 1, 103),
                    2.0)
            )
        )
    )

    mTasks.insertOne(
        Task(
            "OOP",
            "KRB 1",
            "Course work",
            TaskType.KRB,
            5.0,
            1002,
            listOf(
                Completed(
                    Student("Колпакова Полина Евгеньевна",   291101, 2, 101),
                    5.0),
                Completed(
                    Student("Тумакова Вероника Игоревна",  291102, 1, 102),
                    5.0),
                Completed(
                    Student("Селезнёв Дмитрий Сергеевич",   291103, 1, 103),
                    4.0)
            )
        )
    )


//ТОАПС

    mTasks.insertOne(
        Task(
            "TOAPS",
            "Лекция 1",
            "Quadratic Interpolation",
            TaskType.Lecture,
            5.0,
            1002,
            listOf(
                Completed(
                    Student("Колпакова Полина Евгеньевна",   20101, 2, 101),
                    5.0),
                Completed(
                    Student("Тумакова Вероника Игоревна",  20102, 1, 102),
                    4.0),
                Completed(
                    Student("Селезнёв Дмитрий Сергеевич", 20103, 1, 103),
                    3.0)
            )
        )
    )

    mTasks.insertOne(
        Task(
            "TOAPS",
            "KSR № 1",
            "Types of Interpolation",
            TaskType.KSR,
            5.0,
            1002,
            listOf(
                Completed(
                    Student("Колпакова Полина Евгеньевна",  20101, 2, 101),
                    5.0),
                Completed(
                    Student("Тумакова Вероника Игоревна",   20102, 1, 102),
                    3.0),
                Completed(
                    Student("Селезнёв Дмитрий Сергеевич",   20103, 1, 103),
                    3.0)
            )
        )
    )

    mTasks.insertOne(
        Task(
            "TOAPS",
            "Laba № 1",
            "Time and frequency representation of signals",
            TaskType.Laboratornaya,
            5.0,
            1002,
            listOf(
                Completed(
                    Student("Колпакова Полина Евгеньевна", 20101, 2, 101),
                    5.0),
                Completed(
                    Student("Тумакова Вероника Игоревна", 20102, 1, 102),
                    3.0),
                Completed(
                    Student("Селезнёв Дмитрий Сергеевич", 20103, 1, 103),
                    5.0)
            )
        )
    )
//Схемотехника
    mTasks.insertOne(
        Task(
            "EiS",
            "Laba № 1",
            "Passing signals through linear circuits",
            TaskType.Laboratornaya,
            5.0,
            1002,
            listOf(
                Completed(
                    Student("Колпакова Полина Евгеньевна", 20101, 2, 101),
                    5.0),
                Completed(
                    Student("Тумакова Вероника Игоревна", 20102, 1, 102),
                    5.0),
                Completed(
                    Student("Селезнёв Дмитрий Сергеевич", 20103, 1, 103),
                    5.0)
            )
        )
    )
    mTasks.insertOne(
        Task(
            "EiS",
            "Лекция 1",
            "types of stabilizers",
            TaskType.Lecture,
            5.0,
            1002,
            listOf(
                Completed(
                    Student("Колпакова Полина Евгеньевна", 20101, 2, 101),
                    5.0),
                Completed(
                    Student("Тумакова Вероника Игоревна", 20102, 1, 102),
                    2.0),
                Completed(
                    Student("Селезнёв Дмитрий Сергеевич", 20103, 1, 103),
                    3.0)
            )
        )
    )
    mTasks.insertOne(
        Task(
            "EiS",
            "Лаба 2",
            "types of stabilizers",
            TaskType.Laboratornaya,
            5.0,
            1002,
            listOf(
                Completed(
                    Student("Колпакова Полина Евгеньевна", 20101, 2, 101),
                    5.0),
                Completed(
                    Student("Тумакова Веронкиа Игоревна", 20102, 1, 102),
                    2.0),
                Completed(
                    Student("Селезнёв Дмитрий Сергеевич", 20103, 1, 103),
                    3.0)
            )
        )
    )

// РЕйтинг

    mRanks.insertOne(
        Rank(
            "Объектно-ориентированное программирование",
            listOf(
                ValSubject(20.0, "Lecture\n"),
                ValSubject(70.0, "Laboratornaya\n"),
                ValSubject(30.0, "KRB\n"),
            )
        )
    )


    mRanks.insertOne(
        Rank(
            "Теор. основы АПС",
            listOf(
                ValSubject(40.0, "Lecture\n"),
                ValSubject(60.0, "Laboratornaya\n"),
                ValSubject(30.0, "KSR\n")
            )
        )
    )

    mRanks.insertOne(
        Rank(
            "Электроника и схемотехника",
            listOf(
                ValSubject(30.0, "Lecture\n"),
                ValSubject(60.0, "Laboratornaya\n"),
                ValSubject(10.0, "KSR\n")
            )
        )
    )
}