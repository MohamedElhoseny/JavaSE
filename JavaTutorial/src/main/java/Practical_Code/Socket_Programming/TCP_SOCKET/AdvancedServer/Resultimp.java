package Practical_Code.Socket_Programming.TCP_SOCKET.AdvancedServer;

import java.io.Serializable;

public class Resultimp implements Result , Serializable
{
    private String output;
    private double Complete_time;

    public Resultimp(String o,double c)
    {
        this.output=o;
        this.Complete_time=c;
    }
    @Override
    public String Output() {
        return this.output;
    }

    @Override
    public double CompleteTime() {
        return this.Complete_time;
    }
}