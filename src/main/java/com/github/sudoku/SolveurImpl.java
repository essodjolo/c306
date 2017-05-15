package com.github.sudoku;

/**
 *
 * @author Essodjolo KAHANAM & AFODOME K.
 */
public final class SolveurImpl implements ISolveur {

    /**
     * Une grille de Sudoku.
     */
    private GrilleImpl grille;

    /**
     * constructeur de la classe.
     *
     * @param g GrilleImpl
     */
    public SolveurImpl(final GrilleImpl g) {
        this.grille = g;
    }

    /**
     * constructeur par défaut de la classe.
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
     * @param g GrilleImpl
     */
    public void setGrille(final GrilleImpl g) {
        this.grille = g;
    }

    /**
     * Vérifie si la grille à résoudre est valide.
     *
     * @return boolean
     */
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

    /**
     * Teste si la grille à résoudre a été résolue.
     *
     * @return boolean
     */
    public boolean resolu() {
        if (!verifierPuzzle()) {
            throw new IllegalArgumentException("tab ne doit pas être nul.");
        }
        return resoudre();
    }

    /**
     * Résoud la grille de Sudoku.
     *
     * @return boolean
     */
    public boolean resoudre() {
        int dim = grille.getDimension();
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (grille.getSudoku()[i][j] == GrilleImpl.EMPTY) {
                    for (int k = 0; k < dim; k++) {
                        char val = Grille.POSSIBLE[k];
                        try {
                            grille.setValue(i, j, val);
                            if (resoudre()) {
                                return true;
                            }
                        } catch (IllegalArgumentException ex) {
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Affiche la grille complète après résolution.
     */
    public void afficherSolution() {
        int dim = grille.getDimension();
        int nbPart = 3;
        try {
            if (resolu()) {
                for (int i = 0; i < dim; ++i) {
                    if (i % nbPart == 0) {
                        System.out.println(" -----------------------");
                    }
                    for (int j = 0; j < dim; ++j) {
                        if (j % nbPart == 0) {
                            System.out.print("| ");
                        }
                        System.out.print(grille.getSudoku()[i][j]);
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
