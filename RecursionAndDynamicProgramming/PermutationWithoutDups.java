package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class PermutationWithoutDups {
    public void generatePermutations(String s) {
        String prefix = "";
        generatePermutations(s, prefix);
    }

    public void generatePermutations(String s, String prefix) {
        if (prefix.length() == 3) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String subString = s.substring(0, i) + s.substring(i + 1, s.length());
            char c = s.charAt(i);
            generatePermutations(subString, prefix+c);
        }
    }

    // APproach 2
    public ArrayList<String> getParams(String s) {
        if (s == null) {
            return null;
        }
        ArrayList<String> permutations = new ArrayList<>();
//        base case
        if (s.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char first = s.charAt(0);
        String remainder = s.substring(1);
        ArrayList<String> words = getParams(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String result = insertChatAt(word,first,j);
                permutations.add(result);
            }

        }
    return  permutations;
    }
    public String insertChatAt(String word,char first,int i){
        String start = word.substring(0,i);
        String end = word.substring(i);
        return start+first+end;
    }
    public static void main(String[] args) {
        String s = "abc";
        PermutationWithoutDups permutationWithoutDups = new PermutationWithoutDups();
        permutationWithoutDups.generatePermutations(s);
//        for (String word :permutationWithoutDups.getParams(s)) {
//             System.out.println(word);
//        }
    }
}
