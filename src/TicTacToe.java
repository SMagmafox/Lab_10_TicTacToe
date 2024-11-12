import java.util.Scanner;
public class TicTacToe
{

    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];

    //the actual program is here btw
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        int moveCnt = 0;
        int rowMove = 0;
        int colMove = 0;
        String player = " ";

        do {
            clearBoard();
            player = "X";

            for (int i = 0; i < 9; i++)
            {
                rowMove=SafeInput.getRangedInt(in,"Choose the ROW you wish to use, " + player + "!",1,3);
                rowMove--;
                colMove=SafeInput.getRangedInt(in,"Choose the COL you wish to use, " + player + "!",1,3);
                colMove--;
                if(isValidMove(rowMove,colMove))
                    board[rowMove][colMove]=player;
                else
                    System.out.println("invalid move, please pick another area");
                display();
                if(isWin(player)) {
                    System.out.println(player + " wins!");
                    break;
                    }
                player=playerSwap(player);
            }
            System.out.println("Board full, It's a Tie!");
            done=SafeInput.getYNConfirm(in,"Do you want to play again? (Y/N)");
        }while(done);
    }
    //the actual program stops here btw



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

    private static boolean isValidMove(int row, int col) // returns true if move is legal
    {
            if (board[row][col].equals(" "))
                return true;
            return false;
    }
    private static String playerSwap(String player)//changes what player is playing
    {
        if(player.equals("X"))
            player = "O";
        else if (player.equals("O"))
            player = "X";
        else
            player = "X";
        return player;
    }

    private static boolean isColWin(String player) // checks for a col win for specified player
    {
        if(board[0][0].equals(player) && board[0][1].equals(player) && board[0][2].equals(player))
            {return true;}
        else if (board[1][0].equals(player) && board[1][1].equals(player) && board[1][2].equals(player))
            {return true;}
        else if (board[2][0].equals(player) && board[2][1].equals(player) && board[2][2].equals(player))
            {return true;}
        else{return false;}
    }

    private static boolean isWin(String player) // checks to see if there is a win state on the current board for the specified player (X or O)
    {
        if(isColWin(player)||isRowWin(player)|| isDiagonalWin(player)){return true;}; return false;
    }

    private static boolean isRowWin(String player) // checks for a row win for the specified player
    {
        if(board[0][0].equals(player) && board[1][0].equals(player) && board[2][0].equals(player))
            {return true;}
        else if (board[0][1].equals(player) && board[1][1].equals(player) && board[2][1].equals(player))
            {return true;}
        else if (board[0][2].equals(player) && board[1][2].equals(player) && board[2][2].equals(player))
            {return true;}
        else{return false;}
    }

    private static boolean isDiagonalWin(String player) // checks for a diagonal win for the specified player
    {
        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
            {return true;}
        else if(board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
            {return true;}
        else{return false;}
    }

    private static boolean isTie(int moveCnt) // checks for a tie condition: all spaces on the board are filled OR there is an X and an O in every win vector
    {
        if(moveCnt==9){return true;}
        return false;
    }

}