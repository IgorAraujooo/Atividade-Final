package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Cliente;
import br.senai.sp.jandira.model.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    Conexao conexao = new Conexao();
    Connection connection = conexao.getConnection();
    public void cadastrarClientes(Cliente cliente) throws SQLException {
        Statement statement = connection.createStatement();
        String queryCadastro = "insert into clientes(nome, cpf, email) values ('"+
                cliente.getNome() +  "','" +  cliente.getCpf() + "','" +
                cliente.getEmail() + "');";

        statement.executeUpdate(queryCadastro);

    }

    public void pesquisarClientes(String cpf) throws SQLException {
        Statement statement = connection.createStatement();
        String queryPesquisa = "SELECT * FROM clientes where cpf='"+cpf+"'";

        ResultSet resultSet = statement.executeQuery(queryPesquisa);
        List<Cliente> clienteList = new ArrayList<>();

        while (resultSet.next()){
            Cliente cliente = new Cliente();

            cliente.setId(resultSet.getInt("id"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setCpf(resultSet.getString("cpf"));
            cliente.setEmail(resultSet.getString("email"));

            clienteList.add(cliente);

        }for(Cliente cliente : clienteList){

            System.out.println(cliente.getId());
            System.out.println(cliente.getNome());
            System.out.println(cliente.getCpf());
            System.out.println(cliente.getEmail());
        }
    }
}
