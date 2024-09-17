package ru.morpher.checks;

import ru.morpher.HumanCard;
import ru.morpher.enums.Gender;

@FunctionalInterface
public interface TransformCheck {
    boolean check(HumanCard card, Gender gender);
}
