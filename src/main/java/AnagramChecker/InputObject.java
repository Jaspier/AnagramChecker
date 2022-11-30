package AnagramChecker;

public class InputObject {
    String username;
    String word1;
    String word2;

    public InputObject(String username, String word1, String word2) {
        this.username = username;
        this.word1 = word1;
        this.word2 = word2;
    }

    public String getUsername() {
        return username;
    }

    public String getWord1() {
        return word1;
    }

    public String getWord2() {
        return word2;
    }
}
