import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    final private int n;
    final private int t;
    final private double[] thresholds;

    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException("Hold up, N & T have to be greater than zero.");
        }

        this.n = N;
        this.t = T;
        thresholds = new double[T];

        for (int i = 0; i < T; i++) {
            Percolation p = new Percolation(N);

            int openCount = 0;

            while (!p.percolates()) {
                openRandomNode(p);
                openCount++;
            }

            thresholds[i] = (double) openCount / (N * N);
        }
    }

    public double mean() {
        return StdStats.mean(thresholds);
    }

    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(t));
    }

    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(t));
    }

    private void openRandomNode(Percolation p) {
        boolean openNode = true;
        int row = 0;
        int col = 0;

        while (openNode) {
            row = StdRandom.uniform(1, n + 1);
            col = StdRandom.uniform(1, n + 1);

            openNode = p.isOpen(row, col);
        }

        p.open(row, col);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        PercolationStats s = new PercolationStats(N, T);

        System.out.println("mean:\t\t\t\t = " + s.mean());
        System.out.println("stddev:\t\t\t\t = " + s.stddev());
        System.out.println("95% confidence interval:\t = " + s.confidenceLo() + ", " + s.confidenceHi());
    }
}
