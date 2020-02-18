package com.dezzapps.observer_patterns.models;

public interface Subjet {

    void register(Observer o);
    void unRegister(Observer o);
    void notifyObserver();

    boolean getReady();
    void setReady(boolean b);
}
