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

    public boolean resoudre(char[][] cells, int x, int y) throws Exception {

        if (!verifierPuzzle()) {
            throw new IllegalArgumentException("tab ne doit pas être nul.");
        }

        if (x == 9) {
            x = 0;
            if (++y == 9) {
                return true;
            }
        }

        if (cells[x][y] != Grille.EMPTY) // skip filled cells
        {
            return resoudre(cells, x, y);
        }

        for (int i = 0; i < 9; ++i) {
            char val = Grille.POSSIBLE[i];
            if (grille.possible(x, y, val)) {

                cells[x][y] = val;
                if (resoudre(cells, x + 1, y)) {
                    return true;
                }
            }
        }
        cells[x][y] = Grille.EMPTY; // reset on backtrack
        return false;
    }

    public void afficherSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
