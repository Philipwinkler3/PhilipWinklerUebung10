package h1;

public class Cell {

    private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;

    public Cell(int indexRow, int indexCol, boolean alive) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
    }

    public Cell(int indexRow, int indexCol) {
        this(indexRow, indexCol, false);
    }

    public int getIndexRow() {
        return indexRow;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getNumLivingNeighbors() {
        return numLivingNeighbors;
    }

    public void setNumLivingNeighbors(int numLivingNeighbors) {
        this.numLivingNeighbors = numLivingNeighbors;
    }

    public boolean isAliveNextGen() {
        return isAliveNextGen;
    }

    public void setAliveNextGen(boolean isAliveNextGen) {
        this.isAliveNextGen = isAliveNextGen;
    }

    public void countLivingNeighbors(Cell[][] gridArray) {
        int rows = gridArray.length;
        int cols = gridArray[0].length;

        int living = 0;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {

                if (dr == 0 && dc == 0) {
                    continue;
                }

                int r = indexRow + dr;
                int c = indexCol + dc;

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    if (gridArray[r][c].isAlive()) {
                        living++;
                    }
                }
            }
        }

        this.numLivingNeighbors = living;
        decideNextStatus();
    }

    private void decideNextStatus() {
        if (alive) {
            this.isAliveNextGen = (numLivingNeighbors == 2 || numLivingNeighbors == 3);
        } else {
            this.isAliveNextGen = (numLivingNeighbors == 3);
        }
    }
}
