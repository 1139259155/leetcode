package com.pengbo.mydemo.常用算法.sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
        int[] arr=new int[]{3, 1, 5, 7, 2, 4, 9, 6};
        System.out.println("begin: "+Arrays.toString(arr));
        new HeapSort().heapsort(arr);
        System.out.println("end: "+Arrays.toString(arr));
	}

	private void heapsort(int[] arr) {
		// 初始建堆： 从 最后一个拥有叶子节点的元素 向前遍历建堆，从右到左，从下到上
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjustHeap(arr, i, arr.length - 1);
            System.out.println("i="+i+","+ Arrays.toString(arr));
		}

		// 交换首尾元素，重新从根节点开始调整
		for (int j = arr.length - 1; j > 0; j--) {
			swap(arr, 0, j);
			adjustHeap(arr, 0, j - 1);
		}
	}

	/**
	 * 调整堆
	 * @param arr
	 * @param begin 开始坐标
	 * @param end   结束坐标
	 */
	private void adjustHeap(int[] arr, int begin, int end) {
		// 从上到下依次调整堆，以数组[begin...end]的元素作为堆
		// 如果flag不是最后一个非叶子节点 2*begin+1<end
		while (2 * begin + 1 <= end) {
			int leftChildIndex = 2 * begin + 1;
			int rightChildIndex = 2 * begin + 2;
			int maxChildIndex = rightChildIndex > end || arr[leftChildIndex] >= arr[rightChildIndex]
					? leftChildIndex
					: rightChildIndex;
			if (arr[begin] >= arr[maxChildIndex]) {
				break;
			} else {
				swap(arr, begin, maxChildIndex);
				begin = maxChildIndex;
			}
		}

	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
