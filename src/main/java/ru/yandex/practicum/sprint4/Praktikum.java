package ru.yandex.practicum.sprint4;

public class Praktikum {
    private static String name;

    public static void main(String[] args) {
        /*
             В этом методе заложи логику работы с классом ru.yandex.practicum.sprint4.Account.
             Нужно создать экземпляр класса ru.yandex.practicum.sprint4.Account: в качестве аргумента передать тестируемое имя
             и вызвать метод, который проверяет, можно ли использовать фамилию и имя для печати на банковской карте.
         */

        Account cardname = new Account(name);

        cardname.checkNameToEmboss();

    }
}
