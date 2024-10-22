package org.example;

public class Main {
    public static void main(String[] args){
        Container<String> container = new Container<>();

        container.add("Wife");
        container.add("Thing");
        container.add("Virus");

        System.out.println("Размер контейнера: " + container.size());

        System.out.println("Элемент по индексу 1: " + container.get(1));

        System.out.println("Содержимое контейнера: " + container.toString());

        System.out.println("Хэш-код контейнера: " + container.hashCode());

        System.out.println("Элементы контейнера:");
        for (String element : container) {
            System.out.println(element);
        }

        container.remove(2);
        System.out.println("Контейнер после удаления элемента по индексу 1:");

        for (String element : container) {
            System.out.println(element);
        }

        System.out.println("Размер контейнера после удаления: " + container.size());

        System.out.println("Содержимое контейнера после удаления: " + container.toString());

        System.out.println("Хэш-код контейнера после удаления: " + container.hashCode());
    }
}
