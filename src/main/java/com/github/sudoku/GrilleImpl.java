package com.github.sudoku;

/**
 *
 * @author AFK
 */
public final class GrilleImpl implements Grille {

    /**
     * sudoku une grille de sudoku 9x9.
     */
    private char[][] sudoku = {{'@', '3', '@', '6', '7', '@', '9', '@', '2'},
    {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
    {'1', '9', '@', '@', '@', '@', '5', '6', '7'},
    {'@', '5', '@', '7', '6', '1', '@', '2', '3'},
    {'@', '2', '6', '@', '@', '@', '7', '9', '@'},
    {'@', '1', '3', '9', '@', '4', '8', '5', '6'},
    {'@', '6', '@', '5', '3', '@', '@', '8', '@'},
    {'2', '8', '7', '@', '1', '9', '@', '3', '5'},
    {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};

    /**
     * constructeur de la grille.
     */
    public GrilleImpl() {

    }

    @Override
    public int getDimension() {
        return this.sudoku.length;
    }

    /**
     * Accesseur de la variable sudoku.
     *
     * @return char[][]
     */
    public char[][] getSudoku() {
        return sudoku;
    }

    /**
     * Modifie la variable sudoku.
     *
     * @param sudoku1 char[][]
     */
    public void setSudoku(final char[][] sudoku1) {
        this.sudoku = sudoku1;
    }

    @Override
    public void setValue(final int x, final int y, final char value)
            throws IllegalArgumentException {
        if (possible(x, y, value)) {
            sudoku[x][y] = value;
        } else {
            throw new IllegalArgumentException("La valeur est interdite au vu "
                    + "des autres valeurs de la grille");
        }
    }

    @Override
    public char getValue(final int x, final int y)
            throws IllegalArgumentException {
        int dim = getDimension();
        horsBornes(x, y, dim);
        return sudoku[x][y];
    }

    @Override
    public boolean complete() {
        int dim = getDimension();
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (sudoku[i][i] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean possible(final int x, final int y, final char value)
            throws IllegalArgumentException {
        int dim = getDimension();
        horsBornes(x, y, dim);
        //Test si la valeur est autorisée
        if (!contient(dim, value)) {
            throw new IllegalArgumentException("Ce caractère "
                    + "n'est pas autorisé");
        }

        char[] ligne = sudoku[x]; //Valeur de la ligne i de la grille
        char[] colonne = new char[dim]; //Valeurs de la colonne j de la grille
        //Remplissage des valeurs de la colonne Y
        for (int i = 0; i < dim; i++) {
            colonne[i] = sudoku[i][y];
        }

        /*
         * Test si la valeur est présente une seule fois sur la ligne
         * et une seule fois sur la colonne
         */
        if (nombreOccurences(ligne, value) > 1
                || nombreOccurences(colonne, value) > 1) {
            return false;
        }

        return testCarre(x, y, value);
    }

    /**
     * Calcul le nombre d'occurrences d'une valeur dans un tableau.
     *
     * @param tableau char[] un tableau données de caractères
     * @param value un caractère
     * @return int le nombre
     */
    public int nombreOccurences(final char[] tableau, final char value) {
        int nbOccurences = 0;

        for (char c : tableau) {
            if (c == value) {
                nbOccurences++;
            }
        }
        return nbOccurences;
    }

    /**
     * Vérifie si le caractère est autorisé.
     *
     * @param taille un tableau données de caractères
     * @param value un caractère
     * @return true si le caractère est autorisé et false sinon
     */
    private boolean contient(final int taille, final char value) {
        for (int i = 0; i < taille; i++) {
            if (POSSIBLE[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Renvoie un tableau représentant un carré de la grille.
     *
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @param value un caractère
     * @return char[][] un carré de la grille
     */
    public boolean testCarre(final int x, final int y, final char value) {
        //Taille d'un carre après découpage de la grille en carrés
        int dimCarre = (int) Math.sqrt(Double.valueOf(getDimension()));
        char[][] carre = new char[dimCarre][dimCarre];
        //Position X selon le découpage de la grille en carrés
        int xx = x / dimCarre;
        //Position Y selon le découpage de la grille en carrés
        int yy = y / dimCarre;
        int infX = dimCarre * xx, supX = dimCarre * (1 + xx);
        int infY = dimCarre * yy, supY = dimCarre * (1 + yy);

        for (int i = infX; i < supX; i++) {
            for (int j = infY; j < supY; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Test si x ou y sont hors bornes.
     *
     * @param x index de la ligne
     * @param y index de la colonne
     * @param dim dimension du tableau
     * @throws IllegalArgumentException si x > dim
     * @throws IllegalArgumentException si y > dim
     */
    public void horsBornes(final int x, final int y, final int dim)
            throws IllegalArgumentException {
        if (x > dim || y > dim) {
            throw new IllegalArgumentException("x et y sont "
                    + "hors bornes 0-8 ");
        }
    }

}
