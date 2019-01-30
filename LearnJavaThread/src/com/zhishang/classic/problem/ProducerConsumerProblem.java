package com.zhishang.classic.problem;

/*
 * The producer–consumer problem (also known as the bounded-buffer problem)
 * A classic example of a multi-process synchronization problem
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            16:44 2019-01-27
 */
public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Container container = new Container();
        new Thread(new Producer(container)).start();
        new Thread(new Consumer(container)).start();
    }
}
//producer
class Producer extends Thread {
    Container container;

    public Producer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        //Produce
        for (int i = 0; i < 1000; ++i) {
            container.push(new Product(i));
            System.out.println("produce a product");
        }
    }
}
//consumer
class Consumer extends Thread {
    Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; ++i) {
            container.pop();
            System.out.println("buy a product");
        }
    }
}
//Container
class Container {
    private Product[] products = new Product[10];
    private Integer count = 0;

    public synchronized void push(Product product) {
        if (count == products.length){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products[count] = product;
        count++;
        this.notifyAll();
    }

    public synchronized Product pop() {
        if (count < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        this.notifyAll();
        return products[count];
    }
}
//product
class Product {
    Integer id;

    public Product(Integer id) {
        this.id = id;
    }
}