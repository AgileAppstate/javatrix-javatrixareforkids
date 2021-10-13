import matrix.*;
import java.util.Scanner;

public class MatrixDemo {

    public static void main(String [] args)
    {
        System.out.println("\n*****Javatrix Demo*****\n");
        matrixLoop(false);
        return;
    }
    

    public static int createMenu()
    {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        System.out.println("Create a Matrix:");
        System.out.println("1. Matrix(rows, columns)");
        System.out.println("2. Matrix(rows, columns, single value)");
        System.out.println("3. Matrix(rows, columns, value array)");
        System.out.println("4. Identity Matrix");
        System.out.println("5. Random Matrix");
        System.out.println("0. Exit");
        System.out.print("Enter selection: ");

        input = scanner.nextInt();

        return input;
    }

    public static int opsMenu()
    {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        System.out.println("Matrix manipulation:");
        System.out.println("1. Matrix multiplication by scalar");
        System.out.println("2. Matrix multiplication by matrix");
        System.out.println("3. Matrix transpose");
        System.out.println("0. Exit");
        System.out.print("Enter selection: ");

        input = scanner.nextInt();

        return input;
    }

    public static Matrix opsLoop(Matrix matrixA)
    {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            option = opsMenu();

            switch (option)
            {
                case 1:
                    System.out.print("Scalar value to multiple matrix by: ");
                    double val = scanner.nextDouble();
                    System.out.println("Matrix result:");
                    return matrixA.times(val);
                case 2:
                    System.out.print("Create matrix to multiply by: ");
                    Matrix matrixT = matrixLoop(true);
                    //TODO try/catch for exception
                    System.out.println("Matrix result:");
                    return matrixA.times(matrixT);
                case 3:
                    System.out.println("Matrix result:");
                    return matrixA.transpose();
                // case 4:
                //     break;
                // case 5:
                //     break;
                // case 6:
                //     break;
                // case 7:
                //     break;
                // case 8:
                //     break;
                case 0:
                    System.out.println("Exiting");
                    System.exit(0);
                default:
                    System.out.println("\nEnter a valid selection.\n");
                    opsMenu();
            }
        } while (option != 0);

        return null;
    }

    public static Matrix matrixLoop(boolean inner)
    {
        int option, m, n;
        double val;
        Matrix matrix, result;
        Scanner scanner = new Scanner(System.in);

        do {
            option = createMenu();

            switch (option)
            {
                case 1:
                    System.out.print("Enter rows: ");
                    m = scanner.nextInt();
                    System.out.print("\nEnter columns: ");
                    n = scanner.nextInt();
                    matrix = new Matrix(m, n);
                    System.out.println("Matrix created:");
                    matrix.print(2, 0);
                    System.out.println();
                    if (inner)
                    {
                        return matrix;
                    }
                    result = opsLoop(matrix);
                    result.print(5, 1);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter rows: ");
                    m = scanner.nextInt();
                    System.out.print("\nEnter columns: ");
                    n = scanner.nextInt();
                    System.out.print("\nEnter value: ");
                    val = scanner.nextDouble();
                    matrix = new Matrix(m, n, val);
                    System.out.println("Matrix created:");
                    matrix.print(5, 1);
                    System.out.println();
                    if (inner)
                    {
                        return matrix;
                    }
                    result = opsLoop(matrix);
                    result.print(5, 1);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter rows: ");
                    m = scanner.nextInt();
                    System.out.print("\nEnter columns: ");
                    n = scanner.nextInt();
                    int nVals = 0;
                    double [][] valArray = new double[m][n];
                    matrix = new Matrix(m, n);
                    while (nVals < (m * n))
                    {
                        System.out.println("\nEnter values by row");
                        for (int i = 0; i < m; i++)
                        {
                            for (int j = 0; j < n; j++)
                            {
                                System.out.print("\nEnter value: ");
                                valArray[i][j] = scanner.nextDouble();
                                nVals++;
                            }
                        }
                    }

                    matrix = new Matrix(valArray, m, n);

                    System.out.println("Matrix created:");
                    matrix.print(5, 1);
                    System.out.println();
                    if (inner)
                    {
                        return matrix;
                    }
                    result = opsLoop(matrix);
                    result.print(5, 1);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Enter rows: ");
                    m = scanner.nextInt();
                    System.out.print("\nEnter columns: ");
                    n = scanner.nextInt();
                    matrix = Matrix.identity(m, n);
                    System.out.println("Matrix created:");
                    matrix.print(5, 1);
                    if (inner)
                    {
                        return matrix;
                    }
                    result = opsLoop(matrix);
                    result.print(5, 1);
                    break;
                case 5:
                    System.out.print("Enter rows: ");
                    m = scanner.nextInt();
                    System.out.print("\nEnter columns: ");
                    n = scanner.nextInt();
                    matrix = Matrix.random(m, n);
                    System.out.println("Matrix created:");
                    matrix.print(5, 1);
                    if (inner)
                    {
                        return matrix;
                    }
                    result = opsLoop(matrix);
                    result.print(5, 1);
                    System.out.println();
                    break;
                // case 6:
                //     break;
                // case 7:
                //     break;
                // case 8:
                //     break;
                case 0:
                    System.out.println("Demo Exit");
                    return null;
                default:
                    System.out.println("\nEnter a valid selection.\n");
                    createMenu();
            }
        } while (option != 0);
        return null;
    }
}