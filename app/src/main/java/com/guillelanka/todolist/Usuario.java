package com.guillelanka.todolist;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    String userKey;
    List<String> listaListas = new ArrayList<String>();
    int listCount = 0;

    Usuario(String key){
        userKey = key;
    }
    Usuario(List<Lista> listaListas){

    }


    public void addList(String nameLista){
        String lista = nameLista;
        listaListas.add(lista);
        this.listCount++;
    }

}
