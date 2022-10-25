/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stegger
 */
public class GameBoardTest
{

    /**
     * Test of getNextPlayer method, of class GameBoard.
     */
    @Test
    public void testGetNextPlayer()
    {
        GameBoardStandard instance = new GameBoardStandard();
        int expResult = 0;
        
        int result = instance.getNextPlayer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNextPlayer method, of class GameBoard.
     */
    @Test
    public void testGetNextPlayerAfterOneRound()
    {
        GameBoardStandard instance = new GameBoardStandard();
        int expResult = 1;

        instance.play(0, 0);
        int result = instance.getNextPlayer();

        assertEquals(expResult, result);
    }

    /**
     * Test of play method, of class GameBoard.
     */
    @Test
    public void testPlayAtZeroZero()
    {
        GameBoardStandard instance = new GameBoardStandard();
        int col = 0;
        int row = 0;
        boolean expResult = true;

        boolean result = instance.play(col, row);

        assertEquals(expResult, result);
    }

    /**
     * Test of play method, of class GameBoard.
     */
    @Test
    public void testPlayAtOneOne()
    {
        GameBoardStandard instance = new GameBoardStandard();
        int col = 1;
        int row = 1;
        boolean expResult = true;

        boolean result = instance.play(col, row);

        assertEquals(expResult, result);
    }

    /**
     * Test of play method, of class GameBoard.
     */
    @Test
    public void testPlayAtTakenSpot()
    {
        GameBoardStandard instance = new GameBoardStandard();
        int col = 1;
        int row = 1;
        boolean expResult = false;

        instance.play(col, row); //Play once
        boolean result = instance.play(col, row); //Play same spot 

        assertEquals(expResult, result);
    }

    /**
     * Test of isGameOver method, of class GameBoard.
     */
    @Test
    public void testIsGameOver()
    {
        GameBoardStandard instance = new GameBoardStandard();

        instance.play(0, 0); //Player 0
        instance.play(1, 0); //Player 1
        instance.play(0, 1); //Player 0
        instance.play(2, 0); //Player 1
        instance.play(0, 2); //Player 0

        boolean expResult = true;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWinner method, of class GameBoard.
     */
    @Test
    public void testGetWinnerPlayerZeroVeritcal()
    {
        GameBoardStandard instance = new GameBoardStandard();
        int expResult = 0;

        instance.play(0, 0); //Player 0
        instance.play(1, 0); //Player 1
        instance.play(0, 1); //Player 0
        instance.play(2, 0); //Player 1
        instance.play(0, 2); //Player 0

        int result = instance.getWinner();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWinner method, of class GameBoard.
     */
    @Test
    public void testGetWinnerPlayerOneHorizontal()
    {
        GameBoardStandard instance = new GameBoardStandard();
        int expResult = 1;

        instance.play(1, 1); //Player 0
        instance.play(0, 0); //Player 1
        instance.play(0, 1); //Player 0
        instance.play(2, 0); //Player 1
        instance.play(1, 2); //Player 0
        instance.play(1, 0); //Player 1

        boolean isGameOver = instance.isGameOver();
        int result = instance.getWinner();
        assertTrue(isGameOver);
        assertEquals(expResult, result);
    }

    /**
     * Test of getWinner method, of class GameBoard.
     */
    @Test
    public void testGetWinnerDiagonally()
    {
        GameBoardStandard instance = new GameBoardStandard();
        boolean expResult = true;

        instance.play(0, 0); //Player 0
        instance.play(1, 0); //Player 1
        instance.play(1, 1); //Player 0
        instance.play(2, 0); //Player 1
        instance.play(2, 2); //Player 0

        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
    }

}
