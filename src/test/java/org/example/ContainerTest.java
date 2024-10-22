package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для класса {@link Container}.
 */
public class ContainerTest {

    private Container<Integer> container;

    /**
     * Настраивает тестовую среду перед каждым тестом.
     */
    @BeforeEach
    public void setUp() {
        container = new Container<>();
    }

    /**
     * Тест методов {@link Container#add(Object)} и {@link Container#get(int)}.
     */
    @Test
    public void testAddAndGet() {
        container.add(1);
        container.add(2);
        container.add(3);

        assertEquals(1, container.get(0));
        assertEquals(2, container.get(1));
        assertEquals(3, container.get(2));
    }

    /**
     * Тест метода {@link Container#get(int)} для индексов вне допустимого диапазона.
     */
    @Test
    public void testGetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(0));
        container.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(1));
    }

    /**
     * Тест метода {@link Container#remove(int)}.
     */
    @Test
    public void testRemove() {
        container.add(1);
        container.add(2);
        container.add(3);

        container.remove(1);

        assertEquals(1, container.get(0));
        assertEquals(3, container.get(1));

        container.remove(0);

        assertEquals(3, container.get(0));

        container.remove(0);

        assertThrows(IndexOutOfBoundsException.class, () -> container.get(0));
    }

    /**
     * Тест метода {@link Container#remove(int)} для индексов вне допустимого диапазона.
     */
    @Test
    public void testRemoveOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(0));
        container.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(1));
    }

    /**
     * Тест метода {@link Container#size()}.
     */
    @Test
    public void testSize() {
        assertEquals(0, container.size());

        container.add(1);
        assertEquals(1, container.size());

        container.add(2);
        assertEquals(2, container.size());

        container.remove(0);
        assertEquals(1, container.size());

        container.remove(0);
        assertEquals(0, container.size());
    }

    /**
     * Тест метода {@link Container#toString()}.
     */
    @Test
    public void testToString() {
        container.add(1);
        container.add(2);
        container.add(3);

        assertEquals("[1, 2, 3]", container.toString());

        container.remove(1); // Удаляем элемент 2
        assertEquals("[1, 3]", container.toString());

        container.remove(0); // Удаляем элемент 1
        assertEquals("[3]", container.toString());

        container.remove(0); // Удаляем элемент 3
        assertEquals("[]", container.toString()); // Теперь контейнер пуст
    }

    /**
     * Тест метода {@link Container#hashCode()}.
     */
    public void testEqualsAndHashCode() {
        Container container1 = new Container();
        Container container2 = new Container();

        assertEquals(container1, container2, "Два пустых контейнера должны быть равны");
        assertEquals(container1.hashCode(), container2.hashCode(), "Хэш-коды двух пустых контейнеров должны быть равны");

        container1.add("Первый");
        container2.add("Первый");

        assertEquals(container1, container2, "Контейнеры с одинаковыми элементами должны быть равны");
        assertEquals(container1.hashCode(), container2.hashCode(), "Хэш-коды контейнеров с одинаковыми элементами должны быть равны");

        container2.add("Второй");

        assertNotEquals(container1, container2, "Контейнеры с разными элементами не должны быть равны");
        assertNotEquals(container1.hashCode(), container2.hashCode(), "Хэш-коды не должны совпадать для разных контейнеров");
    }

    /**
     * Тест метода {@link Container#iterator()}.
     */
    @Test
    public void testIterator() {
        container.add(1);
        container.add(2);
        container.add(3);

        Iterator<Integer> iterator = container.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());

        assertFalse(iterator.hasNext());

        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }
}
