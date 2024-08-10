package ru.stqa.geometry.figures;

public record Triangle(double a, double b,double c) {

    public Triangle{
        if (a<0||b<0||c<0){
            throw new IllegalArgumentException("Triangle side should be non-negatıve");
        }
        if (a>(b+c)||b>(a+c)||c>(b+a)){
            throw new IllegalArgumentException("One side should not be more than sum of two other sides");

        }
    }

    public static void printTriangleArea(Triangle t) {
        var text=String.format("Площадь треугольника cо cторонами %f,%f и %f = %f",t.a,t.b,t.c,t.triangleArea());
        System.out.println(text);
    }

    public double triangleArea() {
        var p=(trianglePerimeter())/2;
        return Math.sqrt(p*(p-this.a)*(p-this.b)*(p-this.c));
    }

    public static void printTrianglePerimeter(Triangle t){
        var text=String.format("Периметр треугольника cо cторонами %f, %f и %f = %f",t.a,t.b,t.c,t.trianglePerimeter());
        System.out.println(text);
    }

    public double trianglePerimeter() {
        return this.a+this.b+this.c;
    }


}
