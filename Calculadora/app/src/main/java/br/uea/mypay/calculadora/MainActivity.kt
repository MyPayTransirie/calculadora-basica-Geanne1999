package br.uea.mypay.calculadora

import android.os.Bundle
import android.util.Log
import android.widget.Toast
//import android.view.View
//import android.widget.Button
//import android.widget.TextView
//import android.os.Build
//import android.view.ViewDebug
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // colocando os números
        button1.setOnClickListener(){ appendOnExpression("1", true)
        }
        button2.setOnClickListener(){appendOnExpression( "2", true)
        }
        button3.setOnClickListener(){ appendOnExpression("3", true)
        }
        button4.setOnClickListener(){ appendOnExpression("4", true)
        }
        button5.setOnClickListener(){ appendOnExpression( "5", true)
        }
        button6.setOnClickListener(){ appendOnExpression("6", true)
        }
        button7.setOnClickListener(){ appendOnExpression( "7", true)
        }
        button8.setOnClickListener(){appendOnExpression( "8", true)
        }
        button9.setOnClickListener(){appendOnExpression( "9", true)
        }
        button0.setOnClickListener(){appendOnExpression( "0", true)
        }
        buttonPont.setOnClickListener(){appendOnExpression( ".",  true)
        }
        // colocando os operadores
        buttonSom.setOnClickListener(){appendOnExpression( "+",  false)
        }
        buttonMult.setOnClickListener(){appendOnExpression( "*",  false)
        }
        buttonDiv.setOnClickListener(){appendOnExpression( "/",  false)
        }
        buttonPot.setOnClickListener(){appendOnExpression( "^",  false)
        }
        buttonIg.setOnClickListener(){appendOnExpression("=",  false)
        }
        buttonSub.setOnClickListener(){appendOnExpression( "-",  false)
        }
        buttonPar1.setOnClickListener(){appendOnExpression("(",  false)
        }
        buttonPar2.setOnClickListener(){appendOnExpression( ")",  false)
        }
        buttonC.setOnClickListener(){
            resultado.text=""
            expressao.text=""
        }
        buttonIg.setOnClickListener(){

            try {
                val expression = ExpressionBuilder(expressao.text.toString()).build()
                val result=expression.evaluate()
                val longResult=result.toLong()
                if(result==longResult.toDouble()){
                    resultado.text=longResult.toString()
                }
                else
                    resultado.text= result.toString()
            }
            catch (e:Exception){
                Log.d("Exception", "message: " + e.message)
                val myToast= Toast.makeText(this, "Erro na expressão!", Toast.LENGTH_SHORT)
                myToast.show()
                resultado.text=""
                expressao.text=""
            }
        }



    }
// criando a exressão baseado no estado do booleano
    private fun appendOnExpression(string:String, canclear:Boolean){
        if (canclear){
            resultado.text=""
            expressao.append(string)
        }
        else{
            expressao.append(resultado.text)
            expressao.append(string)
            resultado.text=""
        }

    }
}