package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class TriangleTests {

    @Test
    void canCalculateArea(){
        var t=new Triangle(5.,5.,5.);
        double result=t.triangleArea(t.a(),t.b(),t.c()) ;
        double scale= Math.pow(10,6);
        result = Math.ceil(result * scale) / scale;
        Assertions.assertEquals(10.825318,result);
    }

    @Test
    void canCalculatePerimeter(){
        var t=new Triangle(5.,5.,5.);
        double result=t.trianglePerimeter(t.a(),t.b(),t.c());
        Assertions.assertEquals(15,result);
    }
}
