package cn.victw.algorithm.sort.impl;

import cn.victw.algorithm.sort.Compare;
import cn.victw.algorithm.sort.SortService;

/**
 * 希尔排序
 *
 * @param <T>
 */
public class ShellSort<T> implements SortService<T> {
    @Override
    public T[] doSort(T[] rawData, Compare<T> compare) {
        int length = rawData.length;
        int h = 1;
        // 算出切3段，算出间隔
        while (h < length / 3) {
            h = h * 3 + 1;
        }
        // 分段排序
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && compare.compare(rawData[j], rawData[j - h]) < 0; j -= h) {
                    exchange(rawData, j, j - h);
                }
            }
            h /= 3;
        }
        return rawData;
    }
}
