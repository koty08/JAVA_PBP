import java.util.List;

public class JDBCTemplateTest {
    public static void main(String[] args){
        String sql = "SELECT * FROM CLUB";
        JdbcTemplate template = new JdbcTemplate();
        List<Club2> club2List = template.query(sql, new ClubRowMapper());
        club2List.stream().forEach(System.out::println);
    }
}
