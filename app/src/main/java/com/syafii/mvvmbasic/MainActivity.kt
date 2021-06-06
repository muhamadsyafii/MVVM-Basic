package com.syafii.mvvmbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syafii.mvvmbasic.utils.openActivity
import com.syafii.mvvmbasic.views.LoginActivity
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timer().schedule(2000){
            openActivity(LoginActivity::class.java)
            finish()
        }

    }
}