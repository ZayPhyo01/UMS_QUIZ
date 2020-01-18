package com.tech51.eduknowledge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_show_result.*

class ShowResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_result)
        val result = intent.extras!!.getInt("mark")
        tvResult.text = "You got $result mark .."

        btnBack.setOnClickListener {
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context) : Intent = Intent(context , ShowResultActivity::class.java)
    }
}