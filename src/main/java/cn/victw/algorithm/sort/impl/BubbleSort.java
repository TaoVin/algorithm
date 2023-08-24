package cn.victw.algorithm.sort.impl;

import cn.victw.algorithm.sort.Compare;
import cn.victw.algorithm.sort.SortService;

/**
 * 冒泡排序
 *
 * @param <T>
 */
public class BubbleSort<T> implements SortService<T> {

    public T[] doSort(T[] rawData, Compare<T> compare) {
        // 控制每个数循环次数， n 个数需要比较n-1次
        for (int i = 0; i < rawData.length - 1; i++) {
            // 内部相邻两数相互比较， 做相应置换
            for (int j = 0; j < rawData.length - 1 - i; j++) {
                if (compare.compare(rawData[j], rawData[j + 1]) > 0) {
                    exchange(rawData, j, j + 1);
                }
            }
        }
        return rawData;
    }
}
