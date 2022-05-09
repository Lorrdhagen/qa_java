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
        Assert.assertEquals(1, actual);
        System.out.println(lion.getKittens());
    }

    @Test
    public void doesHaveManeReturnsSpecialExceptionText() {
        Exception exception = assertThrows("СамкоСамец", Exception.class, () -> new Lion("СамкоСамец", feline));
        Assert.assertEquals(exception.getMessage(), "Используйте допустимые значения пола животного - самец или самка");
        System.out.println(exception.getMessage());

    }
    @Test
    public void doesHaveManeReturnsTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(true, lion.doesHaveMane());
        System.out.println(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeReturnsFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertEquals(false, lion.doesHaveMane());
        System.out.println(lion.doesHaveMane());
    }

    @Test
    public void getFoodReturnsFoodList() throws Exception{
       Lion lion = new Lion("Самец", feline);
       Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
       Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
       System.out.println(lion.getFood());
    }
}