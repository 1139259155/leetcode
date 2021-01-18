package com.pengbo.mydemo.常用算法.sort;

public class Sort {
    /*
    1.排序：
    插入排序：直接插入排序、折半插入排序、希尔排序
    交换排序：冒泡排序、快速排序
    选择排序：简单选择排序、堆排序（&堆的调整过程）
    归并排序：2-路归并排序
    基数排序：
            （不稳定的排序：希尔、快速、简单选择、堆排）
            2.查找：
    二叉平衡树的调整过程（增、删）
    折半查找，二叉排序树查找、散列（Hash）查找（构造哈希表and函数、处理冲突的方法）

    //直接插入排序(Direct insertion sort)
    void D_I_Sort(ElemType a[], int n) {
        for (i = 2; i <= n; i++)     //从第2 个元素开始比较，第一个元素默认有序
            if (a[i] < a[i - 1]) {   //如果小于前一号元素
                a[0] = a[i];      //a[0]有2个作用：①作为临时存储单元，用于交换位置
                //   ②作为哨兵或监视哨，用于防止寻找插入点时候下标越界
                for (j = i - 1; a[0] < a[j]; j--)   // 寻找插入点，j不会越界，因为一定能找到a[0]
                    a[j + 1] = a[j];           //后移元素
                a[j + 1] = a[0];               //在插入点插入
            }
    }


    //冒泡排序BubbleSort
    void Bubble_Sort(ElemType a[], int n) {
        for (i = 0; i < n - 1; i++) {
            flag = false;
            for (j = n - 1; j > i; j--)
                if (a[j - 1] > a[j]) {
                    swap(a[j - 1], a[j]);
                    flag = true;
                }
            if (flag == false)
                return;
        }
    }

*/
}
