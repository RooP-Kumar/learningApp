package com.example.learningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.SoftReference;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
  private double money = 0;
  private TextView malone;
  private RadioButton rb;
  private RadioButton rab1;
  private RadioButton rab2;
  private RadioButton rab3;
  private String rbvalue;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    malone = findViewById(R.id.textView);
    float hun = 100;
    float fiver = 500;
    float thou = 2000;
    rab1 = findViewById(R.id.rb1);
    rab2 = findViewById(R.id.rb2);
    rab3 = findViewById(R.id.rb3);
    Format formats1 = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
    String num = formats1.format(hun);
    rab1.setText(num);

    String num2 = formats1.format(fiver);
    rab2.setText(num2);

    String num3 = formats1.format(thou);
    rab3.setText(num3);

  }

  public void SelOpt(View viw) {

    switch (viw.getId()) {
      case R.id.rb1:
        if (((RadioButton) viw).isChecked()) {
          rb = findViewById(R.id.rb1);
          rbvalue = (String) rb.getResources().getText(R.string.hundred);
        }
        break;

      case R.id.rb2:
        if (((RadioButton) viw).isChecked()) {
          rb = findViewById(R.id.rb2);
          rbvalue = (String) rb.getResources().getText(R.string.fivehundred);
        }
        break;

      case R.id.rb3:
        if (((RadioButton) viw).isChecked()) {
          rb = findViewById(R.id.rb3);
          rbvalue = (String) rb.getResources().getText(R.string.twothousand);
        }
        break;
    }

  }

  public void increaseMoney(View v) {

    try {
      money = money + Integer.parseInt(rbvalue);

      NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));

      String moneyString = formatter.format(money);

      malone.setText(moneyString);
      String rupee;

      switch ((int) Integer.parseInt(rbvalue)) {
        case 100:
          rupee = "100";
          ShowTag(rupee);
          break;

        case 500:
          rupee = "500";
          ShowTag(rupee);
          break;

        case 2000:
          rupee = "2000";
          ShowTag(rupee);
          break;
      }
    }
    catch (Exception e) {
      Toast.makeText(getApplicationContext(), "Please Select Amount.", Toast.LENGTH_SHORT)
              .show();
    }



  }

  public void ShowTag(String rupee) {
    String Tag = "You added ₹" + rupee;
    Toast.makeText(getApplicationContext(), Tag, Toast.LENGTH_SHORT)
            .show();
  }

}