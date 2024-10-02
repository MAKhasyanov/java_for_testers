package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

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

    @Test
    void  testMap(){
        var digits= new HashMap<Character,String>();
        digits.put('1',"one");
        digits.put('2',"two");
        digits.put('3',"three");

        Assertions.assertEquals("one",digits.get('1'));
        digits.put('1',"один");
        digits.put('2',"два");
        digits.put('3',"три");

        Assertions.assertEquals("один",digits.get('1'));

    }
}
