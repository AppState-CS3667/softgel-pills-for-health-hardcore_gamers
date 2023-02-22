import pills.AcheAway;
import pills.Dreamly;


public class Demo 
{
    public static void main(String[] args)
    {
        Dreamly newDreamly = new Dreamly(2.0, 1.5, "Green");
        AcheAway newAcheAway = new AcheAway(5.0, 0.5, "Red");

        System.out.println(newDreamly);
        newDreamly.description();

        System.out.println(newAcheAway);
        newAcheAway.description();
    }
}
