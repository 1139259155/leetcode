package com.pengbo.mydemo.常用算法.list;

public class ListOper {
    线性表大杂烩（数组、链表、栈、队列）
            //       线性表        &     非线性表 —— 逻辑结构。
//eg：数组、链表、栈、队列       树、图
//    顺序表&链表 —— 存储结构。
//eg：数组   单链表
//线性表数据结构
            #define MaxSize 50
    struct Sqlist
    {
        int data[ MaxSize];
        int length;
    };

    //在数组（线性表）的第k个位置插入元素e
    void ListInsert(Sqlist &L, int k, int e) {
        for (int i = L.length; j >= k; j--)
            L.data[i] = L.data[i - 1];  //将第k个位置后的元素后移
        L.data[k - 1] = e;           //从后往前，后移元素，寻找插入点，插入
        L.length++;
    }

    //将线性表（数组）所有元素置逆，
//要求空间复杂度O(1),时间复杂度尽量小
    void Reverse(Sqlist &L) {
        for (i = 0; i < L.length / 2; i++)
            L.data[i] <->L.data[L.length - i - 1];
    }

    //删除数组中所有值为x的元素
//method_1:
    void Del_x(Sqlist &L, int x) {
        int k = 0;
        for (i = 0; i < L.length; i++)
            if (L.datap[i] != x) {
                L.data[k] = L.data[i];
                k++;
            }
        L.length = k;
    }

    //method_2:
    void Del_x(Sqlist &L, int x) {
        int k = 0;
        for (i = 0; i < L.length; i++)
            if (L.data[i] == x)
                k++;
            else L.data[i - k] = L.data[i];
        L.length -= k;
    }

    //删除 有序排列的数组 中 所有重复的元素
    void Delete_same(Sqlist &L) {
        for (i = 0, j = 1; j < L.length; j++)
            if (L.data[i] < L.data[j])
                L.data[++i] = L.data[j];
        L.length = i + 1;
    }

    //将数组的元素循环左移p位（2010 计算机联考真题）
//即：（A0,A1,...,Ap-1,Ap,Ap+1,...,An-1）->
//    （Ap,Ap+1,...,An-1,A0,A1,...,Ap-1）
//要求时间和空间尽可能高。
//时间复杂度O(n),空间O(1);
//实现思想：  eg：数组：abcdefgh  ，p=3
//Reverse(0,p-1) :cbadefgh    (A-1)B
//Reverse(p,n-1) :cbahgfed    (A-1)(B-1)
//Reverse(0,n-1) :defghabc    ((A-1)(B-1))-1 = BA
    void Reverse(int A[], int low, int high) {
        int i, temp;
        for (i = 0; i < (high - low + 1) / 2; i++)
            A[low + i] <->A[high - i];
    }

    void Converse(int A[], int n, int p) {
        Reserse(A, 0, p - 1);
        Reserse(A, p, n - 1);
        Reserse(A, 0, n - 1);
    }

    //两个“等长”的“升序” 数组A、B，求将A、B合并后的中位数
//实现思想：
// 分别求两个升序序列A、B的中位数，设为a和b
//①若a=b，则a或b即为所求中位数，return
//②若a<b，则舍弃A的较小一半 和 B的较大一半
//③若a>b，则舍弃A的较大一半 和 B的较小一半
//重复过程①②③，直到两个序列中均只含一个元素，较小者即为所求中位数
//链表 ：
    struct node

    {
        int data;
        struct node *next;
    }

    ;

    //将*s 插到 *p 前面
//可以采用另一种方式将其转化为后插操作来实现
//设待插结点为*s，将*s 插到 *p 前面
//我们仍然将将*s 插到 *p 后面，然后将p->data 与s->data 交换即可
//这样既满足了逻辑关系，又能使得时间复杂度为O(1);
//同样删除结点*p的操作也可以用删除*p的后继结点操作来实现，
//实质就是将其后继结点的值赋予其自身，然后删除后继结点，也能使时间复杂度为O(1)
//问题：设计一个尽可能高效的算法，找到链表中倒数第k个结点。
//基本思想：定义两个指针p、q，初始时候均指向链表的第一个结点，
//p沿链表移动，当p移动到 第k个结点时候，q开始和p同步移动，
//当p移动到最后一个结点时候，q正好指向倒数第k个结点。
//key point：保持p、q 的跨度为k，p移动到最后，q即指向倒数第k个。
//将链表里面的元素，从尾到头反向输出
    void Reverse_print(LinkList L) {
        if (L -> next != NULL)
            Reverse_print(L -> next); //递归
        print(L -> data);  //输出
    }

    //链表置逆，笔试，面试 （*常考）
    LinkList Reverse(LinkList &L) {
        p = L -> next;
        L -> next = NULL;   //断开
        while (p != NULL) {
            r = p -> next;   //保存下个结点
            p -> next = L -> next; //头插法
            L -> next = p;
            p = r;    //下一个next one
        }
        return L;
    }
//问题：设计一个算法是链表的中结点元素递增有序
//思想：直接插入排序思想，切成一个一个结点，然后直接插入排序
//
//待完成...
//
//问题：给定两个单链表，找出两个链表的公共结点
//
//待完成...
//
//问题：给定一个单链表，试写出算法：按递增次序输出单链表中的各个结点的数据元素。并释放结点所占的空间
//
//待完成...
//
//问题：删除数据元素递增有序的单链表中重复的元素
//
//待完成...
//
//问题：归并两条数据元素递增有序的单链表A、B，仍保持数据元素递增有序存放在A
//
//待完成...
//
//问题：判断带头结点的循环双向链表是否对称
//
//待完成...
//


}
