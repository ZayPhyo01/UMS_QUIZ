package com.tech51.eduknowledge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import com.tech51.eduknowledge.data.vos.QAVo
import com.tech51.eduknowledge.mvp.presenter.QuestionAnswerPresenter
import com.tech51.eduknowledge.mvp.view.QuestionAnswerView
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity(), QuestionAnswerView {

    val presenter = QuestionAnswerPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        presenter.initView(this)
        presenter.onCreate()

        var ans = ""
        tvFirstAnswer.setOnClickListener {
            tvFirstAnswer.background = ContextCompat.getDrawable(this, R.drawable.right_tap)
            tvSecondAnswer.background =
                ContextCompat.getDrawable(this, R.drawable.wrong_circle_button)
            tvFirstAnswer.setTextColor(ContextCompat.getColorStateList(this, R.color.colorWhite))
            tvSecondAnswer.setTextColor(ContextCompat.getColorStateList(this, R.color.red))
            ans = tvFirstAnswer.text.toString()

        }
        tvSecondAnswer.setOnClickListener {
            tvFirstAnswer.background =
                ContextCompat.getDrawable(this, R.drawable.right_cirlce_button)
            tvSecondAnswer.background = ContextCompat.getDrawable(this, R.drawable.wrong_tap)
            tvSecondAnswer.setTextColor(ContextCompat.getColorStateList(this, R.color.colorWhite))
            tvFirstAnswer.setTextColor(ContextCompat.getColorStateList(this, R.color.green))
            ans = tvSecondAnswer.text .toString()
        }

        btnNext.setOnClickListener {
            presenter.onTapNext(ans)
            tvSecondAnswer.background =
                ContextCompat.getDrawable(this, R.drawable.wrong_circle_button)
            tvFirstAnswer.background =
                ContextCompat.getDrawable(this, R.drawable.right_cirlce_button)
            tvFirstAnswer.setTextColor(ContextCompat.getColorStateList(this, R.color.green))
            tvSecondAnswer.setTextColor(ContextCompat.getColorStateList(this, R.color.red))
            ans = ""

        }

    }

    private fun performClick(position: Int): String {
        for (i in 0..1) {
            if (i == 0) {
                val card = lnChoice.getChildAt(i) as TextView
                card.background = ContextCompat.getDrawable(this, R.drawable.right_cirlce_button)
            } else {
                val card = lnChoice.getChildAt(i) as TextView
                card.background = ContextCompat.getDrawable(this, R.drawable.wrong_circle_button)
            }
        }

        val choice = (lnChoice.getChildAt(position) as TextView)
        choice.setBackgroundColor(ContextCompat.getColor(this, R.color.colorQuizStandard))
        return choice.text.toString()
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, QuizActivity::class.java)
    }

    override fun resetAllChoiceView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateProgress(i: Int) {
      //  tvShowCurrentPosition.text = i.toString()
       // cpvCurrent.setValue(i.toFloat())
    }

    override fun showAllQuestionsAndChoice(vo: QAVo) {
        tvQuestion.text = vo.question
        tvFirstAnswer.text = vo.choiceAnswers.get(0)
        tvSecondAnswer.text = vo.choiceAnswers.get(1)
    }

    override fun nevigateToShowMark(result: Int) {
        val intent = ShowResultActivity.newIntent(this)
        intent.putExtra("mark",result)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {

    }


}