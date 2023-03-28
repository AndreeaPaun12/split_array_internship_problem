import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 1 || n > 30) {
            System.out.println("Invalid input. The size of the array must be in range 1-30.");
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (num < 0 || num > 10000) {
                System.out.println("Invalid input. Each element of the array must be in range 0-10000.");
                return;
            }

            arr[i] = num;
        }

        boolean result = canSplitArray(arr);
        System.out.println(result);
    }

    public static boolean canSplitArray(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return false;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % 2 != 0) { //if the sum of all elements of the array is not even, it cant be split in two lists with the same average value
            return false;
        }
        int target = sum / 2;
        Set<Integer> possibleSums = new HashSet<>();
        possibleSums.add(0);
        for (int i = 0; i < n; i++) { //iterate over each element in the array
            Set<Integer> newSums = new HashSet<>();
            for (int possibleSum : possibleSums) { //iterate over each possible sum in the current set of possible sums
                int newSum = possibleSum + arr[i];
                if (newSum == target) { //if the new sum equals half the sum of all elements, return true
                    return true;
                }
                newSums.add(newSum); //add the new sum to the set of new sums
            }
            possibleSums.addAll(newSums); //add all the new sums to the set of possible sums
        }
        return false;
    }
}
