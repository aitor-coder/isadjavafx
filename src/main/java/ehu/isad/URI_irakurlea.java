package ehu.isad;
import java.net.*;
import java.io.*;

public class URI_irakurlea {
        public String eman_info(String txanpon_izena) throws IOException {
            URL oracle = new URL("https://api.gdax.com/products/"+txanpon_izena+"-eur/ticker");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            String inputLine;
            String balioa = null;
            while ((inputLine = in.readLine()) != null) {
                balioa=inputLine;
                System.out.println(inputLine);
            }
            System.out.println(balioa);
            in.close();
            return balioa ;
        }
    public static void main(String[] args) throws Exception {
    }
}
