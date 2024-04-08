package algorithms.searching.linearSearch;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i : arr) {
            if (i == target) {
                return i;
            }
        }
        return -1;
    }
}
