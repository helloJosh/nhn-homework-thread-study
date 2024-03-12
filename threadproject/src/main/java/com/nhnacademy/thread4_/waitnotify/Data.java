package com.nhnacademy.thread4_.waitnotify;

public class Data {
    private String packet;
    private boolean transfer = true;

    public synchronized String receive(){
        while(transfer){
            try{
                wait();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        transfer = true;

        String returnPacket = packet;
        notifyAll();
        return returnPacket;
    }
    public synchronized void send(String packet){
        while(!transfer){
            try{
                wait();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();

            }
        }
        transfer = false;
        this.packet = packet;
        notifyAll();
    }
    public static void main(String[] args) {
        Data data = new Data();

        Thread sender = new Thread(new Sender(data));
        Thread receiver1 = new Thread(new Receiver(data));
        Thread receiver2 = new Thread(new Receiver(data));

        sender.start();
        receiver1.start();
        receiver2.start();
    }
}
