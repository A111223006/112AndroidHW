// MainActivity2.java
package com.example.raddiobutton1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 获取从 MainActivity 传递过来的文本内容
        String receivedText = getIntent().getStringExtra("textFromMainActivity");

        // 显示接收到的文本内容在 TextView 中
        TextView textView = findViewById(R.id.textView4);
        textView.setText(receivedText);
    }
}
