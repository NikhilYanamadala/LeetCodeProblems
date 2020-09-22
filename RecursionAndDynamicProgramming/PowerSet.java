package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class PowerSet {
    public ArrayList<ArrayList<Integer>> generateSubSets(int[] array) {
        return generateSubSets(array, array.length - 1);

    }

    public ArrayList<ArrayList<Integer>> generateSubSets(int[] array, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (index < 0) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());
        } else {
            allSubsets = generateSubSets(array, index - 1);
            int item = array[index];
            ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<>();
            for (ArrayList<Integer> subSet : allSubsets) {
                ArrayList<Integer> newSubSet = new ArrayList<>();
                newSubSet.addAll(subSet);
                newSubSet.add(item);
                moreSubSets.add(newSubSet);
            }
            allSubsets.addAll(moreSubSets);
        }
        return allSubsets;
    }

    //    Approach 2
    public ArrayList<ArrayList<Integer>> getSubSets(int[] array) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        int max = 1 << array.length;
        for (int i = 0; i < max; i++) {
            ArrayList<Integer> subSet = convertIntToSet(array, i);
            allSubsets.add(subSet);
        }
        return allSubsets;
    }

    public ArrayList<Integer> convertIntToSet(int[] array, int x) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int index = 0;
        for (int i = x; i > 0; i >>= 1) {
            if ((i & 1) == 1) {
                arrayList.add(array[index]);
            }
            index++;
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        PowerSet powerSet = new PowerSet();
//        System.out.println(powerSet.generateSubSets(array));
        System.out.println(powerSet.getSubSets(array));
    }
}
