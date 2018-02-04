package com.example.android.tennistracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int gameScore1 = 0;
    int gameScore2 = 0;

    int setScore1 = 0;
    int setScore2 = 0;

    int matchScore1 = 0;
    int matchScore2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void print() {
        String gameScore1String;
        if(gameScore1 == 50) {
            gameScore1String = "Ad";
        } else {
            gameScore1String = Integer.toString(gameScore1);
        }

        String gameScore2String;
        if(gameScore2 == 50) {
            gameScore2String = "Ad";
        } else {
            gameScore2String = Integer.toString(gameScore2);
        }

        TextView player1GameScore = (TextView) findViewById(R.id.player_1_game_score);
        TextView player2GameScore = (TextView) findViewById(R.id.player_2_game_score);
        TextView player1SetScore = (TextView) findViewById(R.id.player_1_set_score);
        TextView player2SetScore = (TextView) findViewById(R.id.player_2_set_score);
        TextView player1MatchScore = (TextView) findViewById(R.id.player_1_match_score);
        TextView player2MatchScore = (TextView) findViewById(R.id.player_2_match_score);

        player1GameScore.setText(String.valueOf(gameScore1String));
        player2GameScore.setText(String.valueOf(gameScore2String));
        player1SetScore.setText(String.valueOf(setScore1));
        player2SetScore.setText(String.valueOf(setScore2));
        player1MatchScore.setText(String.valueOf(matchScore1));
        player2MatchScore.setText(String.valueOf(matchScore2));
    }

    public void player1point(View view) {
        if(gameScore1 == 0) {
            this.gameScore1 = 15;
        } else if(gameScore1 == 15) {
            gameScore1 = 30;
        } else if(gameScore1 == 30) {
            gameScore1 = 40;
        } else if(gameScore1 == 40){
            if(gameScore2 >= 40) {
                gameScore1 = 50;
                gameScore2 = 40;
            } else {
                incrementSetScore1();
            }
        } else {
            incrementSetScore1();
        }

        print();
    }

    private void incrementSetScore1() {
        gameScore1 = 0;
        gameScore2 = 0;
        setScore1++;

        if(setScore1 > 5 && setScore1 - setScore2 >= 2) {
            incrementMatchScore1();
        }
    }

    private void incrementMatchScore1() {
        gameScore1 = 0;
        gameScore2 = 0;
        setScore1 = 0;
        setScore2 = 0;
        matchScore1++;
    }

    public void player2point(View view) {
        if(gameScore2 == 0) {
            this.gameScore2 = 15;
        } else if(gameScore2 == 15) {
            gameScore2 = 30;
        } else if(gameScore2 == 30) {
            gameScore2 = 40;
        } else if(gameScore2 == 40){
            if(gameScore2 == 50) {
                incrementSetScore2();
                return;
            }

            if(gameScore1 >= 40) {
                gameScore2 = 50;
                gameScore1 = 40;
            } else {
                incrementSetScore2();
            }
        } else {
            incrementSetScore2();
        }

        print();
    }

    private void incrementSetScore2() {
        gameScore1 = 0;
        gameScore2 = 0;
        setScore2++;

        if(setScore2 > 5 && setScore2 - setScore1 >= 2) {
            incrementMatchScore2();
        }
    }

    private void incrementMatchScore2() {
        gameScore1 = 0;
        gameScore2 = 0;
        setScore1 = 0;
        setScore2 = 0;
        matchScore2++;
    }

    public void resetGame(View view) {
        gameScore1 = 0;
        gameScore2 = 0;
        print();
    }

    public void resetSet(View view) {
        gameScore1 = 0;
        gameScore2 = 0;
        setScore1 = 0;
        setScore2 = 0;
        print();
    }

    public void resetMatch(View view) {
        gameScore1 = 0;
        gameScore2 = 0;
        setScore1 = 0;
        setScore2 = 0;
        matchScore1 = 0;
        matchScore2 = 0;
        print();
    }
}
