package org.example;

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
}