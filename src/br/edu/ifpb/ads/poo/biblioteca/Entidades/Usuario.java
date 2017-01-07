/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.ads.poo.biblioteca.Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public abstract class Usuario implements Serializable, Comparable<Usuario> {

    private String nome, endereco, email, matricula, CPF, telefone, senha, estado;
    private int limite_Livros, limite_Dias;
    private Date bloqueadoAte;
    private List<Emprestimo> emprestimo;

    /**
     * @param nome - Nome do Usuario
     * @param endereco - Endereço do Usuario
     * @param email - Email do Usuario
     * @param matricula - Matricula do Usuario
     * @param CPF - CPF do Usuario
     * @param telefone - Telefone do Usuario
     * @param senha - Senha do Usuario
     * @param limite_Dias - Quantidade Limite de dias que se pode ficar com um
     * livro do Usuario
     */
    public Usuario(String nome, String endereco, String email, String matricula, String CPF, String telefone, String senha, int limite_Dias) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.matricula = matricula;
        this.CPF = CPF;
        this.telefone = telefone;
        this.senha = senha;
        this.limite_Livros = Constans.DIAS_BLOQUEADOS;
        this.limite_Dias = limite_Dias;
        this.emprestimo = new ArrayList<>();
        this.bloqueadoAte = null;
        this.estado = "DESBLOQUEADO";
    }

    public void set_Estado_Entregar_Livro_Atasado(Emprestimo emprestimo) {
        this.estado = "BLOQUEADO";
        Date antigoBloqueadoAte = this.bloqueadoAte;
        if (antigoBloqueadoAte == null) {
            emprestimo.atualizarEstado();
            Date novobloqueadoAte = new Date();
            novobloqueadoAte.setTime(novobloqueadoAte.getTime() + (emprestimo.getDiasAtrasados() * 86400000));
            this.bloqueadoAte = novobloqueadoAte;
        } else {
            this.bloqueadoAte.setTime(this.bloqueadoAte.getTime() + (emprestimo.getDiasAtrasados() * 86400000));
        }
    }

    public void atualiaEstado() {
        Date hoje = new Date();
        if (this.bloqueadoAte != null && this.bloqueadoAte.getTime() > hoje.getTime() - Constans.ATRAZO_PADRAO) {
            this.estado = "BLOQUEADO";
        } else if (this.emprestimo != null && this.emprestimo.size() > 0) {
            for (Emprestimo i : this.emprestimo) {
                if (i.getEstado().equals("ATRASADO")) {
                    this.estado = "BLOQUEADO";
                    break;
                }
            }
        } else {
            this.bloqueadoAte = null;
            this.estado = "DESBLOQUEADO";
        }
    }

    /**
     *
     * @return Uma descrição completa do Usuario
     */
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n"
                + "Matrícula: " + this.getMatricula() + "\n"
                + "CPF: " + this.getCPF() + "\n"
                + "Endereço: " + this.getEndereco() + "\n"
                + "Email: " + this.getEmail() + "\n"
                + "Telefone: " + this.getTelefone() + "\n";
    }

    /**
     *
     * @param outro - Outro usuario a ser comparado
     * @return Retorna "true" se forem iguais e "false" se forem diferentes
     */
    @Override
    public boolean equals(Object outro) {
        if ((this == null) || (outro == null)) {
            return false;
        }
        if (outro instanceof Usuario) {
            Usuario aux = (Usuario) outro;
            if (this.getCPF().equals(aux.getCPF()) || this.matricula.equals(aux.getMatricula())) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return Retorna um numero que representa o usuario
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.getCPF());
        return hash;
    }

    /**
     *
     * @return Retorna 0 se forem iguais, 1 se este for maior e -1 se o "Outro"
     * for maior Metodo para a Organizao das Listas
     */
    @Override
    public int compareTo(Usuario outro) {
        return this.getCPF().compareTo(outro.getCPF());
    }

    /**
     * @return O nome do usuario
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return O endereço endereco do usuario
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @return O email do usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return A matricula do usuario
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @return O CPF do usuario
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @return O telefone do usario
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @return A senha do usuario
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @return O estado do usuario perante o sistema, pode ser "BLOQUEADO" ou
     * "DESBLOQUEADO"
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @return O limite de Livros emprestados de uma vez do usuaro
     */
    public int getLimite_Livros() {
        return limite_Livros;
    }

    /**
     * @return A quantidade de dias limites entre o emprestimo e a entrega
     */
    public int getLimite_Dias() {
        return limite_Dias;
    }

    /**
     * @return Uma Date que mostra até quando o usuario está "BLOQUEADO"
     */
    public Date getBloqueadoAte() {
        return bloqueadoAte;
    }

    /**
     * @return Retorna uma lista de emprestimos feito pelo o usuario
     */
    public List<Emprestimo> getEmprestimo() {
        return emprestimo;
    }

    /**
     * @param nome O nome a ser dado ao usuaro
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param endereco O endereço a ser dado ao usuario
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @param email O email a ser dado ao usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param matricula A matricula a ser dada ao usuario
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @param CPF O CPF a ser dado ao usuario
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @param telefone o telefone a ser dado ao usuario
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @param senha a senha a ser dada ao usuario
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @param estado o estato a ser dado ao usuaro, pode ser "BLOQUEADO" ou
     * "DESBLOQUEADO"
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @param limite_Livros o limite de livros para empresto simutaneo do
     * usuario
     */
    public void setLimite_Livros(int limite_Livros) {
        this.limite_Livros = limite_Livros;
    }

    /**
     * @param limite_Dias o limite de dias para a entrega dos livros do usuario
     */
    public void setLimite_Dias(int limite_Dias) {
        this.limite_Dias = limite_Dias;
    }

    /**
     * @param bloqueadoAte a data de até quando ele deve ficar bloqueado
     */
    public void setBloqueadoAte(Date bloqueadoAte) {
        this.bloqueadoAte = bloqueadoAte;
    }

    /**
     * @param emprestimo uma lista de emprestimos do usuario
     */
    public void setEmprestimo(List<Emprestimo> emprestimo) {
        this.emprestimo = emprestimo;
    }

}
