package ru.stqa.geometry.figures;

public record Circle(double r) {
    public static void printCircleArea(Circle c){
        var text=String.format("Площадь окружноcти c радиуcом %f = %f",c.r, circleArea(c.r));
        System.out.println(text);
    }
    public static double circleArea(double r) {
        return Math.PI*r*r;
    }

    public static void printCirclePerimeter(Circle c){
        var text=String.format("Длинна окружноcти c радиуcом %f = %f",c.r,circlePerimeter(c.r));
        System.out.println(text);
    }

    public static double circlePerimeter(double r) {
        return Math.PI*2*r;
    }

}
