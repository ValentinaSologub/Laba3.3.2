public class Main{

    public static void main(String[] args) {
        int n = 5;
        int[][] matrix = generateRandomMatrix(n);
        System.out.println("Початкова матриця:");
        printMatrix(matrix);

        int negativeCount = countNegativeElements(matrix);
        System.out.println("\nКількість від'ємних елементів: " + negativeCount);

        int rowToShift = 2; // Номер рядка для зміщення (приклад)
        shiftRowLeft(matrix, rowToShift);
        System.out.println("\nМатриця після зміщення рядка " + rowToShift + ":");
        printMatrix(matrix);
    }

    public static int[][] generateRandomMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 21) - 10; // Генерує випадкове число від -10 до 10
            }
        }
        return matrix;
    }

    public static int countNegativeElements(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void shiftRowLeft(int[][] matrix, int rowIndex) {
        int minElement = matrix[rowIndex][0];
        int n = matrix.length;

        // Знаходимо мінімальний елемент рядка
        for (int j = 1; j < n; j++) {
            if (matrix[rowIndex][j] < minElement) {
                minElement = matrix[rowIndex][j];
            }
        }

        for (int k = 0; k < minElement; k++) {
            int temp = matrix[rowIndex][0];
            for (int j = 0; j < n - 1; j++) {
                matrix[rowIndex][j] = matrix[rowIndex][j + 1];
            }
            matrix[rowIndex][n - 1] = temp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}