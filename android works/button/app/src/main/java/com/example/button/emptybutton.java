package com.example.button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.button.MainActivity.company;
public class emptybutton extends AppCompatActivity {
    private Button homeid,clearid,addid;
    databasehelper mydb;
    EditText itemid,mrpid,hsnid;
    AutoCompleteTextView edit;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.exampe_menu,menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emptybutton);
        homeid = (Button)findViewById(R.id.homeid);
        clearid = (Button)findViewById(R.id.clearid);
        addid = (Button)findViewById(R.id.addid);
        itemid = (EditText)findViewById(R.id.itemid);
        mrpid = (EditText)findViewById(R.id.mrpid);
        hsnid = (EditText)findViewById(R.id.hsnid);
        mydb = new databasehelper(this );
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edit =  (AutoCompleteTextView) findViewById(R.id.actv);
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,company);
        edit.setAdapter(adapter);
        addid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                boolean isInserted = mydb.insertitem(itemid.getText().toString(),edit.getText().toString(),hsnid.getText().toString(),mrpid.getText().toString());
                itemid.setText("");
                edit.setText("");
                mrpid.setText("");
                hsnid.setText("");
                if(isInserted = true)
                    Toast.makeText(emptybutton.this," Data inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(emptybutton.this," Data not inserted",Toast.LENGTH_LONG).show();
            }
        });
        homeid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
        clearid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemid.setText("");
                edit.setText("");
                mrpid.setText("");
                hsnid.setText("");

            }
        });
    }
    public void add()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
