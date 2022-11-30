package AnagramChecker.anagrams;

public class InputsChecker {

    private static int CHARACTER_RANGE= 256;

    public boolean isAnagram(String word1, String word2) {
        if (isWordsLengthEqual(word1, word2)) return false;

        int histogram[] = new int[CHARACTER_RANGE];
        PopulateHistogram(word1, word2, histogram);

        return IsHistogramBalanced(histogram);
    }

    private static boolean isWordsLengthEqual(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return true;
        }
        return false;
    }

    private static void PopulateHistogram(String word1, String word2, int[] count) {
        for (int i = 0; i < word1.length(); i++) {
            count[word1.charAt(i)]++;
            count[word2.charAt(i)]--;
        }
    }

    private static boolean IsHistogramBalanced(int[] count) {
        for (int i = 0; i < CHARACTER_RANGE; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
