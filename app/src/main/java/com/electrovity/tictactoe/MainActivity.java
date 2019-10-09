package com.electrovity.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity
{

    int myActivePlayer = 0;
    //Setting 0 for CROSS and 1 for CIRCLE...

    //My Game State..
    int[] mystate = {9,9,9,9,9,9,9,9,9};
    int state = 1;

    public void imageTapped(View view)
    {
        ImageView myTapped = (ImageView) view;


        Log.i("msgg","Image Number is: " + myTapped.getTag().toString());


        int tag = Integer.parseInt(myTapped.getTag().toString());


        if (mystate[tag] == 9 && state == 1)
        {
            if(myActivePlayer == 0)
            {
                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(1000);
                mystate[tag] = 1;
                myActivePlayer = 1;
            }

            else
            {
                myTapped.setImageResource(R.drawable.circle);
                //myTapped.animate().rotation(360).setDuration(1000);
                mystate[tag] = 0;
                myActivePlayer = 0;
            }
        }
        else if(state == 0){
            Log.i("msgg","GAME OVER");
            //Assignment Replace this with a taost message...
        }
        else
        {
            Log.i("msgg","This place is already FILLED!!!");
            //Assignment Replace this with a taost message...
        }

        if(     (mystate[0] == 1 && mystate[1] == 1 && mystate[2] == 1) ||
                (mystate[3] == 1 && mystate[4] == 1 && mystate[5] == 1) ||
                (mystate[6] == 1 && mystate[7] == 1 && mystate[8] == 1) ||
                (mystate[0] == 1 && mystate[3] == 1 && mystate[6] == 1) ||
                (mystate[1] == 1 && mystate[4] == 1 && mystate[7] == 1) ||
                (mystate[2] == 1 && mystate[5] == 1 && mystate[8] == 1) ||
                (mystate[0] == 1 && mystate[4] == 1 && mystate[8] == 1) ||
                (mystate[2] == 1 && mystate[4] == 1 && mystate[6] == 1))
        {
            Log.i("msgg","Cross WON!!");
            //Assignment Replace this with a taost message...
            state = 0;
        }
        if( (mystate[0] == 0 && mystate[1] == 0 && mystate[2] == 0) ||
                (mystate[3] == 0 && mystate[4] == 0 && mystate[5] == 0) ||
                (mystate[6] == 0 && mystate[7] == 0 && mystate[8] == 0) ||
                (mystate[0] == 0 && mystate[3] == 0 && mystate[6] == 0) ||
                (mystate[1] == 0 && mystate[4] == 0 && mystate[7] == 0) ||
                (mystate[2] == 0 && mystate[5] == 0 && mystate[8] == 0) ||
                (mystate[0] == 0 && mystate[4] == 0 && mystate[8] == 0) ||
                (mystate[2] == 0 && mystate[4] == 0 && mystate[6] == 0))
        {
            Log.i("msgg","Circle WON!!");
            //Assignment Replace this with a taost message...
            state = 0;
        }
    }


    public void PlayAgainn(View view){
        Log.i("msgg","Play Again Tapped!!!");

        //Change Game state back to 9,9,9...
        for(int i = 0; i < mystate.length; i++){
            mystate[i] = 9;
        }

        //Change active player back to 0...
        myActivePlayer = 0;

        //Change all images to ic_launcher...
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.lineOne);
        for(int i = 0; i < linearLayout1.getChildCount(); i++){
            ((ImageView)linearLayout1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.lineTwo);
        for(int i = 0; i < linearLayout2.getChildCount(); i++){
            ((ImageView)linearLayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.lineThree);
        for(int i = 0; i < linearLayout3.getChildCount(); i++){
            ((ImageView)linearLayout3.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        state = 1;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("msgg","I'm in onCreate...");
    }
}
