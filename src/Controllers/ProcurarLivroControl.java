/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.BibliotecaDAO;
import Entidades.Exemplares;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @version 1.0
 * @author Wensttay
 */
public class ProcurarLivroControl {
    private BibliotecaDAO bibliotecaDAO;
    private List<Exemplares> exemplares_Lista;
    private Exemplares exemplares;
    /**
     * Cria um ProcuadorDeLivroControl para a pagina ProcuradordeLivroFrame
     * @throws IOException error de arquivos
     */
    public ProcurarLivroControl() throws IOException {
        this.bibliotecaDAO = new BibliotecaDAO();
    }
    
    /**
     * Esse metodo faz uma busca nos arquivos atraz de um livro iguao ao passado
     * @param palavra Palavra a ser pesquisada dentre os livros
     * @return retorn o Exemplar do livro, caso não encontre retorna null
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public Exemplares procurarLivro(String palavra) throws IOException, ClassNotFoundException{
        this.setExemplares_Lista(this.getBibliotecaDAO().getExemplares());
        for(Exemplares i : getExemplares_Lista()){
            if(i.getLivro().getISBN().equals(palavra) || i.getLivro().getTitulo().equals(palavra)){
                return i;
            }
        }
        JOptionPane.showMessageDialog(null, "Livro não encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    /**
     * @return the bibliotecaDAO
     */
    public BibliotecaDAO getBibliotecaDAO() {
        return bibliotecaDAO;
    }

    /**
     * @return the exemplares_Lista
     */
    public List<Exemplares> getExemplares_Lista() {
        return exemplares_Lista;
    }

    /**
     * @return the exemplares
     */
    public Exemplares getExemplares() {
        return exemplares;
    }

    /**
     * @param bibliotecaDAO the bibliotecaDAO to set
     */
    public void setBibliotecaDAO(BibliotecaDAO bibliotecaDAO) {
        this.bibliotecaDAO = bibliotecaDAO;
    }

    /**
     * @param exemplares_Lista the exemplares_Lista to set
     */
    public void setExemplares_Lista(List<Exemplares> exemplares_Lista) {
        this.exemplares_Lista = exemplares_Lista;
    }

    /**
     * @param exemplares the exemplares to set
     */
    public void setExemplares(Exemplares exemplares) {
        this.exemplares = exemplares;
    }

}