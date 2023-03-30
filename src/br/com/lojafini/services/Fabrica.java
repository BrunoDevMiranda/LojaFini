package br.com.lojafini.services;



import br.com.lojafini.data.model.Ingrediente;

import java.util.ArrayList;
import java.util.List;

public class Fabrica {

    private String nome;

    private List<Ingrediente> ingredientes;

    public Fabrica(String nome) {
        this.nome = nome;
        this.ingredientes = new ArrayList<>();
    }

    public void colocarIngredientes(Ingrediente ingrediente){
        this.ingredientes.add(ingrediente);
    }

    public List<Ingrediente> getIngredientes(){
        return ingredientes;
    }



}
