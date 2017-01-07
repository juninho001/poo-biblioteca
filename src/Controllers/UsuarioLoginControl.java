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
import javax.swing.JOptionPane;

/**
 * @version 1.0
 * @author wensttay <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class UsuarioLoginControl {

    BibliotecaDAO bibliotecaDAO;
    Usuario usuario;

    /**
     * Cria um Controlador para Usuarios
     *
     * @throws IOException error de arquivos
     */
    public UsuarioLoginControl() throws IOException {
        this.bibliotecaDAO = new BibliotecaDAO();
    }

    /**
     * Esse metodo faz o logn de um usuario do tipo fucionario guardado no
     * sistema
     *
     * @param login login do usuario
     * @param senha senha do usuario
     * @return retorna o usuario que estar a se logar, caso não exista retorna
     * null
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public Usuario logar(String login, String senha) throws IOException, ClassNotFoundException {
        if (login == null || login.equals("") || senha == null || senha.equals("")) {
            JOptionPane.showMessageDialog(null, "Error, campos login e/ou senha vazios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            List<Aluno> alunos = this.bibliotecaDAO.getAnulos();
            
            for (Aluno i : alunos) {
                if (i.getCPF().equals(login) && i.getSenha().equals(senha)
                        || i.getMatricula().equals(login) && i.getSenha().equals(senha)) {
                    return i;
                }
            }

            List<Funcionario> funcionarios = this.bibliotecaDAO.getFuncionarios();
            
            for (Funcionario i : funcionarios) {
                if (i.getCPF().equals(login) && i.getSenha().equals(senha)
                        || i.getMatricula().equals(login) && i.getSenha().equals(senha)) {
                    return i;
                }
            }
        }
        
        return null;
    }
}
