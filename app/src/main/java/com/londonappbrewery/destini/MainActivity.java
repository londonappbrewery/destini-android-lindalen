package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mStoryTextView;
    Button mAlternativeOne;
    Button mAlternativeTwo;

    boolean mPartOne;
    boolean mPartTwo;
    boolean mPartThree;

    int storyState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null) {
            storyState = savedInstanceState.getInt("State");
        } else {
            storyState = 0;
        }
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mAlternativeOne = (Button) findViewById(R.id.buttonTop);
        mAlternativeTwo = (Button) findViewById(R.id.buttonBottom);


        mStoryTextView.setText(R.string.T1_Story);
        mAlternativeOne.setText(R.string.T1_Ans1);
        mAlternativeTwo.setText(R.string.T1_Ans2);

        mPartOne = true;
        mPartTwo = false;
        mPartThree = false;
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mAlternativeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPartOne) {
                    mStoryTextView.setText(R.string.T3_Story);
                    mAlternativeOne.setText(R.string.T3_Ans1);
                    mAlternativeTwo.setText(R.string.T3_Ans2);
                    mPartOne = false;
                    mPartThree = true;
                    storyState = 2;
                } else if (mPartTwo) {
                    mStoryTextView.setText(R.string.T3_Story);
                    mAlternativeOne.setText(R.string.T3_Ans1);
                    mAlternativeTwo.setText(R.string.T3_Ans2);
                    mPartTwo = false;
                    mPartThree = true;
                    storyState = 2;
                }
                else if (mPartThree){
                    mStoryTextView.setText(R.string.T6_End);
                    mAlternativeOne.setVisibility(View.GONE);
                    mAlternativeTwo.setVisibility(View.GONE);
                    storyState = 6;
            }
        }});

        mAlternativeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPartOne) {
                    mStoryTextView.setText(R.string.T2_Story);
                    mAlternativeOne.setText(R.string.T2_Ans1);
                    mAlternativeTwo.setText(R.string.T2_Ans2);
                    mPartOne = false;
                    mPartTwo = true;
                    storyState = 1;
                } else if (mPartTwo) {
                    mStoryTextView.setText(R.string.T4_End);
                    mAlternativeOne.setVisibility(View.GONE);
                    mAlternativeTwo.setVisibility(View.GONE);
                    storyState = 4;
                } else if (mPartThree) {
                    mStoryTextView.setText(R.string.T5_End);
                    mAlternativeOne.setVisibility(View.GONE);
                    mAlternativeTwo.setVisibility(View.GONE);
                    storyState = 5;
                }
            }
        });

        if (storyState == 0) {
            mStoryTextView.setText(R.string.T1_Story);
            mAlternativeOne.setText(R.string.T1_Ans1);
            mAlternativeTwo.setText(R.string.T1_Ans2);
            mPartOne = true;
            mPartTwo = false;
            mPartThree = false;
        } else if (storyState == 1) {
            mStoryTextView.setText(R.string.T2_Story);
            mAlternativeOne.setText(R.string.T2_Ans1);
            mAlternativeTwo.setText(R.string.T2_Ans2);
            mPartOne = false;
            mPartTwo = true;
            mPartThree = false;
        } else if (storyState == 2) {
            mStoryTextView.setText(R.string.T3_Story);
            mAlternativeOne.setText(R.string.T3_Ans1);
            mAlternativeTwo.setText(R.string.T3_Ans2);
            mPartOne = false;
            mPartTwo = false;
            mPartThree = true;
        } else if (storyState == 4) {
            mStoryTextView.setText(R.string.T4_End);
            mAlternativeOne.setVisibility(View.GONE);
            mAlternativeTwo.setVisibility(View.GONE);
        } else if (storyState == 5) {
            mStoryTextView.setText(R.string.T5_End);
            mAlternativeOne.setVisibility(View.GONE);
            mAlternativeTwo.setVisibility(View.GONE);
        } else if (storyState == 6) {
            mStoryTextView.setText(R.string.T6_End);
            mAlternativeOne.setVisibility(View.GONE);
            mAlternativeTwo.setVisibility(View.GONE);
        }


    }
        @Override
        public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("State", storyState);

        }
}
