import java.util.Scanner;

public class Main { // Это баловство. Пожалуйста, смотрите TaskA или SimpleCode

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str1 = sc.nextLine();
        System.out.println("Введите сколько раз хотите это повторить: ");
        int num1 = sc.nextInt();
        System.out.println("Результат: " + str1.repeat(num1) );
    }

}
