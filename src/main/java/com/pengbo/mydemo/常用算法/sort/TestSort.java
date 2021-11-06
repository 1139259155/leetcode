package com.pengbo.mydemo.常用算法.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author pengbo
 * @since 2021年10月31日20:21:05
 */
public class TestSort {
	private static final DecimalFormat df = new DecimalFormat("0.00%");

	/**
	 * 加载实例，完成测试
	 */
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 1000; i++) {
			// 1. generate array which length: 0~1000 and max number is 10000, and print it
			int[] arr = generateArray((int) (Math.random() * 1000), 10000);
			int[] arrbak = arr.clone();
			System.out.println(Arrays.toString(arr));

			// 2. sort array

			// 待测试的排序算法
			// Class[] sortedCode = new Class[]{QuickSort.class, HeapSort.class,
			// MergeSort.class};
			Class[] sortedCode = new Class[]{QuickSort.class};
			for (Class cls : sortedCode) {
				Method sortMethod = cls.getMethod("sort");
				sortMethod.invoke(cls, arr);
			}

			// 3. check sorted array and print it
			int result = checkSortedArray(arr, arrbak);
			if (result != -1) {
				System.out.println("error, the position is: " + result);
			}
			System.out.println(Arrays.toString(arr));
		}
	}

	/**
	 * 校验数组是否递增排列
	 * @param arr
	 * @param arrbak
	 * @return
	 */
	private static int checkSortedArray(int[] arr, int[] arrbak) {
		if (arr.length != arrbak.length) {
			return arr.length;
		}
		// 使用官方排序算法校验
		Arrays.sort(arrbak);

		// 比较自实现的排序算法结构和官方算法结果
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != arrbak[i])
				return i;
		}
		return -1;
	}

	/**
	 * 生成随机数组
	 *
	 * @param len
	 * @param range
	 * @return
	 */
	private static int[] generateArray(int len, int range) {
		if (len < 1) {
			return null;
		}
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int) (Math.random() * range);
		}
		return arr;
	}

}