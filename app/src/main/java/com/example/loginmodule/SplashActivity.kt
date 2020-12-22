package com.example.loginmodule


import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setCountDown()
    }


    private fun setCountDown() {
        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                val thread: Thread = object : Thread() {
                    override fun run() {
                        try {
                            sleep(1000)
                        } catch (e: InterruptedException) {
                        }
                        //YOUR INTENT CODE HERE
                        startActivity(Intent(this@SplashActivity,MainActivity::class.java))
                        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
                        finish()
                    }

                }
                thread.start()
            }
        }.start()
    }

}

