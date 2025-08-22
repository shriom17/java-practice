public class SpiralMatrix {

    public static void main(String[] args) {

        int mat[][] = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 }
        };
        int startRow = 0;
        int startCol = 0;
        int endRow = mat.length-1;
        int endCol = mat[0].length-1;
       while (startRow <= endRow && startCol <= endCol)
       {
            for(int i=startCol; i<=endCol; i++)
            {
                System.out.print(mat[startRow][i] + " ");
            }
            startRow++;
            for(int i=startRow; i<=endRow; i++)
            {
                System.out.print(mat[i][endCol] + " ");
            }
            endCol--;
            if(startRow <= endRow)
            {
                for(int i=endCol; i>=startCol; i--)
                {
                    System.out.print(mat[endRow][i] + " ");
                }
                endRow--;
            }
            if(startCol <= endCol)
            {
                for(int i=endRow; i>=startRow; i--)
                {
                    System.out.print(mat[i][startCol] + " ");
                }
                startCol++;
            }
       }
    }
}