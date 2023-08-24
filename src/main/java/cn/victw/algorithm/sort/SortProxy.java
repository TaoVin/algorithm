package cn.victw.algorithm.sort;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 */
public class SortProxy implements InvocationHandler {

    private SortService sortService;

    public SortProxy(SortService sortService) {
        this.sortService = sortService;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(sortService, args);
    }


}
