package h2;

public class Spielstein {
    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        this.brett = brett;
        this.currentRow = indexRow;
        this.currentCol = indexCol;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }

    private boolean movesOut() {
        Feld[][] b = brett.getBrett();
        int dim = brett.getDim();

        Feld current = b[currentRow][currentCol];
        char dir = current.getDirection();

        if (dir == 'U') return currentRow - 1 < 0;
        if (dir == 'D') return currentRow + 1 >= dim;
        if (dir == 'L') return currentCol - 1 < 0;
        if (dir == 'R') return currentCol + 1 >= dim;

        return false;
    }

    public void go(int n) {
        Feld[][] b = brett.getBrett();
        int dim = brett.getDim();

        for (int i = 0; i < n; i++) {
            Feld current = b[currentRow][currentCol];

            if (current.isBoese()) {
                continue;
            }

            if (movesOut()) {
                continue;
            }

            char dir = current.getDirection();

            if (dir == 'U') currentRow--;
            else if (dir == 'D') currentRow++;
            else if (dir == 'L') currentCol--;
            else if (dir == 'R') currentCol++;
        }
    }
}
