/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaClientSecured;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import javaclient.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import javax.json.Json;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author salim
 * https://www.google.com.lb/?gws_rd=ssl#q=jersey+client+restful+main
 *
 * curl -u salim
 * http://localhost:8080/webServiceFromDbSecured/webresources/entities.chef
 */
public class MainSecured {

    public static void main(String[] args) {
        final String username = "salim";
        final String password = "salim1";
        //set the default authenticator for http requests
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password.toCharArray());
            }
        });
        testURL();
        // testRest3();
    }

    public static void testRest3() {
        JerseyClientSecured client = new JerseyClientSecured();
        Object response = client.findAll_JSON_Auth(String.class);
        System.out.println("response:" + response);
        // do whatever with response
        client.close();
    }

    public static void testURL() {
        try {
            URL url = new URL("http://localhost:8080/webServiceFromDbSecured/webresources/entities.chef");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
           // String userpass = username + ":" + password;
//            String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
//            conn.setRequestProperty("Authorization", basicAuth);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public static void testRESTfulExample() {
        try {

            URL url = new URL("http://localhost:8080/RESTfulExample/json/product/get");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public static void testRest() {
        JerseyClient client = new JerseyClient();
        Object response = client.countREST();
        System.out.println("response:" + response);
        // do whatever with response
        client.close();
    }
}
