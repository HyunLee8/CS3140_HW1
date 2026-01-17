

import java.util.Random;

public class PreprocessGame {
    private int currentIndex = 0;
    private final String[] indexableSonnet;
    private String[] sonnetSubstring;

    public PreprocessGame(String sonnet) {
        this.indexableSonnet = convertStringToArray(sonnet);
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public String[] getSonnetSubstring() {
        return this.sonnetSubstring;
    }

    private String[] convertStringToArray(String sonnet) {
        return sonnet.split(" ");
    }

    private void getRandomIndex() {
        int randomIndex;
        while (true) {
            Random rand = new Random();
            randomIndex = rand.nextInt(this.indexableSonnet.length);
            if (randomIndex != this.currentIndex) {
                break;
            }
        }
        this.currentIndex = randomIndex;
    }

    private void makeSonnetSubstring() {
        String[] subString = new String[currentIndex];
        for(int i=0; i<currentIndex; i++) {
           subString[i] = this.indexableSonnet[i];
        }
        this.sonnetSubstring = subString;
    }

    public void randomize() {
        getRandomIndex();
        makeSonnetSubstring();
    }
}
