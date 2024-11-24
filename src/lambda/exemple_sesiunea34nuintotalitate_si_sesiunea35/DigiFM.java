package lambda.exemple_sesiunea34nuintotalitate_si_sesiunea35;

public class DigiFM implements RadioBroadcast{
    @Override
    public void play(String message) {
        System.out.println("esti la digifm " + message);
    }
}