package matrix;

/** 
 * Matrix.java
 * 
 * Implements the Javatrix package.
 * 
 * @author Matt Sterckx, Jordan Greene
 * @version 5666 Fall 2021
*/

public class Matrix
    extends java.lang.Object
    implements java.lang.Cloneable, java.io.Serializable
{

    private int rows;
    private int columns;
    private double [][] matrix;

    /**
     * Create Matrix constructor from two 
     * dimension arguments initialized with constant value.
     *
     * @param m rows
     * @param n columns
     */
    public Matrix(int m, int n)
    {
        this.rows = m;
        this.columns = n;
        // Java inits to zeros 
        this.matrix = new double[m][n];
    }

    /**
     * Matrix constructor from row, column and constant.
     * 
     * @param m rows
     * @param n columns
     * @param s constant
     */
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

    // Issue: 
    /**
     * Create constructor from 2D array.
     * 
     * @param arrayA 3D array
     */
    public Matrix(double[][] arrayA)
    {
        this.rows = arrayA.length;
        this.columns = arrayA[0].length;
        this.matrix = new double[this.rows][this.columns];

        // Build matrix
        for (int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < this.columns; j++)
            {
                this.matrix[i][j] = arrayA[i][j];
            }
        }

    }

    /**
     * Create constructor from array, row, column.
     *  
     * @param arrayA 3D array
     * @param m rows
     * @param n columns
     */
    public Matrix(double[][] arrayA, int m, int n)
    {
        this.rows = m;
        this.columns = n;
        this.matrix = new double[m][n];

        // This creates copy.
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                this.matrix[i][j] = arrayA[i][j];
            }
        }

    }

    /**
     * Construct matrix with array and row.
     * 
     * @param vals One-dimensional array of doubles, packed by columns
     * @param m rows
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

    /**
     * Multiply matrix by scalar.
     * 
     * @param s Scalar value
     * @return matrix object
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

    /**
     * Multiply matrix by matrix.
     * 
     * @param arrayB Matrix to linearly multiply with
     * @return matrix object
     */
    public Matrix times(Matrix arrayB)
    {
        if (this.getColumns() != arrayB.getRows())
        {
            throw new 
                IllegalArgumentException("Matrix inner dimensions must agree.");
        }
        double [][] newValues = new double [this.rows][this.columns];
        for (int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < arrayB.getColumns(); j++)
            {
                newValues[i][j] = 0;
                for (int k = 0; k < this.columns; k++)
                {
                    newValues[i][j] += 
                        (this.matrix[i][k] * arrayB.getMatrixValues()[k][j]);
                }
            }
        }
        return new Matrix(newValues, this.rows, arrayB.getColumns());
    }


    public static Matrix identity(int m, int n)
    {
        // Created with zeroes
        Matrix matrixA = new Matrix(m, n);

        // Insert 1's on diagonal
        for (int i = 0; i < m; i++)
        {
            matrixA.set(i, j, 1);
        }
    }



    public static Matrix random(int m, int n)
    {
        // Created with zeroes
        Matrix matrixA = new Matrix(m, n);

        // Insert random values 
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrixA.set(i, j, Math.random());
            }
        }

    }

    /**
     * Print matrix with formating.
     * 
     * @param w Column width
     * @param d Number of decimal places
     */
    public void print(int w, int d)
    {
        for (int i = 0; i < this.rows; i++)
        {
            String row = "";
            for (int j = 0; j < this.columns; j++)
            {
                row += String.format(("%" + w + "s"), 
                    String.format("%." + d + "f", this.matrix[i][j]));
            }
            System.out.println(row);
        }
    }


    // Getters for testing purposes
    /** 
     * Get matrix values in double form.
     * 
     * @return 3D array results
     */
    public double [][] getMatrixValues()
    {
        return this.matrix;
    }

    /**
     * Return matrix rows.
     * 
     * @return matrix rows
     */
    public int getRows()
    {
        return this.rows;
    }

    /**
     * Return matrix columns.
     * 
     * @return matrix columns
     */
    public int getColumns()
    {
        return this.columns;
    }
}
