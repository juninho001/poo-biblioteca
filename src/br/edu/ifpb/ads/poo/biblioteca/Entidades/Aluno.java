/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.ads.poo.biblioteca.Entidades;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class Aluno extends Usuario {

    private String curso;

    /**
     *
     * @param curso - O curso do aluno
     * @param nome - O nome do Aluno
     * @param endereco - O endereço do Aluno
     * @param email - O email do aluno
     * @param matricula - A matricula do Aluno
     * @param CPF - O CPF do aluno
     * @param telefone - O felefone do Aluno
     * @param senha - A senha do Aluno
     */
    public Aluno(String curso, String nome, String endereco, String email,
            String matricula, String CPF, String telefone, String senha) {
        super(nome, endereco, email, matricula, CPF, telefone, senha, Constans.DIAS_ENTREGA_ALUNO);
        this.curso = curso;
    }

    /**
     *
     * @param outro o outro aluno a ser comparado
     * @return true se forem iguais e false se forem diferentes
     */
    @Override
    public boolean equals(Object outro) {
        return super.equals(outro);
    }

    /**
     *
     * @return retorna uma descrição completa do Aluno
     */
    @Override
    public String toString() {
        return super.toString()
                + "Curso: " + this.getCurso() + "\n";
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }
}
