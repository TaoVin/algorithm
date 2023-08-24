package cn.victw.algorithm.sort.impl;

import cn.victw.algorithm.sort.Compare;
import cn.victw.algorithm.sort.SortService;

/**
 * 查询排序
 *
 * @param <T>
 */
public class InsertionSort<T> implements SortService<T> {

    @Override
    public T[] doSort(T[] rawData, Compare<T> compare) {
        for (int i = 1; i < rawData.length; i++) {
            for (int j = i; j > 0 && compare.compare(rawData[j], rawData[j - 1]) < 0; j--) {
                exchange(rawData, j, j - 1);
            }
        }
        return rawData;
    }
}
