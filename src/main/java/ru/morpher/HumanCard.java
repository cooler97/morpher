package ru.morpher;

public class HumanCard {
    private final String firstName;
    private final String surname;
    private final String lastName;

    public HumanCard(String firstName, String surname, String lastName) {
        this.firstName = firstName;
        this.surname = surname;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastName() {
        return lastName;
    }

    public String asString() {
        return surname + " " + firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "HumanCard{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
