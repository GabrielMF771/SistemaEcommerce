package ucb.estudo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL implements ConexaoDB{
    private static final String URL = "jdbc:mysql://localhost:3307/system_biblioteca?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "catolica";

    @Override
    public Connection obterConexao() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Retorna a conexão
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conectado ao MySQL com sucesso!");

            return conexao;
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver JDBC do MySQL não encontrado!", e);
        } catch (SQLException e) {
            throw new Exception("Erro ao conectar ao banco de dados!", e);
        }
    }

    @Override
    public void fecharConexao(Connection conexao) {
        if(conexao != null){
            try {
                conexao.close();
                System.out.println("Conexão fechada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
