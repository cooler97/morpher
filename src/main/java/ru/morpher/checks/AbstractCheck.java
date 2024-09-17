package ru.morpher.checks;

public class AbstractCheck {
    protected static final char[] CONSONANTS = new char[]{'Б', 'б', 'В', 'в', 'Г', 'г', 'Д', 'д', 'Ж', 'ж', 'З', 'з',
            'Й', 'й', 'К', 'к', 'Л', 'л', 'М', 'м', 'Н', 'н', 'П', 'п', 'Р', 'р', 'С', 'с', 'Т', 'т', 'Ф', 'ф',
            'Х', 'х', 'Ц', 'ц', 'Ч', 'ч', 'Ш', 'ш', 'Щ', 'щ'};

    protected static boolean isNameEndsOnConsonants(String name) {
        return isStringEndOnSpecificChar(name, CONSONANTS);
    }

    protected static boolean isNameEndsOnSoftLetter(String name) {
        return isStringEndOnSpecificChar(name, new char[]{'ь', 'ъ'});
    }

    protected static boolean isStringEndOnSpecificChar(String input, char[] chars) {
        char lastLetter = input.charAt(input.length() - 1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == lastLetter) {
                return true;
            }
        }
        return false;
    }
}
