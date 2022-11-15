/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

/**
 *
 * @author Stegger
 */
public class GameBoardStandard extends GameBoard
{

    public boolean isGameOver()
    {
        for (int x = 0; x < 3; x++) {
            if(board[0][x]==board[1][x] &&
                    board[1][x]==board[2][x] &&
                    board[0][x]!=-1)
                return true;
            if(board[x][0]==board[x][1] &&
                    board[x][1]==board[x][2] &&
                    board[x][0]!=-1)
                return true;
        }

        if(board[0][0]==board[1][1] &&
                board[1][1]==board[2][2] &&
                board[1][1]!=-1)
            return true;

        if(board[0][2]==board[1][1] &&
                board[1][1]==board[2][0] &&
                board[1][1]!=-1)
            return true;

        return false;
    }
}
