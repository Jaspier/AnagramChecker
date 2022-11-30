package Client;

import AnagramChecker.InputObject;
import AnagramChecker.anagrams.LettersOnly;
import AnagramChecker.anagrams.Anagram;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Anagram anagram = new LettersOnly();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------- Anagram Checker ---------");
        System.out.println("Enter username");
        String username = scanner.nextLine();
        System.out.println("Enter first word");
        String word1 = scanner.nextLine();
        System.out.println("Enter second word");
        String word2 = scanner.nextLine();

        InputObject inputObject = new InputObject(username, word1, word2);

        System.out.println(anagram.checkWords(inputObject));
    }
}
