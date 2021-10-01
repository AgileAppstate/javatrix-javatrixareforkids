// Don't need package in Main, just in source files I think
// package matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
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

    @Test 
    public void testMatrix_mn()
    {
        double [][] testA = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Matrix A = new Matrix(3, 3);
        assertEquals(3, A.getRows());
        assertEquals(3, A.getColumns());
        assert(Arrays.equals(testA, A.getMatrixValues()));
    }

    @Test 
    public void testMatrix_mns()
    {
        double [][] testB = {{42, 4, 9}, {-1, 0, 7}, {-100, 32, 67}};
        Matrix B = new Matrix(3, 3, 42);
        assertEquals(3, B.getRows());
        assertEquals(3, B.getColumns());
        assert(Arrays.equals(testB, B.getMatrixValues()));
    }

    @Test 
    public void testMatrix_A()
    {
        double [][] testC = {{42, 42, 42}, {42, 42, 42}, {42, 42, 42}};
        Matrix C = new Matrix(testC);
        assertEquals(3, C.getRows());
        assertEquals(3, C.getColumns());
        assert(Arrays.equals(testC, C.getMatrixValues()));
    }

    @Test 
    public void testMatrix_Amn()
    {
        double [][] testD = {{42, 42, 42}, {42, 42, 42}, {42, 42, 42}};
        Matrix D = new Matrix(testD);
        assertEquals(3, D.getRows());
        assert(Arrays.equals(testD, D.getMatrixValues()));
    }

    @Test 
    public void testMatrix_Avalsm()
    {
        double [][] testE = {{42, 42, 42}, {42, 42, 42}, {42, 42, 42}};
        Matrix E = new Matrix(testE);
        assertEquals(3, E.getRows());
        assertEquals(3, E.getColumns());
        assert(Arrays.equals(testE, E.getMatrixValues()));
    }

    @Test 
    public void testMatrix_ScalarTimes()
    {
        double [][] testF = {{42, 21, 5}, {7, -19, 14}, {74, 0, 1}};
        Matrix F = new Matrix(testF);
        Matrix F1 = F.times(2);
        double [][] testF2 = {{84, 42, 10}, {14, -38, 28}, {148, 0, 2}};
        assert(Arrays.equals(testF, F1.getMatrixValues()));
    }

    @Test 
    public void testMatrix_MatrixTimes()
    {
        double [][] testG1 = {{42, 21, 5, 10}, {7, -19, 14, 8}, {74, 0, 1, 84}};
        double [][] testG2 = {{15, 2}, {63, -5}, {28, 0}, {-15, -26}};
        Matrix G1 = new Matrix(testG1);
        Matrix G2 = new Matrix(testG2);
        Matrix G = G1.times(G2);
        double [][] testG3 = {{1943, -281}, {-820, -99}, {-122, -2036}};
        assertEquals(G1.getRows(), G.getRows());
        assertEquals(G2.getColumns(), G.getColumns());
        assert(Arrays.equals(testG3, G.getMatrixValues()));
    }

}