// Java program to find IP address of your computer
// java.net.InetAddress class provides method to get
// IP of any host name
import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;



public class MyIP_Finder
{

    public static void main(String []args) throws Exception {

        InetAddress localhost = InetAddress.getLocalHost();

        // Find public IP address
        String systemipaddress;
        Date dNow = new Date();
        SimpleDateFormat ft1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat ft2 = new SimpleDateFormat("hh:mm:ss a");
        //System.out.println("Public IP Address: ");

        try {
            URL oracle = new URL("https://ifconfig.me/ip");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));
                    systemipaddress = in.readLine().trim();

        } catch (Exception e) {
            systemipaddress = "Cannot Execute Properly";
        }
        System.out.println("Public IP Address: " + systemipaddress + "\n");
        PrintWriter out = new PrintWriter("MyIP.txt");
        out.printf("Date: %s time: %s\n", ft1.format(dNow), ft2.format(dNow));
        out.println(systemipaddress);
        out.close();

    }
}
