package br.com.lojaautopecas.CriacaoTabelas;

import br.com.lojaautopecas.dao.ClienteDao;
import br.com.lojaautopecas.dao.FuncionarioDao;
import br.com.lojaautopecas.dao.PecaDao;
import br.com.lojaautopecas.dao.ServicoDao;
import br.com.lojaautopecas.dao.VeiculoDao;
import br.com.lojaautopecas.dao.VendaDao;
import br.com.lojaautopecas.dao.VendaPecaDao;
import br.com.lojaautopecas.dao.VendaServicoDao;
import br.com.lojaautopecas.model.Cliente;
import br.com.lojaautopecas.model.Funcionario;
import br.com.lojaautopecas.model.Peca;
import br.com.lojaautopecas.model.Servico;
import br.com.lojaautopecas.model.Veiculo;
import br.com.lojaautopecas.model.Venda;
import br.com.lojaautopecas.model.VendaPeca;
import br.com.lojaautopecas.model.VendaServico;

import java.sql.SQLException;
import java.util.Date;

public class Povoamento {
    public static void main(String[] args) throws SQLException {
        Funcionario fun = new Funcionario();
        FuncionarioDao funDao = new FuncionarioDao();
        Veiculo veiculo = new Veiculo();
        VeiculoDao veiculoDao = new VeiculoDao();
        Cliente cliente = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        Venda venda = new Venda();
        VendaDao venDao = new VendaDao();
        Servico servico = new Servico();
        ServicoDao servicoDao = new ServicoDao();
        Peca peca = new Peca();
        PecaDao pecaDao = new PecaDao();
        VendaServico vendaServico = new VendaServico();
        VendaServicoDao vendaServicoDao = new VendaServicoDao();
        VendaPeca vendaPeca = new VendaPeca();
        VendaPecaDao vendaPecaDao = new VendaPecaDao();
        int retorno;


        // Funcionarios
        fun.setCargo("Vendedor");
        fun.setCpf("teste");
        fun.setNome("João testador");
        fun.setSenha("teste");
        funDao.inserirFuncionario(fun);

        fun.setCargo("Vendedor");
        fun.setCpf("666.521.358-63");
        fun.setNome("Victor");
        fun.setSenha("656984");
        funDao.inserirFuncionario(fun);

        fun.setCargo("Mecânico");
        fun.setCpf("123.456.789-10");
        fun.setNome("José");
        fun.setSenha("senha123");
        funDao.inserirFuncionario(fun);

        fun.setCargo("Eletricista Automotivo");
        fun.setCpf("987.654.321-21");
        fun.setNome("Carlos");
        fun.setSenha("senha456");
        funDao.inserirFuncionario(fun);

        fun.setCargo("Recepcionista");
        fun.setCpf("555.666.777-88");
        fun.setNome("Pedro");
        fun.setSenha("senhaABC");
        funDao.inserirFuncionario(fun);

        fun.setCargo("Gerente");
        fun.setCpf("444.333.222-11");
        fun.setNome("Gabriel");
        fun.setSenha("senhaGHI");
        funDao.inserirFuncionario(fun);


        // Veiculos
        veiculo.setModelo("Chevrollet");
        veiculo.setMarca("Fiest");
        veiculo.setAno(2012);
        veiculoDao.inserirVeiculo(veiculo);

        veiculo.setModelo("Toyota");
        veiculo.setMarca("Corolla");
        veiculo.setAno(2015);
        veiculoDao.inserirVeiculo(veiculo);

        veiculo.setModelo("Honda");
        veiculo.setMarca("Civic");
        veiculo.setAno(2018);
        veiculoDao.inserirVeiculo(veiculo);

        veiculo.setModelo("Volkswagen");
        veiculo.setMarca("Golf");
        veiculo.setAno(2017);
        veiculoDao.inserirVeiculo(veiculo);

        veiculo.setModelo("Ford");
        veiculo.setMarca("Fusion");
        veiculo.setAno(2014);
        veiculoDao.inserirVeiculo(veiculo);


        //Clientes
        cliente.setCpf("684.325.658-85");
        cliente.setNome("Pedro");
        cliente.setId_Veiculo(1);
        clienteDao.inserirCliente(cliente);

        cliente.setCpf("123.456.789-10");
        cliente.setNome("Ana");
        cliente.setId_Veiculo(2);
        clienteDao.inserirCliente(cliente);

        cliente.setCpf("987.654.321-21");
        cliente.setNome("João");
        cliente.setId_Veiculo(3);
        clienteDao.inserirCliente(cliente);

        cliente.setCpf("111.222.333-44");
        cliente.setNome("Maria");
        cliente.setId_Veiculo(4);
        clienteDao.inserirCliente(cliente);

        //Vendas
        venda.setData(new Date());
        venda.setValor_Total(253.50);
        venda.setId_Cliente(1);
        venda.setId_Funcionario(1);
        retorno= venDao.inserirVenda(venda);
        System.out.println(retorno);

        venda.setData(new Date());
        venda.setValor_Total(33.50);
        venda.setId_Cliente(2);
        venda.setId_Funcionario(1);
        retorno= venDao.inserirVenda(venda);

        venda.setData(new Date());
        venda.setValor_Total(150.50);
        venda.setId_Cliente(3);
        venda.setId_Funcionario(4);
        retorno= venDao.inserirVenda(venda);

        venda.setData(new Date());
        venda.setValor_Total(150.50);
        venda.setId_Cliente(3);
        venda.setId_Funcionario(2);
        retorno= venDao.inserirVenda(venda);


        // Serviços
        servico.setDescricao("Troca de oleo");
        servico.setPreco(150.00);
        servicoDao.inserirServico(servico);

        servico.setDescricao("Alinhamento e balanceamento");
        servico.setPreco(200.00);
        servicoDao.inserirServico(servico);

        servico.setDescricao("Reparo de motor");
        servico.setPreco(500.00);
        servicoDao.inserirServico(servico);

        servico.setDescricao("Substituição de filtro de ar");
        servico.setPreco(50.00);
        servicoDao.inserirServico(servico);


        //Peças
        peca.setNome("Para-choque");
        peca.setPreco(200.00);
        pecaDao.inserirPeca(peca);

        peca.setNome("Bateria");
        peca.setPreco(150.00);
        pecaDao.inserirPeca(peca);

        peca.setNome("Amortecedor");
        peca.setPreco(120.00);
        pecaDao.inserirPeca(peca);

        peca.setNome("Pneu");
        peca.setPreco(300.00);
        pecaDao.inserirPeca(peca);


        //VendaServico
        vendaServico.setId_Venda(1);
        vendaServico.setId_Servico(1);
        vendaServicoDao.inserirVendaServico(vendaServico);

        vendaServico.setId_Venda(1);
        vendaServico.setId_Servico(2);
        vendaServicoDao.inserirVendaServico(vendaServico);

        vendaServico.setId_Venda(1);
        vendaServico.setId_Servico(3);
        vendaServicoDao.inserirVendaServico(vendaServico);

        vendaServico.setId_Venda(2);
        vendaServico.setId_Servico(1);
        vendaServicoDao.inserirVendaServico(vendaServico);

        vendaServico.setId_Venda(2);
        vendaServico.setId_Servico(2);
        vendaServicoDao.inserirVendaServico(vendaServico);

        vendaServico.setId_Venda(2);
        vendaServico.setId_Servico(3);
        vendaServicoDao.inserirVendaServico(vendaServico);

        vendaServico.setId_Venda(3);
        vendaServico.setId_Servico(4);
        vendaServicoDao.inserirVendaServico(vendaServico);

        vendaServico.setId_Venda(4);
        vendaServico.setId_Servico(4);
        vendaServicoDao.inserirVendaServico(vendaServico);


        //VendaPeca
        vendaPeca.setId_Venda(1);
        vendaPeca.setId_Peca(2);
        vendaPecaDao.inserirVendaPeca(vendaPeca);

        vendaPeca.setId_Venda(1);
        vendaPeca.setId_Peca(1);
        vendaPecaDao.inserirVendaPeca(vendaPeca);

        vendaPeca.setId_Venda(2);
        vendaPeca.setId_Peca(1);
        vendaPecaDao.inserirVendaPeca(vendaPeca);

        vendaPeca.setId_Venda(2);
        vendaPeca.setId_Peca(3);
        vendaPecaDao.inserirVendaPeca(vendaPeca);

        vendaPeca.setId_Venda(3);
        vendaPeca.setId_Peca(1);
        vendaPecaDao.inserirVendaPeca(vendaPeca);

        vendaPeca.setId_Venda(4);
        vendaPeca.setId_Peca(4);
        vendaPecaDao.inserirVendaPeca(vendaPeca);

    }
}