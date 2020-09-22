package RecursionAndDynamicProgramming;

public class MagicIndex {
    // Approach 1 RT=O(N)
    public int getMagicIndex(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                return i;
            }
        }
        return -1;
    }

    //    Approach 2 RT=O(logN)
    public int magicFast(int[] array) {
        return magicFast(array, 0, array.length);
    }

    public int magicFast(int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast(array, mid + 1, end);

        }
    }

    // Approach 3 with duplicate elements
    public int fastMagicIndex(int[] array) {

        return fastMagicIndex(array, 0, array.length);
    }

    public int fastMagicIndex(int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midValue = array[mid];
        if (midValue == mid) {
            return mid;
        }
//        search left recursively
        int leftIndex = Math.min(mid-1,midValue);
        int left = magicFast(array,start,leftIndex);
        if(left > 0 ){
            return left;
        }
        int rightIndex = Math.max(mid+1,midValue);
        int right = magicFast(array,rightIndex,end);
        return right;
    }

    public static void main(String[] args) {
        int[] array = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        int[] array1 = {10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        MagicIndex magicIndex = new MagicIndex();
//        System.out.println(magicIndex.getMagicIndex(array));
//        System.out.println(magicIndex.magicFast(array));
        System.out.println(magicIndex.fastMagicIndex(array1));
    }
}
