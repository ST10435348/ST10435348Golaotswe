package com.example.historyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val ageEditText = findViewById<EditText>(R.id.ageEditText)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val clearButton = findViewById<Button>(R.id.clearButton)

        val historicalFigures = mapOf(
            "Nelson Mandela, was a South African anti-apartheid activist and politician who served as the president of South Africa from 1994 to 1999." to 95,
            "Niki Lauda, Austrian Formula One racer who won three F1 Championships." to 76,
            "Walt Disney, the founder of Disney Brothers Studios." to 66,
            "Bob Ross, an American painter and art instructor." to 52,
            "Malcolm X, an American Muslim minister & human rights activist." to 39,
            "George Washington, American Founding Father, military officer, and politician who served as the first president of United States." to 67,
            "Queen Victoria, was Queen of the United Kingdom of Great Britain and Ireland." to 81,
            "Mahatma Gandhi, was an Indian lawyer, anti-colonial nationalist and political ethicist" to 78,
            "Mac Miller, was an American rapper, singer-songwriter and record producer. " to 20,
            "Raymond Kroc, an American fast food entrepreneur and businessman." to 84,
            "Paul Walker, an American actor best known for his role in the movie Fast And Furious." to 40
        )

        //Function to find the matched historical figure
        fun findMatch(userage: Int): String {
            var matchedFigure = ""
            var minDifference = Int.MAX_VALUE

            for ((figure, age) in historicalFigures) {
                val difference = kotlin.math.abs(age - userage)
                if (difference < minDifference) {
                    minDifference = difference
                    matchedFigure = figure
                }
            }
            return matchedFigure
        }
        generateButton.setOnClickListener {
            val userAgeStr = ageEditText.text.toString()

            if (userAgeStr.isEmpty()) {
                resultTextView.text = "Error: Please enter your age"
            } else {
                val userAge = userAgeStr.toIntOrNull()
                if (userAge != null) {
                    val matchedFigure = findMatch(userAge)
                    resultTextView.text = "You are matched with $matchedFigure"
                } else {
                    resultTextView.text = "Error: Please enter a valid age"
                }
            }
        }

        clearButton.setOnClickListener {
            ageEditText.text.clear()
            resultTextView.text = ""
        }
    }
}

