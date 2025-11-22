public class Chris {
    public static void main(String[] args) {
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] matrixB = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        int[][] matrixC = {
            {2, 0},
            {1, 3},
            {4, 5}
        };

        int[][] matrixD = {
            {1, 2, 3},
            {0, 1, 4}
        };

        int[][] firstProduct = multiply(matrixA, matrixB);
        int[][] secondProduct = multiply(matrixC, matrixD);

        System.out.println("Premier produit matriciel (A x B) :");
        printMatrix(firstProduct);

        System.out.println("\nDeuxieme produit matriciel (C x D) :");
        printMatrix(secondProduct);
    }

    private static int[][] multiply(int[][] left, int[][] right) {
        int rows = left.length;
        int cols = right[0].length;
        int inner = right.length;

        if (left[0].length != inner) {
            throw new IllegalArgumentException("Les matrices ne sont pas compatibles pour la multiplication.");
        }

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                for (int k = 0; k < inner; k++) {
                    sum += left[i][k] * right[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            StringBuilder line = new StringBuilder();
            for (int value : row) {
                line.append(String.format("%4d", value));
            }
            System.out.println(line.toString().trim());
        }
    }
}
