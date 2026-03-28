class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];
        char c = 'a';
        
        for (int i = 0; i < n; i++) {
            if (word[i] == 0) {
                if (c > 'z') return "";
                word[i] = c;
                for (int j = i + 1; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        word[j] = c;
                    }
                }
                c++;
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int expected = 0;
                if (word[i] == word[j]) {
                    if (i == n - 1 || j == n - 1) {
                        expected = 1;
                    } else {
                        expected = lcp[i + 1][j + 1] + 1;
                    }
                }
                if (lcp[i][j] != expected) {
                    return "";
                }
            }
        }
        
        return new String(word);
    }
}
