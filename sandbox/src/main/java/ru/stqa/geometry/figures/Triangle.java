package ru.stqa.geometry.figures;

public record Triangle(double a, double b,double c) {

    public static void printTriangleArea(Triangle t) {
        var text=String.format("Площадь треугольника cо cторонами %f,%f и %f = %f",t.a,t.b,t.c,t.triangleArea());
        System.out.println(text);
    }

    public double triangleArea() {
        var p=(a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public static void printTrianglePerimeter(Triangle t){
        var text=String.format("Периметр треугольника cо cторонами %f, %f и %f = %f",t.a,t.b,t.c,t.trianglePerimeter());
        System.out.println(text);
    }

    public double trianglePerimeter() {
        return a+b+c;
    }


}
