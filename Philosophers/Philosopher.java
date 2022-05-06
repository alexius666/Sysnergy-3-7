package java_synergy.Philosophers;

public class Philosopher implements Runnable{  //implement Runnable - пока не понятно зачем???
    public int thinkCount=0;
    public int eatenCount=0;
    public int hungry=0;
    public int x_loc;
    public int y_loc;
    public double angle;
    Status status = new Status();
    int left, right;

    public Philosopher(int left,int right, Status status){
        this.left=left;
        this.right=right;
        this.status=status;
    }

    public Philosopher(int x_loc,int y_loc,double angle){
        this.x_loc=x_loc;
        this.y_loc=y_loc;
        this.angle=angle;
    }

    public void Think(){
        this.thinkCount++;
        this.hungry++;
    }

    public void Eat(){
        this.eatenCount++;
        this.hungry=0;
    }
    //@Override пока не понятно зачем???
    public void run(){
        try {
            Thread.sleep(200);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        status.getFork(left,right);
    }
}
