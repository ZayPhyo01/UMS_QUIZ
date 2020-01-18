package com.tech51.eduknowledge.data.model

import com.tech51.eduknowledge.data.vos.QAVo

interface IModel {
    fun getQuestions(i : Int) : QAVo
    fun doAnswer(answer : String , i : Int) : Boolean
    fun clearMark()
    fun shuffleQuestion()
    fun getFinalMark() : Int
}