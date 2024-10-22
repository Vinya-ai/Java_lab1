package org.example;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс контейнер, позволяющий хранить произвольное количество объектов. Со свойством <b>head</b>.
 * @author Иван Жмурко
 * @param <T>  тип элементов в этом контейнере
 */

public class Container<T> implements Iterable<T> {

    /**
     * Голова списка.
     */
    private Node<T> head;

    /**
     * Конструктор, создающий пустой контейнер.
     */
    public Container() {
        head = null;
    }

    /**
     * Внутренний статический класс, представляющий узел в связном списке.
     * @param <T> тип данных, хранящихся в узле
     */
    private static class Node<T> {
        /**
         * Данные, хранящиеся в узле.
         */
        T data;
        /**
         * Следующий узел в списке.
         */
        Node<T> next;

        /**
         * Конструктор узла с указанными данными.
         * @param data - значение, которые будет храниться в узле
         */
        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    /**
     * Функция добавления нового элемента в конец контейнера.
     * @param data - значение, которые нужно добавить
     * @see Node#data
     */
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        Node<T> cNode = head;
        if (head == null) {
            head = newNode;
        } else {
            while (cNode.next != null) {
                cNode = cNode.next;
            }
            cNode.next = newNode;
        }
    }

    /**
     * Функция получения элемента списка по его индексу
     * @param index индекс элемента для получения
     * @return возвращает элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node<T> cNode = head;
        for (int i = 0; i < index; i++) {
            cNode = cNode.next;
        }
        return cNode.data;
    }


    /**
     * Функция удаляния элемента по указанному индексу.
     * @param index индекс элемента для удаления
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    public void remove(int index) {
        Node<T> cNode = head;
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == 0) {
            head = head.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                cNode = cNode.next;
            }
            if (cNode.next.next != null) {
                cNode.next = cNode.next.next;
            } else {
                cNode.next = null;
            }
        }
    }

    /**
     * Функция получения количества элементов в контейнере.
     * @return возвращает размер контейнера
     */
    public Integer size() {
        Integer i = 0;
        Node<T> cNode = head;
        while (cNode != null) {
            i++;
            cNode = cNode.next;
        }
        return i;
    }
    /**
     * Функция возвращает итератор для последовательного обхода элементов, содержащихся в контейнере.
     * @return возращает итератор для контейнера
     */
    @Override
    public Iterator<T> iterator() {
        return new ContainerIterator();
    }

    /**
     * Внутренний класс, реализующий итератор для контейнера.
     */
    private class ContainerIterator implements Iterator<T> {

        /**
         * Текущий узел итератора.
         */
        private Node<T> currentNode = head;

        /**
         * Проверяет, есть ли следующий элемент в контейнере.
         * @return true если следующий элемент существует, иначе false
         */
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        /**
         * Функция возвращает следующий элемент из контейнера.
         * @return возвращает следующий элемент
         * @throws NoSuchElementException если больше нет элементов
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }
    /**
     * Функция возвращает строковое представление контейнера.
     * @return строка, представляющая элементы контейнера
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.data);
            currentNode = currentNode.next;
            if (currentNode != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Функция вычисляет хэш-код контейнера на основе его содержащихся элементов.
     * @return возращает хэш-код контейнера
     */
    @Override
    public int hashCode() {
        int result = 1;
        Node<T> currentNode = head;
        while (currentNode != null) {
            result = 31 * result + (currentNode.data != null ? currentNode.data.hashCode() : 0);
            currentNode = currentNode.next;
        }
        return result;
    }
}


