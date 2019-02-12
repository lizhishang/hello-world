package com.zhishang.gof.adapter;

/**
 * 对象适配器
 */
public class AdapterV2 implements Target{
    private Adaptee adaptee;

    public AdapterV2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleReq() {
        adaptee.request();
    }
}
