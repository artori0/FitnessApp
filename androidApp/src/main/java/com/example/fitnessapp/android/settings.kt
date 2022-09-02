package com.example.fitnessapp.android

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val home = findViewById<ImageView>(R.id.appIcon)
        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val password = findViewById<TextView>(R.id.changePassword)
        password.setOnClickListener {
            val intent = Intent(this, changePassword::class.java)
            startActivity(intent)
        }

        //to open change email page
        val email = findViewById<TextView>(R.id.changeEmail)
        email.setOnClickListener{
            val intent = Intent(this,changeEmail::class.java)
            startActivity(intent)
        }

        //to open terms and services page
        val TNS = findViewById<TextView>(R.id.TNS)

        TNS.setOnClickListener{
            val intent = Intent(this, terms::class.java)
            startActivity(intent)
        }
        appPermissions()
    }

    //clicks to ask for permissions
    private val fine_location_rq = 66
    private val calendar_rq = 212

    private fun appPermissions(){
        val allowCalendarPermission = findViewById<TextView>(R.id.allowCalendarPermissions)

        allowCalendarPermission.setOnClickListener {
            checkForPermissions(android.Manifest.permission.READ_CALENDAR,"Calendar", calendar_rq)
        }
        val allowLocationPermission = findViewById<TextView>(R.id.allowLocationServices)

        allowLocationPermission.setOnClickListener {
            checkForPermissions(android.Manifest.permission.ACCESS_FINE_LOCATION,"Location", fine_location_rq)
        }

    }

    //toast to tell that permissions already granted
    private fun checkForPermissions(permission: String, name: String, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            when {
                ContextCompat.checkSelfPermission(applicationContext, permission) == PackageManager.PERMISSION_GRANTED -> {
                    Toast.makeText(applicationContext, "$name permission granted", Toast.LENGTH_SHORT).show()
                }
                shouldShowRequestPermissionRationale(permission) -> showDialog(permission,name,requestCode)

                else -> ActivityCompat.requestPermissions(this, arrayOf(permission),requestCode)
            }
        }

    }

    //toast when refusing or allowing permissions
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        fun innerCheck(name: String){
            if (grantResults.isEmpty() && grantResults[0] != PackageManager.PERMISSION_GRANTED ){
                Toast.makeText(applicationContext,"$name permission refused", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext,"$name permission granted", Toast.LENGTH_SHORT).show()
            }

        }

        when (requestCode){
            fine_location_rq -> innerCheck("Location")
            calendar_rq -> innerCheck("Calender")
        }
    }

    //DialogBox to tell why need to allow permissions
    private fun showDialog(permission: String,name:String,requestCode: Int){

        val builder = AlertDialog.Builder(this)

        builder.apply {

            setMessage("Permission to access your $name is required to use this app")
            setTitle("Permission required")
            setPositiveButton("OK"){_,_->
                ActivityCompat.requestPermissions(this@settings, arrayOf(permission),requestCode)
            }
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}