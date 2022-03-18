package PlayerPackage.PlayerPackage;

public class Midfielder extends Player implements Comparable{
    public Midfielder(String name, String clubName, int performance) {
        super(name, clubName, "Midfielder", performance);
    }

    public Midfielder(String name, String clubName) {
        this(name, clubName,0);
    }

    public Midfielder(String name) {
        this(name, null);
    }

    public Midfielder() {
        this(null);
    }

    @Override
    public void scoringGoal(int num) {
        this.setPerformance(this.getPerformance()+4*num);
    }

    @Override
    public void assistingGoal(int num) {
        this.setPerformance(this.getPerformance()+3*num);
    }

    @Override
    public void cleanSheet(int num) {
        this.setPerformance(this.getPerformance()+2*num);
    }
}
