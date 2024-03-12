package com.nhnacademy.thread4_;

public class SharedCountV1 {    
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //synchronized 추가시 동기화 가능
    public void increment() {
        synchronized(this){
            setCount(getCount() + 1);
        }
    }


}
