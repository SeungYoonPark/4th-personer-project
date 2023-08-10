package com.example.homepage

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SingUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        val et_name = findViewById<EditText>(R.id.et_name)
        val et_id = findViewById<EditText>(R.id.et_id)
        val et_pw = findViewById<EditText>(R.id.et_pw)

        val btn_signUp = findViewById<Button>(R.id.btn_signupOk)

        btn_signUp.setOnClickListener{
            if(et_name.text.toString().trim().isEmpty() ||et_id.text.toString().trim().isEmpty() ||et_pw.text.toString().trim().isEmpty()){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, SignInActivity::class.java).apply {
                putExtra("id", et_id.text.toString())
                putExtra("pw", et_pw.text.toString())
            }

            setResult(RESULT_OK, intent)

            if (!isFinishing) finish()
        }


    }

}