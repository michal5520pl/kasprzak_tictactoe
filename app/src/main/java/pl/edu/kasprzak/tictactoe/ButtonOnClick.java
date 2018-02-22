package pl.edu.kasprzak.tictactoe;

import android.view.View;
import android.widget.Button;

public class ButtonOnClick implements View.OnClickListener {
    private static boolean isOMove = true;
    private Button button;
    private Board board;

    public ButtonOnClick(Button button, Board board) {
        this.button = button;
        this.board = board;
    }

    @Override
    public void onClick(View view) {
        board.checkIfGameIsOver();

        if(button.getText().length() == 0 && !board.isGameOver()) {
            if (isOMove) {
                button.setText("O");
            } else {
                button.setText("X");
            }
            isOMove = !isOMove;

            board.checkIfGameIsOver();
        }
    }
}


