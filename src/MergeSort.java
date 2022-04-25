public class MergeSort extends BaseSort{
    @Override
    public void sort(int[] nums) {
        int l = 0, r = nums.length - 1;
        mergeSort(nums, l, r);
    }
    // 0               5
    // 37 6 67    4 11 26
    private void mergeSort(int[] nums, int l, int r){
        if(l >= r){
            return;
        }
        int mid = (r - l) >> 1 + l;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, r, mid);
    }

    public static void main(String[] args) {
        int[] nums = getNums();
        printNums(nums);
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(nums);
        printNums(nums);
    }

    private void merge(int[] nums, int left, int right, int mid){
        int[] newarr = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while(i <= mid && j <= right){
            newarr[index ++] = nums[i] > nums[j] ? nums[j ++] : nums[i ++];
        }
        while(i <= mid){
            newarr[index ++] = nums[i++];
        }
        while(j <= right){
            newarr[index ++] = nums[j++];
        }
        for(int k = 0; k < newarr.length; k ++){
            nums[left + k] = newarr[k];
        }
    }
}
