import java.util.Arrays;

class Solution {
    public int longestBalanced(String s) {
        int length = s.length();
        int[] frequency = new int[26];   // frequency of each character in current substring
        int maxBalancedLength = 0;

        // Try every possible starting index of substring
        for (int start = 0; start < length; ++start) {
            Arrays.fill(frequency, 0);

            int maxCharCount = 0;        // highest frequency among characters in current window
            int distinctChars = 0;       // number of distinct characters in current window

            // Expand substring from 'start' to 'end'
            for (int end = start; end < length; ++end) {
                int charIndex = s.charAt(end) - 'a';

                // First appearance of this character in current substring
                if (++frequency[charIndex] == 1) {
                    ++distinctChars;
                }

                // Update the max frequency in current substring
                maxCharCount = Math.max(maxCharCount, frequency[charIndex]);

                int currentLength = end - start + 1;

                /*
                 * Balanced condition:
                 * If all present characters have the same frequency,
                 * then:
                 *   currentLength = (frequency of each char) * (number of distinct chars)
                 * Here maxCharCount represents that equal frequency value
                 * when the substring is balanced.
                 */
                if (maxCharCount * distinctChars == currentLength) {
                    maxBalancedLength = Math.max(maxBalancedLength, currentLength);
                }
            }
        }

        return maxBalancedLength;
    }
}