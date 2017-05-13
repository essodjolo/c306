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
        char[][] plateau = grille.getSudoku().clone();
        int dim = grille.getDimension();
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (plateau[i][j] != Grille.EMPTY) {
                    char tempo = plateau[i][j];
                    plateau[i][j] = Grille.EMPTY;
                    try {
                        if (!grille.possible(i, j, tempo)) {
                            System.out.println("(" + i + "," + j + ")");
                            return false;
                        }
                    } catch (IllegalArgumentException e) {
                        return false;
                    }
                    plateau[i][j] = tempo;
                }
            }
        }
        return true;
    }
    
    public boolean resolu(){
        return resoudre(grille.getSudoku(), 0, 0);
    }
    
    public boolean resoudre(char[][] cells, int x, int y)
            throws IllegalArgumentException {

        if (!verifierPuzzle()) {
            throw new IllegalArgumentException("tab ne doit pas �tre nul.");
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
        try {
            if (resolu()) {
                for (int i = 0; i < 9; ++i) {
                    if (i % 3 == 0) {
                        System.out.println(" -----------------------");
                    }
                    for (int j = 0; j < 9; ++j) {
                        if (j % 3 == 0) {
                            System.out.print("| ");
                        }
                        System.out.print(grille.getSudoku()[i][j]
                                == Grille.EMPTY ? " "
                                        : grille.getSudoku()[i][j]);

                        System.out.print(' ');
                    }
                    System.out.println("|");
                }
                System.out.println(" -----------------------");
            } else {
                System.out.println("Acune solution n'a pu être calculée.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Une erreur est survenue.");
        }
    }

}
