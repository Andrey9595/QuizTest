package ru.anb.quiztest.constants

object Constants {

    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val QUESTION: String = "Guess the word!!!"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1, QUESTION, "Красный", "Красный", "синий",
            "счастливый", "грустный", 1
        )
        questionsList.add(que1)
        val que2 = Question(
            1, QUESTION, "слон", "лев", "обезьяна",
            "слон", "тигр", 3
        )
        questionsList.add(que2)
        val que3 = Question(
            1, QUESTION, "огурец", "яблоко", "морковь",
            "банан", "огурец", 4
        )
        questionsList.add(que3)
        val que4 = Question(
            1, QUESTION, "Италия", "Франция", "Италия",
            "Испания", "Германия", 2
        )
        questionsList.add(que4)
        val que5 = Question(
            1, QUESTION, "поезд", "автомобиль", "самолет",
            "поезд", "велосипед", 3
        )
        questionsList.add(que5)
        val que6 = Question(
            1, QUESTION, "вода", "вода", "огонь",
            "земля", "воздух", 1
        )
        questionsList.add(que6)
        val que7 = Question(
            1, QUESTION, "Рапунцель", "Золушка", "Белоснежка",
            "Рапунцель", "Красная Шапочка", 3
        )
        questionsList.add(que7)
        val que8 = Question(
            1, QUESTION, "кисть", "рука", "нога",
            "голова", " кисть", 4
        )
        questionsList.add(que8)
        val que9 = Question(
            1, QUESTION, "учитель", "врач", "учитель",
            "пожарный", "шеф-повар", 2
        )
        questionsList.add(que9)
        val que10 = Question(
            1, QUESTION, "гитара", "гитара", "труба",
            "фортепиано", "саксофон", 1
        )
        questionsList.add(que10)

        return questionsList
    }
}