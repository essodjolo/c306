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
     * constructeur par dï¿½faut de la classe.
     *
     */
    public SolveurImpl() {
    }

    /**
     * Accesseur de la propriï¿½tï¿½ grille SolveurImpl.
     *
     * @return GrilleImpl
     */
    public GrilleImpl getGrille() {
        return grille;
    }

    /**
     * Mutateur de la propriï¿½tï¿½ gille.
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
