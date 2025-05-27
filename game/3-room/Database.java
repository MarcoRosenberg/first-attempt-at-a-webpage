import java.sql.*;

public class Database {
    private static final String URL = "jdbc:sqlite:game.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static Room getRoom(int id) {
        String sql = "SELECT * FROM rooms WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Room(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getObject("north", Integer.class),
                    rs.getObject("south", Integer.class),
                    rs.getObject("east", Integer.class),
                    rs.getObject("west", Integer.class)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
