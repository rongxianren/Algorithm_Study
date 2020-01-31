package com.rongxianren.algorithm.search;

import com.rongxianren.algorithm.search.impl.BinarySearch;
import com.rongxianren.algorithm.search.inter.Search;

public class SearchClient {
    public static void main(String[] args) {
        int[] data = {4, 5, 6, 3, 2, 1};
        int[] data1 = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        Search search = new BinarySearch();
        int result = search.search(data1, 8);
        System.out.println("search result is " + result);
    }
}
