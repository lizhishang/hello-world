package com.zhishang.gof.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 22:36 2019-02-02
 */
public class ChessFlyWeightFactory {
    //享元池
    private static Map<String, ChessFlyWeight> map = new HashMap<>();

    public static ChessFlyWeight getChess(String color) {
        if (map.get(color) != null) {
            return map.get(color);
        } else {
            ChessFlyWeight weight = new ConcreteChess(color);
            map.put(color, weight);
            return weight;
        }
    }
}
