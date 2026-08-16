import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine(); // consume newline

        while (T-- > 0) {
            String s = sc.nextLine();
            String[] words = s.split(" ");

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                // Check if word is completely uppercase
                boolean isAcronym = true;

                for (int j = 0; j < word.length(); j++) {
                    if (Character.isLowerCase(word.charAt(j))) {
                        isAcronym = false;
                        break;
                    }
                }

                if (isAcronym) {
                    // Keep acronym unchanged
                    result.append(word);
                } else {
                    // First letter uppercase, remaining lowercase
                    result.append(Character.toUpperCase(word.charAt(0)));

                    for (int j = 1; j < word.length(); j++) {
                        result.append(Character.toLowerCase(word.charAt(j)));
                    }
                }

                if (i < words.length - 1) {
                    result.append(" ");
                }
            }

            System.out.println(result);
        }

        sc.close();
    }
}