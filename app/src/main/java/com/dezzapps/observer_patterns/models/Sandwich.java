package com.dezzapps.observer_patterns.models;

import java.util.ArrayList;

public class Sandwich implements Subjet {


    public boolean isReady;

    private ArrayList<Observer> orders = new ArrayList<Observer>();


    @Override
    public void register(Observer o) {

        orders.add(o);

    }

    @Override
    public void unRegister(Observer o) {

        orders.remove(o);

    }

    @Override
    public boolean getReady() {
        return isReady;
    }

    @Override
    public void setReady(boolean b) {

        this.isReady = b;

    }

    @Override
    public void notifyObserver() {

        for(Observer o: orders){
            o.update();
        }

    }
}
