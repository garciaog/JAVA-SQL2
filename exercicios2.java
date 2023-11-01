import java.sql.*;

public class exercicios2 {
    public static void main(String[] args) {
        String host = "localhost";
        String database = "exercicios2";
        String usuario = "root";
        String senha = "";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, usuario,
                senha)) {
            String nome = "Cauã Delicio";
            String email = "cauãzinhogmaplais@gmail.com";
            int telefone = 452652136;

            String sql = "INSERT INTO cadastro_usuario (nome, email, telefone) VALUES (?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setInt(3, telefone);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Usuario cadastrado com sucesso! ");
            } else {
                System.out.println("Erro ao cadastrar o usuario");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

}

