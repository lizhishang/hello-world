package com.zhishang.gof.flyweight;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 22:42 2019-02-02
 */
public class Client {
    public static void main(String[] args) {
        ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("black");
        ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("black ");
        System.out.println(chess1);
        System.out.println(chess2);

        chess1.display(new Coordinate(1, 1));
        chess2.display(new Coordinate(2, 2));
    }
}
