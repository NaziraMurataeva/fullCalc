package kg.tutorialapp.fullcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var math_op: TextView
    lateinit var result: TextView

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        math_op = findViewById(R.id.math_op)
        result = findViewById(R.id.result)
        val btn_0 = findViewById<Button>(R.id.btn_0)
        val btn_1 = findViewById<Button>(R.id.btn_1)
        val btn_2 = findViewById<Button>(R.id.btn_2)
        val btn_3 = findViewById<Button>(R.id.btn_3)
        val btn_4 = findViewById<Button>(R.id.btn_4)
        val btn_5 = findViewById<Button>(R.id.btn_5)
        val btn_6 = findViewById<Button>(R.id.btn_6)
        val btn_7 = findViewById<Button>(R.id.btn_7)
        val btn_8 = findViewById<Button>(R.id.btn_8)
        val btn_9 = findViewById<Button>(R.id.btn_9)
        val btn_div = findViewById<Button>(R.id.div_btn)
        val btn_mult = findViewById<Button>(R.id.btn_mult)
        val btn_add = findViewById<Button>(R.id.btn_add)
        val btn_sub = findViewById<Button>(R.id.btn_sub)
        val btn_equ = findViewById<Button>(R.id.btn_equal)
        val btn_opb = findViewById<Button>(R.id.open_bracket_btn)
        val btn_cb = findViewById<Button>(R.id.close_bracket_btn)
        val btn_AC = findViewById<Button>(R.id.AC_btn)
        val back_btn = findViewById<Button>(R.id.btn_back)

        btn_0.setOnClickListener {setTextFields("0")}
        btn_1.setOnClickListener {setTextFields("1")}
        btn_2.setOnClickListener {setTextFields("2")}
        btn_3.setOnClickListener {setTextFields("3")}
        btn_4.setOnClickListener {setTextFields("4")}
        btn_5.setOnClickListener {setTextFields("5")}
        btn_6.setOnClickListener {setTextFields("6")}
        btn_7.setOnClickListener {setTextFields("7")}
        btn_8.setOnClickListener {setTextFields("8")}
        btn_9.setOnClickListener {setTextFields("9")}
        btn_div.setOnClickListener {setTextFields("/")}
        btn_mult.setOnClickListener {setTextFields("*")}
        btn_add.setOnClickListener {setTextFields("+")}
        btn_sub.setOnClickListener {setTextFields("-")}
        btn_equ.setOnClickListener {setTextFields("=")}
        btn_opb.setOnClickListener {setTextFields("(")}
        btn_cb.setOnClickListener {setTextFields(")")}

        btn_AC.setOnClickListener {
            math_op.text = ""
            result.text = ""
        }
        back_btn.setOnClickListener {
            val str = math_op.text.toString()
            if(str.isNotEmpty())
                math_op.text = str.substring(0, str.length -1)
            result.text=""
        }
        btn_equ.setOnClickListener{
            try{
                val ex = ExpressionBuilder(math_op.text.toString()).build()
                val res =ex.evaluate()
                val longRes = res.toLong()
                if (res == longRes.toDouble())
                    result.text = longRes.toString()
                else
                    result.text = res.toString()

            } catch (e:Exception){
               Log.d("Ошибка","сообщение: ${e.message}")
            }
        }
    }

        fun setTextFields(str: String) {
            if(result.text != ""){
                math_op.text = result.text
                result.text = ""
            }
            math_op.append(str)
    }

}