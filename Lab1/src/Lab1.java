public class Lab1 {
    public static void main(String args[]) {

        Lab1 lab1 = new Lab1();
        lab1.compulsory();
        lab1.homework(args);
    }
    void compulsory() {
        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        String bin = "10101";
        int binaryNum = Integer.parseInt(bin, 2);
        int hexadecimalNum = Integer.parseInt("FF", 16); // *
        int result = ((n * 3) + binaryNum + hexadecimalNum) * 6;

        while (result > 10) // *
        {
            int aux = 0; // *
            while (result > 0) {
                aux = aux + result % 10;
                result = result / 10;
            }
            result = aux;
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

    void homework(String args[]) {
        long startTime = System.nanoTime();
        if (args.length < 1) {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }
        if (args.length > 1) {
            System.out.println("Too many arguments!");
            System.exit(-1);
        }
        try {
            int n = Integer.parseInt(args[0]);
            if (n < 0) {
                System.out.println("n cannot be negative!");
                System.exit(-1);
            }
            //System.out.println(n);

            int[][] LatinSquare = ReducedLatinSquare(n);

            PrintRowsAndColumns(n, LatinSquare);
        } catch (OutOfMemoryError e) {

            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println(duration);
        }
    }

    public static int[][] ReducedLatinSquare(int n) {
        int[][] LatinSquare = new int[n][n];
        int i, j;
        // we use the reduced form of the Latin Square
        for (j = 0; j < n; j++)
            LatinSquare[0][j] = j + 1;
        for (i = 1; i < n; i++) {
            LatinSquare[i][0] = LatinSquare[i - 1][0] + 1;
            for (j = 1; j < n; j++)
                if (LatinSquare[i][j - 1] == n)
                    LatinSquare[i][j] = 1;
                else LatinSquare[i][j] = LatinSquare[i][j - 1] + 1;
        }
        return LatinSquare;
    }

    public static void PrintRowsAndColumns(int n, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            String row = new String("");
            for (int j = 0; j < n; j++) {
                String number = String.valueOf(matrix[i][j]);
                row = row + number + " ";
            }
            System.out.println("Row " + (i + 1) + " : " + row);
        }
        for (int j = 0; j < n; j++) {
            String column = new String("");
            for (int i = 0; i < n; i++) {
                String number = String.valueOf(matrix[i][j]);
                column = column + number + " ";
            }
            System.out.println("Column " + (j + 1) + " : " + column);
        }
    }
}