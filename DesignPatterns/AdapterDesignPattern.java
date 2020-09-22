package DesignPatterns;
// Structural design Pattern
interface Pen{
public void write(String str);
}
class PilotPen{
    public void mark(String str){
        System.out.println(str);
    }
}
class PenAdapter implements Pen{
    PilotPen pp = new PilotPen();

    @Override
    public void write(String str) {
        pp.mark(str);
    }
}
class AssignmentWork{
    private Pen p;

    public Pen getP() {
        return p;
    }

    public void setP(Pen p) {
        this.p = p;
    }
    public void writeAssignment(String str){
        p.write(str);
    }
}
public class AdapterDesignPattern {
    public static void main(String[] args) {
        Pen p = new PenAdapter();
    AssignmentWork work = new AssignmentWork();
    work.setP(p);
    work.writeAssignment("I am tired");
    }
}
