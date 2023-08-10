package com.example.homepage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.ads.mediationtestsuite.activities.HomeActivity

class SignInActivity : AppCompatActivity() {
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val et_id = findViewById<EditText>(R.id.et_id)
        val et_pw = findViewById<EditText>(R.id.et_pw)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_signUp = findViewById<Button>(R.id.btn_signUp)

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val user_id = it.data?.getStringExtra("id") ?: ""
                val user_pw = it.data?.getStringExtra("pw") ?: ""
                et_id.setText(user_id)
                et_pw.setText(user_pw)
            }
        }

        btn_login.setOnClickListener{
            if (et_id.text.toString().trim().isEmpty()|| et_pw.text.toString().trim().isEmpty()){
                Toast.makeText(this, getString(R.string.toast_msg_idpqErr), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("id", et_id.text.toString())
            startActivity(intent)
        }

        btn_signUp.setOnClickListener{
                val intent = Intent(this, SignInActivity::class.java)
            activityResultLauncher.launch(intent)
        }
    }
}