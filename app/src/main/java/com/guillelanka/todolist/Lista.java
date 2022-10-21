package com.guillelanka.todolist;

import java.util.List;

public class Lista {
    String name;
    int tareaCounter;
    List<Tarea> listaTareas;

    Lista (String name){

    }
    Lista(String name, List<Tarea> listaTareas){

    }

    public Lista() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTareaCounter() {
        return tareaCounter;
    }

    public void setTareaCounter(int tareaCounter) {
        this.tareaCounter = tareaCounter;
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "name='" + name + '\'' +
                ", tareaCounter=" + tareaCounter +
                ", listaTareas=" + listaTareas +
                '}';
    }
}
