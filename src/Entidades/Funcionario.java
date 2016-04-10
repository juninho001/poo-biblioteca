/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Objects;

/**
 * @version 1.0
 * @author Wensttay
 */
public class Funcionario extends Usuario{
    private String cargo, setor;
    /**
     * 
     * @param cargo - O cardo do Funcionario
     * @param setor - O setor que Funcionario atua
     * @param nome  - O numero do funcionario   
     * @param endereco  - O endereço do Funcionario
     * @param email - O email do Funcionario
     * @param matricula - A matriula do Funcionario
     * @param CPF - O CPF do Funcionario
     * @param telefone - O telefone do Funcionario
     * @param senha - A senha do Funcionairo
     */
    public Funcionario( String cargo,       String setor,       String nome,        String endereco, 
                        String email,       String matricula,   String CPF,         String telefone, 
                        String senha) {
        
        super(nome, endereco, email, matricula, CPF, telefone, senha, Constans.DIAS_ENTREGA_FUNCIONARIO);
        this.cargo = cargo;
        this.setor = setor;
    }
    /**
     * 
     * @return Uma descrição completa do Funcionario 
     */
    @Override
    public String toString(){
        return super.toString() +
               "Cargo: " + this.getCargo() + "\n" +
               "Setor: " + this.getSetor() + "\n";
    }
    
    /**
     * 
     * @param outro o objeto a ser comparado
     * @return retorna true se forem iguais e false se forem diferentes
     */
    @Override
    public boolean equals(Object outro){
        return super.equals(outro);
    }

    /**
     * 
     * @return retorna um numero que representa o usuario
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.getCargo());
        hash = 23 * hash + Objects.hashCode(this.getSetor());
        return hash;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @return the setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }
}
