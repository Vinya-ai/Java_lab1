package org.example;

public class Main {
    public static void main(String[] args) {
        Container<String> container = new Container<>();

        // Добавление элементов
        container.add("Wife");
        container.add("Thing");
        container.add("Virus");

        // Получение элементов
        System.out.println("Element at index 0: " + container.get(0));
        System.out.println("Element at index 1: " + container.get(1));
        System.out.println("Element at index 2: " + container.get(2));

        // Удаление элемента
        container.remove(1);
        System.out.println("After removing element at index 1:");
        System.out.println("Element at index 0: " + container.get(0));
        System.out.println("Element at index 1: " + container.get(1));

        // Размер контейнера
        System.out.println("Size of container: " + container.size());

    }
}