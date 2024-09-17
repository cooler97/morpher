package ru.morpher.parsers;

import ru.morpher.HumanCard;

public class BaseParser implements Parser {
    @Override
    public HumanCard parse(String input) {
        final var names = input.split(" ", 3);
        return new HumanCard(names[1], names[0], names[2]);
    }
}
