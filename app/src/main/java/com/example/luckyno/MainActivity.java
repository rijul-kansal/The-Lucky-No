/**
 * Section 11
   video no 97-103

   make changes in xml and drawable java->package
 */

/**
   Drawable -- background image paste
   XML      -- Declared text view buttons and edit view
   java->package     -- Create Second Page
   Main Activity -- Create Explicint Intext
                    Get input from user in form of int
                    send data t next page
 */
package com.example.luckyno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2;
    Button bt1;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView2);
        bt1=findViewById(R.id.button);
        ed1=findViewById(R.id.editText);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // taking input from user in the form of integer
                int n=Integer.parseInt(ed1.getText().toString());
                // explicint intent
                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
                // other info send to 2nd page
                i.putExtra("Number",n);
                startActivity(i);
            }
        });
    }
}