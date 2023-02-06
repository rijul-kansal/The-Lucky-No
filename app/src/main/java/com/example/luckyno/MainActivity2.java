/**
 * Section 11
 video no 97-103

 make changes in xml and drawable java->package
 */

/**
 XML                 -- Declared text view buttons and edit view
 main activity 2     --talking input from the last page
                       explicint intent
                       implicint intent
                                to whome we have to share data
                                adding extra text
                                subject to email
                                create choosers
 */

package com.example.luckyno;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    Button bt1,bt2,bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1=findViewById(R.id.textView3);
        tv2=findViewById(R.id.textView4);
        tv3=findViewById(R.id.textView5);
        bt1=findViewById(R.id.button2);
        bt2=findViewById(R.id.button3);
        bt3=findViewById(R.id.button4);

        // variable creation
        final int[] randd = new int[1];


        // talking info from first page in the form of int
        Intent i= getIntent();
        int s=i.getIntExtra("Number",0);

        // storing any random no
        randd[0] =Random_No();

        // set that no in text tv2
        tv2.setText(" "+ randd[0]);

        // check if our no from page 1 == the random no we generate
        // if yes then print you are lucky else print better luck next time
        if(randd[0] ==s)
        {
            tv3.setText("You are Lucky");
        }
        else
        {
            tv3.setText("Better Luck Next Time");
        }

        // this is  if user wants to play again then click try again
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                randd[0] =Random_No();
                tv2.setText(" "+ randd[0]);
                if(randd[0] ==s)
                {
                    tv3.setText("You are Lucky");
                }
                else
                {
                    tv3.setText("Better Luck Next Time");
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // explicint intent
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
       bt3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // implicint intent
               // this action view will send info to any email or whatsapp etc
               Intent i = new Intent(Intent.ACTION_SEND);
               // this will add some extra text so that user no need to type
               i.putExtra(Intent.EXTRA_TEXT, "The Random No is  "+ randd[0] +"\n");
               // this is for email purpose we will add Subject to any user
               i.putExtra(Intent.EXTRA_SUBJECT,"My Lucky No App");
               i.setType("text/plain");
               // create chooser will display us like on whih platform we have to send out info
               // we have to create a option so that user have a choice to whome he have to send
               startActivity(Intent.createChooser(i,"Share Text"));

           }
       });
    }
    // random no generator
    int Random_No()
    {
        Random random = new Random();
        int randomInt = random.nextInt(10) + 1;
        return randomInt;
        }
    }