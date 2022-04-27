package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

private const val STATE_PENDING_OPERATION = "pedingOperation"
private const val STATE_OPERAND1 ="Operand1"
private const val STATE_OPERAND1_STORED = "Operand1_Stored"

class MainActivity : AppCompatActivity() {
    private lateinit var result : TextView;
    private lateinit var operation: TextView;

    //Variables hold numbers

    private var operand1: Double? = null;
    private var operand2 : Double? = null;
    private var equial : String = "=";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.result);
        operation = findViewById(R.id.operation);


        var numb0: Button = findViewById(R.id.numb0);
        var numb1: Button = findViewById(R.id.numb1);
        var numb2: Button = findViewById(R.id.numb2);
        var numb3: Button = findViewById(R.id.numb3);
        var numb4: Button = findViewById(R.id.numb4);
        var numb5: Button = findViewById(R.id.numb5);
        var numb6: Button = findViewById(R.id.numb6);
        var numb7: Button = findViewById(R.id.numb7);
        var numb8: Button = findViewById(R.id.numb8);
        var numb9: Button = findViewById(R.id.numb9);
        var plus: Button = findViewById(R.id.plus);
        var division: Button = findViewById(R.id.division);
        var multiply: Button = findViewById(R.id.multiply);
        var minus: Button = findViewById(R.id.minus);
        var equal: Button = findViewById(R.id.equal)

        var clean: Button = findViewById(R.id.clean)

       val listener = View.OnClickListener {v->
           val b = v as Button
           operation.append(b.text)
        }

        clean.setOnClickListener {
            operation.setText("");
        }

        numb0.setOnClickListener(listener)
        numb1.setOnClickListener(listener)
        numb2.setOnClickListener(listener)
        numb3.setOnClickListener(listener)
        numb4.setOnClickListener(listener)
        numb5.setOnClickListener(listener)
        numb6.setOnClickListener(listener)
        numb7.setOnClickListener(listener)
        numb8.setOnClickListener(listener)
        numb9.setOnClickListener(listener)

        plus.setOnClickListener { operation.setText(operation.text.toString() + "+") }
        minus.setOnClickListener { operation.setText(operation.text.toString() +"-") }
        multiply.setOnClickListener { operation.setText(operation.text.toString() +"x") }
        division.setOnClickListener { operation.setText(operation.text.toString() +"/") }

        equal.setOnClickListener {
            var txt = operation.text.toString() ;
            var expression:Expression = ExpressionBuilder(txt).build()
            var result = expression.evaluate()
            operation.setText(result.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(operation != null){
            outState.putString(STATE_OPERAND1,operation.text.toString());
        }
        outState.putString(STATE_PENDING_OPERATION,"=")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        operation.text = savedInstanceState.getString(STATE_OPERAND1)
    }
}