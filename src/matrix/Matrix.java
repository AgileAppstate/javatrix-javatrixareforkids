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
        if (this.getColumnDimension() != arrayB.getRowDimension())
        {
            throw new 
                IllegalArgumentException("Matrix inner dimensions must agree.");
        }
        double [][] newValues = new double [this.rows][this.columns];
        for (int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < arrayB.getColumnDimension(); j++)
            {
                newValues[i][j] = 0;
                for (int k = 0; k < this.columns; k++)
                {
                    newValues[i][j] += 
                        (this.matrix[i][k] * arrayB.getMatrixValues()[k][j]);
                }
            }
        }
        return new Matrix(newValues, this.rows, arrayB.getColumnDimension());
    }

    /**
     * Return identity matrix.
     * 
     * @param m Number of rows
     * @param n Number of columns
     * @return New identity matrix
     */
    public static Matrix identity(int m, int n)
    {
        // I must be square
        if (m != n)
        {
            throw new 
                IllegalArgumentException("Identity matrix must be square.");
        }
        // Created with zeroes
        Matrix matrixI = new Matrix(m, n);

        // Insert 1's on diagonal
        for (int i = 0; i < m; i++)
        {
            matrixI.set(i, i, 1);
        }
        return matrixI;
    }


    /**
     * Return a randomized matrix.
     * 
     * @param m number of rows
     * @param n number of columns
     * @return New matrix with random number
     */
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
        return matrixA;
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

    /**
     * Transpose the matrix.
     * 
     * @return transposed matrix
     */
    public Matrix transpose()
    {
        Matrix matrixA = new Matrix(this.columns, this.rows);
        for (int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < this.columns; j++)
            {
                matrixA.set(j, i, this.matrix[i][j]);
            }
        }
        return matrixA;
    }

    /**
     * Set a single element to value.
     * 
     * @param row matrix row
     * @param column matrix column
     * @param val value to be set
     */
    public void set(int row, int column, double val)
    {
        if (row < 0 || row >= this.rows 
            || column < 0 || column >= this.columns)
        {
            throw new
                ArrayIndexOutOfBoundsException("Matrix index out of range.");
        }
        matrix[row][column] = val;
    }

    /**
     * Get a single element to value.
     * 
     * @param row matrix row
     * @param column matrix column
     * @return val at (row, column)
     */
    public double get(int row, int column)
    {
        if (row < 0 || row >= this.rows || column < 0 || column >= this.columns)
        {
            throw new
                ArrayIndexOutOfBoundsException("Matrix index out of range.");
        }
        return this.matrix[row][column];
    }

    /**
     * Element-by-element left division.
     * 
     * @param b matrix to divide elements of
     * @return C = A .\ B
     */
    public Matrix arrayLeftDivide(Matrix b)
    {
        if (b.getColumnDimension() != this.getColumnDimension() 
            || b.getRowDimension() != this.getRowDimension())
        {
            throw new IllegalArgumentException(
                "Matrices have different dimensions.");
        }
        Matrix c = new Matrix(this.getRowDimension(), 
                              this.getColumnDimension());
        for (int i = 0; i < this.getRowDimension(); i++)
        {
            for (int j = 0; j < this.getColumnDimension(); j++)
            {
                c.set(i, j, (b.get(i, j) / this.get(i, j)));
            }
        }
        return c;
    }

    /**
     * Element-by-element right division.
     * 
     * @param b matrix to divide elements of
     * @return C = A ./ B
     */
    public Matrix arrayRightDivide(Matrix b)
    {
        if (b.getColumnDimension() != this.getColumnDimension() 
            || b.getRowDimension() != this.getRowDimension()) 
        {
            throw new IllegalArgumentException(
                "Matrices have different dimensions.");
        }
        Matrix c = new Matrix(this.getRowDimension(), 
                              this.getColumnDimension());
        for (int i = 0; i < this.getRowDimension(); i++)
        {
            for (int j = 0; j < this.getColumnDimension(); j++)
            {
                c.set(i, j, (this.get(i, j) / b.get(i, j)));
            }
        }
        return c;
    }

    /**
     * Element-by-element multiplication.
     * 
     * @param b matrix to multiply elements of
     * @return C = A .* B
     */
    public Matrix arrayTimes(Matrix b)
    {
        if (b.getColumnDimension() != this.getColumnDimension() 
            || b.getRowDimension() != this.getRowDimension())
        {
            throw new IllegalArgumentException(
                "Matrices have different dimensions.");
        }
        Matrix c = new Matrix(this.getRowDimension(), 
            this.getColumnDimension());
        for (int i = 0; i < this.getRowDimension(); i++)
        {
            for (int j = 0; j < this.getColumnDimension(); j++)
            {
                c.set(i, j, (b.get(i, j) * this.get(i, j)));
            }
        }
        return c;
    }

    /**
     * Element-wise subtraction for two matrices.
     * 
     * @param b matrix to subtract elements of
     * @return C = A - B
     */
    public Matrix minus(Matrix b)
    {
        if (b.getColumnDimension() != this.getColumnDimension() 
            || b.getRowDimension() != this.getRowDimension())
        {
            throw new IllegalArgumentException(
                "Matrices have different dimensions.");
        }
        Matrix c = new Matrix(this.getRowDimension(), 
            this.getColumnDimension());
        for (int i = 0; i < this.getRowDimension(); i++)
        {
            for (int j = 0; j < this.getColumnDimension(); j++)
            {
                c.set(i, j, (this.get(i, j) - b.get(i, j)));
            }
        }
        return c;
    }

    /**
     * Element-wise addition for two matrices.
     * 
     * @param b matrix to add elements of
     * @return C = A + B
     */
    public Matrix plus(Matrix b)
    {
        if (b.getColumnDimension() != this.getColumnDimension() 
            || b.getRowDimension() != this.getRowDimension())
        {
            throw new IllegalArgumentException(
                "Matrices have different dimensions.");
        }
        Matrix c = new Matrix(this.getRowDimension(), 
            this.getColumnDimension());
        for (int i = 0; i < this.getRowDimension(); i++)
        {
            for (int j = 0; j < this.getColumnDimension(); j++)
            {
                c.set(i, j, (b.get(i, j) + this.get(i, j)));
            }
        }
        return c;
    }

    /**
     * Return one norm.
     * 
     * @return one norm
     */
    public double norm1()
    {
        double norm1 = 0;
        for (int j = 0; j < this.getColumnDimension(); j++)
        {
            double colSum = 0;
            for (int i = 0; i < this.getRowDimension(); i++)
            {
                colSum += this.get(i, j);
            }
            if (colSum > norm1)
            {
                norm1 = colSum;
            }
        }
        return norm1;
    }

    /**
     * Return Frobenius norm.
     * 
     * @return Frobenius norm
     */
    public double normF()
    {
        double normF = 0;
        for (int i = 0; i < this.getRowDimension(); i++)
        {
            for (int j = 0; j < this.getColumnDimension(); j++)
            {
                normF += Math.pow(this.get(i, j), 2);
            }
        }
        return Math.sqrt(normF);
    }

    /**
     * Return infinity norm.
     * 
     * @return infinity norm
     */
    public double normInf()
    {
        double normInf = 0;
        for (int i = 0; i < this.getRowDimension(); i++)
        {
            double rowSum = 0;
            for (int j = 0; j < this.getColumnDimension(); j++)
            {
                rowSum += this.get(i, j);
            }
            if (rowSum > normInf)
            {
                normInf = rowSum;
            }
        }
        return normInf;
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
    public int getRowDimension()
    {
        return this.rows;
    }

    /**
     * Return matrix columns.
     * 
     * @return matrix columns
     */
    public int getColumnDimension()
    {
        return this.columns;
    }
}
