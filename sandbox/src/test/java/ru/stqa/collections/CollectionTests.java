package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTests {

    @Test
    void arrayTests(){
        //массив
        var array=new String[]{"a","b","c"};
        Assertions.assertEquals(3,array.length);
        Assertions.assertEquals("a",array[0]);

        array[0]="d";
        Assertions.assertEquals("d",array[0]);
    }
    @Test
    void listTests(){
        //список для хранения строк
        var list= new ArrayList<>(List.of("a","b","c"));
        //проверяем длинну списка
        //Assertions.assertEquals(0,list.size());
        //добавляем элементы в список
        //list.add("a");
        //list.add("b");
        //list.add("c");
        Assertions.assertEquals(3,list.size());
        Assertions.assertEquals("a",list.get(0));
        //меняем элемент списка
        list.set(0,"d");
        Assertions.assertEquals("d",list.get(0));
    }
}
