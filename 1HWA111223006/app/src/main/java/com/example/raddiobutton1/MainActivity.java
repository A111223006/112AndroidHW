// MainActivity.java
package com.example.raddiobutton1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView outputTextView;
    private RadioButton rdbBoy, rdbGirl;
    private RadioGroup rgType;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputTextView = findViewById(R.id.lblOutput);
        rdbBoy = findViewById(R.id.rdbBoy);
        rdbGirl = findViewById(R.id.rdbGirl);
        rgType = findViewById(R.id.rgType);
        editText = findViewById(R.id.editTextNumber);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                updateTextView();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        rgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                updateTextView();
            }
        });


        updateTextView();


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textToPass = outputTextView.getText().toString();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("textFromMainActivity", textToPass);
                startActivity(intent);
            }
        });
    }


    private void updateTextView() {
        String outputStr = "";

        if (rdbBoy.isChecked()) {
            outputStr += getResources().getString(R.string.male) + "\n";
        } else if (rdbGirl.isChecked()) {
            outputStr += getResources().getString(R.string.female) + "\n";
        }

        int sum = 0;
        int selectedId = rgType.getCheckedRadioButtonId();

        if (selectedId == R.id.rdbAdult) {
            outputStr += getResources().getString(R.string.regularticket) + "\n";
            sum = 500;
        } else if (selectedId == R.id.rdbChild) {
            outputStr += getResources().getString(R.string.childticket) + "\n";
            sum = 200;
        } else if (selectedId == R.id.rdbStudent) {
            outputStr += getResources().getString(R.string.studentticket) + "\n";
            sum = 400;
        }

        String userInput = editText.getText().toString();

        try {
            int userInputValue = Integer.parseInt(userInput);
            sum *= userInputValue;
        } catch (NumberFormatException e) {

            outputStr += "0\n";
        }

        String textToDisplay = outputStr + userInput + "張，總計 " + sum + " 元";
        outputTextView.setText(textToDisplay);
    }
}
