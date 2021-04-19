package com.faartaak.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.faartaak.calculator.databinding.ActivityMainBinding

      var selecteOperator= ""
      var oldNumber = ""
      var newNumber= true
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // To delete last index
       binding.btnDel.setOnClickListener() {
            val text = binding.showNumber.text.toString()
            if (text.isNotEmpty()) {
                binding.showNumber.text = text.dropLast(1)
            }
        }


    }

    fun setClickEvent(view: View) {
        if (newNumber)    { clearfullNumber() }
        newNumber= false
        val selectedBtn = view as Button
        val currentNumber : String = binding.showNumber.text.toString()
        val newNumber= setNextChar(currentNumber,selectedBtn)
        binding.showNumber.setText(newNumber)
    }

    fun clearfullNumber(){binding.showNumber.setText("0")}

    fun setNextChar(oldNumber:String,selectedBtn:Button) :String {
        var number= oldNumber
        when(selectedBtn.id){
            R.id.btn_0 -> {
             if (number=="0" || number==""){
                 number="0"
         }else {
             number+="0"
         } }

            R.id.btn_1 -> {
                if (number=="0" || number==""){
                    number="1"
                }else {
                    number+="1"
                } }
            R.id.btn_2 -> {
                if (number=="0" || number==""){
                    number="2"
                }else {
                    number+="2"
                } }
            R.id.btn_3 -> {
                if (number=="0" || number==""){
                    number="3"
                }else {
                    number+="3"
                } }
            R.id.btn_4 -> {
                if (number=="0" || number==""){
                    number="4"
                }else {
                    number+="4"
                } }
            R.id.btn_5 -> {
                if (number=="0" || number==""){
                    number="5"
                }else {
                    number+="5"
                } }
            R.id.btn_6 -> {
                if (number=="0" || number==""){
                    number="6"
                }else {
                    number+="6"
                } }
            R.id.btn_7 -> {
                if (number=="0" || number==""){
                    number="7"
                }else {
                    number+="7"
                } }
            R.id.btn_8 -> {
                if (number=="0" || number==""){
                    number="8"
                }else {
                    number+="8"
                } }
            R.id.btn_9 -> {
                if (number=="0" || number==""){
                    number="9"
                }else {
                    number+="9"
                } }
            R.id.btn_dot -> {
                if (number==""){
                    number="0."
                }else { if(number.indexOf('.') == -1)
                    number+="."
                } }

            R.id.btn_plus_minus -> {
                if (number=="0" || number==""){
                    number="0"
                }else {
                  if (number.first() == '-'){
                      number= number.substring(startIndex = 1,number.lastIndex +1)
                  }else{
                      number= "-$number"
                  } } } }
        return number
    }// fun setNextNumber

    fun operarionevent(view: View){
        val selectedbtn = view as Button
        when (selectedbtn.id){
            R.id.btn_plus -> { selecteOperator= "+" }
            R.id.btn_divide -> {selecteOperator= "÷" }
            R.id.btn_minus -> {selecteOperator= "-" }
            R.id.btn_x -> {selecteOperator= "×" }

        }
        newNumber= true
        oldNumber= binding.showNumber.text.toString()
    } // operarionevent

    fun equalEvent(view: View){
        view as Button
        val newnumber= binding.showNumber.text.toString().toDouble()
        var answer : Double?= null
       if (selecteOperator != "" && oldNumber != ""){
           when(selecteOperator){

               "÷" -> answer= oldNumber.toDouble() / newnumber
               "+" -> answer= oldNumber.toDouble() + newnumber
               "-" -> answer= oldNumber.toDouble() - newnumber
               "×" -> answer= oldNumber.toDouble() * newnumber
           }
           binding.showNumber.setText(answer.toString())
           newNumber = true
           oldNumber= ""
           selecteOperator = ""


       }


    } //equalEvent

    fun percentageEvent(view: View){
        view as Button
        val number = binding.showNumber.text.toString().toDouble()
        val percentage = number / 100
        binding.showNumber.setText(percentage.toString())
        newNumber= true

    }

    fun clearText(view: View){
        view as Button
        clearfullNumber()
        newNumber= true
        selecteOperator= ""
    }




























}




