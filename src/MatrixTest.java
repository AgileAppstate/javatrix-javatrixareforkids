// Don't need package in Main, just in source files I think
// package matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;

import java.util.Arrays;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
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

        double [][] testH = {{42.5, 21.033, 5, 10.10}, {7.3456, -19.2, 14.20, 8.333}, {74.5, 0, 1, 84.1}};
		Matrix H = new Matrix(testH);
        H.print(8, 2);
    }

    @Test 
    public void testMatrix_mn()
    {
        double [][] testA = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Matrix A = new Matrix(3, 3);
        assertEquals(3, A.getRows());
        assertEquals(3, A.getColumns());
        assertTrue(Arrays.deepEquals(testA, A.getMatrixValues()));
    }

    @Test 
    public void testMatrix_mns()
    {
        double [][] testB = {{42, 42, 42}, {42, 42, 42}, {42, 42, 42}};
        Matrix B = new Matrix(3, 3, 42);
        assertEquals(3, B.getRows());
        assertEquals(3, B.getColumns());
        assertTrue(Arrays.deepEquals(testB, B.getMatrixValues()));
    }

    @Test 
    public void testMatrix_A()
    {
        double [][] testC = {{42, 42, 42}, {42, 42, 42}, {42, 42, 42}};
        Matrix C = new Matrix(testC);
        assertEquals(3, C.getRows());
        assertEquals(3, C.getColumns());
        assertTrue(Arrays.deepEquals(testC, C.getMatrixValues()));
    }

    @Test 
    public void testMatrix_Amn()
    {
        double [][] testD = {{42, 42, 42}, {42, 42, 42}, {42, 42, 42}};
        Matrix D = new Matrix(testD);
        assertEquals(3, D.getRows());
        assertTrue(Arrays.deepEquals(testD, D.getMatrixValues()));
    }

    @Test 
    public void testMatrix_Avalsm()
    {
        double [][] testE = {{42, 42, 42}, {42, 42, 42}, {42, 42, 42}};
        Matrix E = new Matrix(testE);
        assertEquals(3, E.getRows());
        assertEquals(3, E.getColumns());
        assertTrue(Arrays.deepEquals(testE, E.getMatrixValues()));
    }

    @Test 
    public void testMatrix_ScalarTimes()
    {
        double [][] testF = {{42, 21, 5}, {7, -19, 14}, {74, 0, 1}};
        Matrix F = new Matrix(testF);
        Matrix F1 = F.times(2);
        double [][] testF2 = {{84, 42, 10}, {14, -38, 28}, {148, 0, 2}};
        assertTrue(Arrays.deepEquals(testF2, F1.getMatrixValues()));
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
        assertTrue(Arrays.deepEquals(testG3, G.getMatrixValues()));
    }

    @Test
	public void testMatrix_print() {
        double [][] testH = {{42.5, 21.033, 5, 10.10}, {7.3456, -19.2, 14.20, 8.333}, {74.5, 0, 1, 84.1}};
		Matrix H = new Matrix(testH);

		// Redirect System.out to a string
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		H.print(8, 2);

        // Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		// Check for desired result
		String s = baos.toString();

        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        H.print(5, 0);
        String s2 = baos.toString();

        // Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

		String expected = "   42.50   21.03    5.00   10.10\n    7.35  -19.20   14.20    8.33\n   74.50    0.00    1.00   84.10\n";
        String expected2 = "   43   21    5   10\n    7  -19   14    8\n   75    0    1   84\n";
		if (! expected.equals(s))
			fail("Unexpected output:\n"+s+"\n");
        
        if (! expected2.equals(s2))
			fail("Unexpected output:\n"+s+"\n");
    }
     
    @Test
    public void testTranspose()
    {
        double [][] arrayA = {{42.5, 21.033, 5, 10.10}, {7.3456, -19.2, 14.20, 8.333}, 
                              {74.5, 0, 1, 84.1}};
        double [][] arrayB = {{42.5, 7.3456, 74.5}, {21.033, -19.2, 0}, {5, 14.20, 1}, 
                              {10.10, 8.333, 84.1}};
        Matrix testA = new Matrix(arrayA);
        Matrix transA = testA.transpose();
        assertTrue(Arrays.deepEquals(arrayB,
                     transA.getMatrixValues()));
        assertFalse(Arrays.deepEquals(arrayA,
                     transA.getMatrixValues()));

    }
    
    // TODO add set test!!

}