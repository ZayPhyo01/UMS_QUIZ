package com.tech51.eduknowledge.mvp.presenter

import com.tech51.eduknowledge.mvp.view.BaseView

open class BasePresenter<T : BaseView> {
    lateinit var mView: T
    fun initView(view: T) {
        mView = view
    }
}