package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CircleTests {
    @Test
    void canCalculateArea(){
        var c=new Circle(6.);
        double result=c.circleArea();
        Assertions.assertEquals(113.09733552923255,result);
    }

    @Test
    void canCalculatePerimeter(){
        Assertions.assertEquals(37.69911184307752,new Circle(6.).circlePerimeter());
    }


}
