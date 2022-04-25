
public class InsertSort extends BaseSort{
    // 57 99 65 24 39 72 5 68 18
    // 57 65 99 24 39 72 5 68 18
    // 24 57 65 99 39 72 5 68 18
    public static void main(String[] args) {
        int[] nums = {57 ,99 ,65 ,24 ,39, 72 ,5, 68 ,18};
        InsertSort sort = new InsertSort();
        sort.sort(nums);
        printNums(nums);
    }
    @Override
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 临时缓存当前值
            int tmp = nums[i];
            // 从tmp之前的区域开始寻找比tmp小的
            int j = i - 1;
            for (; j >= 0 && nums[j] > tmp; j--){
                // 比tmp大的都往后移一位
                nums[j + 1] = nums[j];
            }
            // 将tmp放至位置j的右边
            nums[j + 1] = tmp;
        }
    }

}
