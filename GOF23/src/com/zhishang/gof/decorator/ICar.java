package com.zhishang.gof.decorator;

/**
 * 抽象接口
 */
public interface ICar {
    void move();
}

/**
 * 真实对象
 */
class Car implements ICar {
    @Override
    public void move() {
        System.out.println("simple car move out");
    }
}

/**
 * 装饰器
 */
class SuperCar implements ICar {
    private ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}
class FlyCar extends SuperCar {
    public FlyCar(ICar car) {
        super(car);
    }

    public void fly() {
        System.out.println("fly to sky");
    }
    @Override
    public void move() {
        super.move();
        fly();
    }
}
class WaterCar extends SuperCar {
    public WaterCar(ICar car) {
        super(car);
    }

    public void swim() {
        System.out.println("swim to sea");
    }
    @Override
    public void move() {
        super.move();
        swim();
    }
}
class AICar extends SuperCar {
    public AICar(ICar car) {
        super(car);
    }

    public void auto() {
        System.out.println("auto drive");
    }
    @Override
    public void move() {
        super.move();
        auto();
    }
}