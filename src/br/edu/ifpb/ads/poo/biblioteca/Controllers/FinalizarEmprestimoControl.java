/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.ads.poo.biblioteca.Controllers;

import br.edu.ifpb.ads.poo.biblioteca.Dao.BibliotecaDAO;
import br.edu.ifpb.ads.poo.biblioteca.Entidades.Aluno;
import br.edu.ifpb.ads.poo.biblioteca.Entidades.Emprestimo;
import br.edu.ifpb.ads.poo.biblioteca.Entidades.Funcionario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class FinalizarEmprestimoControl {

    BibliotecaDAO bibliotecaDAO;

    /**
     * Cria um FinalizarEmprestimoControl que serve para controlar um
     * FinalizarEmprestimoFrame
     *
     * @throws IOException error de arquivos
     */
    public FinalizarEmprestimoControl() throws IOException {
        this.bibliotecaDAO = new BibliotecaDAO();
    }

    /**
     * Esse metodo fasculha nos sistemas atrás de emprestimos procurando por,
     * CPFs, Matriculas, ISBN, titulos e altores que sejão iguais a "palavra"
     *
     * @param palavra palavra a ser procurada
     * @return Retorna uma lista de Emprestimos existentes nos arquivos
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public List<Emprestimo> procurarGeral(String palavra) throws IOException, ClassNotFoundException {
        List<Emprestimo> respos = new ArrayList<>();
        List<Aluno> alunos = bibliotecaDAO.getAnulos();
        List<Funcionario> funcionarios = bibliotecaDAO.getFuncionarios();
        List<Emprestimo> emprestimos = new ArrayList<>();

        for (Aluno i : alunos) {
            emprestimos.addAll(i.getEmprestimo());
        }

        for (Funcionario i : funcionarios) {
            emprestimos.addAll(i.getEmprestimo());
        }

        for (Emprestimo i : emprestimos) {
            if (i.getUsuario().getCPF().equals(palavra) || i.getUsuario().getMatricula().equals(palavra)
                    || i.getExemplares().getLivro().getISBN().equals(palavra)
                    || i.getExemplares().getLivro().getTitulo().equals(palavra)) {
                respos.add(i);
            }

            List<String> nova = i.getExemplares().getLivro().getAutores();

            for (String j : nova) {
                if (j.equals(palavra)) {
                    respos.add(i);
                    break;
                }
            }
        }

        return respos;
    }

    /**
     * Esse metodo retorna uma lista com todos emprestimos de todos usuarios
     *
     * @return Retorna uma lista de Emprestimos existentes nos arquivos
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public List<Emprestimo> procurarGeral() throws IOException, ClassNotFoundException {
        List<Aluno> alunos = bibliotecaDAO.getAnulos();
        List<Funcionario> funcionarios = bibliotecaDAO.getFuncionarios();
        List<Emprestimo> emprestimos = new ArrayList<>();

        for (Aluno i : alunos) {
            emprestimos.addAll(i.getEmprestimo());
        }

        for (Funcionario i : funcionarios) {
            emprestimos.addAll(i.getEmprestimo());
        }

        return emprestimos;
    }

    /**
     * Esse metodo vasculha nos sistemas atrás de emprestimos procurando por,
     * CPFs e Matriculas que sejão iguais a "palavra"
     *
     * @param palavra palavra a ser procurada
     * @return Retorna uma lista de Emprestimos existentes nos arquivos
     * @throws IOException error de arquivo
     * @throws ClassNotFoundException error de classe
     */
    public List<Emprestimo> procurarUsuario(String palavra) throws IOException, ClassNotFoundException {
        List<Emprestimo> respos = new ArrayList<>();
        List<Aluno> alunos = bibliotecaDAO.getAnulos();
        List<Funcionario> funcionarios = bibliotecaDAO.getFuncionarios();
        List<Emprestimo> emprestimos = new ArrayList<>();

        for (Aluno i : alunos) {
            emprestimos.addAll(i.getEmprestimo());
        }

        for (Funcionario i : funcionarios) {
            emprestimos.addAll(i.getEmprestimo());
        }

        for (Emprestimo i : emprestimos) {
            if (i.getUsuario().getCPF().equals(palavra) || i.getUsuario().getMatricula().equals(palavra)) {
                respos.add(i);
            }
        }

        return respos;
    }

    /**
     * Esse metodo vasculha nos sistemas atrás de emprestimos procurando por
     * ISBN, titulos e altores que sejão iguais a "palavra"
     *
     * @param palavra palavra a ser procurada
     * @return Retorna uma lista de Emprestimos existentes nos arquivos
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public List<Emprestimo> procurarLivro(String palavra) throws IOException, ClassNotFoundException {
        List<Emprestimo> respos = new ArrayList<>();
        List<Aluno> alunos = bibliotecaDAO.getAnulos();
        List<Funcionario> funcionarios = bibliotecaDAO.getFuncionarios();
        List<Emprestimo> emprestimos = new ArrayList<>();

        for (Aluno i : alunos) {
            emprestimos.addAll(i.getEmprestimo());
        }
        
        for (Funcionario i : funcionarios) {
            emprestimos.addAll(i.getEmprestimo());
        }
        
        for (Emprestimo i : emprestimos) {
            if (i.getExemplares().getLivro().getISBN().equals(palavra)
                    || i.getExemplares().getLivro().getTitulo().equals(palavra)) {
                respos.add(i);
            }
            
            List<String> nova = i.getExemplares().getLivro().getAutores();
            
            for (String j : nova) {
                if (j.equals(palavra)) {
                    respos.add(i);
                    break;
                }
            }
        }
        
        return respos;
    }
}
