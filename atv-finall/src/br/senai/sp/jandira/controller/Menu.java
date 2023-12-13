package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Cliente;
import br.senai.sp.jandira.model.Produto;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public void executarMenu() throws SQLException {
        boolean continuar = true;
        Scanner scanner = new Scanner(System.in);

        Cliente cliente = new Cliente();
        Produto produto = new Produto();
        ClienteController clienteController = new ClienteController();
        ProdutoController produtoController = new ProdutoController();

        while (continuar) {

            System.out.println("----------------------------------------");
            System.out.println("|  Sistema de Gerenciamento de Produtos ");
            System.out.println("----------------------------------------");
            System.out.println(" 1 - Cadastrar produto");
            System.out.println(" 2 - Cadastrar cliente");
            System.out.println(" 3 - Pesquisar produto");
            System.out.println(" 4 - Pesquisar Cliente");
            System.out.println(" 5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    produto.cadastrarProduto();
                    produtoController.cadastrarProdutos(produto);
                    break;
                case 2:
                    cliente.cadastrarCliente();
                    clienteController.cadastrarClientes(cliente);
                    break;
                case 3:
                    System.out.println("Informe o Id do produto");
                    int idProduto = scanner.nextInt();
                    produtoController.pesquisarProdutos(idProduto);
                    break;
                case 4:
                    System.out.print("Informe o CPF do cliente: ");
                    String cpfPesquisa = scanner.nextLine();
                    clienteController.pesquisarClientes(cpfPesquisa);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
