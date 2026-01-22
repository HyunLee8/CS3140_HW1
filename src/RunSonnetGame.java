import java.util.Random;
import java.util.Scanner;

public class RunSonnetGame {
    private String sonnet = "Two households, both alike in dignity,\n" +
            "In fair Verona, where we lay our scene,\n" +
            "From ancient grudge break to new mutiny,\n" +
            "Where civil blood makes civil hands unclean.\n" +
            "From forth the fatal loins of these two foes\n" +
            "A pair of star-cross'd lovers take their life;\n" +
            "Whose misadventured piteous overthrows\n" +
            "Do with their death bury their parents' strife.\n" +
            "The fearful passage of their death-mark'd love,\n" +
            "And the continuance of their parents' rage,\n" +
            "Which, but their children's end, nought could remove,\n" +
            "Is now the two hours' traffic of our stage;\n" +
            "The which if you with patient ears attend,\n" +
            "What here shall miss, our toil shall strive to mend.\n";

    private int wins = 0;
    private int losses = 0;
    private int runs = 1;
    private int currentIndex = 0;
    private final String[] indexableSonnet;
    private String[] sonnetSubstring;

    //Immediately starts the game when instantiated
    public RunSonnetGame() {
        this.indexableSonnet = convertStringToArray(this.sonnet);
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getRuns() {
        return runs;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    //IMPORTANT: Private Packages; Cannot access in other packages, but you can JUnit test
    String[] convertStringToArray(String sonnet) {
        return sonnet.split(" ");
    }

    //Never the same substring
    void getRandomIndex() {
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

    void makeSonnetSubstring() {
        String[] subString = new String[currentIndex];
        for(int i=0; i<currentIndex; i++) {
            subString[i] = this.indexableSonnet[i];
        }
        this.sonnetSubstring = subString;
    }

    //Done after every iteration
    void randomize() {
        getRandomIndex();
        makeSonnetSubstring();
    }

    //Used in testing and RunSonnetGame
    String[] getSonnetSubstring() {
        return this.sonnetSubstring;
    }

    //Run engine
    public void runGame() {
        Scanner scanner = new Scanner(System.in);
        while(wins < 3 && losses < 3) {
            randomize();

            System.out.println("=================Run " + runs +" =================");
            System.out.println();
            String[] sonnetSubstring = getSonnetSubstring();

            for(int i=0; i<sonnetSubstring.length-1; i++) {
                System.out.print(sonnetSubstring[i] + " ");
            }

            System.out.println("____");
            System.out.println("What is the next word?");
            String response = scanner.next();
            response = response.toLowerCase();

            if(response.equals(sonnetSubstring[sonnetSubstring.length-1].toLowerCase())) {
                wins++;
            } else {
                losses++;
            }
            runs++;
        }

        if(wins == 3) {
            System.out.println("you won");
        } else {
            System.out.println("you lost");
        }
    }
}