public class DiagonalSum
{
   public static void main(String[] args) {
       int mat [][] = {
           {1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12},
           {13, 14, 15, 16}
       };
       int sum = 0;
       int n = mat.length;
       for(int i=0; i<n; i++)
       {
        sum += mat [i][i];

        if(i != n-1-i)
        {
            sum += mat[i][n-1-i];
        }
       }
       System.out.println("Sum of diagonals is: " + sum);
   }
}