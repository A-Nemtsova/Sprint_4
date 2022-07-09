package ru.yandex.practicum.sprint4;

import io.qameta.allure.Step;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //Прверка, что имя можно напечатать на карте (использует отельные методы проверок)
    @Step("Прверка, что имя можно напечатать на карте")
    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */

        return checkLengthName(getName())
                && checkSpaceAtStartAndEnd(getName())
                && checkOnlyOneSpace(getName());
    }

    //Проверка, что в строке не меньше 3 и не больше 19 символов

    @Step("Проверка, что в строке не меньше 3 и не больше 19 символов")
    public boolean checkLengthName (String name) {
        return name.length() >= 3 && name.length() <= 19;
    }

    //Проверка, что в начале и в конце строки не стоит пробел
    @Step("Проверка, что в начале и в конце строки не стоит пробел")
    public  boolean checkSpaceAtStartAndEnd(String name) {
        return !name.startsWith(" ") && !name.endsWith(" ");
    }

    //Проверка, что в строке есть только один пробел
    @Step("Проверка, что в строке есть только один пробел")
    public boolean checkOnlyOneSpace (String name) {
        String preparedName = name.trim();
        if (!preparedName.contains(" ")) {
            return false;
        } else {
            return preparedName.indexOf(" ") == preparedName.lastIndexOf(" ");
        }
    }



}
