/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.BibliotecaDAO;
import Entidades.Exemplares;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author wensttay <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class CriarEmprestimoControl {

    BibliotecaDAO bibliotecaDAO;
    List<Exemplares> exemplares;

    /**
     * Cria um CriarEmprestimoControl que serve para controlar um
     * CriarEmprestimoFrame
     *
     * @throws IOException error de arquivos
     */
    public CriarEmprestimoControl() throws IOException {
        this.bibliotecaDAO = new BibliotecaDAO();
    }

    /**
     * Esse metodo faz uma busca nos arquivos atras de Exemplares que contenham
     * ISBN ou titulo iguais a "palavra"
     *
     * @param palavra palavra a ser procurada
     * @return Retorna uma lista de exemplares que contem alguma caracteristica
     * iguais a "palavra"
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public List<Exemplares> procurarExemplar(String palavra) throws IOException, ClassNotFoundException {
        this.exemplares = bibliotecaDAO.getExemplares();
        List<Exemplares> aux = new ArrayList<>();

        for (Exemplares i : exemplares) {
            if (i.getLivro().getISBN().equals(palavra)) {
                aux.add(i);
            } else if (i.getLivro().getTitulo().equals(palavra)) {
                aux.add(i);
            } else {
                for (String j : i.getLivro().getAutores()) {
                    if (j.equals(palavra)) {
                        aux.add(i);
                        break;
                    }
                }
            }
        }

        return aux;
    }

}
