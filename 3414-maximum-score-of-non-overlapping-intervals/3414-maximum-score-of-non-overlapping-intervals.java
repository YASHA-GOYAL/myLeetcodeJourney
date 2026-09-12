import java.util.*;

class Solution {
    static class Interval {
        int left;
        int right;
        int weight;
        int index;

        Interval(int left, int right, int weight, int index) {
            this.left = left;
            this.right = right;
            this.weight = weight;
            this.index = index;
        }
    }

    static class Result {
        long score;
        int[] indices;

        Result(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Result[][] dp;
    int[] starts;
    int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        n = intervals.size();

        Interval[] arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            int left = intervals.get(i).get(0);
            int right = intervals.get(i).get(1);
            int weight = intervals.get(i).get(2);

            arr[i] = new Interval(left, right, weight, i);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.left != b.left) {
                return Integer.compare(a.left, b.left);
            }

            return Integer.compare(a.right, b.right);
        });

        starts = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = arr[i].left;
        }

        dp = new Result[n + 1][5];

        for (int count = 0; count <= 4; count++) {
            dp[n][count] = new Result(0, new int[0]);
        }

        for (int i = n - 1; i >= 0; i--) {
            dp[i][4] = new Result(0, new int[0]);

            for (int count = 3; count >= 0; count--) {
                Result skip = dp[i + 1][count];

                int nextIndex = findNext(arr[i].right);

                Result future = dp[nextIndex][count + 1];

                int[] selected = Arrays.copyOf(
                    future.indices,
                    future.indices.length + 1
                );

                selected[selected.length - 1] = arr[i].index;

                Arrays.sort(selected);

                Result take = new Result(
                    arr[i].weight + future.score,
                    selected
                );

                if (isBetter(take, skip)) {
                    dp[i][count] = take;
                } else {
                    dp[i][count] = skip;
                }
            }
        }

        return dp[0][0].indices;
    }

    private int findNext(int end) {
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (starts[mid] <= end) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private boolean isBetter(Result first, Result second) {
        if (first.score != second.score) {
            return first.score > second.score;
        }

        return compareArrays(first.indices, second.indices) < 0;
    }

    private int compareArrays(int[] first, int[] second) {
        int length = Math.min(first.length, second.length);

        for (int i = 0; i < length; i++) {
            if (first[i] != second[i]) {
                return Integer.compare(first[i], second[i]);
            }
        }

        return Integer.compare(first.length, second.length);
    }
}