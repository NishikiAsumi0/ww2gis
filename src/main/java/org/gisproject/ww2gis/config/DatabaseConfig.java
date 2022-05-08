package org.gisproject.ww2gis.config;

import org.springframework.stereotype.Component;

/**
 * @author Zhang Yunpeng
 */
@Component
public class DatabaseConfig extends Config
{
    public String databaseType = "mysql";
    public String username;
    public String password;

    public String getDatabaseType()
    {
        return databaseType;
    }

    public void setDatabaseType(String databaseType)
    {
        this.databaseType = databaseType;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
