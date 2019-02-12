package com.zhishang.gof.iterator;

/**
 * 自定义迭代接口
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 12:42 2019-02-04
 */
public interface MyIterator {
    void first();
    void next();
    boolean hasNext();
    boolean isFirst();
    boolean isLast();
    Object getCurrentObj();
}
