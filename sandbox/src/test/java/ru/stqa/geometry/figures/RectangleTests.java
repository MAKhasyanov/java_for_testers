package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests {

    @Test
    void cannotCreateRectangleWithNegativeSide(){
        try {
            new Rectangle(-5.0,3.0);
            Assertions.fail();
        }catch (IllegalArgumentException exception){
            //Ok
        }
    }
    @Test
    void testEquality(){
        var r1=new Rectangle(5.,6.);
        var r2=new Rectangle(5.,6.);
        Assertions.assertEquals(r1,r2);
    }
    @Test
    void testEquality2(){
        var r1=new Rectangle(5.,4.);
        var r2=new Rectangle(4.,5.);
        Assertions.assertEquals(r1,r2);
    }

}
