package Practical_Code.Intro_Network;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

/**
 * Created by ElHosany on 8/23/2016.
 */
public class Encoding_Decoding
{
    public static void main(String[] args) throws IOException
    {
         //ex
        String x = "Hello World and # is the hash";
        String encode_x = URLEncoder.encode(x,"UTF-8");
        System.out.println(encode_x);

        //URLEncode Class
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\FCIH\\Self-Study\\Java\\Projects\\JavaSE\\src\\Practical_Code\\Intro_Network\\trace.txt")));
        String line = in.readLine();
          String encoded_line = URLEncoder.encode(line,"UTF-8");
          String encoded_URL = "http://google.com/"+encoded_line;
        System.out.println(encoded_URL);
    }
}
