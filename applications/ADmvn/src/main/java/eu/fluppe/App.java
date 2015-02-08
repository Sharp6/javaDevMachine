package eu.fluppe;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! in the maven." );
        InsultService is = new InsultService();
        is.createInsult("Uw moeder is braaf");
    }
}
