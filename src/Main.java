import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String operation = scan.nextLine();
        String[] elements = operation.split(" ");
        if(elements.length != 3) throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *), разделенные пробелом");
        String el1 = elements[0];
        String el2 = elements[2];
        String action = elements[1];
        if(!isNumeric(el1, el2) && !isRoman(el1, el2)) throw new Exception("используются одновременно разные системы счисления");
        if(isNumeric(el1, el2)){
            int num1 = Integer.parseInt(el1);
            int num2 = Integer.parseInt(el2);
            System.out.println(Action(num1, num2, action));
        } else {
            int num1 = ToArabic.valueOf(el1).getArab();
            int num2 = ToArabic.valueOf(el2).getArab();
            int res = Action(num1, num2, action);
            if(res <= 0) throw new Exception("в римской системе нет отрицательных чисел и нуля");
            System.out.println(Roman(res));
        }



    }

    public static boolean isNumeric(String el1, String el2) {
        try {
            int x = Integer.parseInt(el1);
            int y = Integer.parseInt(el2);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isRoman(String el1, String el2) {
        try {
            int x = ToArabic.valueOf(el1).getArab();
            int y = ToArabic.valueOf(el2).getArab();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static int Action(int num1, int num2, String action) throws Exception {
        int res = 0;
        switch (action) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
            default:
                throw new Exception("Неверный оператор");
        }
        return res;
    }

    public static String Roman(int res){
        StringBuilder roman = new StringBuilder();
        for(ToRoman num: ToRoman.values()) {
            while (res >= num.arabic) {
                roman.append(num.roman);
                res -= num.arabic;

            }
        }
        return roman.toString();
    }
}
