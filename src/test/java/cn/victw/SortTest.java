package cn.victw;

import cn.victw.algorithm.sort.SortProxy;
import cn.victw.algorithm.sort.SortService;
import cn.victw.algorithm.sort.impl.BubbleSort;
import cn.victw.algorithm.sort.impl.InsertionSort;
import cn.victw.algorithm.sort.impl.SelectionSort;
import cn.victw.algorithm.sort.impl.ShellSort;
import junit.framework.TestCase;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class SortTest
        extends TestCase {


    public void test() {
        System.out.println("原数组:");
        Integer[] array = new Integer[]{12, 54, 23, -1, 67, 9, 11, 24, 55, 90, 22};
        outArray(array);
        sort(array, new BubbleSort<>(), "冒泡");
        sort(array, new InsertionSort<>(), "插入");
        sort(array, new SelectionSort<>(), "选择");
        sort(array, new ShellSort<>(), "希尔");
    }

    private void sort(Integer[] array, SortService<Integer> sortService, String msg) {
        System.out.println();
        SortService<Integer> o = (SortService<Integer>) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{SortService.class}, new SortProxy(sortService));
        System.out.println(msg + "正序:");
        Integer[] toAscSort = Arrays.copyOf(array, array.length);
        Integer[] integersAsc = o.doSort(toAscSort, (x1, x2) -> x1 - x2);
        outArray(integersAsc);
        System.out.println();
        System.out.println(msg + "倒序:");
        Integer[] toDescSort = Arrays.copyOf(array, array.length);
        Integer[] integersDesc = o.doSort(toDescSort, (x1, x2) -> x2 - x1);
        outArray(integersDesc);
    }

    private void outArray(Integer[] arr) {
        for (Integer integer : arr) {
            System.out.print(integer + "\t");
        }
    }
}
