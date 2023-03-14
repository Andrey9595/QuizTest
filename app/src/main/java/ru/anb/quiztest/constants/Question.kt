package ru.anb.quiztest.constants

data class Question(
 val id: Int,
 val whoQuestion: String,
 val question: String,
 val optionOne: String,
 val optionTwo: String,
 val optionThree: String,
 val optionFour: String,
 val correctAnswer: Int
)