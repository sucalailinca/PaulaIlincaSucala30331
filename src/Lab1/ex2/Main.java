package Lab1.ex2;

import static Lab1.ex2.Matrix.*;

public class Main {
    public static void main(String[] args) {
        int[][] a = {{2,3,1},{7,1,6},{9,2,4}};
        int[][] b = {{8,5,3},{3,9,2},{2,7,3}};

        int[][] sum = sumM(a,b);
        int[][] prod = productM(a,b);

        System.out.println("The sum of the matrices is: ");
        printMatrix(sum);

        System.out.println("The product of the matrices is: ");
        printMatrix(prod);
    }
}
