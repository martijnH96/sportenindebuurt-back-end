package Services;
import DTO.SportsDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SportService {
    final String dbUsername = "application";
    final String dbPassword = "cM1l:Qze";
    final String serverName = "jdbc:mysql://145.74.104.78:3306/sportenInDeBuurt";

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";
    Connection conn = null;
    Statement stmt = null;

    public List<SportsDTO> getSports(){
        try {
            List<SportsDTO> sportsDTOList = new ArrayList<>();
//            Class.forName("org.h2.Driver");
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//            stmt = conn.createStatement();
//            String sql =  "CREATE TABLE   REGISTRATION " +
//                    "(id INTEGER not NULL, " +
//                    " first VARCHAR(255), " +
//                    " last VARCHAR(255), " +
//                    " age INTEGER, " +
//                    " PRIMARY KEY ( id ))";
//            stmt.executeUpdate(sql);
//            stmt.close();
//            conn.close();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(serverName, dbUsername, dbPassword);
            PreparedStatement stmt = con.prepareStatement("SELECT * from Sport");
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                SportsDTO sportsDTO = new SportsDTO();
                sportsDTO.setSport(result.getString("naam"));
                sportsDTO.setSportLevel(0);
                sportsDTOList.add(sportsDTO);
            }
            return sportsDTOList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
