package ru.morpher.enums;

public enum RussianCases {

    NATIVE("Именительный"),

    GENITIVE("Родительный");

    private final String description;

    RussianCases(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
