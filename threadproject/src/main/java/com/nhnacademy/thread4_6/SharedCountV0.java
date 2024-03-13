package com.nhnacademy.thread4_;

public class SharedCountV0 {    
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //synchronized 추가시 동기화 가능
    public synchronized void increment() {
        setCount(getCount() + 1);
    }
}
