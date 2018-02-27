import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Random;

class MatrixTest {

    @org.junit.jupiter.api.Test
    void transpose() {
        double[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] transposedArray = {
                {1, 4},
                {2, 5},
                {3, 6}
        };

        double[] vector = {1, 2, 3};

        double[][] transposedVector = {
                {1},
                {2},
                {3}
        };

        Matrix arrayMatrix = new Matrix(array);
        arrayMatrix = Matrix.transpose(arrayMatrix);

        Matrix vectorMatrix = new Matrix(vector);
        vectorMatrix = Matrix.transpose(vectorMatrix);

        assertArrayEquals(transposedArray, arrayMatrix.getValues(), "transpose matrix");
        assertArrayEquals(transposedVector, vectorMatrix.getValues(), "transpose vector");
    }

    @org.junit.jupiter.api.Test
    void add() {
        double[][] arrayA = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] arrayAplusA = {
                {2, 4, 6},
                {8, 10, 12}
        };

        Matrix arrayMatrix = new Matrix(arrayA);
        arrayMatrix = Matrix.add(arrayMatrix, arrayMatrix);

        assertArrayEquals(arrayAplusA, arrayMatrix.getValues(), "Add matrices");
    }

    @org.junit.jupiter.api.Test
    void sub() {

        double[][] arrayA = {
                {2, 4, 6},
                {8, 10, 12}
        };

        double[][] arrayAminusA = {
                {0, 0, 0},
                {0, 0, 0}
        };

        Matrix arrayMatrix = new Matrix(arrayA);
        arrayMatrix = Matrix.sub(arrayMatrix, arrayMatrix);

        assertArrayEquals(arrayAminusA, arrayMatrix.getValues(), "Subtract matrices");
    }

    @org.junit.jupiter.api.Test
    void scale() {
        double[][] array = {
                {2, 4, 6},
                {8, 10, 12}
        };

        int scalar = 2;

        double[][] arrayScaled = {
                {4, 8, 12},
                {16, 20, 24}
        };

        Matrix arrayMatrix = new Matrix(array);
        arrayMatrix = Matrix.scale(arrayMatrix, scalar);

        assertArrayEquals(arrayScaled, arrayMatrix.getValues(), "Scale matrix");
    }

    @org.junit.jupiter.api.Test
    void hadm() {
        double[][] arrayA = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] arrayAdotA = {
                {1, 4, 9},
                {16, 25, 36}
        };

        Matrix arrayMatrix = new Matrix(arrayA);
        arrayMatrix = Matrix.hadm(arrayMatrix, arrayMatrix);

        assertArrayEquals(arrayAdotA, arrayMatrix.getValues(), "Hadamard product of matrices");
    }

    @org.junit.jupiter.api.Test
    void mul() {
        double[][] arrayA = {
                {1, 2},
                {3, 4}
        };

        double[][] arrayB = {
                {5, 6},
                {7, 8}
        };

        double[][] arrayAB = {
                {19, 22},
                {43, 50}
        };

        Matrix matrixArrayA = new Matrix(arrayA);
        Matrix matrixArrayB = new Matrix(arrayB);
        Matrix matrixArrayAB = Matrix.mul(matrixArrayA, matrixArrayB);

        double[][] arrayC = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] arrayD = {
                {7, 8},
                {9, 8},
                {7, 6}
        };

        double[][] arrayCD = {
                {46, 42},
                {115, 108}
        };

        Matrix matrixArrayC = new Matrix(arrayC);
        Matrix matrixArrayD = new Matrix(arrayD);
        Matrix matrixArrayCD = Matrix.mul(matrixArrayC, matrixArrayD);

        assertArrayEquals(arrayAB, matrixArrayAB.getValues(), "Multiply matrices");
        assertArrayEquals(arrayCD, matrixArrayCD.getValues(),"Multiply matrices");
    }
}