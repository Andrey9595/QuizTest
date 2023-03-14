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
import ru.anb.quiztest.R
import ru.anb.quiztest.constants.Constants
import ru.anb.quiztest.constants.Question


class GameFragment : Fragment(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    private lateinit var tv_option_one: TextView
    private lateinit var tv_option_two: TextView
    private lateinit var tv_option_three: TextView
    private lateinit var tv_option_four: TextView
    private lateinit var btn_submit: Button

    private lateinit var  progressBar: ProgressBar
    private lateinit var tv_progress: TextView
    private lateinit var tv_question: TextView
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

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.word1 -> {
                selectedOptionView(tv_option_one, 1)
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
        tv.background = ContextCompat.getDrawable(requireContext(), R.drawable.selected_option_border_bg)
    }

    private fun setQuestion() {
        val question = mQuestionsList!!.get(mCurrentPosition - 1)

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "FINISH"
        } else {
            btn_submit.text = "SUBMIT"
        }
        progressBar.progress = mCurrentPosition
        tv_progress.text  = "$mCurrentPosition" + "/" + progressBar.getMax()

        tv_question.text = question.whoQuestion
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

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){

            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(requireContext(), drawableView)
            }
            2 -> {
               tv_option_two.background = ContextCompat.getDrawable(requireContext(), drawableView)
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(requireContext(), drawableView)
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(requireContext(), drawableView)
            }
        }
    }
}