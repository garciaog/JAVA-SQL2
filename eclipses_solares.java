import java.sql.*;


public class eclipses_solares {
    private static final Double Total = null;

    public static void main(String[] args) throws Exception {
        String host = "localhost";
        String database = "exercicios2";
        String usuario = "root";
        String senha = "";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, usuario, senha)) {

            String data = "2023-11-30";
            String tipo = "Lunar";
            
            String sql = "INSERT INTO eclipses_solares (data, tipo) VALUES (?, ?)";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, data);
            stmt.setString(2, tipo);
            
            int linhasAfetadas = stmt.executeUpdate();
            if(linhasAfetadas > 0) {
                System.out.println("Eclipse Solar adcionado com sucesso! ");
            }else{
                System.out.println("Erro ao inserir eclipse solar.");

            }            
        } catch (SQLException e) {
            System.err.println("erro ao conectar ao banco de dados: " + e.getMessage());
            
        }
    }
}
