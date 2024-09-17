package ru.morpher.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.morpher.HumanCard;
import ru.morpher.IdentifyGenderStrategyByName;
import ru.morpher.RussianNamesMorpher;
import ru.morpher.checks.FemaleSurnameCheck;
import ru.morpher.enums.RussianCases;
import ru.morpher.transformers.GenitiveTransformer;

import java.util.Map;
import java.util.Set;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/morph")
public class RestController {
    private final FemaleSurnameCheck femaleSurnameCheck = new FemaleSurnameCheck();

    private final GenitiveTransformer genitiveTransformer = new GenitiveTransformer(
            Set.of(femaleSurnameCheck)
    );
    private final RussianNamesMorpher morpher = new RussianNamesMorpher(
            Set.of(
                    new IdentifyGenderStrategyByName()
            ),
            Map.of(RussianCases.GENITIVE, genitiveTransformer)
    );

    @GetMapping
    public Map<RussianCases, HumanCard> morphName(@RequestParam("name") String name) {
        return morpher.morphHumanName(name);
    }
}
