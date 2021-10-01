package matrix;

public class Matrix
    extends java.lang.Object
    implements java.lang.Cloneable, java.io.Serializable
{

    private int m;
    private int n;
    private double [][] matrix;

    // Getters for testing purposes
    public double [][] getMatrixValues()
    {
        return this.matrix;
    }

    public int getRows()
    {
        return this.m;
    }

    public int getColumns()
    {
        return this.n;
    }

    // Issue: Create Matrix constructor from two dimension arguments initialized with constant value
    public Matrix(int m, int n)
    {
        this.m = m;
        this.n = n;
        // Java inits to zeros 
        this.matrix = new double[m][n];
    }

    public Matrix(int m, int n, double s)
    {
        this.m = m;
        this.n = n;
        this.matrix = new double[m][n];

        // Build matrix
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                this.matrix[i][j] = s;
            }
        }

    }

    // Issue: Create constructor from 2D array
    public Matrix(double[][] A)
    {
        this.m = A.length;
        this.n = A[0].length;
        this.matrix = new double[m][n];

        // Build matrix
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                this.matrix[i][j] = A[i][j];
            }
        }

    }

    public Matrix(double[][] A, int m, int n)
    {
        this.m = m;
        this.n = n;
        this.matrix = new double[m][n];

        // This creates copy.
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                this.matrix[i][j] = A[i][j];
            }
        }

    }

    /*
     * vals - One-dimensional array of doubles, packed by columns (ala Fortran).
     * m - Number of rows.
     */
    public Matrix(double[] vals, int m)
    {
        this.m = m;
        this.n = vals.length / m;
        this.matrix = new double[m][n];

        // Create by column
        for (int j = 0; j < m; j++)
        {
            for (int i = 0; i < n; i++)
            {
                // Create matrix from columns
                this.matrix[i][j] = vals[i + (j + (j * 2))];
            }
        }
    }


}