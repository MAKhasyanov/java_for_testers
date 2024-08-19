package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateArea(){
        var t=new Triangle(1.,2.,5.);
        double result=t.triangleArea() ;
        //Assertions.assertEquals(10.825317547305483,result);
    }

    @Test
    void canCalculatePerimeter(){
        Assertions.assertEquals(15,new Triangle(5.,5.,5.).trianglePerimeter());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide(){
        try {
            new Triangle(-1.,-5.,5.);
            Assertions.fail();
        }catch (IllegalArgumentException exception){
            //Ok
        }
    }

    @Test
    void cannotCreateTriangleWithSideLessThanSumOfTwoOthers(){
        try {
            new Triangle(1.,1.,5.);
            Assertions.fail();
        }catch (IllegalArgumentException exception){
            //Ok
        }
    }
    @Test
    void testEquality() {
        var t1 = new Triangle(5., 6., 7.);
        var t2 = new Triangle(5., 6., 7);
        Assertions.assertEquals(t1, t2);
    }
    @Test
    void testEquality2(){
        var a = 2;
        var b = 3;
        var c = 4;
        var triangle = new Triangle(a, b, c);
        var triangle1 = new Triangle(a, c, b);
        Assertions.assertEquals(triangle, triangle1);

    }
}