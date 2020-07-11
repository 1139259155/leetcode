package com.pengbo.mydemo.常用算法.kmp;

public class KMP {
    KMP算法
            改进后的KMP算法
    主要是求next域
    //串的模式匹配算法（即子串在主串中出现的第一个位置）  时间复杂度O（n+m）  最坏时间复杂度O（n*m）
    int Index(SString S,SString T,int pos){
        int i= pos, j=1;
        while(i <= S[0] && j <=T[0]){
            //第0号单元存放串的长度S[0],T[0]
            if(S[i]==T[j]) { i++; j++; }
            else{ i=i-j+2; j=1; }
        }
        if(j>T[0])  return i-T[0]; //查找成功并返回位置
        else return 0;             //查找失败
    }
    //改进后的KMP算法 ，时间复杂度为O(n+m),最坏也是(n+m)
    int Index_KMP(SString S,SString T,int pos){
        int i=pos,j=1;
        while(i<=S[0]&&j<=T=T[0]){
            if(i==0||S[i]==T[j]){i++;j++;}
            else j=next[j];    //利用next域进行指针后退，减少后退次数
        }
        //（ps：但前提是求next 域值，每个子串都有自己的独特的next域值，与主串无关）
        if(j>T[0])
            return i-T[0];
        else return 0;
    }
//next函数的含义：next[j]=k 表明当前模块（即子串）中的第j 个字符与主串中的第 i 个字符 “失配”时，
//               就应该从模式（子串）中的第k个字符（k<j）重新开始和i对齐比较.
//next域的求法：eg：子串 “abaabcac”
//       |= 0;  当j=1时      |      j     |  1    2    3    4    5    6    7    8  |
//next[]=|= 1;    j=2        |   模式串   |  a    b    a    a    b    c    a    c  |
//       |= 具体分析； j>2   |  k=next[j] |  0    1    1    2    2    3    1    2  |
//
//         当j=1时；    当j=2时；     当j=3时；    当j=4；        ....   当j=6；        ....
//      ↓               ↓              ↓             ↓                       ↓
// 主串：b ******       ac *****      abb*****     abab*****             abaaba***
// 子串：abaabcac       abaabcac      abaabcac     abaabcac       ....   abaabcac       ....
//      ↑（失配）        ↑（失配）       ↑（失配）      ↑（失配）                ↑（失配）
//
//       next[1]=0；    next[2]=1；   next[3]=1；  next[4]=2；    ....   next[6]=3；    ....
//       右移一位        右移一位        右移两位


}
