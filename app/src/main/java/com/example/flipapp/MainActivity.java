 package com.example.flipapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText inputText, outputText;
    private Button flipButton, copyButton, clearButton, shareButton;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);
        flipButton = findViewById(R.id.flipButton);
        copyButton = findViewById(R.id.copyButton);
        clearButton = findViewById(R.id.clearButton);
        shareButton = findViewById(R.id.shareButton);
        linearLayout = findViewById(R.id.linearlayout);

        // Flip button click listener
        flipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = inputText.getText().toString();
                String flippedText = new StringBuilder(input).reverse().toString();
                outputText.setText(flippedText);
                outputText.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
//                copyButton.setVisibility(View.VISIBLE);
//                shareButton.setVisibility(View.VISIBLE);
//                clearButton.setVisibility(View.VISIBLE);
            }
        });

        // Copy button click listener
        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Text Copied", Toast.LENGTH_SHORT).show();
                String textToCopy = outputText.getText().toString();
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("flippedText", textToCopy);
                clipboard.setPrimaryClip(clip);
            }
        });

        // Clear button click listener
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Text Cleared!", Toast.LENGTH_SHORT).show();
                inputText.setText("");
                outputText.setText("");
            }
        });

        // Share button click listener
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToShare = outputText.getText().toString();
                Intent shareIntent = new Intent();


            }
        });
    }
}