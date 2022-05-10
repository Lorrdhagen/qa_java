package com.example;

import org.junit.Assert;

import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensReturnsOne() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        Assert.assertEquals("Вернет число 1", 1, actual);
    }

    @Test
    public void doesHaveManeReturnsSpecialExceptionText() {
        Exception exception = assertThrows("СамкоСамец", Exception.class, () -> new Lion("СамкоСамец", feline));
        Assert.assertEquals("Вернет текст исключения, если пол некорректный", "Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void doesHaveManeReturnsTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue("Вернет true", lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeReturnsFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse("Вернет false", lion.doesHaveMane());
    }

    @Test
    public void getFoodReturnsFoodList() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals("Вернет список еды", List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}