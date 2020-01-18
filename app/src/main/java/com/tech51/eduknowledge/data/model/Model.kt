package com.tech51.eduknowledge.data.model

import android.util.Log
import com.tech51.eduknowledge.data.vos.QAVo
import com.tech51.quiz.persistance.EduDataSource

object Model : IModel {

    override fun getFinalMark() : Int = mark

    var mark = 0

    val dataStore = EduDataSource

    override fun getQuestions(i : Int): QAVo = dataStore.getQuestions(i)

    override fun doAnswer(answer: String , i : Int): Boolean {
        Log.d("doAns","$answer for ${dataStore.getQuestions(i)}")
        if (dataStore.questions[i].answer.equals(answer)){
            //ans true
            mark++
        }
        return true
    }

    override fun clearMark() {
        mark = 0
    }

    override fun shuffleQuestion() {
        dataStore.shuffle()
    }
}