package com.pengbo.mydemo.常用算法.backtrack;

public class BackTrack {
/*

    int site[20], b[20], c[40], d[40];      */
/* 全局数组 site：n皇后摆放的列；（n皇后有2n-1条 主、副对角线。2n-1<40） *//*

    */
/* b、c、d： 用来判断 列、主、副对角 冲突 *//*

    void output()                           */
/* 待优化的输出布局 *//*

    {
        for ( int i = 0; i < 20; i++ )
            if ( site[i] != 0 )
                */
/* for(int i=0;i<20&&site[i]!=0;i++) *//*

                printf( "%d ", site[i] );
        printf( "\n" );
    }
    int isValid( int i, int j, int n )
    {
        if ( b[j] == 0 && c[i - j + n] == 0 && d[i + j] == 0 ) */
/*不在同列，不在同一主、副对角线 *//*

            return(1);
        else return(0);
    }
    void backtrack( int i, int n )                          */
/* 回溯搜索摆放位置（深度优先思想） *//*

    {
        for ( int j = 1; j <= n; j++ )                  */
/* 第i个皇后有n种摆放位置  ------------------- *//*

            if ( isValid( i, j, n ) )                   */
/*                                 | *//*

            {                                           */
/* 第i个皇后默认摆放第i行            | *//*

                site[i] = j;                            */
/* 第i个皇后摆放第j列  坐标（i,j）； | *//*

                */
/*                                 | *//*

                b[j] = 1;                               */
/* 第j列被占领                      | *//*

                c[i - j + n] = 1; d[i + j] = 1;         */
/* 第i-j+n ，i+j主副对角线被占领,|主对角线编号从1~2n-1，副从2~2n *//*

                */
/*         | *//*

                if ( i < n )                            */
/* n个皇后未摆放完                             | *//*

                    backtrack( i + 1, n );              */
/* 摆放下一个，神齐的递归开始，|深度优先思想，以下代码进入堆栈------ *//*

                else                                    */
/*                        |                            /|\ *//*

                    */
/*                       \|/ (以及未执行完的             | *//*

                    output();                           */
/*                                 for循环也进入递归)    |                                                    //                                                      | *//*

                */
/*                                                      | *//*

                b[j] = 0;                               */
/*                                                      | *//*

                c[i - j + n] = 0;                       */
/*                                                     \|/ *//*

                d[i + j] = 0;                           */
/* --------------------------------------------------------- *//*

            }
    }
    void main()
    {
        int n;
        printf( "input n:" );           */
/* 2n-1<40 -> n<=20 *//*

        scanf( "%d", &n );
        for ( int i = 1; i <= n; i++ )  */
/* 初始化数组 *//*

        {
            site[i] = 0; b[i] = 0;
            c[i] = 0; c[i + n] = 0;
            d[i] = 0; d[i + n] = 0;
        }
        backtrack( 1, n );  */
/* 开始回溯搜索摆放位置 *//*

    }

*/


}
