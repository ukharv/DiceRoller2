package com.example.diceroller2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int score =0;

    // declare ArrayList here, create a method which adds the questions to it,
    // then only call this method when its required (and not immediately on button click)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public int rollTheDice(){
        Random r = new Random();
        int rolledNumber = (r.nextInt(6) +1);
        return rolledNumber;
    }



    public void on_button_click(View button) {

        TextView tv = (TextView) this.findViewById(R.id.numberTextView);
        TextView tv2 = (TextView) this.findViewById(R.id.textViewScore);


        EditText number = this.findViewById(R.id.editText1);

        int rolledNumber=rollTheDice();

        int guessedNumber = Integer.parseInt(number.getText().toString());





            if (guessedNumber == rolledNumber) {
                score = score + 1;
                tv.setText("Congrats! dice was" + rolledNumber);
                tv2.setText("Your score is: " + score);

            } else {
                tv.setText("Wrong! dice was" + rolledNumber);
            }

        //tv.setText(Integer.toString(guessedNumber));





    }


    public void on_button2_click(View button2) {

        TextView tv = (TextView) this.findViewById(R.id.question);

        int rolledNumber=rollTheDice();

        if (rolledNumber == 1) {
            tv.setText(" If you could go anywhere in the world, where would you go? ");
        }
        if (rolledNumber == 2) {
            tv.setText(" If you were stranded on a desert island, what 3 things would you want to take with you? ");
        }
        if (rolledNumber == 3) {
            tv.setText(" If you could eat only one food for the rest of your life, what would that be? ");
        }
        if (rolledNumber == 4) {
            tv.setText(" If you won a million dollars, what is the first thing you would buy? ");
        }
        if (rolledNumber == 5) {
            tv.setText(" If you could spend the day with one fictional character, who would it be? ");
        }
        else if (rolledNumber == 6) {
            tv.setText(" If you found a magic lantern and a genie gave you three wishes, what would you wish? ");
        }


    }


}
