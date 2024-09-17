package ru.morpher.transformers;

import ru.morpher.HumanCard;
import ru.morpher.checks.TransformCheck;
import ru.morpher.enums.Gender;

import java.util.Set;

public class GenitiveTransformer implements CaseTransformer {
    private final Set<TransformCheck> surnameChecks;

    public GenitiveTransformer(Set<TransformCheck> surnameChecks) {
        this.surnameChecks = surnameChecks;
    }

    @Override
    public HumanCard transform(HumanCard card, Gender gender) {
        if (gender == Gender.UNKNOWN) {
            throw new IllegalArgumentException("Невозможно произвести склонение: не определен пол!");
        }

        return new HumanCard(
                transformFirstname(card.getFirstName()),
                transformSurname(card, gender),
                transformLastName(card, gender)
        );
    }

    private String transformFirstname(String name) {
        int length = name.length();
        char lastChar = Character.toLowerCase(name.charAt(length - 1));
        String result = name;
        switch (lastChar) {
            case 'я':
                result = name.substring(0, length - 1) + "и";
                break;
            case 'а':
                result = name.substring(0, length - 1) + "ы";
                break;
        }
        return result;
    }

    private String transformSurname(HumanCard card, Gender gender) {
        String surname = card.getSurname();
        if (surnameChecks.stream()
                .noneMatch(transformCheck -> transformCheck.check(card, gender))) {
            return surname;
        }

        int length = surname.length();
        char lastChar = Character.toLowerCase(surname.charAt(length - 1));
        String result = surname;
        if (gender == Gender.FEMALE && lastChar == 'а') {
            result = surname.substring(0, length - 1) + "ой";
        } else if (gender == Gender.MALE) {
            result = surname + "а";
        }
        return result;
    }

    private String transformLastName(HumanCard card, Gender gender) {
        String lastName = card.getLastName();
        int length = lastName.length();
        char lastChar = Character.toLowerCase(lastName.charAt(length - 1));
        String result = lastName;
        if (gender == Gender.FEMALE && lastChar == 'а') {
            result = lastName.substring(0, length - 1) + "ы";
        } else if (gender == Gender.MALE) {
            result = lastName + "а";
        }
        return result;
    }

}
