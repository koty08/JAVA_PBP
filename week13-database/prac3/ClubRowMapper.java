import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClubRowMapper implements RowMapper<List<Club2>>{
    @Override
    public List<Club2> mapRow(ResultSet rs) throws SQLException {
        List<Club2> club2List = new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("ID");
            String club_name = rs.getString("CLUB_NAME");
            Club2 club2 = new Club2(id, club_name);
            club2List.add(club2);
        }
        return club2List;
    }
}
