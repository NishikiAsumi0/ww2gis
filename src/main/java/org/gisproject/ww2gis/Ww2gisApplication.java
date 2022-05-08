package org.gisproject.ww2gis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Zhang Yunpeng
 */
@SpringBootApplication()
public class Ww2gisApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(Ww2gisApplication.class, args);
    }

}
