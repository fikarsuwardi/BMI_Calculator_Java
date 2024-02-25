package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button buttonCalculate;
    private TextView resultText;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private EditText editTextAge;
    private EditText editTextFeet;
    private EditText editTextInches;
    private EditText editTextWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    private void findViews() {
        radioButtonMale = findViewById(R.id.radio_button_male);
        radioButtonFemale = findViewById(R.id.radio_button_female);
        editTextAge = findViewById(R.id.edit_text_age);
        editTextFeet = findViewById(R.id.edit_text_feet);
        editTextInches = findViewById(R.id.edit_text_inches);
        editTextWeight = findViewById(R.id.edit_text_weight);
        buttonCalculate = findViewById(R.id.button_calculate);
        resultText = findViewById(R.id.text_view_result);
    }

    private void setupButtonClickListener() {
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String ageText = editTextAge.getText().toString();
        String feetText = editTextFeet.getText().toString();
        String inchesText = editTextInches.getText().toString();
        String weightText = editTextWeight.getText().toString();

        int ageInt = Integer.parseInt(ageText);
        int feetInt = Integer.parseInt(feetText);
        int inchesInt = Integer.parseInt(inchesText);
        int weightInt = Integer.parseInt(weightText);

        int totalInches = (feetInt * 12) + inchesInt;

        double heightInMeters = totalInches * 0.0254;

        double bmi = weightInt / (heightInMeters * heightInMeters);

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if (bmi < 18.5) {
            fullResultString = bmiTextResult + "- You are underweight";
        } else if (bmi > 25) {
            fullResultString = bmiTextResult + "- You are overweight";
        } else {
            fullResultString = bmiTextResult + "- You are healthy weight";
        }

        resultText.setText(fullResultString);
    }
}