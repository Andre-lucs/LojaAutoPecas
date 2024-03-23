package br.com.lojaautopecas.CriacaoTabelas;

import java.sql.SQLException;

public class CreateAll {
    public static void main(String[] args) throws SQLException {
        new TabelaCliente().criar();
        new TabelaFuncionario().criar();
        new TabelaPeca().criar();
        new TabelaServico().criar();
        new TabelaVeiculo().criar();
        new TabelaVenda().criar();
        new TabelaVendaPeca().criar();
        new TabelaVendaServico().criar();
    }
}
