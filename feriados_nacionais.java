import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class feriados_nacionais {
    public static void main(String[] args) {
        String host = "localhost";
        String database = "exercicios2";
        String usuario = "root";
        String senha = "";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, usuario,
                senha)) {
            String Feriado = "Dia dos Finados";
            String Data = "2023-11-02";
           

            String sql = "INSERT INTO feriados_nacionais (data, descricao) VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, Data);
            stmt.setString(2, Feriado);
            
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Feriado cadastrado com sucesso! ");
            } else {
                System.out.println("Erro ao cadastrar o feriado");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
