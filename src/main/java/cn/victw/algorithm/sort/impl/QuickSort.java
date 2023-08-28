package cn.victw.algorithm.sort.impl;

import cn.victw.algorithm.sort.Compare;
import cn.victw.algorithm.sort.SortService;

/**
 *
 * @author vincent
 */
public class QuickSort<T> implements SortService<T> {

    @Override
    public T[] doSort(T[] rawData, Compare<T> compare) {
        doQuickSort(rawData, compare, 0, rawData.length - 1);
        return rawData;
    }

    /**
     * 快排实现
     *
     */
    private void doQuickSort(T[] rawData, Compare<T> compare, int lowIndex, int heightIndex) {
        if (lowIndex >= heightIndex) {
            return;
        }
        // 获取基准点
        int pivot = partition(rawData, compare, lowIndex, heightIndex);

        System.err.println("-----");
        // 处理左分支
        doQuickSort(rawData, compare, lowIndex, pivot - 1);
        
        // 处理右分支
        doQuickSort(rawData, compare, pivot + 1, heightIndex);
    }

    /**
     * 数组切分
     *
     */
    private int partition(T[] rawData, Compare<T> compare, int lowIndex, int heightIndex) {
        int i = lowIndex, j = heightIndex + 1;
        // 以第一个作为基准点, 
        T v = rawData[lowIndex];
        while (true) {
            // 从左向右扫描,找出有几个比第一个大
            while (compare.compare(rawData[++i], v) < 0) {
                if (i == heightIndex) {
                    break;
                }
            }
            //从右向左扫描, 找出有几个比第一个小
            while (compare.compare(v, rawData[--j]) < 0) {
                if (j == lowIndex) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }

            System.err.println("i:j =" + i + ":" + j);
            exchange(rawData, i, j);
        }
        exchange(rawData, lowIndex, j);
        return j;
    }

}
