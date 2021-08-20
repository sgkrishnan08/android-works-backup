package com.example.button;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
public class customeraddition extends AppCompatActivity {
    EditText customername,customerph1,customerph2,customeraddress,shopname,area;
    databasehelper mydb;
    Button setcustomerbutton,clearcustomerbutton,savecustomerbutton,exitcustomerbutton;
    TextView displaycustomertextview;
    ImageButton image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_customeraddition);
        customername = (EditText)findViewById(R.id.shopname);
        customerph1 = (EditText)findViewById(R.id.customerp1);
        customerph2 = (EditText)findViewById(R.id.customerp2);
        shopname = (EditText)findViewById(R.id.customername);
        customeraddress = (EditText)findViewById(R.id.customeraddress);
       // displaycustomertextview = (TextView)findViewById(R.id.costodisplay);

        image =  (ImageButton)findViewById(R.id.samplehomelogo);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });

        area =  (EditText)findViewById(R.id.customerarea);
        mydb = new databasehelper(this );
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                home();
            }
        });
        setcustomerbutton = (Button)findViewById(R.id.sampleset);
        setcustomerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                displaycustomertextview.setText(customername.getText().toString()+"\n" +shopname.getText().toString()+
                        "\n"+customeraddress.getText().toString()+"\n"+area.getText().toString()+
                        "\n"+customerph1.getText().toString()+"\n"+customerph2.getText().toString());
            }
        });
        clearcustomerbutton = (Button)findViewById(R.id.sampleclear);
        clearcustomerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        exitcustomerbutton = (Button)findViewById(R.id.sampleexit);
        exitcustomerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });

        savecustomerbutton = (Button)findViewById(R.id.samplesave);

        savecustomerbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean isInserted = mydb.insertcompany(customername.getText().toString(),shopname.getText().toString(),
                        customeraddress.getText().toString(),area.getText().toString(),customerph1.getText().toString(),
                        customerph2.getText().toString());
                if(isInserted = true)
                {
                    Toast.makeText(customeraddition.this, "company "+customername.getText().toString() +" is added",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(customeraddition.this, "company "+customername.getText().toString() +" could not be added",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void home()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void clear()
    {
        customername.setText("");
        shopname.setText("");
        customeraddress.setText("");
        area.setText("");
        customerph1.setText("");
        customerph2.setText("");
    }
}

