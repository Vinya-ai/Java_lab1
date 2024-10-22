package org.example;
/**
 * Класс контейнер, позволяющий хранить произвольное количество объектов. Со свойством <b>head</b>.
 * @author Иван Жмурко
 * @param <T>  тип элементов в этом контейнере
 */

public class Container<T> {

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
            cNode.next = cNode.next != null ? cNode.next.next : null;
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
}