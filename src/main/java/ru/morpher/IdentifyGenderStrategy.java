package ru.morpher;

import ru.morpher.enums.Gender;

public interface IdentifyGenderStrategy {
    Gender identify(HumanCard humanCard);
}
