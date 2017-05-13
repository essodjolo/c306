package com.github.sudoku;

/**
 *
 * @author KAHANAM & AFODOME
 */
public interface ISolveur {
    /**
     * Teste si le puzzle est un puzzle valide.
     *
     * @return boolean
     */
    public boolean verifierPuzzle();

    /**
     * Résoud le puzzle passé en paramètre.
     *
     * @param cells tableau repr�sentant la grille de sudoku
     * @param x position x d'une cellule de la grille
     * @param y position x d'une cellule de la grille
     * @throws  IllegalArgumentException si le puzzle à résoudre n'est pas
     * valable ou si aucune solution n'a pu être calculée
     * @return une grille bien remplie
     */
    public boolean resoudre(char[][] cells, int x, int y) 
            throws IllegalArgumentException;

    /**
     * Affiche la solution trouvé au puzzle.
     */
    public void afficherSolution();
}
