import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Codechef {
    public static void main(String[] args) throws IOException {
        // Using BufferedReader for fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        if (S == null) return;
        
        // Frequency array to store counts of 'a' through 'z'
        int[] freq = new int[26];
        
        // Process each character in the string
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            
            // Check if the character is an English letter
            if (c >= 'a' && c <= 'z') {
                freq[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                freq[c - 'A']++;
            }
        }
        
        int maxFreq = 0;
        char bestLetter = 'a';
        
        // Find the character with the maximum frequency.
        // Looping from 0 to 25 ensures that in case of a tie, 
        // the alphabetically first letter is chosen.
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                bestLetter = (char) ('a' + i);
            }
        }
        
        // Print the result
        System.out.println(bestLetter);
    }
}