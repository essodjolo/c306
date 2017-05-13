package com.github.sudoku;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test de la classe GrilleImpl.java.
 *
 * @author kafodome@gmail.com (AFODOME Kwami A.)
 */
public final class TestGrille {

    /**
     * grille un objet de la classe.
     *
     */
    private static GrilleImpl grille;

    /**
     * initialise la classe.
     *
     */
    @BeforeClass
    public static void initialize() {
        final char[][] sudoku
                = {{'@', '3', '@', '6', '7', '@', '9', '@', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '@', '@', '@', '@', '5', '6', '7'},
                {'@', '5', '@', '7', '6', '1', '@', '2', '3'},
                {'@', '2', '6', '@', '@', '@', '7', '9', '@'},
                {'@', '1', '3', '9', '@', '4', '8', '5', '6'},
                {'@', '6', '@', '5', '3', '@', '@', '8', '@'},
                {'2', '8', '7', '@', '1', '9', '@', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};
        grille = new GrilleImpl(sudoku);
    }

    /**
     * Test de la méthode getDimension().
     *
     */
    @Test
    public void testDimension() {
        final int dim = 9;
        assertEquals(dim, grille.getDimension());
    }

    /**
     * Test de la méthode setValue().
     *
     */
    @Test
    public void testSetValue() {
        final char value = '8';
        final int x = 0;
        final int y = 5;
        grille.setValue(x, y, value);
    }

    /**
     * Test de la méthode setValue(). x est hors bornes
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetValueHorsBorne() {
        final char value = '8';
        final int x = 10;
        final int y = 5;
        grille.setValue(x, y, value);
    }

    /**
     * Test de la méthode setValue(). value est incorrect
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetValueIncorrect() {
        final char value = 'g';
        final int x = 0;
        final int y = 5;
        grille.setValue(x, y, value);
    }

    /**
     * Test de la méthode setValue(). value non autorisée dans la grille
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetValueNonPossible() {
        char value = '5';
        final int x = 3;
        final int y = 0;
        grille.setValue(x, y, value);
    }

    /**
     * Test de la méthode getValue().
     *
     */
    @Test
    public void testGetValue() {
        final char value = '9';
        final int x = 1;
        final int y = 4;
        assertEquals(value, grille.getValue(x, y));
    }

    /**
     * Test de la méthode complete().
     *
     */
    @Test
    public void testComplete() {
        char[][] completeSudoku
                = {{'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};
        GrilleImpl gi = new GrilleImpl(completeSudoku);
        assertTrue(gi.complete());
    }

    /**
     * Test de la méthode complete(). avec un tableau incomplet
     */
    @Test
    public void testNonComplete() {
        char[][] completeSudoku
                = {{'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '@', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '@', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};
        GrilleImpl gi = new GrilleImpl(completeSudoku);
        assertFalse(gi.complete());
    }

    /**
     * Test de la méthode possible(). avec une valeur hors bornes
     */
    @Test(expected = IllegalArgumentException.class)
    public void testHorsBornesWithException() {
        final int dim = 9;
        final int x = 20;
        final int y = 20;
        grille.horsBornes(x, y, dim);
    }
}
