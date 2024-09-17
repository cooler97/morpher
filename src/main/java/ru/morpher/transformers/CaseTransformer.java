package ru.morpher.transformers;

import ru.morpher.HumanCard;
import ru.morpher.enums.Gender;

@FunctionalInterface
public interface CaseTransformer {
    HumanCard transform(HumanCard card, Gender gender);
}
