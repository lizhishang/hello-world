package com.zhishang.gof.flyweight;

/**
 * 享元类
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 22:29 2019-02-02
 */
public interface ChessFlyWeight {
    void setColor(String color);
    String getColor();
    void display(Coordinate coordinate);
}

class ConcreteChess implements ChessFlyWeight {
    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate coordinate) {
        System.out.println("chess color:" + color + "," +
                " site (" + coordinate.getX() + "," + coordinate.getY() + ")");
    }
}