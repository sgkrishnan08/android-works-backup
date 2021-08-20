package com.example.button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class scrollentrybase extends AppCompatActivity {
    private Button customerView,save,close,print,neww;
    private EditText itemName,companyName,hsnCode,mrp,rate,cgst,sgst,piece,value,discount,taxableValue;
    private TextView billValue,dateView;
    public Integer billno = 1;
    public ArrayList<String> item_entry;
    public String s,currentDate;
    private ListView lv;
    public String x;
    public Integer count = 0;
    public ArrayList<items> itemList;
    public ArrayList<ArrayList<String>> entry = new ArrayList<ArrayList<String>>(10);
    private EditText editItem,editCName,editHSN,editMRP;
    FrameLayoutListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollentrybase);
        editItem =  (EditText)findViewById(R.id.itemNameEdit);
        editCName  = (EditText)findViewById(R.id.companyNameEdit);
        editHSN =  (EditText) findViewById(R.id.HSNCodeEdit);
        editMRP =  (EditText) findViewById(R.id.MRPEdit);
        customerView = (Button)findViewById(R.id.customerView);
        customerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newView();
            }
        });
        save =  (Button) findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newSave();
            }
        });
        lv = (ListView)findViewById(R.id.ListView);
        Calendar calender = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance().format(calender.getTime());
        dateView = (TextView)findViewById(R.id.dateValueEdit);
        dateView.setText(currentDate);

        itemList = new ArrayList<items>(8);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int which_item = position;

                new AlertDialog.Builder(scrollentrybase.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("delete this item..?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                itemList.remove(which_item);
                                entry.remove(which_item);
                                list.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
                return true;

            }
        });

        close = (Button)findViewById(R.id.closeButton);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
        print = (Button) findViewById(R.id.printButton);
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print();
            }
        });
        billValue = findViewById(R.id.billValueEdit);
        billValue.setText(String.valueOf(billno));
        neww =  (Button)findViewById(R.id.newButton);
        neww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newNew();
            }
        });

        //edit view starts here..
        itemName = (EditText)findViewById(R.id.itemNameEdit);
        companyName = (EditText)findViewById(R.id.companyNameEdit);
        hsnCode = (EditText)findViewById(R.id.HSNCodeEdit);
        mrp = (EditText)findViewById(R.id.MRPEdit);
        rate = (EditText)findViewById(R.id.rateEdit);
        cgst = (EditText)findViewById(R.id.cgstEdit);
        sgst =  (EditText)findViewById(R.id.sgstEdit);
        piece = (EditText)findViewById(R.id.pieceEdit);
        value = (EditText)findViewById(R.id.valueEdit);
        discount = (EditText)findViewById(R.id.discountEdit);
        taxableValue = (EditText)findViewById(R.id.taxableValueEdit);

        items x = new items("1","hi","35","241","3452","335","345","345","sd");
        items a = new items("1","bye","35","241","bye","335","345","eruma","sd");
        items b = new items("1","hi","35","241","3452","335","345","345","sd");
        items y = new items("1","bye","35","241","bye","335","345","eruma","sd");

        ArrayList<items> fun = new ArrayList<>();
        fun.add(x);
        fun.add(a);
        fun.add(b);
        fun.add(y);
        FrameLayoutListView adapter = new FrameLayoutListView(this,R.layout.customlistview,fun);
        lv.setAdapter(adapter);
    }
    public void newView()
    {
        Intent intent =  new Intent(this,scrollentry.class);
        startActivity(intent);
    }
    public void newSave()
    {
        String cn,p,i,h,r,v,c,ss,t,d;
        ArrayList<String> item_entry =  new ArrayList<String>(8);
        cn = companyName.getText().toString();
        p = piece.getText().toString();
        i = itemName.getText().toString();
        h = hsnCode.getText().toString();
        r = rate.getText().toString();
        v = value.getText().toString();
        c = cgst.getText().toString();
        ss = sgst.getText().toString();
        t = taxableValue.getText().toString();
        d = discount.getText().toString() ;
        companyName.setText("");
        piece.setText("");
        itemName.setText("");
        hsnCode.setText("");
        rate.setText("");
        value.setText("");
        cgst.setText("");
        sgst.setText("");
        taxableValue.setText("");
        discount.setText("");

        items x = new items(p,i,h,r,v,c,ss,t,d);
        System.out.println(x);
        item_entry.add(cn);
        item_entry.add(p);
        item_entry.add(i);
        item_entry.add(h);
        item_entry.add(r);
        item_entry.add(v);
        item_entry.add(c);
        item_entry.add(ss);
        item_entry.add(t);
        item_entry.add(d);
        itemList.add(x);
        entry.add(item_entry);
        System.out.println(entry);
        list =  new FrameLayoutListView(scrollentrybase.this, R.layout.customlistview,itemList);
        lv.setAdapter(list);

        list.notifyDataSetChanged();

    }
    public void close()
    {
        Intent intent =  new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void print()
    {
        billno += 1;
        //print pop generation;
    }
    public void newNew()
    {
        Intent intent =  new Intent(this,scrollentrybase.class);
        startActivity(intent);
    }
}
