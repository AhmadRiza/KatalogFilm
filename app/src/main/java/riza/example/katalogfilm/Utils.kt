package riza.example.katalogfilm

import android.app.Activity
import android.view.View
import android.widget.Toast

/**
 * Created by riza@deliv.co.id on 9/23/19.
 */


fun View.visible(){

    visibility = View.VISIBLE

}

fun View.gone(){

    visibility = View.GONE

}

fun View.invible(){

    visibility = View.INVISIBLE

}

fun Activity.toast(messege : String){

    Toast.makeText(this, messege, Toast.LENGTH_SHORT).show()
}

