package pl.edu.kasprzak.tictactoe;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Board {
    private Button buttons[][];
    private MainActivity activity;
    private boolean gameOver = false;
    String winner;

    public Board(MainActivity activity) {
        this.activity = activity;
        buttons = new Button[3][3];
    }

    public void setButton(Button button, int x, int y, Board board) {
        buttons[x][y] = button;
        button.setOnClickListener(new ButtonOnClick(button, board));
    }

    boolean isGameOver(){
        return gameOver;
    }

    String getWinner(){
        return winner;
    }

    void checkIfGameIsOver(){
        for(Button[] button : this.buttons){
            if(!this.isGameOver()) {
                this.gameOver = button[0].getText().equals(button[1].getText()) && button[1].getText().equals(button[2].getText()) && button[0].getText().length() != 0 && button[1].getText().length() != 0 && button[2].getText().length() != 0;
                this.winner = (this.isGameOver() ? (String) button[0].getText() : "");
            }
        }

        for(int i = 0; i < this.buttons.length && !isGameOver(); ++i){
            this.gameOver = buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[1][i].getText().equals(buttons[2][i].getText()) && buttons[0][i].getText().length() != 0 && buttons[1][i].getText().length() != 0 && buttons[2][i].getText().length() != 0;
            this.winner = (this.isGameOver() ? (String) buttons[i][0].getText() : "");
        }

        if(!this.isGameOver()) {
            this.gameOver = this.buttons[0][0].getText().equals(this.buttons[1][1].getText()) && this.buttons[1][1].getText().equals(this.buttons[2][2].getText()) && buttons[0][0].getText().length() != 0 && buttons[1][1].getText().length() != 0  && buttons[2][2].getText().length() != 0;
            this.winner = (this.isGameOver() ? (String) this.buttons[0][0].getText() : "");
        }

        if(!this.isGameOver()){
            boolean notNull = true;

            for(int i = 0; i < this.buttons.length && notNull; ++i){
                for(int j = 0; j < this.buttons.length && notNull; ++j){
                    notNull &= (this.buttons[i][j].getText().length() != 0);
                }
            }

            if(notNull) {
                this.gameOver = true;
                this.winner = "Remis";
            }
        }

        if(this.isGameOver()){
            if(this.winner.equals("Remis"))
                Toast.makeText(this.activity.getApplicationContext(), this.getWinner(), Toast.LENGTH_LONG).show();

            else
                Toast.makeText(this.activity.getApplicationContext(), "Wygrał gracz posługujący się symbolem: " + this.getWinner(), Toast.LENGTH_LONG).show();
        }
    }
}


