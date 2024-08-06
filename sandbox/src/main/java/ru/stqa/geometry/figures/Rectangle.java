package ru.stqa.geometry.figures;

public record Rectangle (double a,double b) {

    public static void printRectangleArea(Rectangle r) {
        var text=String.format("Площадь прмоугольника co cторонами %f и %f =%f ",r.a,r.b,rectangleArea(r.a,r.b));
        System.out.println(text);
    }

    private static double rectangleArea(double a, double b) {
        return a*b;
    }
}
