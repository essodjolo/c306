package com.github.sudoku;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test de la classe GrilleImpl.java.
 *
 * @author kafodome@gmail.com (AFODOME Kwami A.) & Essodjolo KAHANAM
 */
public final class TestSolveur {

    private static char[][] sudokuComplete
            = {{'5', '3', '4', '6', '7', '8', '9', '1', '2'},
            {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
            {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
            {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
            {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
            {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
            {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
            {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};
    private static char[][] sudokuNonComplete
            = {{'5', '3', '4', '6', '7', '8', '9', '1', '2'},
            {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
            {'1', '9', '@', '3', '4', '2', '5', '6', '7'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
            {'4', '2', '6', '8', '@', '3', '7', '9', '1'},
            {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
            {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
            {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
            {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};
    private static char[][] sudokuIncorrect
            = {{'5', '3', '4', '6', '7', '8', '9', '1', '2'},
            {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
            {'5', '9', '8', '3', '4', '2', '5', '2', '7'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
            {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
            {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
            {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
            {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
            {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};

    /**
     * Test de la méthode resoudre.
     */
    /*@Test(expected = IllegalArgumentException.class)
    public void testResoudre() {
        SolveurImpl solveur = new SolveurImpl(new GrilleImpl(sudokuComplete));
        
    }*/
    @Test
    public void testResolu(){
        SolveurImpl solveur = new SolveurImpl(new GrilleImpl(sudokuNonComplete));
        assertTrue(solveur.resolu());
    }

    /**
     * Test de la méthode verifierPuzzle().
     */
    @Test
    public void testverifierPuzzle() {
        SolveurImpl solveur = new SolveurImpl(new GrilleImpl(sudokuIncorrect));
        assertFalse(solveur.verifierPuzzle());
        //cas de grille correcte
        SolveurImpl solveur2 = 
                new SolveurImpl(new GrilleImpl(sudokuNonComplete));
        assertTrue(solveur2.verifierPuzzle());
    }

}
