package com.example.loginmodule

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main)

        val email= findViewById<EditText>(R.id.email)
        val pass = findViewById<EditText>(R.id.password)
        val DarkButton = findViewById(R.id.DarkButton) as Button
        val login_button = findViewById(R.id.login_button) as Button

        login_button.setOnClickListener{
            var emailTxt =  email.text.toString()
            var passTxt = pass.text.toString()

            if(!validateEmailFormat(emailTxt)){
                email.error = "Please input valid email"
                return@setOnClickListener;
            }else if(passTxt.isEmpty()){
                pass.error = "Please input valid password"
                return@setOnClickListener;
            }else{
                Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
            }
        }

        DarkButton.setOnClickListener {
            // your code to perform when the user clicks on the button
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            delegate.applyDayNight()
            Toast.makeText(this@MainActivity, "login", Toast.LENGTH_SHORT).show()
        }

        val LightButton = findViewById(R.id.LighButton) as Button
        supportActionBar?.hide()
        LightButton.setOnClickListener {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            delegate.applyDayNight()
            Toast.makeText(this@MainActivity, "Light button", Toast.LENGTH_SHORT).show()
        }

    }

    private fun validateEmailFormat(email: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val EMAIL_PATTERN = ".+@.+\\.[a-z]+"
        pattern = Pattern.compile(EMAIL_PATTERN)
        matcher = pattern.matcher(email)
        return matcher.matches()
    }


}

