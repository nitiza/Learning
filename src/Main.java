import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Oops concept
        // 1. Abstraction - achieved by abstract classes and interfaces


        // Arrays - store some data in contiguous fashion
        // Lists - stores data in non contiguous fashion
        // Sets - unordered data with no duplicates
        // Maps - key value store, keys cannot have duplicates

        /*
         Q1.
         Given a list of integers and a target, you need to find a pair whose sum is equal to the target.
         If no such pair exist, you can return -1

          L = [1, 2, 3, 4, 7, 5, 8, 10, 20]
          Target = 15
          [5, 10] or [7, 8]
          Target = 35
          -1

          Q2.
         Given a list of integers and a target, you need to count of all pairs whose sum is equal to the target.
         If no such pair exist, you can return 0

         L = [1, 2, 3, 4, 4, 5, 6, 7, 8, 9]
         T = 10
         Count = [1, 9], [2, 8], [3, 7], [4, 6], [4, 6] = 5

         n occurrences of T / 2 = n * (n - 1) / 2

         Q3.
         Given a list of integers and a value 'k', you need to find Kth largest number
         L = [1, 2, 3, 4, 5, 6, 7, 8]
         k = 4
         Ans = 5

         Brute Force: Sort the array, list.get(n - k) -> NlogN
         */

        // setting the map
//        int arr[] = {1, 2, 3, 4, 4, 5, 5, 5, 6, 7, 8, 9};
//        int target = 10;
//        int count = 0;
//        Map<Integer, Integer> mpp = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
//        }
//
//        // Iterating the map and updating the count
//        Set<Map.Entry<Integer, Integer>> entries = mpp.entrySet();
//        for (Map.Entry<Integer, Integer> entry : entries) {
//            int key = entry.getKey();
//            Integer val = mpp.get(target - key);
//            if (val != null && key * 2 != target) {
//                count += val * entry.getValue();
//                entry.setValue(0);
//                mpp.put(target - key, 0);
//            } else if (key * 2 == target) {
//                count += (entry.getValue() * (entry.getValue() - 1)) / 2;
//            }
//        }
//        System.out.println(count);
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 1, 13);
        System.out.println(findKthLargestElement(nums, 1));
    }

    public static int findKthLargestElement(List<Integer> nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < nums.size(); i++) {
            if (pq.size() < k) {
                pq.add(nums.get(i));
            } else if (nums.get(i) > pq.peek()) {
                pq.poll();
                pq.add(nums.get(i));
            }
        }

        return pq.peek();
    }
}
