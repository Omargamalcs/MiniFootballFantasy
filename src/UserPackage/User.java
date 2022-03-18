package UserPackage;

import PlayerPackage.PlayerPackage.*;

public class User implements Comparable{
    private String Name;
    private String Email;
    private String Password;
    private String TeamName;
    public Player[] team = new Player[11];
    public int numOfPlayers = 0;
    private int totalPoints = 0;
    public  int numOfPlayersInGUI = 0;

    public User(String name, String email, String password, String teamName) {
        Name = name;
        Email = email;
        Password = password;
        TeamName = teamName;
    }

    public User(String name, String email, String password) {
        this(name, email, password, null);
    }

    public User(String name, String teamName) {
        this(name, null, null, teamName);
    }

    public User(String name) {
        this(name, null);
    }

    public User() {
        this(null);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public void buyPlayer(Player p){
        if (numOfPlayers<11) {
            team[numOfPlayers++] = p;
        }
    }

    public Player[] getTeam() {
        return team;
    }

    public Player search(String name){
        Player p = null;
        for (int i = 0; i < numOfPlayers; i++) {
            if (team[i].getName().equals(name)){
                p = team[i];
                break;
            }
        }
        return p;
    }

    public int calcTotalPoints()
    {
        totalPoints = 0;
        for (int i = 0; i < numOfPlayers; i++){
            totalPoints+= team[i].getPerformance();
        }
        return totalPoints;
    }

    public Player getTopPlayer() {
        try {


            int index = 0, topScore = -10;
            for (int i = 0; i < numOfPlayers; i++) {
                if (team[i].getPerformance() > topScore) {
                    index = i;
                    topScore = team[i].getPerformance();
                }
            }
            return team[index];
        } catch (Exception E) {
            System.out.println(E.getMessage());
            return null;
        }
    }

    @Override
    public int compareTo(Object o) {
        User otherUser = (User)o;
        if(this.calcTotalPoints() < otherUser.calcTotalPoints()){
            return 1;
        }

        else if (this.calcTotalPoints() == otherUser.calcTotalPoints()){
            return 0;
        }

        else {
            return -1;
        }
    }

}