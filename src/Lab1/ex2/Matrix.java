package Lab1.ex2;

public class Matrix {
    public static void printMatrix(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] sumM(int[][] m1, int[][] m2){
        int s[][] = new int[m1.length][m1[0].length];
        for(int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++)
                s[i][j] = m1[i][j] + m2[i][j];
        }
        return s;
    }

    public static int[][] productM(int[][] m1, int[][] m2){
        int p[][] = new int[m1.length][m1[0].length];
        for(int i = 0; i < m1.length; i++) {
            for(int j = 0; j < m2[0].length; j++) {
                for(int k = 0; k < m1[0].length; k++) {
                    p[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return p;
    }
}


