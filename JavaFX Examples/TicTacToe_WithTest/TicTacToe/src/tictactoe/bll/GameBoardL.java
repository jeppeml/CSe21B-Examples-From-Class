package tictactoe.bll;

public class GameBoardL extends GameBoard{

    @Override
    public boolean isGameOver() {
        if(board[0][0]==board[0][1] &&
           board[0][1]==board[1][0] &&
           board[0][0]!=-1)
        return false;

        return true;
    }


}
