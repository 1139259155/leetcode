package com.pengbo.mydemo.常用算法.graph;

public class Graph {/*

//    poj2349
//①prim实现 ac代码
//    MinSpanTree_PRIM.cpp

#define MAX 1000000
    struct node {
        int x;
        int y;
    };
    float dis( node a, node b )           *//* 计算两点之间距离 *//*
    {
        return(sqrt( (float) ( (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y) ) ) );
    }
    double prim( float a[505][505], int b, int c )
    {
        int i, j, flag;        *//* flag记录最大或最小值所在的列 *//*
        double max;
        float temp[505];
        float mincost[505];          *//* 生成树 *//*
        int visited[505];
        for ( i = 0; i < b; i++ )
        {
            temp[i] = a[0][i];      *//* temp保存矩阵的第一行 *//*
            visited[i] = 0;         *//* 初始化visited数组 *//*
        }
        visited[0] = 1;                 *//* 访问第一个点 *//*
        for ( i = 0; i < b - 1; i++ )
        {
            flag = 0;
            for ( j = 0; j < b; j++ )
                if ( !visited[j] )
                {
                    flag = j; *//* flag 初值为 第一个未被访问的点所在的列 *//*
                    break;
                }
            for ( j = 0; j < b; j++ )
                if ( temp[j] < temp[flag] && (!visited[j]) )
                {
                    flag = j;                                               *//* flag为最小值所在的列 *//*
                }
            mincost[i] = temp[flag];
            visited[flag] = 1;                                                      *//* 已访问 *//*
            temp[flag] = MAX;                                                       *//*  *//*
            for ( j = 0; j < b; j++ )
                temp[j] = temp[j] <= a[flag][j] ? temp[j] : a[flag][j];         *//* temp保存最小的 *//*
        }
        for ( i = 0; i < c; i++ )                                                       *//*选出第c大的边 *//*
        {
            flag = 0;
            max = mincost[0];
            for ( j = 0; j < b; j++ )
                if ( mincost[j] > max )
                {
                    max = mincost[j];
                    flag = j; *//* 最大值所在列 *//*
                }
            mincost[flag] = 0;
        }
        return(max);
    }
    int main()
    {
        int test_n, wx, n;      *//* 测试数、卫星数、据点数 *//*
        node site[505];         *//* 据点数组 *//*
        float matrix[505][505];
        float d[505];           *//* 结果数组 *//*
        int i, j, k;
        scanf( "%d", &test_n );
        for ( i = 0; i < test_n; i++ )
        {
            scanf( "%d %d", &wx, &n );
            for ( j = 0; j < n; j++ )
                scanf( "%d %d", &site[j].x, &site[j].y );
            for ( j = 0; j < n; j++ ) *//* 初始化 矩阵 *//*
            {
                matrix[j][j] = MAX;
                for ( k = j + 1; k < n; k++ )
                    matrix[j][k] = matrix[k][j] = dis( site[j], site[k] );
            }
            d[i] = prim( matrix, n, wx );   *//*  *//*
        }
        for ( i = 0; i < test_n; i++ )
            printf( "%0.2f\n", d[i] );      *//* 输出d[] *//*
        return(0);
    }


②kruskal思想，未ac，思想是对的 仅供参考和自己备忘
    MinSpanTree_KRUSKAL.cpp

#include <stdio.h>
    struct node {
        int x;
        int y;
    };
    node find( int a[100][100], int b, int c )      *//* 在数组a，b范围内找元素c，返回c的x、y坐标 *//*
    {
        node t;
        int i, j;
        int flag = 0;
        for ( i = 0; i < b; i++ )
        {
            for ( j = i; j < b; j++ )
                if ( a[i][j] == c )
                {
                    t.x = i;
                    t.y = j;
                    flag = 1;
                }
            if ( flag )
                break;
        }
        return(t);
    }
    void kruskal( int m[100][100], int n )
    {
        int i, j;
        int x, y, t1, t2;
        int flag, temp;
        int a[100][100];        *//* a用来表示连通分量，每一行表示一个连通分量 *//*
        int b[100], t = 0;      *//* b记录所有边值 *//*
        int mincost[100];       *//* 生成树 *//*
        *//* for test2  可省略 *//*
        printf( "for test2\n" );
        for ( i = 0; i < n; i++ )
        {
            for ( j = 0; j < n; j++ )
                printf( "%-2d ", m[i][j] );
            printf( "\n" );
        }                               *//* end test2 *//*
        for ( i = 0; i < n; i++ )       *//* 遍历m，记录保存所有边值于b[] *//*
        {
            for ( j = i + 1; j < n; j++ )
                if ( m[i][j] )
                    b[t++] = m[i][j];
        }
        for ( i = 0; i < n; i++ ) *//* 初始化a，有图的顶点数个分量，即每个顶点都是一个分量 *//*
        {
            a[i][i] = i + 1;
            for ( j = i + 1; j < n; j++ )
                a[i][j] = a[j][i] = 0;
        }
        *//* for test3 可省略 *//*
        printf( "for test3\n" );
        for ( i = 0; i < t; i++ )
        {
            printf( "%-2d ", b[i] );
        }
        printf( "\n" );
        *//* end test3 *//*
        *//* for test4 可省略 *//*
        printf( "for test4\n" );
        for ( i = 0; i < n; i++ )
        {
            for ( j = 0; j < n; j++ )
                printf( "%-2d ", a[i][j] );
            printf( "\n" );
        }   *//* end test4 *//*
        *//* sort(b,n);  给边值b数组，按边值排序，简单选择排序 *//*
        for ( i = 0; i < t; i++ )
        {
            flag = i;
            for ( j = i + 1; j < t; j++ )
                if ( b[j] < b[flag] )
                    flag = j;
            temp = b[i];
            b[i] = b[flag];
            b[flag] = temp;
        }
        *//* for test5 看排序成功否 可省略 *//*
        printf( "for test5\n" );
        for ( i = 0; i < t; i++ )
        {
            printf( "%-2d ", b[i] );
        }
        printf( "\n" );
        *//* end test5 *//*
        int count = 0;                          *//*  *//*
        for ( i = 0; i < t; i++ )
        {
            x = (find( m, n, b[i] ).x) + 1; *//* 找b[i] 在数组m中的 行数 *//*
            y = (find( m, n, b[i] ).y) + 1; *//* 找b[i] 在数组m中的 列数 *//*
            *//*      for test 可省略 *//*
            *//*      printf("x:%d ",x); *//*
            *//*      printf("y:%d ",y); *//*
            *//*      printf("\n"); *//*
            t1 = find( a, n, x ).x;
            t2 = find( a, n, y ).x;
            if ( t1 > t2 )
            {
                temp = t1; t1 = t2; t2 = temp;
            }
            *//*      for test 可省略 *//*
            *//*      printf("t1:%d ",t1); *//*
            *//*      printf("t2:%d ",t2); *//*
            *//*      printf("\n"); *//*
            if ( t1 != t2 )
            {
                mincost[count++] = b[i];
                *//* combine(a,t1,t2); 合并a的第t1、t2行，即连通分量合并 *//*
                for ( j = 0; j < n; j++ )
                    a[t1][j] = a[t1][j] > a[t2][j] ? a[t1][j] : a[t2][j];
            }
        }
        *//* show minsoct 输出构成生成树的边 *//*
        for ( i = 0; i < count; i++ ) *//*  *//*
        {
            printf( "(%d->%d):", find( m, n, mincost[i] ).x + 1, find( m, n, mincost[i] ).y + 1 );
            printf( "%d\n", mincost[i] );
        }
        printf( "\n" );
    }
    int main()
    {
        int i, j;
        int matrix[100][100] = { { 0,  28, 0,  0,  0,  10, 0  },
        { 28, 0,  16, 0,  0,  0,  14 },
        { 0,  16, 0,  12, 0,  0,  0  },
        { 0,  0,  12, 0,  22, 0,  18 },
        { 0,  0,  0,  22, 00, 25, 24 },
        { 10, 0,  0,  0,  25, 0,  0  },
        { 0,  14, 0,  18, 24, 0,  0  } };
        *//* for test1 可省略 *//*
        for ( i = 0; i < 7; i++ )
        {
            for ( j = 0; j < 7; j++ )
                printf( "%-2d ", matrix[i][j] );
            printf( "\n" );
        }   *//* end test1 *//*
        kruskal( matrix, 7 );
        return(0);
    }


③测试用例
    http://poj.org/showmessage?message_id=147268*/
}
