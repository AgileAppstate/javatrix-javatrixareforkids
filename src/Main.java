// Don't need package in Main, just in source files I think
// package matrix;

import matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(3, 3);

        // Until we fix toString this just prints object reference, but it works
        System.out.println(matrix);
    }
}