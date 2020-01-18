package com.tech51.quiz.persistance

import com.tech51.eduknowledge.data.vos.QAVo


interface IEduDataSource {

    fun getQuestions(i: Int): QAVo

    fun getAnswer(i: Int): String

    fun shuffle()
}