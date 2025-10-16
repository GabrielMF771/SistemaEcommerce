package ucb.estudo.app;

import ucb.estudo.dao.ConexaoMySQL;
import ucb.estudo.dao.RepositorioDeProdutos;
import ucb.estudo.model.Produto;

import java.util.List;

public class SistemaEcommerce {
    public static void main(String[] args) {
        ConexaoMySQL conexaoDB = new ConexaoMySQL();

        RepositorioDeProdutos repositorioDeProdutos = new RepositorioDeProdutos(conexaoDB);

        listarProdutos(repositorioDeProdutos);
    }

    private static void listarProdutos(RepositorioDeProdutos repositorioDeProdutos) {

        List<Produto> produtos = repositorioDeProdutos.listarTodos();

        System.out.println("\n==== PRODUTOS DISPONÍVEIS ====");

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível no momento.");
            return;
        }

        System.out.println("\nID | Nome | Preço | Estoque");
        System.out.println("-----------------------------");

        for (Produto produto : produtos) {
            System.out.printf("%d | %s | R$ %.2f | %d unidades%n",
                    produto.getId(),
                    produto.getNome(),
                    produto.getPreco(),
                    produto.getQuantidadeEstoque());
        }
    }

}

