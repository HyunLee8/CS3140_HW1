/*
GAME OPTIMIZER
 - sets up game
 - randomizes setup after iterations

 */

import java.util.Random;

public class PreprocessGame {
    private int currentIndex = 0;
    private final String[] indexableSonnet;
    private String[] sonnetSubstring;

    public PreprocessGame(String sonnet) {
        this.indexableSonnet = convertStringToArray(sonnet);
    }

    //Make String indexable
    private String[] convertStringToArray(String sonnet) {
        return sonnet.split(" ");
    }

    //Never the same substring
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

    //Done after every iteration
    public void randomize() {
        getRandomIndex();
        makeSonnetSubstring();
    }

    //Used in testing and RunSonnetGame
    public String[] getSonnetSubstring() {
        return this.sonnetSubstring;
    }
}
