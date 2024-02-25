package leetcode.p20.p2038;

public class WinnerOfGame {
    public boolean winnerOfGame(String colors) {
        if (colors.length() < 3) {
            return false;
        }
        int countOfA = 0;
        int countOfB = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') {
                    countOfA++;
                } else {
                    countOfB++;
                }
            }
        }
        return countOfA > countOfB;
    }
}
