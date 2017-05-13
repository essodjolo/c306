package com.github.sudoku;

/**
 *
 * @author KAHANAM & AFODOME
 */
public interface Solveur {
    /**
     * Teste si le puzzle est un puzzle valide.
     *
     * @param grille la grille de jeu
     * @return boolean
     */
    public boolean verifierPuzzle(GrilleImpl grille);

    /**
     * Résoud le puzzle passé en paramètre.
     *
     * @throws  Exception si le puzzle à résoudre n'est pas valable ou 
     *          si aucune solution n'a pu être calculée
     * @param grille le puzzle à résoudre
     * @return une grille bien remplie
     */
    public char[][] resoudre(GrilleImpl grille) throws Exception;

    /**
     * Affiche la solution trouvé au puzzle.
     */
    public void afficherSolution();
}
