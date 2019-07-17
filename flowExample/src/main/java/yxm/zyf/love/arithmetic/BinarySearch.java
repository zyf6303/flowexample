package yxm.zyf.love.arithmetic;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

public class BinarySearch {
    public static BinarySearch getInstance() {
        return new BinarySearch();
    }

    /**
     * 二分查找
     * */

    public int BSearch(int a[], int length, int value) {
        return BSearchFor(a, 0, length - 1, value);
    }

    private int BSearchFor(int[] a, int begin, int end, int value) {//a是查询的数组,
        if (begin > end) return -1;
        int mid = begin + ((end - begin) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            mid++;
            return BSearchFor(a, mid, end, value);
        } else {
            mid--;
            return BSearchFor(a, begin, mid, value);
        }
    }

    public static void main(String[] args) {
        int[] a = { 12, 11, 3, 4, 5, 6, 7, 8, 9 };
        Arrays.sort(a);
        int value = 11;
        System.out.println(BinarySearch.getInstance().BSearch(a, a.length, value));
    }
    
    /**
     * 冒泡排序
     * */
    private static void sort(int a[]) {
        for (int i=0 ; i<a.length-1;i++) {
            for (int j = i + 1; j < a.length; j++) {
                int tmp = a[i];
                if (a[i] > a[j]) {
                    a[i] = a[j];
                    a[j] = tmp;
                }
                for (int k : a) {
                    System.out.print(k+" ");
                }
                System.out.println();
            }
        }
    }
    
    @Test
    public void testSort(){
        int[] a = { 12, 11, 9, 8, 7, 6, 5, 4, 3 };
        sort(a);
    }
    
    // 冒泡排序，a 表示数组，n 表示数组大小
    public void bubbleSort(int[] a, int n, int[] b) {
      if (n <= 1) return;
     
     for (int i = 0; i < n; ++i) {
        // 提前退出冒泡循环的标志位
        boolean flag = false;
        int f=0;
        for (int j = 0; j < n - i - 1; ++j) {
          if (a[j] > a[j+1]) { // 交换
            int tmp = a[j];
            a[j] = a[j+1];
            a[j+1] = tmp;
            flag = true;  // 表示有数据交换      
          }
          for (int k : a) {
              System.out.print(k+" ");
          }
          System.out.print(",");
          sortcompare(b,i,f++);
        }
        if (!flag) break;  // 没有数据交换，提前退出
      }
    }
    
    private static void sortcompare(int a[],int i,int j) {
                int tmp = a[i];
                if (a[i] > a[j]) {
                    a[i] = a[j];
                    a[j] = tmp;
                }
                for (int k : a) {
                    System.out.print(k+" ");
                }
                System.out.println();
            j++;
    }
    
    @Test
    public void testSort2(){
        int[] a = { 12, 11, 9, 8, 7, 6, 5, 4, 3 };
        int[] b = { 12, 11, 9, 8, 7, 6, 5, 4, 3 };
        BinarySearch.getInstance().bubbleSort(a, a.length,b);
    }

}
