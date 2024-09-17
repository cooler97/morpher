package ru.morpher;

import ru.morpher.enums.Gender;
import ru.morpher.enums.RussianCases;
import ru.morpher.parsers.Parser;
import ru.morpher.transformers.CaseTransformer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RussianNamesMorpher implements Morpher {
    private final Parser parser;
    private final Set<IdentifyGenderStrategy> identifyGenderStrategySet;
    private final Map<RussianCases, CaseTransformer> caseTransformerMap;

    public RussianNamesMorpher(Parser parser, Set<IdentifyGenderStrategy> identifyGenderStrategySet, Map<RussianCases, CaseTransformer> caseTransformerMap) {
        this.parser = parser;
        this.identifyGenderStrategySet = identifyGenderStrategySet;
        this.caseTransformerMap = caseTransformerMap;
    }

    @Override
    public Map<RussianCases, HumanCard> morphHumanName(String inputName) {
        HumanCard card = parser.parse(inputName);
        final var gender = identifyGender(card);

        Map<RussianCases, HumanCard> results = new HashMap<>(caseTransformerMap.size());
        caseTransformerMap.forEach((cases, caseTransformer) -> results.put(cases, caseTransformer.transform(card, gender)));

        return results;
    }

    private Gender identifyGender(HumanCard humanCard) {
        for (IdentifyGenderStrategy strategy : identifyGenderStrategySet) {
            Gender identified = strategy.identify(humanCard);
            if (Gender.UNKNOWN != identified) {
                return identified;
            }
        }
        return Gender.UNKNOWN;
    }
}
