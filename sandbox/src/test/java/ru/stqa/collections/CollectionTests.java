package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        var list= new ArrayList<>(List.of("a","b","c","a"));
        //проверяем длинну списка
        //Assertions.assertEquals(0,list.size());
        //добавляем элементы в список
        //list.add("a");
        //list.add("b");
        //list.add("c");
        Assertions.assertEquals(4,list.size());
        Assertions.assertEquals("a",list.get(0));
        //меняем элемент списка
        list.set(0,"d");
        Assertions.assertEquals("d",list.get(0));
    }
    @Test
    void setTests(){
        var set= new HashSet<>(List.of("a","b","c","a"));
        Assertions.assertEquals(3,set.size());
//        var element=set.stream().findAny().get();

        set.add("d");
        Assertions.assertEquals(4,set.size());
    }
}
