package com.example.printing_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.print.PrintHelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private Button btn = (Button)findViewById(R.id.print);
    btn.
    private void doPhotoPrint() {
        PrintHelper imagePrinter = new PrintHelper(context);
        imagePrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
        imagePrinter.setColorMode(PrintHelper.COLOR_MODE_MONOCHROME);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.d);
        imagePrinter.printBitmap("My Test Print Job", bitmap);

    }

    private Context getActivity()
    {
        return null;
    }
}
