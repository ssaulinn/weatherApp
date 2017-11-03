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
public class serviceCities {

    public String getData() {
        String line = null;
        String data = null;

        try {
            URL url = new URL("http://openweathermap.org/help/city_list.txt");
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                data = data + line.trim() + "\n";
            }

        } catch (Exception ex) {
            Logger.getLogger(getWeather.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
