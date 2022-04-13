package org.gisproject.ww2gis.network;

import okhttp3.Request;

/**
 * @author Zhang Yunpeng
 */
public class FakeRequestBuilder extends Request.Builder
{
    private static final String CHROME_USER_AGENT = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.84 Mobile Safari/537.36";
    FakeRequestBuilder(String url) {
        this.url(url);
        this.addHeader("User-Agent", CHROME_USER_AGENT);
    }
}
