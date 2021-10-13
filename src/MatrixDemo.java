import matrix.*;
import java.util.Scanner;

public class MatrixDemo {

    public static void main(String [] args)
    {
        int option, m, n;
        double val;
        Matrix matrix;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n*****Javatrix Demo*****\n");

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
                    break;
                case 3:
                    System.out.print("Enter rows: ");
                    m = scanner.nextInt();
                    System.out.print("\nEnter columns: ");
                    n = scanner.nextInt();
                    int nVals = 0;
                    double [] valArray = new double[m*n];
                    matrix = new Matrix(m, n);
                    while (nVals < (m * n))
                    {
                        System.out.print("\nEnter next value: ");
                        valArray[nVals] = scanner.nextDouble();
                        
                        nVals++;
                    }

                    matrix = new Matrix(valArray, m);

                    System.out.println("Matrix created:");
                    matrix.print(5, 1);

                   break;
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
                    System.out.println("Demo Exit");
                    return;
                default:
                    System.out.println("Enter a valid selection.");
                    createMenu();
            }
        } while (option != 0);
    }
    
    public static int createMenu()
    {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        System.out.println("Create a Matrix:");
        System.out.println("1. Matrix(rows, columns)");
        System.out.println("2. Matrix(rows, columns, single value)");
        System.out.println("3. Matrix(rows, columns, value array)");
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
        System.out.println("1. Matrix multiplication");
        System.out.println("2. Matrix transpose");
        System.out.println("3. Return to main menu");
        System.out.println("0. Exit");
        System.out.print("Enter selection: ");

        input = scanner.nextInt();

        return input;
    }

}