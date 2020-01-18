package com.tech51.eduknowledge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnQuiz.setOnClickListener {
            startActivity(QuizActivity.newIntent(this))
        }
        btnSharing.setOnClickListener {
            startActivity(KnowledgeSharingActivity.newIntent(this))
        }
        btnResearch.setOnClickListener {
            startActivity(ResearchActivity.newIntent(this))
        }
    }
}
