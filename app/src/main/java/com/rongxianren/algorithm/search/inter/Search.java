package com.rongxianren.algorithm.search.inter;

public abstract class Search {
    /**
     * @param data
     * @param element
     * @return 找到对应元素则返回下标位置 否则返回-1
     */
    public abstract int search(int[] data, int element);
}
