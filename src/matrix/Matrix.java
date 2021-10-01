package matrix;

public class Matrix
    extends java.lang.Object
    implements java.lang.Cloneable, java.io.Serializable
{

    private int rows;
    private int columns;
    private double [][] matrix;

    // Getters for testing purposes
    public double [][] getMatrixValues()
    {
        return this.matrix;
    }

    public int getRows()
    {
        return this.rows;
    }

    public int getColumns()
    {
        return this.columns;
    }

    // Issue: Create Matrix constructor from two dimension arguments initialized with constant value
    public Matrix(int m, int n)
    {
        this.rows = m;
        this.columns = n;
        // Java inits to zeros 
        this.matrix = new double[m][n];
    }

    public Matrix(int m, int n, double s)
    {
        this.rows = m;
        this.columns = n;
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
        this.rows = A.length;
        this.columns = A[0].length;
        this.matrix = new double[this.rows][this.columns];

        // Build matrix
        for (int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < this.columns; j++)
            {
                this.matrix[i][j] = A[i][j];
            }
        }

    }

    public Matrix(double[][] A, int m, int n)
    {
        this.rows = m;
        this.columns = n;
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
        this.rows = m;
        this.columns = vals.length / m;
        this.matrix = new double[m][this.columns];

        // Create by column
        for (int j = 0; j < this.rows; j++)
        {
            for (int i = 0; i < this.columns; i++)
            {
                // Create matrix from columns
                this.matrix[i][j] = vals[i + (j + (j * 2))];
            }
        }
    }

    /*
     * s - Scalar value to multiply each element in matrix with
     */
    public Matrix times(double s)
    {
        double [][] newValues = new double [this.rows][this.columns];
        for (int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < this.columns; j++)
            {
                newValues[i][j] = this.matrix[i][j] * s;
            }
        }
        return new Matrix(newValues, this.rows, this.columns);
    }

    /*
     * B - Matrix to linearly multiply with
     */
    public Matrix times(Matrix B)
    {
        if (this.getColumns() != B.getRows())
            throw new IllegalArgumentException();
        double [][] newValues = new double [this.rows][this.columns];
        for (int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < B.getColumns(); j++)
            {
                newValues[i][j] = 0;
                for (int k = 0; k < this.columns; k++)
                {
                    newValues[i][j] += (this.matrix[i][k] * B.getMatrixValues()[k][j]);
                }
            }
        }
        return new Matrix(newValues, this.rows, B.getColumns());
    }
}