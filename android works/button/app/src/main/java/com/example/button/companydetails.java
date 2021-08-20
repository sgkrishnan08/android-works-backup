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

public class companydetails extends AppCompatActivity {
    EditText owner,companyname,customerph1,customerph2,customeraddress,area;
    databasehelper mydb;
    Button setcompanybutton,clearcompanybutton,savecompanybutton,exitcompanybutton;
    TextView displaycompanytextview;
    ImageButton image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companydetails);
        companyname = (EditText)findViewById(R.id.companydetailscustomername);
        customerph1 = (EditText)findViewById(R.id.companydetailscustomerp1);
        customerph2 = (EditText)findViewById(R.id.companydetailscustomerp2);
        owner = (EditText)findViewById(R.id.companydetailsownername);
        customeraddress = (EditText)findViewById(R.id.companydetailscustomeraddress);
        image =  (ImageButton)findViewById(R.id.companydetailshomelogo);
        area =  (EditText)findViewById(R.id.companydetailscustomerarea);
        mydb = new databasehelper(this );
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });

        exitcompanybutton = (Button)findViewById(R.id.sampleexit);
        exitcompanybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });

        displaycompanytextview = (TextView)findViewById(R.id.companydetailsdisplay);
        setcompanybutton = (Button)findViewById(R.id.companydetailsset);
        setcompanybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                displaycompanytextview.setText("company name:     "+companyname.getText().toString()+"\n" +"ownername:     "+owner.getText().toString()+
                        "\n"+"companyaddress"+customeraddress.getText().toString()+"\n"+"area     :"+area.getText().toString()+
                        "\nphone:   "+customerph1.getText().toString()+"\n     "+customerph2.getText().toString());
            }
        });
        clearcompanybutton = (Button)findViewById(R.id.companydetailsclear);
        clearcompanybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        savecompanybutton = (Button)findViewById(R.id.companydetailssave);
        savecompanybutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean isInserted = mydb.insertcompany(companyname.getText().toString(),owner.getText().toString(),
                        customeraddress.getText().toString(),area.getText().toString(),customerph1.getText().toString(),
                        customerph2.getText().toString());
                if(isInserted = true)
                {
                    Toast.makeText(companydetails.this, "company "+companyname.getText().toString() +" is added",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(companydetails.this, "company "+companyname.getText().toString() +" could not be added",Toast.LENGTH_LONG).show();
                }
                clear();
                displaycompanytextview.setText("");

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
        companyname.setText("");
        owner.setText("");
        customeraddress.setText("");
        area.setText("");
        customerph1.setText("");
        customerph2.setText("");
    }
}
