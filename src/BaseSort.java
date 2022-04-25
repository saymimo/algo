
import java.util.Random;

public abstract class BaseSort {
    public abstract void sort(int[] nums);

    public static int[] getNums(){
        int length = 10;
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            Random random = new Random();
            nums[i] =  random.nextInt(100);
        }
        return nums;
    }

    public static void printNums(int[] nums){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            str.append(nums[i]);
            str.append(" ");
        }
        System.out.println(str);
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
