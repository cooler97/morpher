package ru.morpher.checks;

import org.junit.jupiter.api.Test;
import ru.morpher.HumanCard;
import ru.morpher.enums.Gender;

import static org.assertj.core.api.Assertions.assertThat;

class FemaleSurnameCheckTest {

    FemaleSurnameCheck check = new FemaleSurnameCheck();

    @Test
    void femaleSurnameEndOnConsonantsLetter_returnFalse() {
        assertThat(
                check.check(
                        new HumanCard("Анна", "Жук", "Иванова"),
                        Gender.FEMALE
                )
        ).isFalse();
    }

    @Test
    void femaleSurnameEndOnSoftLetter_returnFalse() {
        assertThat(
                check.check(
                        new HumanCard("Людмила", "Коваль", "Иванова"),
                        Gender.FEMALE
                )
        ).isFalse();
    }

    @Test
    void genderIsMale_returnTrue() {
        assertThat(
                check.check(
                        new HumanCard("Иван", "Иванов", "Иванович"),
                        Gender.MALE
                )
        ).isTrue();
    }

}