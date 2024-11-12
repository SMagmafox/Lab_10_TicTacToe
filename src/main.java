import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int rowMove = SafeInput.getRangedInt(in, "Enter your ROW move",1,3);
        int colMove = SafeInput.getRangedInt(in, "Enter your COLUMN move",1,3);


    }

}
