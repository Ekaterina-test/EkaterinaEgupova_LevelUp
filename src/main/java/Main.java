import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер билета: ");
        String num = in.nextLine();
        if (num.length() != 6) {
            throw new RuntimeException("Введён неправильный номер билета");
        }
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            throw new RuntimeException("Введён неправильный номер билета");
        }
        int number1 = 0;
        int number2 = 0;
        for (int i = 0; i < num.length(); i++) {
            if (i < 3) {
                number1 += Integer.parseInt(num.substring(i, i + 1));
            } else {
                number2 += Integer.parseInt(num.substring(i, i + 1));
            }
        }
        if (number1 == number2) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }
}
