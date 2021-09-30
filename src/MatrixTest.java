// Don't need package in Main, just in source files I think
// package matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;
import matrix.Matrix;

public class MatrixTest {
    public static void main(String[] args) {
        // test public Matrix(int m, int n)
        Matrix A = new Matrix(3, 3);
        // test public Matrix(int m, int n, double s)
        Matrix B = new Matrix(3, 3, -1);
        // test public Matrix(double[][] A)
        double [][] temp = {{0, 1, 2, 3},{5, 6, 7, 8}};
        Matrix C = new Matrix(temp);
        // test public Matrix(double[][] A, int m, int n)
        Matrix D = new Matrix(temp, 2, 4);
        // test public Matrix(double[] vals, int m) 
        double [] temp1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        Matrix E = new Matrix(temp1, 3);

        // Until we fix toString this just prints object reference, but it works
        System.out.println("A:" + A);
        System.out.println("B:" + B);
        System.out.println("C:" + C);
        System.out.println("D:" + D);
        System.out.println("E:" + E);
    }

    // @Test 
    // public void testMatrix()
    // {
    //     Matrix A = new Matrix(3, 3);
    //     A.print()

    // }
}