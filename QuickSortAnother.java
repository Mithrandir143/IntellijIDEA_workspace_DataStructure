package quicksorttest;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.awt.font.NumericShaper;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Mithrandir
 * @date 2021-03-2021/3/27-21:36
 */
public class QuickSortAnother {
    public static void main(String[] args) {
        int[] arr={1,6,5,4,3,2,9,1};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 随机将一个数字放至其合适的位置，并对该位置左右两区间进行排序
     * @param arr 待排序的数组
     * @param left 数组的左端
     * @param right 数组的右端
     */
    private static void quicksort(int[] arr,int left,int right) {
        if(left>=right){
            return;
        }
        int mid=partition(arr,left,right);
        quicksort(arr, left, mid-1);
        quicksort(arr, mid+1, right);
    }

    /**
     * 这个要完成的功能是对数组内的一个随机数字安排至合适的位置，并以该位置为根据将数组分为左右区间
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] arr, int left, int right) {

        Random random = new Random();
        //来区间内位置的一个随机位置
        int tmpIndex=random.nextInt(right-left+1)+left;
        //将该位置的数字放到数组的最右侧
        swap(arr,tmpIndex,right);
        //定义一个索引
        int index=left;
        for(int i=left;i<right;i++){
            if(arr[i]<arr[right]){//凡是小于我们的随机数的值，一律从左开始排
                swap(arr, i, index++);
            }
        }
        //此时，index左侧的所有值，均小于随机数，将随机数放到index的位置
        swap(arr,index, right);
        return index;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
