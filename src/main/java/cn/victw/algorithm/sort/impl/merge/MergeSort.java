package cn.victw.algorithm.sort.impl.merge;

import cn.victw.algorithm.sort.SortService;

public interface MergeSort<T> extends SortService<T> {


    default void merge(T[] rawData, int lowIndex, int midIndex, int heightIndex) {

    }

}
