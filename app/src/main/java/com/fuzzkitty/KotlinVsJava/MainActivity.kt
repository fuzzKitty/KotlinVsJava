package com.fuzzkitty.KotlinVsJava

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    // Try to play with the variables and only declare them without initialising them...
    // What happens? Can it be done? Can we initialise them later? lateinit???
    private var firstNumber: Double = 0.0;
    private var secondNumber: Double = 0.0;

    // Try to initialise the operator to null, can you do it?
    private var currentOperator: Operator = Operator.PLUS;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Setting up button listeners
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Computing result :)", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            //Smart Cast here!!!
            firstNumber = first_number_et.getText().toString().toDouble()
            secondNumber = second_number_et.getText().toString().toDouble()

            // Try to use an implicit setter when accessing the TextView text
            // Can you do the same with the actual numbers and get rid of the Class variables?
            result_tv.setText(computeResult(firstNumber, secondNumber, currentOperator))

        }

        plus_btn.setOnClickListener { view ->
            currentOperator = Operator.PLUS
            plus_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.active_button_colour))
            minus_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.inactive_button_colour))
            times_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.inactive_button_colour))
            divided_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.inactive_button_colour))
        }

        minus_btn.setOnClickListener { view ->
            currentOperator = Operator.MINUS
            plus_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.inactive_button_colour))
            minus_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.active_button_colour))
            times_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.inactive_button_colour))
            divided_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.inactive_button_colour))
        }

        times_btn.setOnClickListener { view ->
            currentOperator = Operator.TIMES
            plus_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.inactive_button_colour))
            minus_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.inactive_button_colour))
            times_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.active_button_colour))
            divided_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.inactive_button_colour))
        }

        divided_btn.setOnClickListener { view ->
            currentOperator = Operator.DIVIDED
            plus_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.inactive_button_colour))
            minus_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.inactive_button_colour))
            times_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.inactive_button_colour))
            divided_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.active_button_colour))
        }

    }


    //MENU
    // Can you add a menu function that switches you over to Java? Kotlin and Java are interoperable!!!
    // Below are the the 2 methods you need to get started with a Menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.switch_to_java -> true
            else -> super.onOptionsItemSelected(item)
        }

    }


    // Custom functions
    private fun computeResult(num1: Double, num2: Double, operator: Operator): String {

        //type inference?
        var result: Double = when (operator) {
            Operator.PLUS -> (num1 + num2)
            Operator.MINUS -> (num1 - num2)
            Operator.TIMES -> (num1 * num2)
            Operator.DIVIDED -> (num1 / num2)
            else -> 0.0 //there is no need for else! :)
        }

        return result.toString()

    }


}
