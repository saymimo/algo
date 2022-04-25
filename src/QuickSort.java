import java.util.concurrent.CountDownLatch;

/**
 * 快速排序
 */
public class QuickSort extends BaseSort{

    public void test(int count){

    }

    public void partition(int[] nums, int left, int right){
        if (left > right){
            return;
        }
        int i = left, j = right, base = nums[left];
        // 循环实现左分区全部小于base 右分区全部大于base
        while (i < j){
            // 左指针比右指针小 且 未找到比base小的数 继续向左寻找
            while (i < j && nums[j] >= base){
                j--;
            }

            // 左指针比右指针小 且 未找到第一个比base大的数 继续向右寻找
            while (i < j && nums[i] <= base){
                i++;
            }

            // 左/右指针找到了比base大/小的数 or 左指针不在右指针左侧
            if (i < j){
                swap(nums, i, j);
            }
        }
        // 基数归位
        swap(nums, left, i);

        // 递归左分区
        partition(nums, left, i - 1);
        // 递归右分区
        partition(nums,j+1, right);
    }

    @Override
    public void sort(int[] nums) {
        partition(nums, 0 , nums.length - 1);
    }
}
