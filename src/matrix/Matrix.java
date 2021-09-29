package matrix;

public class Matrix
    extends java.lang.Object
    implements java.lang.Cloneable, java.io.Serializable
{

    private int m;
    private int n;
    private double [][] data;

    public Matrix(int m, int n)
    {
        this.m = m;
        this.n = n;
        // Java inits to zeros 
        this.data = new double[m][n];
    }

    public Matrix(double[][] A, int m, int n)
    {
        this.m = m;
        this.n = n;
        // Does this create copy or reference?
        this.data = A;
    }

    /*
     * vals - One-dimensional array of doubles, packed by columns (ala Fortran).
     * m - Number of rows.
     */
    public Matrix(double[] vals, int m)
    {
        this.m = m;
        this.n = vals.length / m;

        // Create by column
        for (int j = 0; j < m; j++)
        {
            for (int i = 0; i < n; i++)
            {
                // Create matrix from columns
                // TODO!!! stopped here
                this.data[i][j] = vals[];
            }
        }
    }
}