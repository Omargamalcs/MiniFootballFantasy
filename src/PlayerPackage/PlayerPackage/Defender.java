package PlayerPackage.PlayerPackage;

public class Defender extends Player implements Comparable{
    public Defender(String name, String clubName, int performance) {
        super(name, clubName, "Defender", performance);
    }

    public Defender(String name, String clubName) {
        this(name, clubName,0);
    }

    public Defender(String name) {
        this(name, null);
    }

    public Defender() {
        this(null);
    }

    @Override
    public void scoringGoal(int num) {
        this.setPerformance(this.getPerformance()+7*num);
    }

    @Override
    public void assistingGoal(int num) {
        this.setPerformance(this.getPerformance()+5*num);
    }

    @Override
    public void cleanSheet(int num) {
        this.setPerformance(this.getPerformance()+4*num);
    }
}
