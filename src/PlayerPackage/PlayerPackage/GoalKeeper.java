package PlayerPackage.PlayerPackage;

public class GoalKeeper extends Player implements Comparable{
    public GoalKeeper(String name, String clubName, int performance) {
        super(name, clubName, "Goalkeeper", performance);
    }

    public GoalKeeper(String name, String clubName) {
        this(name, clubName,0);
    }

    public GoalKeeper(String name) {
        this(name, null);
    }

    public GoalKeeper() {
        this(null);
    }

    @Override
    public void scoringGoal(int num) {
        this.setPerformance(this.getPerformance()+10*num);
    }

    @Override
    public void assistingGoal(int num) {
        this.setPerformance(this.getPerformance()+7*num);
    }

    @Override
    public void cleanSheet(int num) {
        this.setPerformance(this.getPerformance()+3*num);
    }
}
