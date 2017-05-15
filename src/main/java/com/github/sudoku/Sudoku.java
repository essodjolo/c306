/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sudoku;

/**
 *
 * @author AFK
 */
public final class Sudoku {

    /**
     * constructeur par défaut de la classe.
     */
    private Sudoku() {
    }

    /**
     * main method.
     *
     * @param args les arguments
     */
    public static void main(final String[] args) {

        char[][] sudokuNonComplete
                = {{'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '@', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '@', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '@', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '@', '5', '6'},
                {'9', '6', '1', '5', '@', '7', '2', '8', '4'},
                {'@', '8', '7', '4', '1', '9', '6', '@', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};
        SolveurImpl solveur
                = new SolveurImpl(new GrilleImpl(sudokuNonComplete));
        solveur.afficherSolution();
    }
}
