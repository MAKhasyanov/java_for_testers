package ru.stqa.geometry.figures;

public class Square {
    public static void printSquareArea(double side){
        String text = String.format("Площадь квадрата co cтороной %f=%f", side, squareArea(side));
        System.out.println(text);
    }

    private static double squareArea(double a) {
        return a * a;
    }
}
