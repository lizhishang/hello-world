package com.zhishang;

/*
 * Static Proxy
 * Proxy role and target role
 * @project_name    hello-world
 * @author          zhishangli
 * @time            09:25 2019-01-27
 */
public class StaticProxy {
    public static void main(String[] args) {
        new ParachuteCompany(new Target()).jump();
    }
}
// They should implement this interface.
interface parachute{
    void jump();
}
// Target role
class Target implements parachute{
    @Override
    public void jump() {
        System.out.println("I am so afraid to jump out without parachute.");
    }
}
// Proxy role
class ParachuteCompany implements parachute{
    private Target you;

    public ParachuteCompany(Target you) {
        this.you = you;
    }

    @Override
    public void jump() {
        prepare();
        you.jump();
        System.out.println("Relax. We will give you a parachute.");
        makeTargetSafeLand();
    }

    private void prepare(){}

    private void makeTargetSafeLand(){}
}
