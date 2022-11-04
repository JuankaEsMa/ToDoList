package com.guillelanka.todolist;

import java.util.List;

public class Lista {
    String name;
    List<Tarea> listaTareas;

    Lista(String name, List<Tarea> listaTareas){
        this.name = name;
        this.listaTareas = listaTareas;
    }

    public Lista() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", listaTareas=" + listaTareas +
                '}';
    }
}
