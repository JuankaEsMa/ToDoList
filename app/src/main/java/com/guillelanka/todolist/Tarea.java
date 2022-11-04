package com.guillelanka.todolist;

public class Tarea {
    String key;
    String name;
    boolean completada;

    Tarea(){

    }
    Tarea(String name){
        this.name = name;
        this.completada = false;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }


}
