package AnagramChecker.anagrams;

import AnagramChecker.InputObject;

public class LettersOnly implements Anagram {

    InputsChecker inputsChecker;

    public LettersOnly() {
        inputsChecker = new InputsChecker();
    }

    @Override
    public Boolean checkWords(InputObject inputObject) {
        String wordToCheck1 = inputObject.getWord1().toLowerCase();
        String wordToCheck2 = inputObject.getWord2().toLowerCase();
        String[] words = new String[]{wordToCheck1, wordToCheck2};
        if (hasDigits(words) || hasSpecialChars(words)) {
            return false;
        } else {
            return inputsChecker.isAnagram(words[0], words[1]);
        }
    }

    private Boolean hasSpecialChars(String[] wordsToCheck) {
        char[] characters;
        for (String word : wordsToCheck) {
           characters = word.toCharArray();
            for(char c: characters){
                if(!Character.isLetterOrDigit(c)){
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean hasDigits(String[] wordsToCheck) {
        char[] characters;
        for (String word : wordsToCheck) {
            characters = word.toCharArray();
            for(char c: characters){
                if(Character.isDigit(c)){
                    return true;
                }
            }
        }
        return false;
    }
}
