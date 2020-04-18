package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    var tempCondition: String = ""      //variable for condition

    var editText: EditText? = null      //variable for accessing EditText box
    var btnOne: Button? = null          //variable for accessing Button 1
    var btnTwo: Button? = null          //variable for accessing Button 2
    var btnThree: Button? = null          //variable for accessing Button 3
    var btnFour: Button? = null          //variable for accessing Button 4
    var btnFive: Button? = null          //variable for accessing Button 5
    var btnSix: Button? = null          //variable for accessing Button 6
    var btnSeven: Button? = null          //variable for accessing Button 7
    var btnEight: Button? = null          //variable for accessing Button 8
    var btnNine: Button? = null          //variable for accessing Button 9
    var btnZero: Button? = null          //variable for accessing Button 0
    var btnDot: Button? = null          //variable for accessing Button dot
    var btnPlus: Button? = null          //variable for accessing Button +
    var btnMinus: Button? = null          //variable for accessing Button -
    var btnMul: Button? = null          //variable for accessing Button *
    var btnDiv: Button? = null          //variable for accessing Button /
    var btnEqual: Button? = null          //variable for accessing Button =
    var btnBack: Button? = null          //variable for accessing Button backspace
    var btnClear: Button? = null          //variable for accessing Button clear
    var temp: Double? = null          //define the variable fot storing the temporary value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()          //called the function for finding the values of all controls
        onClickEvent()      //Called click events of controls

    }

    //Find view of controls
    private fun initView() {
        editText = findViewById(R.id.editText) as EditText    //Find view of EditText box
        btnOne = findViewById(R.id.btnOne) as Button    //Find view of Button 1
        btnTwo = findViewById(R.id.btnTwo) as Button    //Find view of Button 2
        btnThree = findViewById(R.id.btnThree) as Button    //Find view of Button 3
        btnFour = findViewById(R.id.btnFour) as Button    //Find view of Button 4
        btnFive = findViewById(R.id.btnFive) as Button    //Find view of Button 5
        btnSix = findViewById(R.id.btnSix) as Button    //Find view of Button 6
        btnSeven = findViewById(R.id.btnSeven) as Button    //Find view of Button 7
        btnEight = findViewById(R.id.btnEight) as Button    //Find view of Button 8
        btnNine = findViewById(R.id.btnNine) as Button    //Find view of Button 9
        btnZero = findViewById(R.id.btnZero) as Button    //Find view of Button 0
        btnDot = findViewById(R.id.btnDot) as Button    //Find view of Button dot(.)
        btnPlus = findViewById(R.id.btnPlus) as Button    //Find view of Button +
        btnMinus = findViewById(R.id.btnMinus) as Button    //Find view of Button -
        btnMul = findViewById(R.id.btnMul) as Button    //Find view of Button *
        btnDiv = findViewById(R.id.btnDiv) as Button    //Find view of Button /
        btnEqual = findViewById(R.id.btnEqual) as Button    //Find view of Button =
        btnBack = findViewById(R.id.btnBack) as Button    //Find view of Button backspace
        btnClear = findViewById(R.id.btnClear) as Button    //Find view of Button clear
    }

    //Set the values
    fun onClickEvent() {
        btnOne?.setOnClickListener {
            editText?.setText("" + editText?.text.toString().trim() + btnOne!!.text.trim())     //Find the value of Button 1
        }
        btnTwo?.setOnClickListener {
            editText?.setText("" + editText?.text.toString().trim() + btnTwo!!.text.trim())     //Find the value of Button 2
        }
        btnThree?.setOnClickListener {
            editText?.setText("" + editText?.text.toString().trim() + btnThree!!.text.trim())     //Find the value of Button 3
        }
        btnFour?.setOnClickListener {
            editText?.setText("" + editText?.text.toString().trim() + btnFour!!.text.trim())     //Find the value of Button 4
        }
        btnFive?.setOnClickListener {
            editText?.setText("" + editText?.text.toString().trim() + btnFive!!.text.trim())     //Find the value of Button 5
        }
        btnSix?.setOnClickListener {
            editText?.setText("" + editText?.text.toString().trim() + btnSix!!.text.trim())     //Find the value of Button 6
        }
        btnSeven?.setOnClickListener {
            editText?.setText("" + editText?.text.toString().trim() + btnSeven!!.text.trim())     //Find the value of Button 7
        }
        btnEight?.setOnClickListener {
            editText?.setText("" + editText?.text.toString().trim() + btnEight!!.text.trim())     //Find the value of Button 8
        }
        btnNine?.setOnClickListener {
            editText?.setText("" + editText?.text.toString().trim() + btnNine!!.text.trim())     //Find the value of Button 9
        }
        btnZero?.setOnClickListener {
            editText?.setText("" + editText?.text.toString().trim() + btnZero!!.text.trim())     //Find the value of Button 0
        }
        btnDot?.setOnClickListener {
            editText?.setText("" + editText?.text.toString().trim() + btnDot!!.text.trim())     //Find the value of Button (.)
        }
        btnPlus?.setOnClickListener {
            tempCondition = Condition.PLUS.toString()       //Check the condition
            temp = editText?.text.toString().toDouble()       //Storing temporary value of +
            editText?.setText("")                               //After storing the value EditTest is blank
        }
        btnMinus?.setOnClickListener {
            tempCondition = Condition.MINUS.toString()       //Check the condition
            temp = editText?.text.toString().toDouble()       //Storing temporary value of -
            editText?.setText("")                               //After storing the value EditTest is blank
        }
        btnMul?.setOnClickListener {
            tempCondition = Condition.MULTIPLICATION.toString()       //Check the condition
            temp = editText?.text.toString().toDouble()       //Storing temporary value of *
            editText?.setText("")                               //After storing the value EditTest is blank
        }
        btnDiv?.setOnClickListener {
            tempCondition = Condition.DIVISION.toString()       //Check the condition
            temp = editText?.text.toString().toDouble()       //Storing temporary value of /
            editText?.setText("")                               //After storing the value EditText is blank
        }
        btnEqual?.setOnClickListener {
            equal()                                         //Called the equal function
        }
        btnBack?.setOnClickListener() {
            editText?.setText(
                editText?.text.toString().trim()
                    .substring(0, editText?.text.toString().trim().length - 1)      //Remove the last digit from EditText
            )
        }
        btnClear?.setOnClickListener {
            editText?.text?.clear()                                             //Clear the EditText
        }
    }
    //Created equal function
    private fun equal() {

        if (editText?.text?.toString()?.trim()!!.length > 0) {
            if (Condition.MINUS.toString().equals(tempCondition)) {         //Checked the last pressed Button
                minus()                                                     //If pressed - then call the minus function
            } else if (Condition.DIVISION.toString().equals(tempCondition)) {            //Checked the last pressed Button
                division()                                                     //If pressed / then call the division function
            } else if (Condition.MULTIPLICATION.toString().equals(tempCondition)) {         //Checked the last pressed Button
                multiplication()                                                     //If pressed * then call the multiplication function
            } else if (Condition.PLUS.toString().equals(tempCondition)) {         //Checked the last pressed Button
                plus()                                                     //If pressed + then call the plus function
            } else {
                Toast.makeText(applicationContext, "Something went wrong!!", Toast.LENGTH_SHORT)
                    .show()                                                                             //If something went wrong then show the toast message
            }
        }
    }
    //Created function for division
    private fun division() {
        try {
            editText?.setText("" + (temp?.div((editText?.text.toString().toDouble()))))
            if (editText?.text.toString().trim().equals("NaN")) {           //Check the
                editText?.setText("")
                Toast.makeText(this, "Can't zero divide by zero", Toast.LENGTH_SHORT).show()    //Print the error message of 0/0
            }
        } catch (e: ArithmeticException) {
            e.printStackTrace()                                 //Throw the other errors
        }
    }
    //Function for multiplication
    private fun multiplication() {
        editText?.setText("" + (temp?.times((editText?.text.toString().toDouble()))))
    }
    //Function for addition
    private fun plus() {

        editText?.setText("" + (temp?.plus((editText?.text.toString().toDouble()))))
    }
    //Function for subtraction
    private fun minus() {
        editText?.setText("" + (temp?.minus((editText?.text.toString().toDouble()))))
    }
//Created enumeration class
    enum class Condition {
        PLUS,
        MINUS,
        MULTIPLICATION,
        DIVISION
    }
}