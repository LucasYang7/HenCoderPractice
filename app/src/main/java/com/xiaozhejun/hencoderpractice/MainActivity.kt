package com.xiaozhejun.hencoderpractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xiaozhejun.hencoderpractice.practice1.Practice1Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_goto_practice1.setOnClickListener {
            var intent = Intent(this@MainActivity, Practice1Activity::class.java)
            this@MainActivity.startActivity(intent)
        }
    }
}
