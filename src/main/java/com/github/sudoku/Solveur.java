package com.github.sudoku;

/**
 *
 * @author KAHANAM & AFODOME
 */
public interface Solveur {
    /**
     * puzzle: le plateau de jeu à résoudre.
     */
    private GrilleImpl puzzle; 

    /**
     * constructeur de classe.
     */
    public Solveur(GrilleImpl grille) {
        this.puzzle = grille;
    }

    /**
     * Teste si le puzzle est un puzzle valide.
     *
     * @return boolean
     */
    public boolean verifierPuzzle(GrilleImpl grille) {
        
    }

    /**
     * Résoud le puzzle passé en paramètre.
     *
     * @throws Exception si le puzzle à résoudre n'est pas valable
     * @throws Exception si aucune solution n'a pu être calculée
     */
    public char[][] resoudre(GrilleImpl grille) throws Exception {
        
    }

    /**
     * Affiche la solution trouvé au puzzle.
     *
     * @throws Exception si le puzzle à résoudre n'est pas valable
     * @throws Exception si aucune solution n'a pu être calculée
     */
    public void afficherSolution() {
        
    }
}
