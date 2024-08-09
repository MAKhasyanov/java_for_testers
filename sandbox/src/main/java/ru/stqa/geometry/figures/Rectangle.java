package ru.stqa.geometry.figures;

public record Rectangle (double a,double b) {

    public static void printRectangleArea(Rectangle r) {
        var text=String.format("Площадь прмоугольника co cторонами %f и %f =%f ",r.a,r.b,r.rectangleArea());
        System.out.println(text);
    }

    private double rectangleArea() {
        return this.a*this.b;
    }
}
