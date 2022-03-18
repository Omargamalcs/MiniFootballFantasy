package sample;
import java.sql.*;

public class Connect {


    private Connection conn;

    // select all users (Email,Password)
    public ResultSet validateInDB() throws SQLException {

        ResultSet res = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:FantasyDatabase.db");
            Statement stat = conn.createStatement();
            res = stat.executeQuery("SELECT Email, PASSWORD FROM User;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    //add user to database
    public void addUsers(String s1, String s2, String s3) throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:FantasyDatabase.db");
            PreparedStatement prep = conn.prepareStatement("INSERT into User (User_id, name, email ,password) values (?,?,?,?);");
            prep.setString(2, s1);
            prep.setString(3,s2);
            prep.setString(4, s3);
            prep.executeUpdate();
            prep.closeOnCompletion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    //choosing formation of user
    public void addFormation(String email , int id) throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:FantasyDatabase.db");
            PreparedStatement prep = conn.prepareStatement("Update user set formation = ? " +
                                                                        "where email=?;");
            prep.setInt(1, id);
            prep.setString(2, email);
            prep.executeUpdate();
            prep.closeOnCompletion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //show available players
    public ResultSet selectAvailablePlayers(String PlayerPosition) throws SQLException{
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:FantasyDatabase.db");
            PreparedStatement prep = conn.prepareStatement("SELECT Name,Team from Fantasy where Availability = 1 and lower(Position) = ?");
            prep.setString(1, PlayerPosition);
            prep.execute();
            ResultSet res = prep.executeQuery();
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    //add player to user in buy_player table
    public void addPlayerToUser(String PlayerName, String UserEmail) throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:FantasyDatabase.db");
            PreparedStatement prep = conn.prepareStatement("INSERT into buy_player (User_email, player_name) values (?,?);");
            prep.setString(1, UserEmail);
            prep.setString(2, PlayerName);
            prep.executeUpdate();
            prep.closeOnCompletion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        conn.close();

    }

    //make availability to zero for selected player
    public void setAvailability(String PlayerName) throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:FantasyDatabase.db");
            PreparedStatement prep = conn.prepareStatement("UPDATE Fantasy set Availability = 0 where Name = ?");
            prep.setString(1, PlayerName);
            prep.executeUpdate();
            prep.closeOnCompletion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    //show user team
    public ResultSet showYourTeam(String userEmail) throws SQLException{
        ResultSet res;
        try {
            conn.close();
            conn = DriverManager.getConnection("jdbc:sqlite:FantasyDatabase.db");
            PreparedStatement prep = conn.prepareStatement("SELECT Name,Team,performance,position from Fantasy where name in"+"(SELECT player_name FROM buy_Player where user_email=?)");
            prep.setString(1, userEmail);
            prep.execute();
            prep.closeOnCompletion();
            res = prep.executeQuery();
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    //set total point of user to him in user table
    public void setUserPoints(String userEmail , int userPoints) throws SQLException{
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:FantasyDatabase.db");
            PreparedStatement prep = conn.prepareStatement("Update User set Points = ? " +
                    "where email=?");
            prep.setInt(1, userPoints);
            prep.setString(2, userEmail);
            prep.execute();
            prep.closeOnCompletion();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //set player performance in fantasy table
    public void setPlayerPerformance(int getPerformance ,String playerName , String teamName) throws SQLException{
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:FantasyDatabase.db");
            PreparedStatement prep = conn.prepareStatement("Update Fantasy set Performance = ? " +
                    "where name=?"+"AND Team = ?");
            prep.setInt(1, getPerformance);
            prep.setString(2, playerName);
            prep.setString(3, teamName);
            prep.closeOnCompletion();
            prep.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //show all players in database
    public ResultSet selectAllPlayers() throws SQLException{
        ResultSet res;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:FantasyDatabase.db");
            Statement stat = conn.createStatement();
            res = stat.executeQuery("SELECT Name, Team , POSITION ,Performance FROM Fantasy;");
            stat.closeOnCompletion();
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    //Descending (users)
    public ResultSet selectTop3() throws SQLException{
        ResultSet res;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:FantasyDatabase.db");
            Statement stat = conn.createStatement();
            res = stat.executeQuery("SELECT Name,points FROM User order by 2 desc;");
            stat.closeOnCompletion();
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
