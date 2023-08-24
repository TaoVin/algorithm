package cn.victw.algorithm.sort.impl.merge;

import cn.victw.algorithm.sort.Compare;

import java.util.Arrays;

/**
 * 自底向上的归并排序
 * 排序步骤
 * [0, 1] [2,3] [4, 5]....[n-2, n-1]
 * [0, 1, 2, 3][4,5, 6, 7] .... [n -4, n -3, n-2, n-1]
 * .....
 * [0,..., n-1]
 *
 * @param <T>
 */
public class MergeDownToTopSort<T> implements MergeSort<T> {
    @Override
    public T[] doSort(T[] rawData, Compare<T> compare) {
        T[] temp = Arrays.copyOfRange(rawData, 0, rawData.length);
        int length = rawData.length;
        // 把数组分成n份，每个元素为1组
        for (int itemLength = 1; itemLength < length; itemLength += itemLength) {
            for (int lo = 0; lo < length - itemLength; lo += itemLength + itemLength) {

            }

        }
        return null;
    }
}
