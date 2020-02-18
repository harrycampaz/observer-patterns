package com.dezzapps.observer_patterns.models;

public class Order implements Observer {

    private Subjet subjet = null;

    public Order(Subjet s){
        this.subjet = s;
    }

    @Override
    public String update() {
        if(subjet.getReady()){
            subjet.unRegister(this);

            return "Tu orden esta lista";
        }else {
            return  "Tu orden esta en preparacion";
        }
    }
}
