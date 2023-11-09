package com.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView showCount;
    private int count = 0;
    private long fibNMinus1 = 0;
    private long fibNMinus2 = 1;
    private long currentfib= 0;
    private long limit = 0;
    private EditText edit_max_fibonacci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        showCount = findViewById(R.id.show_count);
        edit_max_fibonacci = findViewById(R.id.edit_max_fibonacci);

        updateCountDisplay();

    }

    private void updateCountDisplay() {
        showCount.setText(String.valueOf(fibNMinus1));

        if(count % 4 == 0) {
            showCount.setTextColor(getResources().getColor(R.color.colorPrimary));
        } else if (count % 4 == 1) {
            showCount.setTextColor(getResources().getColor(R.color.colorAccent));
        } else if (count % 4 == 2) {
            showCount.setTextColor(getResources().getColor(R.color.colorPrimary));
        } else {
            showCount.setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }
    public void showToast(View view) {
        Toast.makeText(this, "Bilangan Fibonacci",
                Toast.LENGTH_SHORT).show();
    }
    public void countUp(View view) {
        if(edit_max_fibonacci.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter limit first", Toast.LENGTH_SHORT).show();
            return;
        }
        limit = Long.parseLong(edit_max_fibonacci.getText().toString());
        if(count >= limit){
            Toast.makeText(this,"Fibonacci limit reached", Toast.LENGTH_SHORT).show();
            return;
        }
        long newFib = fibNMinus1 + fibNMinus2;
        fibNMinus2 = fibNMinus1;
        fibNMinus1 = newFib;
        currentfib = newFib;

        updateCountDisplay();
        count++;
    }

    public void back1(View view) {
        count = 0;
        fibNMinus1 = 0;
        fibNMinus2 = 1;
        currentfib = 0;
        updateCountDisplay();
    }
}