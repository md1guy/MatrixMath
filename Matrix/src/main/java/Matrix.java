public class Matrix {

    private int rows;
    private int cols;
    private double[][] values;

    public double[][] getValues() {
        return values;
    }

    // new values filled with 0's
    public Matrix(int rows, int cols) {

        this.rows = rows;
        this.cols = cols;
        this.values = new double[rows][cols];
    }

    // new values based on 2d array
    public Matrix(double[][] values) {

        this.rows = values.length;
        this.cols = values[0].length;
        this.values = new double[this.rows][this.cols];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.values[i][j] = values[i][j];
            }
        }
    }

    // new matrix(vector) based on 1d array
    public Matrix(double[] vector) {

        this.rows = 1;
        this.cols = vector.length;
        this.values = new double[this.rows][this.cols];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.values[i][j] = vector[j];
            }
        }
    }

    // return values with random values in range [0, 1]
    public static Matrix random(int rows, int cols) {

        Matrix matrix = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix.values[i][j] = Math.random();
            }
        }

        return matrix;
    }

    // return transposed matrix
    public Matrix transpose() {
        Matrix matrix = new Matrix(this.cols, this.rows);

        for (int i = 0; i < matrix.rows; i++) {
            for (int j = 0; j < matrix.cols; j++) {
                matrix.values[i][j] = this.values[j][i];
            }
        }

        return matrix;
    }

    // A + B
    public Matrix add(Matrix B) {
        Matrix A = this;

        if (B.rows != A.rows || B.cols != A.cols) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }

        Matrix C = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C.values[i][j] = A.values[i][j] + B.values[i][j];
            }
        }

        return C;
    }

    // A - B
    public Matrix sub(Matrix B) {
        Matrix A = this;

        if (B.rows != A.rows || B.cols != A.cols) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }

        Matrix C = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C.values[i][j] = A.values[i][j] - B.values[i][j];
            }
        }

        return C;
    }

    // A * n
    public Matrix scale(double scalar) {

        Matrix C = new Matrix(this.rows, this.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                C.values[i][j] = this.values[i][j] * scalar;
            }
        }

        return C;
    }

    // A * B
    public Matrix mul(Matrix B) {

        Matrix A = this;

        if (A.cols != B.rows) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }

        Matrix C = new Matrix(A.rows, B.cols);

        for (int i = 0; i < C.rows; i++) {
            for (int j = 0; j < C.cols; j++) {
                for (int k = 0; k < A.cols; k++) {
                    C.values[i][j] += (A.values[i][k] * B.values[k][j]);
                }
            }
        }

        return C;
    }

    // print matrix
    public void print() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.values[i][j] + " ");
            }
            System.out.println();
        }
    }
}