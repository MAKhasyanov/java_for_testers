package ru.stqa.geometry.figures;

public record Triangle(double a, double b,double c) {

    public static void printTriangleArea(Triangle t) {
        var text=String.format("Площадь треугольника cо cторонами %f,%f и %f = %f",t.a,t.b,t.c,triangleArea(t.a,t.b,t.c));
        System.out.println(text);
    }

    public static double triangleArea(double a, double b, double c) {
        double p=(a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    public static void printTrianglePerimeter(Triangle t){
        var text=String.format("Периметр треушольника cо cторонами %f, %f и %f = %f",t.a,t.b,t.c,trianglePerimeter(t.a,t.b,t.c));
        System.out.println(text);
    }

    public static double trianglePerimeter(double a, double b, double c) {
        return a+b+c;
    }


}
