package AnagramChecker.anagrams;

import AnagramChecker.InputObject;
import AnagramChecker.cache.FileWR;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class LettersOnly implements Anagram {

    private final Logger logger = Logger.getLogger(this.getClass());
    InputsChecker inputsChecker;
    Map<String, String> cache;

    public LettersOnly() {
        inputsChecker = new InputsChecker();
        cache = new HashMap<>();
        logger.info("Reading Cache");
        readCache();
    }

    private void readCache() {
        FileWR fileWR = new FileWR();
        cache = fileWR.getMapFromCache();
        logger.info("Read Cache");
    }

    @Override
    public Boolean checkWords(InputObject inputObject) {
        String wordToCheck1 = inputObject.getWord1().toLowerCase();
        String wordToCheck2 = inputObject.getWord2().toLowerCase();
        String[] words = new String[]{wordToCheck1, wordToCheck2};
        String key = wordToCheck1 + ":" + wordToCheck2;
        if (cache.containsKey(key)) {
            logger.info(key + " found in cache");
            return true;
        } else {
            if (hasDigits(words) || hasSpecialChars(words)) {
                logger.info(key + " contains digits or has special characters");
                return false;
            } else {
                if (inputsChecker.isAnagram(words[0], words[1])) {
                    logger.info(key + " appending to cache");
                    appendToCache(inputObject);
                    return true;
                }
            }
        }
        return false;
    }
    private void appendToCache(InputObject inputObject) {
        String key = inputObject.getWord1() + ":" + inputObject.getWord2();
        cache.put(key.toLowerCase(), inputObject.getUsername());
        FileWR fileOutput = new FileWR();
        fileOutput.CacheHandler(cache);
        logger.info(key + " appended to cache");
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
