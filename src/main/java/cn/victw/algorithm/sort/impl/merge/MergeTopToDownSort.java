package cn.victw.algorithm.sort.impl.merge;

import cn.victw.algorithm.sort.Compare;

/**
 * 自顶向下归并排序, 递归实现
 */
public class MergeTopToDownSort<T> implements MergeSort<T> {

    @Override
    public T[] doSort(T[] rawData, Compare<T> compare) {
        T[] tempArray = createTempArray(rawData);

        doMergeSort(rawData, tempArray, 0, rawData.length - 1, compare);

        return rawData;
    }

    private void doMergeSort(T[] rawData, T[] tempArray, int lowIndex, int heightIndex, Compare<T> compare) {
        if (lowIndex >= heightIndex) {
            return;
        }
        // 算出mid Index
        int midIndex = lowIndex + (heightIndex - lowIndex) / 2;
        doMergeSort(rawData, tempArray, lowIndex, midIndex, compare);
        doMergeSort(rawData, tempArray, midIndex + 1, heightIndex, compare);
        mergeSort(rawData, tempArray, lowIndex, midIndex, heightIndex, compare);
    }
}
