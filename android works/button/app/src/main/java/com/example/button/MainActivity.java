package com.example.button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.print.PrintHelper;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private Button additemhomeButton,addcustomerhomeButton,addentryhomeButton,addcompanyhomeButton,print;
    databasehelper db;
    public static ArrayList<String> company = new ArrayList();
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.exampe_menu,menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcustomerhomeButton = (Button)findViewById(R.id.addcustomerhome);
        addcustomerhomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCustomerAddition();
            }
        });
        additemhomeButton = (Button)findViewById(R.id.additemhome);
        additemhomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setItemAddition();
            }
        });
        print = (Button)findViewById(R.id.print);
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doprint();
            }
        });
        addentryhomeButton = (Button)findViewById(R.id.addentryhome);
        addentryhomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEntryAddition();
            }
        });
        addcompanyhomeButton = (Button)findViewById(R.id.addcompanyhome);
        addcompanyhomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCompanyAddition();
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void setItemAddition()
    {
        Intent intent =  new Intent(this, emptybutton.class);
        startActivity(intent);
    }
    public void setCompanyAddition()
    {
        Intent intent = new Intent(this,companydetails.class);
        startActivity(intent);
    }
    public void setCustomerAddition()
    {
        Intent intent = new Intent(this,sample.class);
        startActivity(intent);
    }
    public void setEntryAddition()
    {
        Intent intent = new Intent(this,scrollentrybase.class);
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.profileview:
                Intent intent  = new Intent(this,profile.class);
                startActivity(intent);
                break;
            case R.id.viewcustomers:
                Toast.makeText(MainActivity.this," customer is viewed ",Toast.LENGTH_LONG).show();
                break;
            case R.id.viewitems:
                Toast.makeText(MainActivity.this,"  items are viewed ",Toast.LENGTH_LONG).show();
                //viewAllItems();
                break;
           case R.id.viewcompanys:
               Toast.makeText(MainActivity.this," company is viewed ",Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }
    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    public void doprint()
    {
        PrintHelper imagePrinter = new PrintHelper(this);
        imagePrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
        imagePrinter.setColorMode(PrintHelper.COLOR_MODE_MONOCHROME);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.jaivant);
        imagePrinter.printBitmap("My Test Print Job", bitmap);
    }
    public void viewAllItems()
    {
        Cursor res = db.getAllData();
        if(res.getCount() == 0)
        {
            showMessage("Error", "no data found");
            return;
        }
                StringBuffer buf = new StringBuffer();
                while (res.moveToNext())
                {
                    buf.append("ID           :" + res.getString(0) + "\n");
                    buf.append("ITEM         :" + res.getString(1) + "\n");
                    buf.append("COMPANY_NAME :" + res.getString(2) + "\n");
                    buf.append("HSN CODE     :" + res.getString(3) + "\n");
                    buf.append("MRP price    :" + res.getString(4) + "\n\n");
                }
                showMessage("Items",buf.toString());
            }
    }

