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
     * @throws  Exception si le puzzle à résoudre n'est pas valable ou 
     *          si aucune solution n'a pu être calculée
     * @return une grille bien remplie
     */
    public char[][] resoudre() throws Exception;

    /**
     * Affiche la solution trouvé au puzzle.
     */
    public void afficherSolution();
}
