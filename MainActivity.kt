package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b_0.setOnClickListener { SetText("0") }
        b_1.setOnClickListener { SetText("1") }
        b_2.setOnClickListener { SetText("2") }
        b_3.setOnClickListener { SetText("3") }
        b_4.setOnClickListener { SetText("4") }
        b_5.setOnClickListener { SetText("5") }
        b_6.setOnClickListener { SetText("6") }
        b_7.setOnClickListener { SetText("7") }
        b_8.setOnClickListener { SetText("8") }
        b_9.setOnClickListener { SetText("9") }
        b_left_half_circle.setOnClickListener { SetText("(") }
        b_right_half_circle.setOnClickListener { SetText(")") }
        b_plus.setOnClickListener { SetText("+") }
        b_dot.setOnClickListener { SetText(".") }
        b_minus.setOnClickListener { SetText("-") }
        b_divide.setOnClickListener { SetText("/") }
        b_multiplying.setOnClickListener { SetText("*") }
        b_AC.setOnClickListener {
            math_operation.text=""
            math_operation_result.text=""}

            b_back.setOnClickListener {
                val str= math_operation.text.toString()
                if(str.isNotEmpty())

                    math_operation.text=str.substring(0,str.length-1)
                math_operation_result.text=""
            }
        b_equality.setOnClickListener {
            try {
           val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    math_operation_result.text=longResult.toString()
                else
                        math_operation_result.text= result.toString()

           }
            catch (e:Exception) {
                Log.d("ERROR","Сообщение:${e.message}")
            }
     }
}
        fun SetText(str:String) {
            if(math_operation_result.text!="")
                math_operation.text=math_operation_result.text
            math_operation_result.text=""

                math_operation.append(str)

        }
}





