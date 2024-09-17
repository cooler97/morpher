package ru.morpher.parsers;

import ru.morpher.HumanCard;

@FunctionalInterface
public interface Parser {
    HumanCard parse(String input);
}
