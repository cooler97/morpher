package ru.morpher;

import org.junit.jupiter.api.Test;
import ru.morpher.checks.FemaleSurnameCheck;
import ru.morpher.enums.RussianCases;
import ru.morpher.transformers.GenitiveTransformer;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RussianNamesMorpherTest {

    IdentifyGenderStrategyByName identifyGenderStrategyByName = new IdentifyGenderStrategyByName();

    FemaleSurnameCheck femaleSurnameCheck = new FemaleSurnameCheck();

    GenitiveTransformer genitiveTransformer = new GenitiveTransformer(
            Set.of(femaleSurnameCheck)
    );

    @Test
    void smoke_maleNameTransform() {
        var sut = new RussianNamesMorpher(
                Set.of(identifyGenderStrategyByName),
                Map.of(RussianCases.GENITIVE, genitiveTransformer)
        );

        Map<RussianCases, HumanCard> morphed = sut.morphHumanName("Акимов Илья Дмитриевич");

        assertThat(morphed.get(RussianCases.GENITIVE).asString())
                .isEqualTo("Акимова Ильи Дмитриевича");
    }

    @Test
    void smoke_femaleNameTransform() {
        var sut = new RussianNamesMorpher(
                Set.of(new IdentifyGenderStrategyByName()),
                Map.of(RussianCases.GENITIVE, genitiveTransformer)
        );

        Map<RussianCases, HumanCard> morphed = sut.morphHumanName("Крутякова Наталия Вячеславовна");

        assertThat(morphed.get(RussianCases.GENITIVE).asString())
                .isEqualTo("Крутяковой Наталии Вячеславовны");
    }

    @Test
    void femaleSurnameEndOnConsonantLetter() {
        var sut = new RussianNamesMorpher(
                Set.of(new IdentifyGenderStrategyByName()),
                Map.of(RussianCases.GENITIVE, genitiveTransformer)
        );

        Map<RussianCases, HumanCard> morphed = sut.morphHumanName("Жук Анна Иванова");

        assertThat(morphed.get(RussianCases.GENITIVE).asString())
                .isEqualTo("Жук Анны Ивановой");
    }

}