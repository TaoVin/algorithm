package cn.victw.algorithm.sort.impl.merge;

import cn.victw.algorithm.sort.Compare;
import cn.victw.algorithm.sort.SortService;
import java.util.Arrays;

public interface MergeSort<T> extends SortService<T> {

    default T[] createTempArray(T[] rawData) {
        T[] tempArrays = Arrays.copyOfRange(rawData, 0, rawData.length);
        return tempArrays;
    }

    default void mergeSort(T[] rawData, T[] tempArray, int lowIndex, int midIndex, int heightIndex, Compare<T> compare) {
        int left_pos = lowIndex;
        int right_pos = midIndex + 1;
        int temp_pos = lowIndex;

        while (left_pos <= midIndex && right_pos <= heightIndex) {
            if (compare.compare(rawData[left_pos], rawData[right_pos]) > 0) {
                tempArray[temp_pos++] = rawData[left_pos++];
            } else {
                tempArray[temp_pos++] = rawData[right_pos++];
            }
        }
        while (left_pos <= midIndex) {
            tempArray[temp_pos++] = rawData[left_pos++];
        }

        while (right_pos <= heightIndex) {
            tempArray[temp_pos++] = rawData[right_pos++];
        }

        while (lowIndex <= heightIndex) {
            rawData[lowIndex] = tempArray[lowIndex];
            lowIndex++;
        }
    }

}
