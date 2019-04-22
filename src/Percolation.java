import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    final private WeightedQuickUnionUF grid;
    final private WeightedQuickUnionUF full;
    final private int n;
    final private int top;
    final private int bottom;
    private boolean[] openNodes;


    public Percolation(int N) {
        if (N <= 0) {
            throw new java.lang.IllegalArgumentException("Woah, N must be greater than zero");
        }
        grid = new WeightedQuickUnionUF(N * N + 2);
        full = new WeightedQuickUnionUF(N * N + 1);

        this.n = N;
        top = getSingleArrayIdx(N, N) + 1;
        bottom = getSingleArrayIdx(N, N) + 2;

        openNodes = new boolean[N * N];
    }

    private int getSingleArrayIdx(int i, int j) {
        doOutOfBoundsCheck(i, j);

        return (n * (i - 1) + j) - 1;
    }

    private boolean isValid(int i, int j) {
        return i > 0
                && j > 0
                && i <= n
                && j <= n;
    }

    private void doOutOfBoundsCheck(int i, int j) {
        if (!isValid(i, j)) {
            throw new IndexOutOfBoundsException("Boo! Values are out of bounds");
        }
    }

    public void open(int i, int j) {
        doOutOfBoundsCheck(i, j);

        if (isOpen(i, j)) {
            // No need to open this again as it's already open
            return;
        }

        int idx = getSingleArrayIdx(i, j);
        openNodes[idx] = true;


        if (i == 1) {
            grid.union(top, idx);
            full.union(top, idx);
        }

        if (i == n) {
            grid.union(bottom, idx);
        }

        if (isValid(i - 1, j) && isOpen(i - 1, j)) {
            grid.union(getSingleArrayIdx(i - 1, j), idx);
            full.union(getSingleArrayIdx(i - 1, j), idx);
        }

        if (isValid(i, j + 1) && isOpen(i, j + 1)) {
            grid.union(getSingleArrayIdx(i, j + 1), idx);
            full.union(getSingleArrayIdx(i, j + 1), idx);
        }

        if (isValid(i + 1, j) && isOpen(i + 1, j)) {
            grid.union(getSingleArrayIdx(i + 1, j), idx);
            full.union(getSingleArrayIdx(i + 1, j), idx);

        }

        if (isValid(i, j - 1) && isOpen(i, j - 1)) {
            grid.union(getSingleArrayIdx(i, j - 1), idx);
            full.union(getSingleArrayIdx(i, j - 1), idx);
        }
    }

    public boolean isOpen(int i, int j) {
        doOutOfBoundsCheck(i, j);

        return openNodes[getSingleArrayIdx(i, j)];

    }

    public boolean isFull(int i, int j) {
        int idx = getSingleArrayIdx(i, j);
        return full.connected(idx, top);

    }

    public int numberOfOpenSites() {
        int opened = 0;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if (isOpen(row, col)) {
                    opened++;
                }
            }
        }
        return opened;
    }

    public boolean percolates() {
        return grid.connected(top, bottom);
    }

}
