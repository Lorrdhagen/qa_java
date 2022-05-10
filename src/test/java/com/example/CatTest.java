package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundReturnsMeow() {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Вернет Мяу", "Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsFoodList() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals("Вернет список еды кота", List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}