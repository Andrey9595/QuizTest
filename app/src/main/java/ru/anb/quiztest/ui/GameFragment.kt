package ru.anb.quiztest.ui

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.anb.quiztest.R
import ru.anb.quiztest.constants.Constants
import ru.anb.quiztest.constants.Question


class GameFragment : Fragment(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0


//    val  tv_option_one: TextView = view?.findViewById(R.id.word1) ?: z
//    val   tv_option_two: TextView = requireView().findViewById(R.id.word2)
//    val  tv_option_three: TextView = requireView().findViewById(R.id.word3)
//    val   tv_option_four: TextView = requireView().findViewById(R.id.word4)
//    val   btn_submit: Button = requireView().findViewById(R.id.button2)

    private lateinit var tv_option_one: TextView
    private lateinit var tv_option_two: TextView
    private lateinit var tv_option_three: TextView
    private lateinit var tv_option_four: TextView
    private lateinit var btn_submit: Button

    private lateinit var progressBar: ProgressBar
    private lateinit var tv_progress: TextView

    //    private lateinit var tv_question: TextView
    private lateinit var mainQuestion: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mQuestionsList = Constants.getQuestions()


        tv_option_one = getView()?.findViewById(R.id.word1) as TextView
        tv_option_one.setOnClickListener(this)
        tv_option_two = getView()?.findViewById(R.id.word2) as TextView
        tv_option_two.setOnClickListener(this)
        tv_option_three = getView()?.findViewById(R.id.word3) as TextView
        tv_option_three.setOnClickListener(this)
        tv_option_four = getView()?.findViewById(R.id.word4) as TextView
        tv_option_four.setOnClickListener(this)
        btn_submit = getView()?.findViewById(R.id.button2) as Button
        btn_submit.setOnClickListener(this)

        setQuestion()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.word1 -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.word2 -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.word3 -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.word4 -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.button2 -> {
                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {

                            setQuestion()
                        }
                        else -> {
                            val args = Bundle()
                            args.putString(Constants.CORRECT_ANSWERS, mCorrectAnswers.toString())
                            args.putString(
                                Constants.TOTAL_QUESTIONS,
                                mQuestionsList!!.size.toString()
                            )
                            findNavController().navigate(R.id.action_gameFragment_to_finishFragment)
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer != mCurrentPosition) {
                        answerView(mCurrentPosition, R.drawable.correct_option_border_bg)
                        if (mCurrentPosition == mQuestionsList!!.size) {
                            btn_submit.text = "FINISH"
                        } else {
                            btn_submit.text = "GO TO NEXT QUESTION"
                        }

                        mSelectedOptionPosition = 0
                    }
                }
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background =
            ContextCompat.getDrawable(requireContext(), R.drawable.selected_option_border_bg)
    }

    private fun setQuestion() {
        progressBar = view?.findViewById(R.id.progressBar)!!
        tv_progress = view?.findViewById(R.id.tv_progress)!!

        val tv_option_one = getView()?.findViewById(R.id.word1) as TextView
        tv_option_one.setOnClickListener(this)
        val tv_option_two = getView()?.findViewById(R.id.word2) as TextView
        tv_option_two.setOnClickListener(this)
        val tv_option_three = getView()?.findViewById(R.id.word3) as TextView
        tv_option_three.setOnClickListener(this)
        val tv_option_four = getView()?.findViewById(R.id.word4) as TextView
        tv_option_four.setOnClickListener(this)
        val btn_submit = getView()?.findViewById(R.id.button2) as Button
        btn_submit.setOnClickListener(this)
        mainQuestion = view?.findViewById(R.id.textView) as TextView


//        val btn_submit = view?.findViewById(R.id.button2) as Button

        val question = mQuestionsList!!.get(mCurrentPosition - 1)

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size) {
            btn_submit.text = "FINISH"
        } else {
            btn_submit.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()


//        tv_question.text = question.whoQuestion
        mainQuestion.text = question.question
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }


    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.default_option_border_bg)
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {

            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(requireContext(), drawableView)
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(requireContext(), drawableView)
            }
            3 -> {
                tv_option_three.background =
                    ContextCompat.getDrawable(requireContext(), drawableView)
            }
            4 -> {
                tv_option_four.background =
                    ContextCompat.getDrawable(requireContext(), drawableView)
            }
        }
    }
}