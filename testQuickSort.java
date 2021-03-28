package quicksorttest;

import org.junit.Test;
import org.omg.CORBA.RepositoryIdHelper;

import java.util.Arrays;

/**
 * 快速排序：
 *      给定一个数组，使其按照升序进行排序
 *      选定一个pivot，使得其左边的值小于该值，右边的值大于该值
 *      接着以pivot为分界点，将其分为左右两组，然后进行递归，直到每组仅一个值
 *      测试：80000个随机数据进行排序，计时0.02s
 * @author Mithrandir
 * @date 2021-01-2021/1/30-14:35
 */
public class testQuickSort {
    public static void main(String[] args) {
//        int[] arr = {1,6,5,4,3,2,9,1};
        long t1 = System.currentTimeMillis();
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]= (int) (Math.random()*80000);
        }
        quickSort(arr,0,arr.length-1);
        long t2 = System.currentTimeMillis();
        System.out.println("计时："+(t2-t1));
    }


    public static void quickSort(int[] arr,int l,int r){
        if(l<r){
            int left = l,right = r;
//            int pivot = arr[l];
            int pivot = arr[r];
            while (left<right){
//                while (left<right && arr[right]>=pivot){
//                    right--;
//                }
//                if(left<right){
//                    arr[left++] = arr[right];
//                }
                while (left<right && arr[left]<=pivot){
                    left++;
                }
                if(left< right){
                    arr[right--] = arr[left];
                }
                while (left<right && arr[right]>=pivot){
                    right--;
                }
                if(left<right){
                    arr[left++] = arr[right];
                }
            }
//            arr[right] = pivot;
            arr[left] = pivot;
            quickSort(arr, l, right-1);
            quickSort(arr, right+1, r);
        }
    }
    @Test
    public void test(){
        int[] arr = {1,6,5,4,3,2,9,1,48,54,8489,5341,651,1131,1351,8};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        int[] nums=new int[10];
        System.out.println(Arrays.toString(nums));
    }


//    public static void quickSort(int[] arr,int left, int right){
//        if(left >= right){
//            return;
//        }
//        int l = left;
//        int r = right;
//        int pivot = left;
//        while (l<r){
//            while (l<r && arr[r]>=arr[pivot]){
//                r--;
//            }
//            if(l<r){
//                arr[l]=arr[r];
//            }
//            while (l<r && arr[l]<=arr[pivot]){
//                l++;
//            }
//            if(l<r){
//                arr[r] = arr[l];
//            }
//            if(l>=r){
//                arr[l] = arr[pivot];
//            }
//        }
//        quickSort(arr, left, r-1);
//        quickSort(arr, r+1, right);
//    }



}
