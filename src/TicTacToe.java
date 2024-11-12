public class TicTacToe
{
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];

    public static void main(String[] args) {
        
    }


    private static void clearBoard()//sets all board elements to a space
    {
        for(int row=0;row<ROWS;row++)
        {
            for (int col=0; col<COLS;col++)
            {
                board[row][col] = " "; //make this cell a space
            }
        }
    }

    private static void display()//shows board
    {
        for(int row=0;row<ROWS;row++)
        {
            for (int col=0; col<COLS;col++)
            {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

}