package com.zhishang.thread;

import java.util.ArrayList;
import java.util.List;

/*
 * TODO
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            14:50 2019-01-27
 */
public class GrabVotesThread {
    public static void main(String[] args) {
        List<Integer> available = new ArrayList<Integer>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(4);
        available.add(5);
        available.add(7);
        available.add(8);

        List<Integer> seats1 = new ArrayList<Integer>();
        seats1.add(3);
        seats1.add(4);
        seats1.add(5);
        List<Integer> seats2 = new ArrayList<Integer>();
        seats2.add(1);
        seats2.add(2);
        seats2.add(5);

        Cinema cinema = new Cinema(available);
        new Thread(new Customer(cinema, seats1)).start();
        new Thread(new Customer(cinema, seats2)).start();
    }
}
class Customer extends Thread {
    Cinema cinema;
    List<Integer> count;

    public Customer(Cinema cinema, List<Integer> count){
        this.cinema = cinema;
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Boolean flag = cinema.bookTicket(count);
            if (flag) {
                System.out.println("You has booked " + count + " tickets");
            } else {
                System.out.println("Fail");
            }
        }
    }
}
class Cinema {
    private List<Integer> totalSeatCount;
    private List<Integer> availableSeatCount;

    public Cinema(List<Integer> totalSeatCount) {
        this.totalSeatCount = totalSeatCount;
        this.availableSeatCount = totalSeatCount;
    }

    public boolean bookTicket(List<Integer> count) {
        System.out.println("can book" + availableSeatCount);
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(availableSeatCount);
        copy.removeAll(count);
        if (availableSeatCount.size() - copy.size() == count.size()) {
            availableSeatCount.removeAll(count);
            return true;
        } else {
            return false;
        }
    }
}
