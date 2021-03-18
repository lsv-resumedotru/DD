import java.util.Scanner;

public class TaskA { // Это расширенный вариант с использованием рекурсии (подробнее в видео)

    public static void main(String []args) {

        Scanner myScan = new Scanner(System.in);
        System.out.println("Your input: ");

        String input = myScan.nextLine();
        System.out.println("Input is: " + input);
        myScan.close();

        String finalResult = calculate(input);
        System.out.println("Result is: " + finalResult);
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

                Boolean isRecursive = false;

                int nextOpenBraceIndex = input.indexOf('[', index+1); // 3
                int nextCloseBraceIndex = input.indexOf(']');
                if(nextOpenBraceIndex < nextCloseBraceIndex) {
                    isRecursive = true;
                } else {
                    isRecursive = false;
                }

                if(isRecursive) {
                    int closeBracesIndex = input.lastIndexOf(']');
                    line = input.substring(index+1, closeBracesIndex);
                    Boolean isCleanText = true;
                    for(int i = 0; i<line.length(); i++) {
                        if(isCleanText &&
                                (Character.isDigit(line.charAt(i)) || line.charAt(i) == '[' || line.charAt(i) == ']')) {
                            isCleanText = false;
                        }
                    }

                    String newResult = "";
                    if(!isCleanText) {
                        newResult = calculate(line);
                    } else {
                        newResult = line;
                    }

                    for(int i = 0; i < multiplier; i++) {
                        result += newResult;
                    }

                    index = ++closeBracesIndex;
                    input = input.substring(index);
                    index = 0;

                } else {
                    int closeBracesIndex = input.indexOf(']');
                    line = input.substring(index+1, closeBracesIndex);
                    index = ++closeBracesIndex;
                    input = input.substring(index);
                    index = 0;

                    for(int i = 0; i < multiplier; i++) {
                        result += line;
                    }
                }

            } else if(Character.isLetter(ch)) {
                result += ch;
                index++;
            }
        }

        return result;
    }
}
