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
            option = menu();

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
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 0:
                    System.out.println("Demo Exit");
                    return;
                default:
                    System.out.println("Enter a valid selection.");
                    menu();
            }
        } while (option != 0);
    }
    
    public static int menu()
    {
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        System.out.println("Create a Matrix:");
        System.out.println("1. Matrix(rows, columns)");
        System.out.println("2. Matrix(rows, columns, value)");
        System.out.println("0. Exit");
        System.out.print("Enter selection: ");

        input = scanner.nextInt();

        return input;
    }
}