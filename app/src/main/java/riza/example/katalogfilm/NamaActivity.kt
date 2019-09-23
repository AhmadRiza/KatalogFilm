package riza.example.katalogfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nama.*

class NamaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nama)
        setUpView()
    }


    fun setUpView(){

        val username = intent.getStringExtra("name")
        val alamat = intent.getStringExtra("alamat")

        tv_hai.text = "Hai, $username di $alamat"

    }
}
