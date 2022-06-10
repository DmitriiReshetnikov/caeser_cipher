package ru.home;

public class Cipher {
    final static int ALPHABET_LENGTH = 33;
    final static String UPPER_CASE_ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    final static String LOWER_CASE_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    //private int offset;

    public String deCipherMessage(String message, int offset){
        StringBuilder deCipheredString = new StringBuilder();
        char[] deCipherArray = message.toCharArray();
        char newCharacter;
        for (char character : deCipherArray) {
            if (Character.isLetter(character)) {
                newCharacter = this.deCipherOneCharacter(character, offset);
            }else{
                newCharacter = character;
            }
            deCipheredString.append(newCharacter);
        }
        return deCipheredString.toString();
    }

    public char deCipherOneCharacter(char character, int offset){
        char newCharacter;
        int newAlphabetPosition;
        int originalAlphabetPosition;
        if (Character.isUpperCase(character)){
            originalAlphabetPosition = findAlphabetPosition(character, true);
            newAlphabetPosition = (originalAlphabetPosition - offset); // % (Cipher.ALPHABET_LENGTH - 1);
            if (newAlphabetPosition < 0) {
                newAlphabetPosition += Cipher.ALPHABET_LENGTH;
            }
            return getCharacterFromAlphabet(newAlphabetPosition, true);
        }else{
            originalAlphabetPosition = findAlphabetPosition(character, false);
            newAlphabetPosition = (originalAlphabetPosition - offset);// % (Cipher.ALPHABET_LENGTH - 1);
            if (newAlphabetPosition < 0) {
                newAlphabetPosition += Cipher.ALPHABET_LENGTH;
            }
            return getCharacterFromAlphabet(newAlphabetPosition, false);
        }
    }

    public int findAlphabetPosition(char character, boolean isUpperCase){
        int position = 0;
        char[] charArray = findRightAlphabet(isUpperCase);
        for (int i = 0; i < charArray.length ; i++) {
            if (charArray[i] == character) {
                position = i;
                break;
            }
        }
    return position;
    }

    public char getCharacterFromAlphabet(int position, boolean isUpperCase){
        char[] charArray = findRightAlphabet(isUpperCase);
        return charArray[position];
    }

    public char[] findRightAlphabet(boolean isUpperCase){
        if (isUpperCase) {
            return this.UPPER_CASE_ALPHABET.toCharArray();
        } else {
            return this.LOWER_CASE_ALPHABET.toCharArray();
        }
    }
}
