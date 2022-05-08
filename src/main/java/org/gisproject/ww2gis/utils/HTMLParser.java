package org.gisproject.ww2gis.utils;

import okhttp3.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.gisproject.ww2gis.network.FakeRequestBuilder;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Zhang Yunpeng
 * @date 2022/4/20
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public final class HTMLParser
{
    private final OkHttpClient client;
    private Document document;
    public String url;
    public String selector;
    public ArrayList<String> elementsText;

    public HTMLParser(String url, String selector)
    {
        this.client = new OkHttpClient();
        this.url = url;
        this.selector = selector;
    }

    /**
     * 异步GET
     */
    public void getAsync()
    {
        if (this.url != null)
        {
            Request request = new FakeRequestBuilder(this.url).get().build();
            Call call = client.newCall(request);
            call.enqueue(new Callback()
            {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e)
                {
                    Log logger = LogFactory.getLog(this.getClass());
                    logger.error("GET " + url + " failed ", e);
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException
                {
                    if (!response.isSuccessful())
                    {
                        Log logger = LogFactory.getLog(this.getClass());
                        logger.error("GET" + url + " " + response.code());
                    } else
                    {
                        document = Jsoup.parse(Objects.requireNonNull(response.body()).string());
                        Elements elements = document.select(selector);
                        for (Element e : elements)
                        {
                            elementsText.add(e.text());
                        }
                    }
                }
            });
        }
    }

    public ArrayList<String> getSync() throws IOException
    {
        ArrayList<String> result = null;
        if (this.url != null)
        {
            Request request = new FakeRequestBuilder(this.url).get().build();
            Call call = client.newCall(request);
            Response response = call.execute();
            if (!response.isSuccessful())
            {
                Log logger = LogFactory.getLog(this.getClass());
                logger.error("GET " + url + " " + response.code());
            } else
            {
                document = Jsoup.parse(Objects.requireNonNull(response.body()).string());
                Elements elements = document.select(this.selector);
                for (Element e : elements)
                {
                    this.elementsText.add(e.text());
                }
                result = this.elementsText;
            }
        }
        return result;
    }
}


