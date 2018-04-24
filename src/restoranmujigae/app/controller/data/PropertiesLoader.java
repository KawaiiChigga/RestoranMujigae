/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranmujigae.app.controller.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Kenny
 */
public class PropertiesLoader {

    public static Properties prop = new Properties();
    public static InputStream input = null;

    public static void initProperties() {
        try {
            input = new FileInputStream("config.properties");
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input == null) {
                try {
                    input.close();
                    OutputStream output = null;
                    try {

                        output = new FileOutputStream("config.properties");

                        // Default
                        prop.setProperty("url", "localhost");
                        prop.setProperty("dbuser", "root");
                        prop.setProperty("dbpassword", "");

                        prop.store(output, null);

                    } catch (IOException io) {
                        io.printStackTrace();
                    } finally {
                        if (output != null) {
                            try {
                                output.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
