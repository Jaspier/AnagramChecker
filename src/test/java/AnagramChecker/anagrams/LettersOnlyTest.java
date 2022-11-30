package AnagramChecker.anagrams;

import AnagramChecker.InputObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LettersOnlyTest {

    private InputObject inputObject;
    private Anagram anagram;

    @BeforeEach
    void setUp() {
        inputObject = new InputObject();
        anagram = new LettersOnly();
    }

    @AfterEach
    void tearDown() {
        inputObject = null;
        anagram = null;
    }

    @Test
    public void givenValidInput_WhenRan_ThenTestShouldPass() {
        inputObject = new InputObject("allen", "finder", "friend");
        Assertions.assertTrue(anagram.checkWords(inputObject));

        inputObject = new InputObject("allen", "cat", "act");
        Assertions.assertTrue(anagram.checkWords(inputObject));

        inputObject = new InputObject("allen", "bag", "gab");
        Assertions.assertTrue(anagram.checkWords(inputObject));
    }

    @Test
    public void givenValidInputWithCapitalLetters_WhenRan_ThenTestShouldPass() {
        inputObject = new InputObject("allen", "FinDer", "FriEnd");
        Assertions.assertTrue(anagram.checkWords(inputObject));

        inputObject = new InputObject("allen", "Cat", "acT");
        Assertions.assertTrue(anagram.checkWords(inputObject));

        inputObject = new InputObject("allen", "baG", "gAb");
        Assertions.assertTrue(anagram.checkWords(inputObject));
    }

    @Test
    public void givenInvalidInputWithDigits_WhenRan_ThenTestShouldFail() {
        inputObject = new InputObject("allen", "fin1der", "fri1end");
        Assertions.assertFalse(anagram.checkWords(inputObject));

        inputObject = new InputObject("allen", "ca5t", "ac5t");
        Assertions.assertFalse(anagram.checkWords(inputObject));

        inputObject = new InputObject("allen", "ba7g", "ga7b");
        Assertions.assertFalse(anagram.checkWords(inputObject));
    }

    @Test
    public void givenInvalidInputWithSpecialChars_WhenRan_ThenTestShouldFail() {
        inputObject = new InputObject("allen", "find@er", "friend@");
        Assertions.assertFalse(anagram.checkWords(inputObject));

        inputObject = new InputObject("allen", "cat$", "t%ac");
        Assertions.assertFalse(anagram.checkWords(inputObject));

        inputObject = new InputObject("allen", "b&ag", "gab&");
        Assertions.assertFalse(anagram.checkWords(inputObject));
    }

    @Test
    public void givenInvalidInputWithSpaces_WhenRan_ThenTestShouldFail() {
        inputObject = new InputObject("allen", "finder ", "friend");
        Assertions.assertFalse(anagram.checkWords(inputObject));

        inputObject = new InputObject("allen", "cat ", "act  ");
        Assertions.assertFalse(anagram.checkWords(inputObject));

        inputObject = new InputObject("allen", " bag", "gab");
        Assertions.assertFalse(anagram.checkWords(inputObject));
    }
}