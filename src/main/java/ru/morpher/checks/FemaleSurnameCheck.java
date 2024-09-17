package ru.morpher.checks;

import ru.morpher.HumanCard;
import ru.morpher.enums.Gender;

/**
 * НЕ СКЛОНЯЮТСЯ: женские фамилии, оканчивающиеся на согласный звук и мягкий знак
 * (у Анны Жук, семья Марии Мицкевич, назначить Людмилу Коваль)
 */
public class FemaleSurnameCheck extends AbstractCheck implements TransformCheck {
    @Override
    public boolean check(HumanCard card, Gender gender) {
        if (gender != Gender.FEMALE) {
            return true;
        }
        return !isNameEndsOnConsonants(card.getSurname()) && !isNameEndsOnSoftLetter(card.getSurname());
    }
}
