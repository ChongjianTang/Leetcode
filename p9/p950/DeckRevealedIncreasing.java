package leetcode.p9.p950;

import java.util.Arrays;

public class DeckRevealedIncreasing {
    /**
     * Apr 11, 2024 16:58
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1)
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] result = new int[deck.length];
        boolean skip = false;

        int idx1 = 0;
        int idx2 = 0;
        while (idx2 < deck.length) {
            if (result[idx1] == 0) {
                if (!skip) {
                    result[idx1] = deck[idx2];
                    idx2++;
                }
                skip = !skip;
            }
            idx1 = (idx1 + 1) % deck.length;
        }
        return result;
    }
}
