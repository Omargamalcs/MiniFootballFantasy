package PlayerPackage.PlayerPackage;

public class Striker extends Player implements Comparable{
    public Striker(String name, String clubName, int performance) {
        super(name, clubName, "Striker", performance);
    }

    public Striker(String name, String clubName) {
        this(name, clubName,0);
    }

    public Striker(String name) {
        this(name, null);
    }

    public Striker() {
        this(null);
    }

    @Override
    public void scoringGoal(int num) {
        this.setPerformance(this.getPerformance()+3*num);
    }

    @Override
    public void assistingGoal(int num) {
        this.setPerformance(this.getPerformance()+4*num);
    }

    @Override
    public void cleanSheet(int num) {
        this.setPerformance(this.getPerformance()+1*num);
    }
}
