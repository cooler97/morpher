package ru.morpher;

import ru.morpher.enums.RussianCases;

import java.util.Map;

public interface Morpher {
    Map<RussianCases, HumanCard> morphHumanName(String name);
}
