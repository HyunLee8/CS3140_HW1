import java.util.Scanner;

public class RunSonnetGame {
    String sonnet = "Two households, both alike in dignity,\n" +
            "In fair Verona, where we lay our scene,\n" +
            "From ancient grudge break to new mutiny,\n" +
            "Where civil blood makes civil hands unclean.\n" +
            "From forth the fatal loins of these two foes\n" +
            "A pair of star-cross’d lovers take their life;\n" +
            "Whose misadventured piteous overthrows\n" +
            "Do with their death bury their parents’ strife.\n" +
            "The fearful passage of their death-mark’d love,\n" +
            "And the continuance of their parents’ rage,\n" +
            "Which, but their children’s end, nought could remove,\n" +
            "Is now the two hours’ traffic of our stage;\n" +
            "The which if you with patient ears attend,\n" +
            "What here shall miss, our toil shall strive to mend.\n";

    private int wins = 0;
    private int losses = 0;
    private int runs = 1;
    private final PreprocessGame game;

    //Immediately starts the game when instantiated
    public RunSonnetGame() {
        this.game = new PreprocessGame(this.sonnet);
        runGame();
    }

    private void runGame() {
        Scanner scanner = new Scanner(System.in);
        while(wins < 3 && losses < 3) {
            game.randomize();

            System.out.println("=================Run " + runs +" =================");
            System.out.println();
            String[] sonnetSubstring = game.getSonnetSubstring();

            for(int i=0; i<sonnetSubstring.length-2; i++) {
                System.out.print(sonnetSubstring[i] + " ");
            }

            System.out.println("____");
            System.out.println("What is the next word?");
            String response = scanner.next();
            response = response.toLowerCase();

            if(response.equals(sonnetSubstring[sonnetSubstring.length-1])) {
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
