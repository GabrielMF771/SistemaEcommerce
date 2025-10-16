package ucb.estudo.dao;

import java.sql.Connection;

public interface ConexaoMySQLInterface {

    Connection obterConexao() throws Exception;

    void fecharConexao(Connection conexao);
}
