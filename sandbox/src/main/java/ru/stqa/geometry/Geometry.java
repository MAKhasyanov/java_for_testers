package ru.stqa.geometry;

import ru.stqa.geometry.figures.Circle;
import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

import java.util.List;
import java.util.function.Consumer;

public class Geometry {
    public static void main(String[] args) {
       var squares= List.of(new Square(7.),new Square(5.),new Square(3.));
//        for (Square square:squares){
//            Square.printSquareArea(square);
//        }

 //       Consumer<Square> print= Square::printSquareArea;
        squares.forEach(Square::printSquareArea);
//        Square.printSquareArea(new Square(7.0));
//        Square.printSquareArea(new Square(5.0));
//        Square.printSquareArea(new Square(3.0));

        Rectangle.printRectangleArea(new Rectangle(3.,5.));
        Rectangle.printRectangleArea(new Rectangle(7.0,9.0));

        Triangle.printTriangleArea(new Triangle(5.,5.,5.));
        Triangle.printTrianglePerimeter(new Triangle(3.,3.,3.));

        Circle.printCircleArea(new Circle(6.));
        Circle.printCirclePerimeter(new Circle(6.));

    }

}
