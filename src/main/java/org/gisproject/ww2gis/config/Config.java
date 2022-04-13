package org.gisproject.ww2gis.config;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.gisproject.ww2gis.Constant;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Zhang Yunpeng
 * @date 2022/3/30
 */
public class Config
{
    public DatabaseConfig database;
    // 其他设置

    public static @Nullable Config loadFromConfigFile()
    {
        String json;
        try
        {
            byte[] bytes = Files.readAllBytes(Paths.get(Constant.CONFIG_PATH));
            json = new String(bytes, StandardCharsets.UTF_8);
            return JSON.parseObject(json, Config.class);
        } catch (IOException e)
        {
            Log logger = LogFactory.getLog(Config.class);
            logger.error(e.getMessage());
            return null;
        }
    }

}