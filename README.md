# leetcode530
# 个人用来刷Leetcode的

#### 简单题直接看答案做到滚瓜烂熟

#### 中等题自己做总结思路是重点 要做到看一眼反映出思路方法

#### 困难题没事看着玩就行了

会统计一些思路在下面，就是做完题总结出“为什么我会想到用这个方法做？”

---



| 题号                                    |             关键点              | 刷题指数 |
| :-------------------------------------- | :-----------------------------: | -------- |
| 剑指offer24 反转链表                    |             双指针              | 🌟        |
| 69求平方根                              |           二分法查找            | 🌟        |
| **剑指offer03**                         |             hashset             | 🌟        |
| **20**有效括号                          |               栈                | 🌟        |
| **155**最小栈                           |               栈                | 🌟        |
| **160**多数元素                         |             hashmap             | 🌟🌟       |
| **26**删除排序数组的重复元素            |             双指针              | 🌟        |
| **136**只出现一次的数字                 |             位运算              | 🌟🌟🌟      |
| **344**反转字符串                       |             双指针              | 🌟        |
| **141**判断链表有环                     |        双指针，快慢指针         | 🌟🌟       |
| **14**找最长公共前缀                    |            字符串API            | 🌟        |
| **9**判断回文数                         |             双指针              | 🌟        |
| **226** 翻转二叉树                      |             二叉树              | 🌟🌟🌟🌟🌟    |
| **114**二叉树展开为链表                 |             二叉树              | 🌟🌟🌟      |
| **116**填充每个节点的下一个右侧节点指针 |             二叉树              | 🌟🌟🌟      |
| **92**反转链表                          |         双指针 递归也行         | 🌟🌟🌟      |
| **654**创造最大二叉树                   |              递归               | 🌟🌟🌟      |
| **652**二叉树重复子树                   |           二叉树 递归           | 🌟🌟🌟      |
| **230**寻找第k小的元素                  |           二叉树 递归           | 🌟🌟🌟      |
| **538**BST转累加树                      |            BST 递归             | 🌟🌟🌟      |
| **98**验证二叉搜索树                    |             BST递归             | 🌟🌟🌟      |
| **700**搜索二叉树中的搜索               |             BST递归             | 🌟🌟🌟      |
| **701**搜索二叉树插入                   |             BST递归             | 🌟🌟🌟      |
| **450**删除搜索二叉树某个元素           |             BST递归             | 🌟🌟🌟🌟     |
| **297**二叉树的序列化于反序列化         |           二叉树 递归           | 🌟🌟🌟🌟     |
| **236**最近公共祖先                     |           二叉树 递归           | 🌟🌟🌟      |
| **222**求完全二叉树的节点数             | 二叉树 递归 完全二叉树 满二叉树 | 🌟🌟🌟      |
| **146**LRU缓存机制                      |             设计题              | 🌟🌟🌟🌟🌟    |
| **496**下一个更大元素                   |             单调栈              | 🌟🌟🌟      |
| **739**每日温度                         |             单调栈              | 🌟🌟🌟      |
| **503**环形数组中下一个更大元素         |             单调栈              | 🌟🌟🌟      |
| **239**滑动窗口最大值                   |         单调栈 双端队列         | 🌟🌟🌟🌟     |
| **232**用栈实现队列                     |               栈                | 🌟        |
| **875**猪b吃香蕉                        |             二分法              | 🌟🌟🌟      |

## 😁模板速记

### 反转链表

```java
// 反转以 a 为头结点的链表
ListNode reverse(ListNode a) {
    ListNode pre, cur, nxt;
    pre = null; cur = a; nxt = a;
    while (cur != null) {
        nxt = cur.next;
        // 逐个结点反转
        cur.next = pre;
        // 更新指针位置
        pre = cur;
        cur = nxt;
    }
    // 返回反转后的头结点
    return pre;
}

//反转a到b之间的链表 注意左闭右开
ListNode kReverse(ListNode a, ListNode b) {

        ListNode pre, nxt;
        pre = null;
        while (a != b) {
            nxt = a.next;
            a.next = pre;
            pre = a;
            a = nxt;
        }

        return pre;
    }
```

**其实第一个反转全部链表相当于，从反转头指针到null之间的链表，这样第二种就很好理解**

### 二叉树遍历模板

```java
/* 二叉树遍历框架 */
void traverse(TreeNode root) {
    // 前序遍历
    traverse(root.left)
    // 中序遍历
    traverse(root.right)
    // 后序遍历
}
```

二叉树的所有题，都离不开这个递归模板，只是具体操作放在哪的问题，在前序还是中序还是后序

### BST中序遍历就是升序打印

```java
void traverse(TreeNode root) {
    if (root == null) return;
    traverse(root.left);
    // 中序遍历代码位置
    print(root.val);
    traverse(root.right);
}
```

**如果想降序**

```java
void traverse(TreeNode root) {
    if (root == null) return;
    // 先递归遍历右子树
    traverse(root.right);
    // 中序遍历代码位置
    print(root.val);
    // 后递归遍历左子树
    traverse(root.left);
}
```

### 在二叉树中搜索一个元素

```java
boolean isInBST(TreeNode root, int target) {
    if (root == null) return false;
    if (root.val == target) return true;
    // 当前节点没找到就递归地去左右子树寻找
    return isInBST(root.left, target)
        || isInBST(root.right, target);
}
```

### BST中搜索一个元素

```java
boolean isInBST(TreeNode root, int target) {
    if (root == null) return false;
    if (root.val == target)
        return true;
    if (root.val < target) 
        return isInBST(root.right, target);
    if (root.val > target)
        return isInBST(root.left, target);
    // root 该做的事做完了，顺带把框架也完成了，妙
}
```

**搜索就是找到这个数，找到了就可以对这个数进行操作，类似更改，删除，添加。**

### BST遍历模板

```java
void BST(TreeNode root, int target) {
    if (root.val == target)
        // 找到目标，做点什么
    if (root.val < target) 
        BST(root.right, target);
    if (root.val > target)
        BST(root.left, target);
}
```

**如果涉及插入，需要有返回值，模板如下**

```java
TreeNode insertIntoBST(TreeNode root, int val) {
    // 找到空位置插入新节点
    if (root == null) return new TreeNode(val);
    // if (root.val == val)
    //     BST 中一般不会插入已存在元素
    if (root.val < val) 
        root.right = insertIntoBST(root.right, val);
    if (root.val > val) 
        root.left = insertIntoBST(root.left, val);
    return root;
}
```

### 递归问题灵魂三问

> 1. 这个函数是干嘛的
> 2. 这个函数参数重的变量是什么（一直在变化的是啥）
> 3. 得到函数的递归结果，你该干什么

### 单调栈

以“求每个数的右侧最大数”为例

```java
public int[] nextGreaterElement(int[] nums) {
        int[] answerArr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        //从后向前遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            //栈不是空的
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            //如果栈不空但 栈顶元素比当前元素大
            answerArr[i] = stack.isEmpty() ? -1 : stack.peek();
            //就把这个数放进去
            stack.push(nums[i]);
        }
        return answerArr;
    }
```

### 二分法查找的几个模板

```java
int binarySearch(int[] nums, int target) {
    int left = 0; 
    int right = nums.length - 1; // 注意

    while(left <= right) { // 注意
        int mid = (right + left) / 2;
        if(nums[mid] == target)
            return mid; 
        else if (nums[mid] < target)
            left = mid + 1; // 注意
        else if (nums[mid] > target)
            right = mid - 1; // 注意
        }
    return -1;
}
```

上面是第一种：找到了就返回，正中间那个数

```java
int left_bound(int[] nums, int target) {
    if (nums.length == 0) return -1;
    int left = 0;
    int right = nums.length; // 注意

    while (left < right) { // 注意
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            right = mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid; // 注意
        }
    }
    return left;
}
```

上面是第二种，有重复值的中间值，找左侧边界，比如【1，2，3，3，3，3，4】

```java
int right_bound(int[] nums, int target) {
    if (nums.length == 0) return -1;
    int left = 0, right = nums.length;

    while (left < right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            left = mid + 1; // 注意
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid;
        }
    }
    return left - 1; // 注意
}
```

上面是有重复值时候找右侧边界。

---



## 🤪LeetCode题目点评

> 觉得有必要的再具体写几句

### 9题 判断一个数是否是回文数

​	这题没啥难度没啥好总结的

### 14题 找最长公共前缀

​	这题主要复习一下str.charAt()  str.substring()

### 141题 判断链表有环

​	很经典，快慢指针，没难度，注意coding细节

### 415题🌟 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和

​	难度不大，但是处理思想和两个链表数相加比较相似，值得总结

### 136题🌟 只出现一次的数字

​	惊了！位运算也太骚了[看官方解答](https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/)

### 169题🌟 多数元素

​	两分钟AC但是性能不好，[解答中的分治算法可以看看](https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/)

### 160题🌟 相交链表

​	双指针太浪漫了，[思路值得学习](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)

### 26题 删除排序数组的重复元素

> ```txt
> 对于数组的问题，常用的方法是双指针，首先为什么要用双指针，就是为了把已处理和未处理的数组元素区分开，也就是说通过两个指针，把数组分成3个部分。对于同向双指针，通常[0...i)(注意看题目要求是闭区间还是开区间)表示已处理，[i,j)还未处理，只要明白双指针的本质是为了区分已处理和未处理，就能轻松写出代码，但需要注意区间是闭区间还是开区间。
> ```

​	题解区的这一段话值得仔细思考，数组的题我们应该首先想想双指针是否能做

### 226、114、116都是二叉树的

而且226的翻转二叉树虽然不难，但是他有重要的战略意义，就算是背也得背下来

### 92反转链表

双指针方法反转链表也有着同样的战略意义

### 25 K个一组反转链表

这道题递归思想很重要

### 654创造最大二叉树

需要截取数组时候不一定非要真的截取出来，可以传index，按照首尾index来取。这样不用额外的空间。

### 450删除BST某个元素

这道题很典型体现递归在二叉树中的应用，并且很练coding，建议多做几遍。

### 297序列化与反序列化

多做几遍，非常练习coding

### 236最近公共祖先

有点难理解，多看几遍有空

### 222完全二叉树的节点数

### 146LRU缓存设计

这题面试总是出现，最好是自己实现双向链表不要用LinkedHashMap

### 496、739很好地使用了单调栈

模板记住！

### 503下一个最大元素

当需要循环数组的时候，我们的思想应该是 **将数组长度变为二倍，再复制一个完整的接到末尾**

但实际操作不需要复制数组，**只需要将 for循环的 index *2 就行**

### 875二分法的几个模板都要记牢





