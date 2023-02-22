import pills.AcheAway;
import pills.Dreamly;
import pills.GelCap;


public class Demo 
{
    public static void main(String[] args)
    {
        GelCap newDreamly = new Dreamly(2.0, 1.5, "Green");
        GelCap newAcheAway = new AcheAway(5.0, 0.5, "Red");

        newDreamly.manufacture();
        System.out.println(newDreamly);
        newDreamly.description();

        newAcheAway.manufacture();
        System.out.println(newAcheAway);
        newAcheAway.description();
    }
}
