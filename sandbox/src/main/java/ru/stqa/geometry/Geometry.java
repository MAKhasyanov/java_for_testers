package ru.stqa.geometry;

import ru.stqa.geometry.figures.Circle;
import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
      //  Square.printSquareArea(new Square(7.0));
      //  Square.printSquareArea(new Square(5.0));
        Square.printSquareArea(new Square(3.0));

       // Rectangle.printRectangleArea(new Rectangle(3.,5.));
        Rectangle.printRectangleArea(new Rectangle(7.0,9.0));

        Triangle.printTriangleArea(new Triangle(5.,5.,5.));
        Triangle.printTrianglePerimeter(new Triangle(3.,3.,3.));

        Circle.printCircleArea(new Circle(6.));
        Circle.printCirclePerimeter(new Circle(6.));

    }

}
