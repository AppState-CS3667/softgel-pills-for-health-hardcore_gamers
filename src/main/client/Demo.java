package client;
import pills.AcheAway;
import pills.Dreamly;


public class Demo 
{
    public static void main(String[] args)
    {
        AcheAway newAcheAway = new AcheAway(5.0, 0.5, "Red");
        System.out.println(newAcheAway);
        newAcheAway.description();

        Dreamly newDreamly = new Dreamly(2.0, 1.5, "Green");
        System.out.println(newDreamly);
        newDreamly.description();
    }
}
