package AnagramChecker.anagrams;

import AnagramChecker.InputObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LettersOnlyTest {

    @Test
    public void givenValidInput_WhenRan_ThenTestShouldPass() {
        Anagram anagram = new LettersOnly();

        InputObject inputObject = new InputObject("allen", "finder", "friend");
        InputObject inputObject2 = new InputObject("allen", "cat", "act");
        InputObject inputObject3 = new InputObject("allen", "bag", "gab");

        Assertions.assertTrue(anagram.checkWords(inputObject));
        Assertions.assertTrue(anagram.checkWords(inputObject2));
        Assertions.assertTrue(anagram.checkWords(inputObject3));
    }

    @Test
    public void givenValidInputWithCapitalLetters_WhenRan_ThenTestShouldPass() {
        Anagram anagram = new LettersOnly();

        InputObject inputObject = new InputObject("allen", "FinDer", "FriEnd");
        InputObject inputObject2 = new InputObject("allen", "Cat", "acT");
        InputObject inputObject3 = new InputObject("allen", "baG", "gAb");

        Assertions.assertTrue(anagram.checkWords(inputObject));
        Assertions.assertTrue(anagram.checkWords(inputObject2));
        Assertions.assertTrue(anagram.checkWords(inputObject3));
    }

    @Test
    public void givenInvalidInputWithDigits_WhenRan_ThenTestShouldFail() {
        Anagram anagram = new LettersOnly();

        InputObject inputObject = new InputObject("allen", "fin1der", "fri1end");
        InputObject inputObject2 = new InputObject("allen", "ca5t", "ac5t");
        InputObject inputObject3 = new InputObject("allen", "ba7g", "ga7b");

        Assertions.assertFalse(anagram.checkWords(inputObject));
        Assertions.assertFalse(anagram.checkWords(inputObject2));
        Assertions.assertFalse(anagram.checkWords(inputObject3));
    }

    @Test
    public void givenInvalidInputWithSpecialChars_WhenRan_ThenTestShouldFail() {
        Anagram anagram = new LettersOnly();

        InputObject inputObject = new InputObject("allen", "find@er", "friend@");
        InputObject inputObject2 = new InputObject("allen", "cat$", "t%ac");
        InputObject inputObject3 = new InputObject("allen", "b&ag", "gab&");

        Assertions.assertFalse(anagram.checkWords(inputObject));
        Assertions.assertFalse(anagram.checkWords(inputObject2));
        Assertions.assertFalse(anagram.checkWords(inputObject3));
    }

    @Test
    public void givenInvalidInputWithSpaces_WhenRan_ThenTestShouldFail() {
        Anagram anagram = new LettersOnly();

        InputObject inputObject = new InputObject("allen", "finder ", "friend");
        InputObject inputObject2 = new InputObject("allen", "cat ", "act  ");
        InputObject inputObject3 = new InputObject("allen", " bag", "gab");

        Assertions.assertFalse(anagram.checkWords(inputObject));
        Assertions.assertFalse(anagram.checkWords(inputObject2));
        Assertions.assertFalse(anagram.checkWords(inputObject3));
    }
}