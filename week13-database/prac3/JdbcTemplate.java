import java.sql.*;

public class JdbcTemplate {
    public <T> T execute (StatementCallback <T> action){
        T result = null;
        try (Connection conn = DriverManager.getConnection("jdbc:h2:file:C:\\Users\\user\\IdeaProjects\\db\\src\\main\\resources\\db");
             Statement stmt = conn.createStatement();) {
            result = action.doInStatement(stmt);
        } catch (SQLException ex){}
        return result;
    }

    public <T> T query(final String sql, RowMapper<T> mapper){
        class QueryStatementCallback implements StatementCallback<T> {
            @Override
            public T doInStatement(Statement stmt) throws SQLException {
                T result = null;
                ResultSet rs = stmt.executeQuery(sql);
                result = mapper.mapRow(rs);
                return result;
            }
        }
        return execute(new QueryStatementCallback());
    }
}
