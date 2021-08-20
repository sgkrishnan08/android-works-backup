package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText aa,bb;
    private String inter;
    private TextView yes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aa = (EditText)findViewById(R.id.a);
        bb=(EditText)findViewById(R.id.b);
        yes = (TextView) findViewById(R.id.soln);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                yes.setText(aa.getText().toString()+" "+bb.getText().toString());
            }
            @Override
            public void afterTextChanged(Editable s)
            {



            }
        };
        aa.addTextChangedListener(textWatcher);
        bb.addTextChangedListener(textWatcher);
    }

}
