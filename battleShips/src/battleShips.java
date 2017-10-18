/**
 * Created by sierra on 10/17/17.
 */
import java.util.Scanner;
import java.util.Random;

public class battleShips{
    private static int[][] arr = new int[10][10];

    public static void main(String[] args){
        System.out.println("**** The Battle Ships game! ****");
        System.out.println();
        System.out.println("Right now, the sea is empty");
        System.out.println();

        grid();
        shipPlacement();
        computerShipPlacement();
        grid();
        battle();
    }

    public static void shipPlacement(){
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int x, y;
            String str;
            System.out.print("Enter X coordinate for your ship: ");
            while (true){
                str = input.next();
                if(!str.matches("[0-9]")){
                    System.out.print("Please enter X coordinate: ");
                    continue;
                } else {
                    x = new Integer(str);
                    break;
                }
            }
            System.out.print("Enter Y coordinate for your ship: ");
            while (true) {
                str = input.next();
                if (!str.matches("[0-9]")) {
                    System.out.print("Please enter Y coordinate: ");
                    continue;
                } else {
                    y = new Integer(str);
                    if (arr[x][y] == 1){
                        System.out.println("this place is occupied");
                        System.out.print("Please enter different coordinate: ");
                        continue;
                    } else
                        break;
                }
            }
            arr[x][y] = 1;
        }

        grid();
    }

    public static void computerShipPlacement() {
        Random rand = new Random();
        System.out.println("Computer is deploying ships!");
        for (int i = 0; i < 5; i++) {
            while (true){
                int random1 = rand.nextInt(10);
                int random2 = rand.nextInt(10);
                if (arr[random1][random2] != 0){
                    continue;
                } else {
                    arr[random1][random2] = 2;
                    System.out.println(String.format("%d. ship DEPLOYED", i+1));
                    break;
                }
            }
        }
        System.out.println("----------------------------");

    }

    public static void grid(){
        System.out.println();
        System.out.println("   0123456789");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < arr[i].length; j++)
                if (arr[j][i] == 1)
                    System.out.print("@");
                else if (arr[j][i] == 2)
                    System.out.print("!");
                else if (arr[j][i] == 3)
                    System.out.print("x");
                else
                    System.out.print(" ");
            System.out.print("| " + i);
            System.out.println();
        }
        System.out.println("   0123456789");
        System.out.println();
    }

    public static void battle(){
        int blueShips = 5;
        int redShips = 5;
        int x, y;
        while (blueShips > 0 && redShips > 0){
            System.out.println("YOUR TURN");
            String str;
            Scanner input = new Scanner(System.in);
            System.out.print("Enter X coordinate for your ship: ");
            while (true){
                str = input.next();
                if(!str.matches("[0-9]")){
                    System.out.print("Please enter X coordinate: ");
                    continue;
                } else {
                    x = new Integer(str);
                    break;
                }
            }
            System.out.print("Enter Y coordinate for your ship: ");
            while (true) {
                str = input.next();
                if (!str.matches("[0-9]")) {
                    System.out.print("Please enter Y coordinate: ");
                    continue;
                } else {
                    y = new Integer(str);
                    if (arr[x][y] == 1){
                        System.out.println("BOOOM! You sunk your own ship!");
                        redShips--;
                    } else if (arr[x][y] == 2){
                        System.out.println("Well done! You sunk your enemy ship!");
                        blueShips--;
                    } else {
                        System.out.println("You've missed");
                    }
                    arr[x][y] = 3;
                    break;
                }
            }

            Random rand = new Random();
            System.out.println("Computer's turn");
            while (true){
                int random1 = rand.nextInt(10);
                int random2 = rand.nextInt(10);
                if (arr[random1][random2] == 3){
                    continue;
                } else if (arr[random1][random2] == 1) {
                    System.out.println("COMPUTER SUNK YOUR SHIP!!!");
                    redShips--;
                    arr[random1][random2] = 3;
                    break;
                } else if (arr[random1][random2] == 2) {
                    System.out.println("COMPUTER SUNK HIS OWN SHIP");
                    blueShips--;
                    arr[random1][random2] = 3;
                    break;
                } else {
                    System.out.println("COMPUTER missed");
                    arr[random1][random2] = 3;
                    break;
                }
            }

            grid();
            System.out.println(String.format("Your ships: %d | Computer ships: %d",
                    redShips, blueShips));
        }

        System.out.println("Game Over!");
        if (redShips == 0){
            System.out.println("You've lost the game");
        } else {
            System.out.println("YOU WIN THE BATTLE :) ");
        }

    }
}
