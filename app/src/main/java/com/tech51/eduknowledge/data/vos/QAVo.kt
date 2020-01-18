package com.tech51.eduknowledge.data.vos

data class QAVo (
    val question : String ,
    val answer : String ,
    val choiceAnswers : ArrayList<String>
)