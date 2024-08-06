package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CircleTests {
    @Test
    void canCalculateArea(){
        var c=new Circle(6.);
        double result=c.circleArea(c.r());
        double scale= Math.pow(10,6);
        result = Math.ceil(result * scale) / scale;
        Assertions.assertEquals(113.097336,result);
    }

    @Test
    void canCalculatePerimeter(){
        var c=new Circle(6.);
        double result=c.circlePerimeter(c.r());
        double scale= Math.pow(10,6);
        result = Math.ceil(result * scale) / scale;
        Assertions.assertEquals(37.699112,result);
    }


}
