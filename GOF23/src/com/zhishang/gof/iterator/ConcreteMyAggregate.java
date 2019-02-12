package com.zhishang.gof.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义聚合类
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 12:45 2019-02-04
 */
public class ConcreteMyAggregate {
    private List<Object> list = new ArrayList<>();

    public ConcreteMyAggregate(List<Object> list) {
        this.list = list;
    }

    public void add(Object o) {
        list.add(o);
    }

    public void remove(Object o) {
        list.remove(o);
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public MyIterator createIterator() {
        return new ConcreteIterator();
    }

    //使用内部类定义迭代器，可以直接使用外部类属性
    private class ConcreteIterator implements MyIterator{
        //定义游标
        private int cursor;

        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public void next() {
            if (hasNext()) cursor++;
        }

        @Override
        public boolean hasNext() {
            if (cursor < list.size()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public boolean isFirst() {
            return cursor == 0;
        }

        @Override
        public boolean isLast() {
            return cursor == (list.size() - 1);
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }
}
