/**
 * 选择排序
 */
public class SelectionSort extends BaseSort{

    public static void main(String[] args) {
        int[] nums = {57 ,99 ,65 ,24 ,39, 72 ,5, 68 ,18};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(nums);
        printNums(nums);
    }

    @Override
    public void sort(int[] nums){
        // 循环len-1次 每次找最小数向前置换
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            int tmp = nums[min];
            nums[min] = nums[i];
            nums[i] = tmp;
        }
    }


}
