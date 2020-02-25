package com.aca.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn_0.setOnClickListener{ setTextFiles("0")}
        btn_1.setOnClickListener{ setTextFiles("1")}
        btn_2.setOnClickListener{ setTextFiles("2")}
        btn_3.setOnClickListener{ setTextFiles("3")}
        btn_4.setOnClickListener{ setTextFiles("4")}
        btn_5.setOnClickListener{ setTextFiles("5")}
        btn_6.setOnClickListener{ setTextFiles("6")}
        btn_7.setOnClickListener{ setTextFiles("7")}
        btn_8.setOnClickListener{ setTextFiles("8")}
        btn_9.setOnClickListener{ setTextFiles("9")}
        minus_btn.setOnClickListener{ setTextFiles("-")}
        plus_btn.setOnClickListener { setTextFiles("+") }
        mult_btn.setOnClickListener{ setTextFiles("*")}
        disivion_btn.setOnClickListener{ setTextFiles("/")}
        bracket_open_btn.setOnClickListener{ setTextFiles("(")}
        bracket_close_btn.setOnClickListener{ setTextFiles(")")}
        dot_btn.setOnClickListener { setTextFiles(".") }

        clear_btn.setOnClickListener{
            match_operation.text=""
            result_text.text=""
        }

        back_btn.setOnClickListener{
           var str=match_operation.text.toString()

            if (str.isNotEmpty())
                match_operation.text=str.substring(0,str.length-1)

            result_text.text=""
        }


        equal_btn.setOnClickListener {

            try {

                val ex=ExpressionBuilder(match_operation.text.toString()).build()

                val result=ex.evaluate()

                val longRes=result.toLong()

                if(result==longRes.toDouble())
                    result_text.text=longRes.toString()
                else
                    result_text.text=result.toString()





            }catch (e:Exception){
                Log.d("Error","message: ${e.message}")

            }
        }

        

    }





    fun setTextFiles(str:String){
        if (result_text.text!="")
            match_operation.text=result_text.text
        result_text.text=""

        match_operation.append(str)



        }
    }



