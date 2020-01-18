package com.tech51.eduknowledge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class KnowledgeSharingActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_knowledge_sharing)
    }
    companion object {
        fun newIntent(context: Context): Intent = Intent(context, KnowledgeSharingActivity::class.java)
    }


}