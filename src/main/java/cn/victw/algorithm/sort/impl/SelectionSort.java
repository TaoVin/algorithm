package cn.victw.algorithm.sort.impl;

import cn.victw.algorithm.sort.Compare;
import cn.victw.algorithm.sort.SortService;

/**
 * 选择排序
 *
 * @param <T>
 */
public class SelectionSort<T> implements SortService<T> {

    public T[] doSort(T[] rawData, Compare<T> compare) {
        int minIndex = 0;
        // 控制每个数循环次数， n 个数需要比较n-1次
        for (int i = 0; i < rawData.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < rawData.length; j++) {
                if (compare.compare(rawData[minIndex], rawData[j]) > 0) {
                    minIndex = j;
                }
            }
            exchange(rawData, i, minIndex);
        }
        return rawData;
    }
}
