package com.pengbo.mydemo.常用算法.tree;

public class Tree {
/*

    //二叉树的递归遍历 
    void Traverse(TreeNode treeNode) {
        if (treeNode != null) {
            //语句visit(treeNode.data);的位置①、②、③
            //____①____          //对应 先序遍历 
            Traverse(treeNode.left);
            //____②____          //对应 中序遍历 
            Traverse(treeNode.left);
            //____③____          //对应 后序遍历 
        }
    }


    //二叉树的中序非递归算法
    void InorderTraverse(TreeNode treeNode) {
        InitStack(S);
        p = treeNode;      //初始化栈
        while (p || !StackEmpty(S)) {    //p非空 或 栈非空
            if (p) {
                push(S, p);
                p = p.left;
            } //入栈，左走到底
            else {
                Pop(S, p);
                visit(p.data);
                p = p.right;     //出栈，右走一步
            }
        }
    }


    //二叉树的层次遍历  ，（与广度优先 类似？）
    void LevelTraverse(TreeNode treeNode) {
        InitQueue(Q);   //初始化队列Q
        if (treeNode != null) EnQueue(Q, treeNode);   //根指针若非空，入队列
        while (!QueueEmpty(Q)) {   //若队列非空
            DeQueue(Q, p);
            visit(p.data);   //弹出一个赋给p，访问p
            if (p.left) EnQueue(Q, p.left);   //p左子树非空，入队列
            if (p.right) EnQueue(Q, p.right);   //p右子树非空，入队列
        }
    }


    //二叉树的深度的递归算法 
    int Depth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return 1 + Math.max(Depth(treeNode.left), Depth(treeNode.right));  //大者加1
    }


    //二叉树的深度的非递归算法（采用层次遍历的思想，用数组模拟） 
    int Depth1(TreeNode treeNode) {
        //if(!treeNode) return 0; //空树 和第10行 重复 
        int front = -1, rear = -1;  //队列的头和尾
        int last = 0, level = 0;   //last指像每一层的最后一个元素（神奇的last用法），level统计层数
        TreeNode[] Q = new TreeNode[100];  //maxsize够用就行
        if (treeNode != null) Q[++rear] = treeNode;  //根非空，根节点入队列，尾进头出，入队列++rear、出++front
        while (front < rear) {   //队列非空还有元素 
            TreeNode p = Q[++front];    //弹出一个，开始
            if (p.left != null) Q[++rear] = p.left;   //左孩子入队列
            if (p.right != null) Q[++rear] = p.right;   //右孩子入队列
            if (front == last) {  //访问到每层的最后一个结点了---------------  
                level++;      //层数+1                              /|\（除去这3行就 
                last = rear;    //更新last指针，下一层的最后一个结点   |   是层次遍历的 
            }                 // ----------------------------------\|/-- 非递归了 )                                  
            //并且 Max（rear-last） 就是树的最大“广度（宽度）“算法了 
            return level;
        }
        return 0;
    }


    //二叉树的叶子数统计递归算法 
    //method①：全局变量 
    int num = 0;

    void leaf(TreeNode treeNode) {
        if (treeNode != null) {
            if (treeNode.left == null && treeNode.right == null)
                num++;
            leaf(treeNode.left);
            leaf(treeNode.right);
        }
    }

    //method②：
    int leaf1(TreeNode treeNode) {
        if (treeNode == null) return 0;
        else if (treeNode.left == null && treeNode.right == null)
            return 1;
        else
            return leaf1(treeNode.left) + leaf1(treeNode.right);
    }


    //二叉树的中序线索化递归算法
    void InOrderThreading(TreeNode Thrt, TreeNode treeNode) {
        Thrt.ltag = 0;                    //准备前奏
        Thrt.rtag = 1;
        Thrt.right = Thrt;
        if (treeNode != null) {
            Thrt.left = treeNode;
            TreeNode pre = Thrt;
            InThreading(treeNode);    //核心，中序线索化
            pre.rtag = 1;
            pre.right = Thrt;   //打完收工
            Thrt.right = pre;
        }
    }
*/
/*

    void InThreading(TreeNode p) {
        if (p!=null) {
            //_____①_____
            InThreading(p.left);
            if (p.left==null) {
                p.ltag = 1;
                p.left = pre;
            }
            //线索p的前驱（p的左）-------|
            if (!pre.right) {
                pre.rtag = 1;
                pre.right = p;
            }
            //线索pre的后继（pre的右）   ②
            pre = p;
            //同步p、pre，--------------|
            //将②处的代码放到①处，即是前序线索化
            InThreading(p.right);
        }
    }
*//*



    //二叉树的复制递归算法 
    void CopyTree(TreeNode T1, TreeNode T2) {
        //对每一子树先复制根结点，再分别复制左右子树（前序遍历的思想） 
        if (T1 == null) T2 = null;
        else {
            T2 = new TreeNode();
            T2.val = T1.val;
            CopyTree(T1.left, T2.left);
            CopyTree(T1.right, T2.right);
        }
    }


    //二叉树的对称交换（所有结点左右子树交换） 
    void Swap(TreeNode treeNode) {
        if (treeNode != null) {
            //交换 左右
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;

            Swap(treeNode.left);
            Swap(treeNode.right);
        }
    }
*/


}

