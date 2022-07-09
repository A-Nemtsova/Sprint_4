package ru.yandex.practicum.sprint4;

import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final boolean isCheckName;

    public AccountTest(String name, boolean isCheckName) {
        this.name = name;
        this.isCheckName = isCheckName;
    }

    @Parameterized.Parameters(name = "Тестовые данные: Имя {0} и можно ли печатать {1}")
    public static Object [][] checkName() {
        return new Object[][] {
                {"Ян", false}, //2 символа
                {"Варфоломей Варфоломеев", false}, // 23 символа
                {" ТимотиШаламе", false}, // пробел в начале строки
                {"ТимотиШаламе ", false}, // пробел в конце строки
                {"Ян Янович Янов", false}, // 2 пробела
                {"ТимотейШевроле", false}, // нет пробелов
                {"Тимоти Шаламе", true},
        };
    }

    @Test
    @DisplayName("Проверка, что имя можно напечатать на карте")
    @Description("Требования к имени: в строке не меньше 3 и не больше 19 символов; в строке есть только один пробел; пробел стоит не в начале и не в конце строки")
    public void checkNameToEmboss() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(isCheckName, actual);

    }

}