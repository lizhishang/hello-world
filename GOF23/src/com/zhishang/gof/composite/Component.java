package com.zhishang.gof.composite;

/**
 * 抽象组件
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 17:11 2019-02-02
 */
public interface Component {
    void operation();
}
//叶子组件
interface Leaf extends Component {

}
//容器组件
interface Composite extends Component {
    void add(Component c);
    void remove(Component c);
    Component getChild(int index);
}
