package com.tech51.eduknowledge.mvp.view

import com.tech51.eduknowledge.data.vos.QAVo

interface QuestionAnswerView : BaseView {
    fun resetAllChoiceView()
    fun updateProgress(i : Int)
    fun showAllQuestionsAndChoice(vo : QAVo)
    fun nevigateToShowMark(result : Int)
}