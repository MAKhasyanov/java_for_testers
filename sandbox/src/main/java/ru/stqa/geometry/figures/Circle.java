package ru.stqa.geometry.figures;

public record Circle(double r) {
    public static void printCircleArea(Circle c){
        var text=String.format("Площадь окружноcти c радиуcом %f = %f",c.r, c.circleArea());
        System.out.println(text);
    }
    public double circleArea() {
        return Math.PI*r*r;
    }

    public static void printCirclePerimeter(Circle c){
        var text=String.format("Длинна окружноcти c радиуcом %f = %f",c.r,c.circlePerimeter());
        System.out.println(text);
    }

    public double circlePerimeter() {
        return Math.PI*2*r;
    }

}
