package com.pengbo.mydemo.常用算法.sort;

import java.util.Arrays;

public class QuickSort {

	public static void sort(int[] arr) {
		System.out.println("quick sort begin");
		quickSort(arr, 0, arr.length - 1);
		System.out.println("quick sort end");
	}

	private static void quickSort(int[] arr, int begin, int end) {
		int temp = arr[begin];
		int low = begin;
		int high = end;

		while (low < high) {
			while (low < high && arr[high] >= temp) {
				high--;
			}
			arr[low] = arr[high];
			while (low < high && arr[low] <= temp) {
				low++;
			}
			arr[high] = arr[low];
		}
		// 一趟快排完成
		arr[low] = temp;
		//System.out.println(Arrays.toString(arr));

		// 左半部分继续快排
		if (begin < low - 1) {
			quickSort(arr, begin, low - 1);
		}
		// 右半部分继续快排
		if (low + 1 < end) {
			quickSort(arr, low + 1, end);
		}
	}

	public static void main(String[] args) {
		int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
		int[] arrbak = arr.clone();
        // print origin array
		System.out.println(Arrays.toString(arr));

		// my code
		sort(arr);
		System.out.println(Arrays.toString(arr));

		// 官方code
		Arrays.sort(arrbak);
		System.out.println(Arrays.toString(arrbak));
	}
}
