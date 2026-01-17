public class TestMain {
    static String sonnet = "Two households, both alike in dignity,\n" +
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
    int wins = 0;
    int losses = 0;

    public static void main(String[]args) {
        System.out.println(runTest());
    }

    public static boolean runTest() {
        PreprocessGame game = new PreprocessGame(sonnet);
        game.randomize();

        String[] sonnetSubstring = game.getSonnetSubstring();
        String answer = sonnetSubstring[sonnetSubstring.length-1];

        if(answer.equals(sonnetSubstring[sonnetSubstring.length-1])) {
            System.out.println(answer + " == " + sonnetSubstring[sonnetSubstring.length-1]);
            return true;
        } else {
            return false;
        }
    }
}