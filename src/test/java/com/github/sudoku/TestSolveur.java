package com.github.sudoku;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test de la classe GrilleImpl.java.
 *
 * @author kafodome@gmail.com (AFODOME Kwami A.) & Essodjolo KAHANAM
 */
public final class TestSolveur {
    private static final char[][] SUDOKU_NON_COMPLET
            = {{'5', '3', '4', '6', '7', '8', '9', '1', '2'},
            {'6', '7', '@', '1', '9', '5', '3', '4', '8'},
            {'1', '9', '8', '3', '@', '2', '5', '6', '7'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
            {'4', '2', '@', '8', '5', '3', '7', '9', '1'},
            {'7', '1', '3', '9', '2', '4', '@', '5', '6'},
            {'9', '6', '1', '5', '@', '7', '2', '8', '4'},
            {'@', '8', '7', '4', '1', '9', '6', '@', '5'},
            {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};
    private static final char[][] SUDOKU_INCORRECT
            = {{'5', '3', '4', '6', '7', '8', '9', '1', '2'},
            {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
            {'5', '9', '8', '3', '4', '2', '5', '2', '7'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
            {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
            {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
            {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
            {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
            {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};
    private static final char[][] SUDOKU_INCORRECT2
            = {{'5', '3', '4', '6', '7', '8', '9', '1', '2', 'x'},
            {'6', '7', '2', '1', '9', '5', '3', '4', '8', '1'},
            {'5', '9', '8', '3', '4', '2', '5', '2', '7', 't'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3', '5'},
            {'4', '2', '6', '8', '5', '3', '7', '9', '1', '5'},
            {'7', '1', '3', '9', '2', '4', '8', '5', '6', 'g'},
            {'9', '6', '1', '5', '3', '7', '2', '8', '4', '1'},
            {'2', '8', '7', '4', '1', '9', '6', '3', '5', '2'},
            {'3', '4', '5', '2', '8', '6', '1', '7', '9', '9'}};
    private static final char[][] SUDOKU_INCORRECT3
            = {{'X', 'T', '4', '6', '7', '8', '9', '1', '2'},
            {'X', '7', '@', '1', '9', '5', '3', '4', '8'},
            {'1', '9', '8', '3', '@', '2', '5', '6', '7'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
            {'4', '2', '@', '8', '5', '3', '7', '9', '1'},
            {'7', '1', '3', '9', '2', '4', '@', '5', '6'},
            {'9', '6', '1', '5', '@', '7', '2', '8', '4'},
            {'@', '8', '7', '4', '1', '9', '6', '@', '5'},
            {'3', '4', '5', '2', 't', '6', '1', '7', '9'}};

    /**
     * Test de la méthode resolu() pour une grille non compl�te.
     */    
    @Test
    public void testResolu(){
        SolveurImpl solveur = 
                new SolveurImpl(new GrilleImpl(SUDOKU_NON_COMPLET));
        assertTrue(solveur.resolu());
    }

    /**
     * Test de la méthode resolu() avec exception.
     */    
    @Test(expected = IllegalArgumentException.class)
    public void testNonResoluAvecException(){
        SolveurImpl solveur = new SolveurImpl(new GrilleImpl(SUDOKU_INCORRECT));
        assertFalse(solveur.resolu());
    }

    /**
     * Test de la méthode verifierPuzzle().
     */
    @Test
    public void testverifierPuzzle() {
        SolveurImpl solveur = new SolveurImpl(new GrilleImpl(SUDOKU_INCORRECT));
        assertFalse(solveur.verifierPuzzle());
        //cas de grille correcte
        SolveurImpl solveur2 = 
                new SolveurImpl(new GrilleImpl(SUDOKU_NON_COMPLET));
        assertTrue(solveur2.verifierPuzzle());
    }
    /**
     * Test de la méthode verifierPuzzle() avec exception.
     */
    @Test
    public void testverifierPuzzleAvecException() {
        SolveurImpl solveur = 
                new SolveurImpl(new GrilleImpl(SUDOKU_INCORRECT3));
        assertFalse(solveur.verifierPuzzle());
    }

    /**
     * Test de la méthode afficherSolution().
     */
    @Test
    public void testafficherSolution() {
        //test avec une grille incorrecte
        SolveurImpl solveur = new SolveurImpl(new GrilleImpl(SUDOKU_INCORRECT));
        solveur.afficherSolution();
        //test avec une grille non complète
        SolveurImpl solveur2 = 
                new SolveurImpl(new GrilleImpl(SUDOKU_NON_COMPLET));
        solveur2.afficherSolution();
        //cas de grille à dimensions incorrecte (msg d'erreur attendu)
        SolveurImpl solveur3 = 
                new SolveurImpl(new GrilleImpl(SUDOKU_INCORRECT2));
        solveur3.afficherSolution();
    }

    /**
     * Test de la méthode setGrille().
     */
    @Test
    public void testSetGrille() {
        SolveurImpl solveur = new SolveurImpl();
        solveur.setGrille(new GrilleImpl(SUDOKU_NON_COMPLET));
    }

    /**
     * Test de la méthode getGrille().
     */
    @Test
    public void testGetGrille() {
        SolveurImpl solveur = 
                new SolveurImpl(new GrilleImpl(SUDOKU_NON_COMPLET));
        GrilleImpl g = solveur.getGrille();
    }

}
