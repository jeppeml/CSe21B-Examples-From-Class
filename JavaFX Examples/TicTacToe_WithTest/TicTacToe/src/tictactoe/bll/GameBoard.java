package tictactoe.bll;

public abstract class GameBoard implements IGameModel{
    protected int currentPlayer = 0;
    protected int[][] board = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
    protected int turns = 0;
    public int getNextPlayer()
    {
        return currentPlayer;
    }

    @Override
    public boolean play(int col, int row) {
        if(board[col][row]!=-1)
            return false;

        if (currentPlayer==0)
            currentPlayer = 1;
        else
            currentPlayer = 0;

        return true;
    }

    public int getWinner()
    {
        if (!isGameOver()) {
            if (turns == 9)
                return -1;
            else
                throw new RuntimeException("No winner yet");
        }
        return currentPlayer;
    }

    @Override
    public void newGame(boolean xPlaysFirst)
    {
        if(xPlaysFirst)
            currentPlayer = 0;
        else currentPlayer = 1;

        board = new int[][]{{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        turns = 0;
    }

    @Override
    public void newGame(){
        newGame(true);
    }
}
