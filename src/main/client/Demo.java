package client;
import pills.AcheAway;
import pills.Dreamly;


public class Demo {
    static final double STRENGTH_ACHE = 5.0;
    static final double STRENGTH_DREAM = 2.0;
    static final double SIZE_ACHE = 0.5;
    static final double SIZE_DREAM = 1.5;
    public static void main(String[] args) {
        AcheAway newAcheAway = new AcheAway(STRENGTH_ACHE, SIZE_ACHE, "Red");
        System.out.println(newAcheAway);
        System.out.println(newAcheAway.description());

        Dreamly newDreamly = new Dreamly(STRENGTH_DREAM, SIZE_DREAM, "Green");
        System.out.println(newDreamly);
        System.out.println(newDreamly.description());
    }
}
