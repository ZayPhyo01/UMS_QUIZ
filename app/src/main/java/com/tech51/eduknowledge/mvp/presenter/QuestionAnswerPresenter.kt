package com.tech51.eduknowledge.mvp.presenter

import android.util.Log
import com.tech51.eduknowledge.data.model.Model
import com.tech51.eduknowledge.mvp.view.QuestionAnswerView

import java.lang.Exception

class QuestionAnswerPresenter : BasePresenter<QuestionAnswerView>() {
    var count = 0
     val model = Model

    //now no need to use
    fun onTapNext(ans: String) {
        Log.d("ans" , ans)
        model.doAnswer(ans , count)
        count++
        if (count < 30) {
            val data = model.getQuestions(count)
            mView.showAllQuestionsAndChoice(data)
            mView.updateProgress(count)
        }else {
            mView.nevigateToShowMark(model.getFinalMark())
            model.clearMark()
            count = 0
        }

    }

    fun onCreate() {
        count = 0
        model.shuffleQuestion()
        val data = model.getQuestions(count)
        mView.showAllQuestionsAndChoice(data)


    }




    fun onTapBack() {
        model.shuffleQuestion()
        model.clearMark()
    }

    fun onCreateWithEnglish() {
        count = 0
    }
}