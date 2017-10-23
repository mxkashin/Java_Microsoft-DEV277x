import java.util.Scanner;

/**
 * Created by sierra on 10/18/17.
 */
public class FractionCalculator {
    public static void main(String[] args){

        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until" +
                "you type Q or q to quit");
        while (true) {
            System.out.println("----------------------------------------------------------");

            String operation = getOperation();

            if (operation.equals("q") || operation.equals("Q")) {
                System.exit(0);
            }

            Fraction fraction1 = getFraction();
            Fraction fraction2 = getFraction();

            System.out.print(fraction1 + " " + operation + " " + fraction2 + " is: ");

            if (operation.equals("=")) {
                System.out.println(fraction1.equals(fraction2));
            } else {
                switch (operation){
                    case "+":
                        System.out.println(fraction1.add(fraction2));
                        break;
                    case "-":
                        System.out.println(fraction1.subtract(fraction2));
                        break;
                    case "/":
                        try {
                            System.out.println(fraction1.divide(fraction2));
                        } catch (IllegalArgumentException Fraction) {
                            System.out.println("Undefined");
                        }
                        break;
                    default:
                        System.out.println(fraction1.multiply(fraction2));

                }
                //if (operation.equals("+")) {
                //    System.out.println(fraction1.add(fraction2));
                //} else if (operation.equals("-")) {
                //    System.out.println(fraction1.subtract(fraction2));
                //} else if (operation.equals("/")) {
                //    try {
                //        System.out.println(fraction1.divide(fraction2));
                //    } catch (IllegalArgumentException Fraction) {
                //        System.out.println("Undefined");
                //    }
                //} else {
                //    System.out.println(fraction1.multiply(fraction2));
                //}
            }
        }
    }

    public static Fraction getFraction(){
        System.out.println("Please enter a fraction (a/b) or integer (a): ");
        Scanner input = new Scanner(System.in);
        String fraction = input.nextLine();

        while (!validFraction(fraction)) {
            System.out.println("Invalid fraction. Please enter a fraction (a/b) or integer (a): ");
            fraction = input.nextLine();
        }

        int num;
        int den;
        if (fraction.matches("-?\\d+")) {
            num = Integer.parseInt(fraction);
            den = 1;
        } else {
            String[] newStr = fraction.split("/");
            num = Integer.parseInt(newStr[0]);
            den = Integer.parseInt(newStr[1]);
        }
        Fraction fr = new Fraction(num, den);
        return fr;
    }

    public static boolean validFraction(String str){
        if (str.matches("-?\\d+")){
            return true;
        } else if(str.matches("-?\\d+/?\\d+")){
            String[] newStr = str.split("/");
            int den = Integer.parseInt(newStr[1]);
            if(den > 0){
                return true;
            }
        }
        return false;
    }

    public static String getOperation(){
        System.out.println("Please enter an operation (+, -, /, *, = or Q to quit): ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        while (!str.matches("[-*+/=Qq]")){
            System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
            str = input.nextLine();
        }
        return str;
    }
}
