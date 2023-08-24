package cn.victw.algorithm.sort;


/**
 * 排序接口服务定义，代理主体
 *
 * @param <T>
 */
public interface SortService<T> {

    /**
     * 执行排序
     *
     * @param rawData 原数组
     * @param compare 比较器
     * @return
     */
    T[] doSort(T[] rawData, Compare<T> compare);

    /**
     * 数组交换位置
     *
     * @param rawData     数据源
     * @param firstIndex  下标1
     * @param secondIndex 下标2
     */
    default void exchange(T[] rawData, Integer firstIndex, Integer secondIndex) {
        T temp = rawData[firstIndex];
        rawData[firstIndex] = rawData[secondIndex];
        rawData[secondIndex] = temp;
    }
}
