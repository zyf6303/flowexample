package yxm.zyf.love.arithmetic;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

public class Arithmetic {

    /**
     * 计算：给一个整数数组，找到两个数使得他们的和等于一个给定的数,假设只有一组答案
     * */
    @Test
    public void test() {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = 15;
        System.out.println(Arrays.toString(twoSum1(a, target)));
        System.out.println(Arrays.toString(twoSum2(a, target)));
    }

    //方法一：复杂度O(n^2)
    public int[] twoSum1(int a[], int target) {
        int targetA = target / 2;
        int targetB = 0;
        int A = 0, B = 0;//A大，B小
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > targetA) {
                A = i;
                break;
            }
        }
        for (int i = A; i < a.length - 1; i++) {
            for (int j = A; j >= 0; j--) {
                B = a[j];
                A = a[i];
                if (A + B == target) {
                    targetB = A + B;
                    int[] result = { i, j };
                    return result;
                }
            }
            if (targetB == target) {
                break;
            }
            A++;
        }
        int[] result = {};
        return result;
    }

    //方法二：复杂度O(n)
    public int[] twoSum2(int[] numbers, int target) {
        //用一个hashmap来记录，key记录target-numbers[i]的值，value记录numbers[i]的i的值，如果碰到一个
        //numbers[j]在hashmap中存在，那么说明前面的某个numbers[i]和numbers[j]的和为target，i和j即为答案
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                int[] result = { map.get(numbers[i]), i };
                return result;
            }
            map.put(target - numbers[i], i);
        }

        int[] result = {};
        return result;
    }
}
