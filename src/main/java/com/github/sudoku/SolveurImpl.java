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
     * constructeur par d�faut de la classe.
     *
     */
    public SolveurImpl() {
    }

    /**
     * Accesseur de la propri�t� grille SolveurImpl.
     *
     * @return GrilleImpl
     */
    public GrilleImpl getGrille() {
        return grille;
    }

    /**
     * Mutateur de la propri�t� gille.
     *
     * @param grille
     */
    public void setGrille(GrilleImpl grille) {
        this.grille = grille;
    }

    public boolean verifierPuzzle() {
        for (int i = 0; i < getGrille().getDimension(); i++) {
            for (int j = 0; j < getGrille().getDimension(); i++) {
                try {
                    if (! getGrille().possible(i, j, getGrille().getSudoku()[i][j]))
                        return false;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] resoudre() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void afficherSolution() {
        for (int i = 0; i < 9; ++i) {
            if (i % 3 == 0)
                System.out.println(" -----------------------");
            for (int j = 0; j < 9; ++j) {
                if (j % 3 == 0) System.out.print("| ");
                System.out.print(getGrille().getSudoku()[i][j] == Grille.EMPTY
                                 ? " "
                                 : getGrille().getSudoku()[i][j]);

                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }

}
