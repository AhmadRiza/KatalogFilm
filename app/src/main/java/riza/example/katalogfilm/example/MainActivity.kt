package riza.example.katalogfilm.example

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import riza.example.katalogfilm.HomeActivity
import riza.example.katalogfilm.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }


    private fun setupView(){

        val username = "Riza"
        val password = "Riza"
        val alamat = "Tuban"

        btn_login?.setOnClickListener {

            val usernameInput = et_username?.text.toString()
            val passwordInput = et_password?.text.toString()

            if(usernameInput == username && passwordInput == password){

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)


            }else{

                Toast.makeText(this,"Username / Password Salah!", Toast.LENGTH_LONG).show()

            }

        }

    }


}