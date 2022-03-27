package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

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
        var numb2: Button = findViewById(R.id.numb1);
        var numb3: Button = findViewById(R.id.numb2);
        var numb4: Button = findViewById(R.id.numb3);
        var numb5: Button = findViewById(R.id.numb4);
        var numb6: Button = findViewById(R.id.numb5);
        var numb7: Button = findViewById(R.id.numb6);
        var numb8: Button = findViewById(R.id.numb7);
        var numb9: Button = findViewById(R.id.numb8);
        var plus: Button = findViewById(R.id.plus);
        var division: Button = findViewById(R.id.division);
        var multiply: Button = findViewById(R.id.multiply);
        var minus: Button = findViewById(R.id.minus);



    }
}