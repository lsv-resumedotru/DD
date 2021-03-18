import java.util.Scanner;

public class SimpleCode { // Это упрощенный вариант, но с подобием проверки на валидность (подробнее в видео)

    public static void main(String []args) {

        Scanner myScan = new Scanner(System.in);
        System.out.println("Your input: ");

        String input = myScan.nextLine();
        System.out.println("Input is: " + input);
        myScan.close();

        valid(input);

        String finalResult = calculate(input);
        System.out.println("Result is: " + finalResult);
    }

    private static void valid (String input) {

        int index = 0;
        while (index < input.length()) {
            Character ch = input.charAt(index);

            if (Character.isDigit(ch)) {
                index++;
            } else if (Character.isLetter(ch)) {
                index++;
            } else if (ch == '[') {

                int nextOpenBraceIndex = input.indexOf('[', index + 1);
                int nextCloseBraceIndex = input.indexOf(']');

                if (nextOpenBraceIndex < nextCloseBraceIndex) {
                    System.out.println("Невалидное выражение. Подумай и напиши ещё раз!");
                    System.exit(0);
                } else index++;

            } else break;
        }
    }

    private static String calculate(String input) {
        String result = "";
        int multiplier = 0;
        String line = "";

        int index = 0;
        while(index < input.length()) {
            Character ch = input.charAt(index);

            if(Character.isDigit(ch)) {
                multiplier = Character.getNumericValue(ch);
                index++;
            } else if(ch == '[') {
                    int closeBracesIndex = input.indexOf(']');
                    line = input.substring(index+1, closeBracesIndex);
                    index = ++closeBracesIndex;
                    input = input.substring(index);
                    index = 0;

                    for(int i = 0; i < multiplier; i++) {
                        result += line;
                    }

            } else if (Character.isLetter(ch)) {
                result += ch;
                index++;
            }
        }

        return result;
    }

}
