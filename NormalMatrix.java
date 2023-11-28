import java.util.Random;
import java.util.Scanner;

public class NormalMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows for Matrix A:");
        int rowsA = scanner.nextInt();

        System.out.println("Enter the number of columns for Matrix A:");
        int colsA = scanner.nextInt();

        System.out.println("Enter the number of rows for Matrix B:");
        int rowsB = scanner.nextInt();

        System.out.println("Enter the number of columns for Matrix B:");
        int colsB = scanner.nextInt();

        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible with the given dimensions.");
            return;
        }

        int[][] matrixA = generateRandomMatrix(rowsA, colsA);
        int[][] matrixB = generateRandomMatrix(rowsB, colsB);

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("Matrix B:");
        printMatrix(matrixB);
        long start = System.nanoTime();
        int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);
        long end = System.nanoTime();
        System.out.println(end-start);
//        System.out.println("Result Matrix (Matrix A * Matrix B):");
//        printMatrix(resultMatrix);
    }

    public static int[][] generateRandomMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10); // Adjust the range of random values as needed
            }
        }

        return matrix;
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int value = 0;
                for (int k = 0; k < colsA; k++) {
                    value += matrixA[i][k] * matrixB[k][j];
                }
                result[i][j] = value;
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
