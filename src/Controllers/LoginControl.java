/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entidades.Funcionario;
import java.util.List;

/**
 * @version 1.0
 * @author Wensttay
 */
public class LoginControl {
    
    /**
     * 
     * @param login login de funcionario a ser logado
     * @param senha senha de funcionario a ser logado
     * @param funcionario_List  lista de funcionarios a ser procurado o usuario com login e senhas iguais aos passados
     * @return retorna o funcionario caso ele exista, caso contrario retorna null
     */
    public Funcionario logar_Funcionario (String login, String senha, List<Funcionario> funcionario_List){
        for(Funcionario i : funcionario_List){
            if(i.getMatricula().equals(login) && i.getSenha().equals(senha)){
                return i;
            }
        }
        return null;
    }
    
    /**
     * 
     * @param login login de funcionario a ser procurado
     * @param senha senha de funcionario a ser procurado
     * @param funcionario_List lista de funcionarios a ser procurado o usuario com login e senhas iguais aos passados
     * @return retorna o true caso ele exista, caso contrario retorna false
     */
    public boolean funcionario_Existe (String login, String senha, List<Funcionario> funcionario_List){
        for(Funcionario i : funcionario_List){
            if((i.getMatricula().equals(login) && !i.getSenha().equals(senha))){
                return true;
            }
        }
        return false;
    }
}
