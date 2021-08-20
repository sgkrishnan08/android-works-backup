package com.example.button;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class profile extends AppCompatActivity {
    public Button edit, exit, save;
    public EditText name,phone1,phone2,address,company;
    public  String view;
    public String  name1,phone11,phone21,address1,company1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name =  (EditText)findViewById(R.id.nameprofile);
        company =  (EditText)findViewById(R.id.profilecompany);
        address =  (EditText)findViewById(R.id.profileaddress);
        phone1 =  (EditText)findViewById(R.id.profieno1);
        phone2 =  (EditText)findViewById(R.id.profileno2);
        name1 = name.getText().toString();
        company1 = company.getText().toString();
        address1 = address.getText().toString();
        phone11 = phone1.getText().toString();
        phone21 = phone2.getText().toString();
        save = (Button)findViewById(R.id.profilesave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";
                view = name1 + "\n"+company1 + "\n" + address1 +"\n" +phone11 +"\n" + phone21;
                Toast.makeText(profile.this,s+"profile updated",Toast.LENGTH_LONG).show();
                System.out.print(view);
            }
        });
        edit=(Button) findViewById(R.id.profileedit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(" ");
                company.setText(" ");
                address.setText(" ");
                phone1.setText(" ");
                phone2.setText(" ");
            }
        });
        exit=(Button)  findViewById(R.id.profileexit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                neww();
            }
        });
    }
    public void neww()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
