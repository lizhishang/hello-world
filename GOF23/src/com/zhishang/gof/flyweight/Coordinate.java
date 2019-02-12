package com.zhishang.gof.flyweight;

/**
 * 外部状态UnSharedConcreteFlyWeight
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 22:31 2019-02-02
 */
public class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
