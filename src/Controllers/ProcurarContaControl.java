/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.BibliotecaDAO;
import Entidades.Aluno;
import Entidades.Funcionario;
import Entidades.Usuario;
import java.io.IOException;
import java.util.List;

/**
 * @version 1.0
 * @author wensttay <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class ProcurarContaControl {

    private Usuario usuario;

    /**
     *
     * @param CPF CPF a ser vasculhado entre os funcionarios salvos
     * @return retorna o funcionario com CPF passado, caso não exista retorna
     * null
     * @throws IOException error de arquivo
     * @throws ClassNotFoundException error de classe
     */
    public Funcionario procurarFuncionario(String CPF) throws IOException, ClassNotFoundException {
        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        List<Funcionario> funcionarios = bibliotecaDAO.getFuncionarios();
        
        for (Funcionario i : funcionarios) {
            if (i.getCPF().equals(CPF)) {
                return i;
            }
        }
        
        return null;
    }

    /**
     *
     * @param CPF CPF a ser vasculhado entre os alunos salvos
     * @return retorna o aluno com CPF passado, caso não exista retorna null
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public Aluno procurarAluno(String CPF) throws IOException, ClassNotFoundException {
        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        List<Aluno> alunos = bibliotecaDAO.getAnulos();
        
        for (Aluno i : alunos) {
            if (i.getCPF().equals(CPF)) {
                return i;
            }
        }
        
        return null;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
