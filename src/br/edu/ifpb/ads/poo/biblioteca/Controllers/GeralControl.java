/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.ads.poo.biblioteca.Controllers;

import br.edu.ifpb.ads.poo.biblioteca.Dao.BibliotecaDAO;
import br.edu.ifpb.ads.poo.biblioteca.Entidades.Funcionario;
import br.edu.ifpb.ads.poo.biblioteca.Interface.LoginFrame;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class GeralControl {

    private Funcionario funcionario_Logado;

    /**
     * Inciador main do Programa
     *
     * @param args Iniciador normal
     */
    public static void main(String[] args) {
        try {

            BibliotecaDAO bibliotecaDAO = new BibliotecaDAO(false);
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);

            Funcionario wensttay = new Funcionario("Gerente", "Administrativo", "Wensttay", "ECPS", "wensttay2@gmail.com", "2014-120-100-39", "000.000.000-00", "+55 (083) 9105-9901", "12345");
            Funcionario adm = new Funcionario("adm", "adm", "adm", "adm", "adm", "adm", "adm", "adm", "adm");
            Funcionario renata = new Funcionario("Meu Amor", "Minha vida", "Renata", "Futuramente o mesmo que o meu", "love@minhavida.com", "Best namorada", "Renata", "Liga Pra Min", "gelatina");
            
            try {
                bibliotecaDAO.addFuncionario(adm);
                bibliotecaDAO.addFuncionario(wensttay);
                bibliotecaDAO.addFuncionario(renata);
            
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Falha no acesso ao banco de dados");
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falha no acesso ao banco de dados");
        }
    }

    /**
     * @return the funcionario_Logado
     */
    public Funcionario getFuncionario_Logado() {
        return funcionario_Logado;
    }

    /**
     * @param funcionario_Logado the funcionario_Logado to set
     */
    public void setFuncionario_Logado(Funcionario funcionario_Logado) {
        this.funcionario_Logado = funcionario_Logado;
    }

}
