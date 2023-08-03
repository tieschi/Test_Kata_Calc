public enum ToRoman {
    HUNDRED(100, "C"), NINETY(90, "XC"), FIFTY(50, "L"), FORTY(40, "XL"),
    TEN(10, "X"), NINE(9, "IX"), FIVE(5, "V"), FOUR(4, "IV"), ONE(1, "I");

    public final int arabic;
    public final String roman;

    ToRoman(int arabic, String roman) {
        this.arabic = arabic;
        this.roman = roman;
    }

}
