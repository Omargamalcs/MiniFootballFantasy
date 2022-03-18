package PlayerPackage.PlayerPackage;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public abstract class Player implements Comparable{
    private String Name;
    private String ClubName;
    private String Position;
    private int Performance = 0;
    private CheckBox CheckBox = new CheckBox();

    public Player(String name, String clubName, String position, int performance) {
        Name = name;
        ClubName = clubName;
        Position = position;
        Performance = performance;
    }

    public Player(String name, String clubName, String position) {
        this(name,clubName,position,0);
    }

    public Player(String name, String clubName) {
        this(name,clubName,null);
    }

    public Player(String name) {
        this(name,null);
    }

    public Player() { this(null); }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getClubName() {
        return ClubName;
    }

    public void setClubName(String clubName) {
        ClubName = clubName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public int getPerformance() {
        return Performance;
    }

    public void setPerformance(int performance) {
        Performance = performance;
    }

    public javafx.scene.control.CheckBox getCheckBox() {
        return CheckBox;
    }

    public void setCheckBox(javafx.scene.control.CheckBox checkBox) {
        CheckBox = checkBox;
    }

    public abstract void scoringGoal(int num);
    public abstract void assistingGoal(int num);
    public abstract void cleanSheet(int num);

    @Override
    public String toString() {
        return "Player{" +
                "Name='" + Name + '\'' +
                ", ClubName='" + ClubName + '\'' +
                ", Position='" + Position + '\'' +
                ", Performance=" + Performance +
                '}';
    }

    public int compareTo(Object o){
        Player otherPlayer = (Player)o;
        if(this.getPerformance() < otherPlayer.getPerformance()){
            return -1;
        }
        else if (this.getPerformance() == otherPlayer.getPerformance()){
            return 0;
        }
        else{
            return 1;
        }

    }


}