package com.example.potatohead

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun createPotatoHead(view: View){
        var gender: CharSequence = ""
        var features = ""

        //views
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val genderId = radioGroup.checkedRadioButtonId
        val output = findViewById<TextView>(R.id.output)
        val rootLayout = findViewById<ConstraintLayout>(R.id.root_layout)
        val checkBox1 = findViewById<CheckBox>(R.id.checkBox1)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        val checkBox4 = findViewById<CheckBox>(R.id.checkBox4)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val switch = findViewById<SwitchMaterial>(R.id.hairySwitch)

        if(genderId == -1){
            Log.i("if statement", "$genderId")
            //Snackbar
            val genderSnackbar = Snackbar.make(rootLayout, "Please select a gender", Snackbar.LENGTH_SHORT)
            genderSnackbar.show()
        }
        else{
            Log.i("else statement", "$genderId")
            gender = findViewById<RadioButton>(genderId).text

            //checkboxes
            if (checkBox1.isChecked){
                features += " " + checkBox1.text
            }
            if (checkBox2.isChecked){
                features += " " + checkBox2.text
            }
            if (checkBox3.isChecked){
                features += " " + checkBox3.text
            }
            if (checkBox4.isChecked){
                features += " " + checkBox4.text
            }
            if (features.isNotEmpty()){
                features = "with" + features
            }

            //spinner
            val personality = "a " + spinner.selectedItem

            //switch
            if (switch.isChecked){
                gender = switch.text.toString() + ", $gender"
            }

            output.text = "You have created a $gender $features and $personality personality."
        }


    }
}