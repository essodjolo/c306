package com.github.sudoku;

/**
 *
 * @author Essodjolo KAHANAM & AFODOME K.
 */
public class SolveurImpl implements ISolveur {

    private GrilleImpl grille;

    /**
     * constructeur de la classe.
     *
     * @param grille
     */
    public SolveurImpl(GrilleImpl grille) {
        this.grille = grille;
    }

    /**
     * constructeur par défaut de la classe.
     *
     */
    public SolveurImpl() {
    }

    /**
     * Accesseur de la propriété grille SolveurImpl.
     *
     * @return GrilleImpl
     */
    public GrilleImpl getGrille() {
        return grille;
    }

    /**
     * Mutateur de la propriété gille.
     *
     * @param grille
     */
    public void setGrille(GrilleImpl grille) {
        this.grille = grille;
    }

    public boolean verifierPuzzle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public char[][] resoudre() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void afficherSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
