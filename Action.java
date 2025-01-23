import java.util.Scanner;

public class Action {
    public static  Scanner Player_input = new Scanner(System.in);
    public static int x_position = 0;
    public static int y_position = 0;
    public static int x_con = 50;
    public static int y_con = 50;
    

    public void X_addpos(){
        if(x_position>x_con){
            x_position = x_con;
        }else{
            x_position++;
        }
    }
    public void X_delpos(){
        if(x_position<){
            x_position = x_con;
        }else{
            x_position++;
        }
    }

    public static void main(String[] args) {
        String pos = Player_input.nextLine();
        switch (pos){
            case "w" -> x_position++;
            case "s" -> x_position--;
            case "a" -> y_position++;
            case "d" -> y_position++;
        }
    }
}
