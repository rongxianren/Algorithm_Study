#### 算法数据结构学习之旅

##### 排序算法
###### 三个衡量标准
* 1、是否是原地排序。
* 2、是否是稳定性排序。
* 3、时间复杂度。

###### 巧用哨兵简化编程难度。
* 这种利用哨兵简化编程难度的技巧在很多代码实现中都有用到，
  比如插入排序、归并排序、动态规划等

#### 排序算法分类
###### 时间复杂度O(n^2)的排序算法
* 1、冒泡排序

* 2、插入排序

* 3、选择排序

###### 时间复杂度O(nlogn)的排序算法
* 1、归并排序
    * 归并排序的时间复杂度为O(nlogn),但是由于他不是原地排序算法，空间复杂度为O(n)
    所以实际应用中很少选用他来实现排序算法。

* 2、快速排序
    * 快速排序的时间复杂度平均情况下是O(nlogn),当数据有序或者接近有序的时候
    时间复杂度退化到O(n^2)


###### 时间复杂度O(n)的线性排序算法
* 1、桶排序

* 2、计数排序

* 3、基数排序

---

#### 查找算法
##### 1、二分查找算法

##### 2、几种二分查找的变种
* （1）查找第一个等于给定值的元素

* （2）查找最后一个等于给定值的元素

* （3）查找第一个大于给定值的元素

* （4）查找最后一个小于给定值的元素

---

#### 跳表
* 跳表是为了在链接结构的数据存储格式下，实现二分查找。

---

#### 散列表
* 1、什么是散列函数？
    * 将元素key转换成散列数组下标的函数成为散列函数。

* 2、散列函数的三点基本设计要求
    * （1）散列函数计算得到的散列值是一个非负整数。
    * （2）如果 key1 = key2，那 hash(key1) == hash(key2)。
    * （3）如果 key1 ≠ key2，那 hash(key1) ≠ hash(key2)。（理想上是希望这样，但是实际上基本不可能）

* 3、散列冲突
    * 定义：不同的key通过散列函数得到的数组下标是一样的，即元素的存储位置冲突了。

    * 解决方法：
        * （1）开放地址法
            * (a) 线性探测
            * (b) 二次探测（改变探测的步长）
            * (c) 双重散列 使用一组散列函数 hash1(key)，hash2(key)，hash3(key)……我们先用第一个散列函数，如果计算得到的存储位置已经被占用，再用第二个散列函数，依次类推，直到找到空闲的存储位置
        * （2）链表法
    * 总结
        * 当数据量比较小、装载因子小的时候，适合采用开放寻址法。这也是 Java 中的ThreadLocalMap使用开放寻址法解决散列冲突的原因
        * 基于链表的散列冲突处理方法比较适合存储大对象、大数据量的散列表，而且，比起开放寻址法，它更加灵活，支持更多的优化策略，比如用红黑树代替链表。


---

#### 二叉树


---


#### 字符串匹配




---
#### 贪心

---

#### 分治

---

#### 回溯

---

#### 动态规划


---

#### 大数加减乘除运算

---
