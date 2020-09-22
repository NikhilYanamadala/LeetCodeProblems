package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Parens {
    public void generateParens(int n) {
        Hashtable<Integer, ArrayList<String>> hashtable = new Hashtable<>();
        generateParens(n, hashtable);
        ArrayList<String> list = hashtable.get(3);
        for (String s : list) {
            System.out.println(s + ",");
        }
    }

    public void generateParens(int n, Hashtable<Integer, ArrayList<String>> hashtable) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (n == 1) {
            arrayList.add("()");
            hashtable.put(n, arrayList);
            return;
        }
        generateParens(n - 1, hashtable);
        if (hashtable.get(n - 1) != null) {
            ArrayList<String> resultFromHash = hashtable.get(n - 1);
            ArrayList<String> tempList = new ArrayList<>();
            for (String s : resultFromHash) {
                generateCombinations(s, tempList);
            }
            hashtable.put(n, tempList);
        }
    }

    public ArrayList<String> generateCombinations(String s, ArrayList<String> tempList) {
        String temp = "()";
        for (int i = 0; i < s.length(); i++) {
            String start = s.substring(0, i);
            String end = s.substring(i, s.length());
            String result = start + temp + end;
            tempList.add(result);
        }
        return tempList;
    }

    // Approach 2
    public Set<String> generateParens2(int remaining) {
        Set<String> set = new HashSet<>();
        if (remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParens2(remaining - 1);
            for (String s : prev) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '(') {
                        String resultString = insertAt(s, i);
                        set.add(resultString);
                    }
                }
                set.add("()" + s);
            }
        }
        return set;
    }

    public String insertAt(String s, int i) {
        String start = s.substring(0, i + 1);
        String end = s.substring(i + 1, s.length());
        return start + "()" + end;
    }
// Approach 3
    public void generateParens3(int n){
        if(n>0){
            char[] str = new char[n*2];
            printParens(str,0,n,0,0);
        }


    }
    public void printParens(char[] str,int pos,int count,int open,int close){
        if(close==count){
            String s = String.copyValueOf(str);
            System.out.println(s);
            return;
        }else{
            if(open > close){
                str[pos]=')';
                printParens(str,pos+1,count,open,close+1);
            }
            if(open < count){
                str[pos]='(';
                printParens(str,pos+1,count,open+1,close);
            }
        }

    }
    public static void main(String[] args) {
        int n = 3;
        Parens parens = new Parens();
//        parens.generateParens(n);
//        for (String s:parens.generateParens2(n)) {
//            System.out.println(s+"");
//        }
        parens.generateParens3(n);
    }
}
