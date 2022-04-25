/**
 * 选择排序
 */
public class SelectionSort extends BaseSort{

    @Override
    public void sort(int[] nums){
        // 循环len-1次 每次找最小数向前置换
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]){
                    swap(nums, i, j);
                }
            }
        }
    }


}
