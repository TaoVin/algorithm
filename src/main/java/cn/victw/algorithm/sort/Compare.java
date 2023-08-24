package cn.victw.algorithm.sort;


/**
 * 通用比较器
 *
 * @param <T>
 */
@FunctionalInterface
public interface Compare<T> {

    int compare(T first, T second);
}
