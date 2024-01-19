package Solutions;

public class Solution25 {

    public static String getEncryptedName(String name) {
        Validator validator = new Validator();
        if (validator.validate(name)) {
            return modifyString(name);
        } else {
            throw new IllegalArgumentException("Try again with valid name");
        }
    }

    public static String modifyString(String input) {
        StringBuilder modifiedString = new StringBuilder(input.length());
        for (int i = input.length() - 1; i >= 0; i--) {
            char currentChar = input.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                modifiedString.append(Character.toLowerCase(currentChar));
            } else {
                modifiedString.append(currentChar);
            }
        }
        return modifiedString.toString();
    }
}

