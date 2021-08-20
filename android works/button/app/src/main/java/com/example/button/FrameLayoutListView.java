package com.example.button;
import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class FrameLayoutListView extends ArrayAdapter<items> {
    private Context contexts;
    int mresource;
    public FrameLayoutListView(Context context, int resource, ArrayList<items> objects)
    {
        super(context,resource,objects);
        contexts = context;
        mresource = resource;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        String piecee = getItem(position).getpc();
        String itemnamee =  getItem(position).getin();
        String hsnn = getItem(position).gethsn();
        String ratee =  getItem(position).getr();
        String  valuee = getItem(position).getv();
        String  cgstt = getItem(position).getcgst();
        String  sgstt = getItem(position).getsgst();
        String  amountt = getItem(position).getamt();
        String  discountt = getItem(position).getdis();

        items x = new items(piecee,itemnamee,hsnn,ratee,valuee,cgstt,sgstt,amountt,discountt);

        LayoutInflater inflater = LayoutInflater.from(contexts);
        convertView = inflater.inflate(mresource,parent,false);


        TextView sno =  (TextView) convertView.findViewById(R.id.snolv);
        TextView piece =  (TextView) convertView.findViewById(R.id.piecelv);
        TextView itemname =  (TextView) convertView.findViewById(R.id.itemnamelv);
        TextView hsn =  (TextView) convertView.findViewById(R.id.hsnlv);
        TextView rate =  (TextView) convertView.findViewById(R.id.ratelv);
        TextView value =  (TextView) convertView.findViewById(R.id.valuelv);
        TextView cgst =  (TextView) convertView.findViewById(R.id.cgstlv);
        TextView sgst =  (TextView) convertView.findViewById(R.id.sgstlv);
        TextView amount =  (TextView) convertView.findViewById(R.id.amountlv);
        TextView discount =  (TextView) convertView.findViewById(R.id.discountlv);

        piece.setText("No of Pieces "+ piecee);
        itemname.setText("ItemName "+itemnamee);
        hsn.setText("HSN Code "+hsnn);
        rate.setText("Rate "+ratee);
        value.setText("Value"+valuee);
        cgst.setText("CGST "+ cgstt);
        sgst.setText("SGST "+sgstt);
        amount.setText("Amount "+amountt);
        discount.setText("Discount"+discountt);

        return convertView;
    }
}
