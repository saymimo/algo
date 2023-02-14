
public class BubbleSort extends BaseSort{
    public static void main(String[] args) {
        int[] nums = {57 ,99 ,65 ,24 ,39, 72 ,5, 68 ,18};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(nums);
        printNums(nums);
    }

    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }
}
