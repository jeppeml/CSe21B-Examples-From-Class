package tictactoe.bll;

public class GameBoardL extends GameBoard{

    @Override
    public boolean isGameOver() {
        int sum = 0;
        sum /= 2;
        if(board[0][0]==board[1][0] &&
           board[1][0]==board[1][1] &&
           board[0][0]!=-1)
            return true;

        if(board[1][0]==board[2][0] &&
                board[2][0]==board[2][1] &&
                board[1][0]!=-1)
            return true;

        if(board[1][1]==board[2][1] &&
                board[2][1]==board[2][2] &&
                board[1][1]!=-1)
            return true;

        if(board[0][1]==board[1][1] &&
                board[0][1]==board[1][1] &&
                board[0][1]!=-1)
            return true;

        return false;
    }


}
