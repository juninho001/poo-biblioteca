/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.ads.poo.biblioteca.Controllers;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class AdicionarExemplarControl {

    private List<String> autores;

    /**
     * Pega uma String contendo os autores de um livro e separa cada altor da
     * string para dentro de uma lista de strings
     *
     * @param autores uma String contendo um conjunto de Autores separados por
     * ";"
     * @return Retorna uma lista de String contendo os autores de um livro
     */
    public List<String> separar_Altores(String autores) {
        this.setAutores(new ArrayList<>());
        String autor = "";

        for (int i = 0; i < autores.length(); i++) {
            if (autores.charAt(i) != ';') {
                autor += autores.charAt(i);
            } else {
                this.getAutores().add(autor);
                autor = "";
            }
        }

        return this.getAutores();
    }

    /**
     * @return the autores
     */
    public List<String> getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(List<String> autores) {
        this.autores = autores;
    }
}
