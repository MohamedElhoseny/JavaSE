package Practical_Code.Socket_Programming.TCP_SOCKET.AdvancedClient;

import java.io.Serializable;

public class Job implements Executable,Serializable
{

    @Override
    public String execute()
    {
        //Code of Job that the Server Do
        return "Doing Your Job";
    }
}
