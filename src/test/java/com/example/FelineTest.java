package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.List;

import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class FelineTest {

    private int kittensCount;
    private int kittensCountExpected;

    public FelineTest(int kittensCount, int kittensCountExpected) {
        this.kittensCount = kittensCount;
        this.kittensCountExpected = kittensCountExpected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getKittensData() {
        return new Object[][]{
                {3, 3},
                {5, 5}
        };
    }

    @Test
    public void eatMeatReturnsFoodList() throws Exception {
        Feline feline = new Feline();
        Assert.assertEquals("Вернет список еды", List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyReturnsFamilyTitle() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        Assert.assertEquals("Вернет - Кошачьи", "Кошачьи", actual);
    }

    @Test
    public void getKittensReturnsOne() {
        Feline feline = new Feline();
        Assert.assertEquals("Вернет число 1", 1, feline.getKittens());
    }

    @Test
    public void getKittensReturnsKittensCount() {
        Feline feline = new Feline();
        Assert.assertEquals("Вернет количество котят", kittensCountExpected, feline.getKittens(kittensCount));
    }
}