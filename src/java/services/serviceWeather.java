/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import svlWeather.getWeather;

/**
 *
 * @author Saul Jimenez
 */
public class serviceWeather {
        public String getData(String city, String unit) {
            String line = null;
            String data = null;
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/find?q=" + city + "&units=" + unit + "&appid=be73dfab444bdcdce8399c18a0d28767");
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            // read each line and write
            while ((line = br.readLine()) != null) {
                data = line;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(getWeather.class.getName()).log(Level.SEVERE, null, ex);
        }
            return data;
    }
}
