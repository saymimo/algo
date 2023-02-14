
public class InsertSort extends BaseSort{
    // 57 99 65 24 39 72 5 68 18
    // 57 65 99 24 39 72 5 68 18
    // 24 57 65 99 39 72 5 68 18
    public static void main(String[] args) {
        int[] nums = {57 ,99 ,65 ,24 ,39, 72 ,5, 68 ,18};
        InsertSort sort = new InsertSort();
        sort.sort2(nums);
        printNums(nums);
    }
    @Override
    public void sort(int[] nums) {
        // 假设前半部分[0 - i)为有序序列，从i开始一个个遍历后半部分
        for (int i = 1; i < nums.length; i++) {
            // 临时缓存当前值
            int tmp = nums[i];
            // 从tmp之前的区域开始寻找比tmp大的
            int j = i - 1;
            for (; j >= 0 && nums[j] > tmp; j--){
                // 如果有比tmp大的元素j，则将元素j往后移一位（即用j直接覆盖j+1）
                nums[j + 1] = nums[j];
            }
            // 最后将tmp放至位置j的右边（此时的j要么是<0 要么元素j<=tmp）
            nums[j + 1] = tmp;
        }
    }

    /**
     * 2023-02-14 巩固练习
     * 感想1：类似于排队比身高，比当前i高的都逐渐往后排，将i插入到腾出的位置上来。
     * 感想2：既然前半部分为有序序列，可以用二分查找的思路在[0-i）中更快速找到i的位置
     * @param nums
     */
    public void sort2(int[] nums) {
        // 假设[0-i)为有序序列，从i开始一个个遍历后边序列，来找到元素i该插入到前面有序序列的哪个位置
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                // 找到了比cur大的元素j，则将元素j
                if (nums[j] > cur) {
                    // 将大元素nums[j]往后排
                    nums[j +1 ] = nums[j];
                    // 将tmp放到
                    nums[j] = cur;
                }
            }
        }
    }

}
