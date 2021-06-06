package com.syafii.mvvmbasic.utils

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/* Toast Activity*/
fun AppCompatActivity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/*Open Activity*/
fun <T> Activity.openActivity(destination : Class<T>){
    val intent = Intent(this, destination)
    startActivity(intent)
}

/*Open Activity with data*/
fun <T> Activity.openActivity(destination : Class<T>, bundleKey : String, id : String){
    val intent = Intent(this, destination)
    intent.putExtra(bundleKey, id)
    startActivity(intent)
}