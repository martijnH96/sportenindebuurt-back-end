public class LoginService {

    String dbName = "DB4364163";
    String dbUsername = "U4364163";
    String dbPassword = "Icedmangowachtwoord123";
    String serverName = "jdbc:mysql://rdbms.strato.de:3306/"+dbName+"?user="+dbUsername+"&password="+dbPassword;

    public boolean login(String username, String password) {
        //TODO Database verbinding
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(serverName);
//            PreparedStatement stmt = con.prepareStatement("SELECT * FROM 'user' WHERE 'Username' = ?");
//            stmt.setString(1, "martijn");
//            ResultSet result = stmt.executeQuery();
//            if (result.first()){
        if (username.equals("martijn") && password.equals("martijn")) {
            return true;
        } else {
            return false;
        }
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return false;
    }
}
