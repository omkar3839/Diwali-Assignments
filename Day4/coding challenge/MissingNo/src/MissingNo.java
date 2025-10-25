
public class MissingNo {
    public static int findMissingNo(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] array = {3, 0, 1};
        System.out.println("Missing number is: " + findMissingNo(array));
    }
}

