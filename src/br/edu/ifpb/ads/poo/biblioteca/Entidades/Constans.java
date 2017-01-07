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
public interface Constans {

    int DIAS_BLOQUEADOS = 3;
    int DIAS_ENTREGA_ALUNO = 10;
    int DIAS_ENTREGA_FUNCIONARIO = 15;
    int ATRAZO_PADRAO = 43200000;
    int UM_DIA = 86400000;
    int TAMANHO_DE_SENHA = 16;
    String[] CARGOS = new String[]{"<none>", "BIBLIOTECÁRIO", "GERENTE", "SUPORTE TEC.", "ESTÁGIARIO"};
    String[] SETORES = new String[]{"<none>", "INFANTIL", "ADOLESCENTE", "ADULTO", "FINANCEIRO"};
    String[] CURSOS = new String[]{"<none>", "ADS", "ODONTOLOGIA", "ENGENHARIA", "MEDICINA", "FARMÁCIA", "ARQUITETO", "ENG. DA COMPUTAÇÃO",
        "CIÊ. DA COMPUTAÇÃO"};
}
