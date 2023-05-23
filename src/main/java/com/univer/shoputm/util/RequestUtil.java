package com.univer.shoputm.util;

import static java.util.Objects.isNull;

import java.net.http.HttpClient;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class RequestUtil {
  private static HttpClient httpClient;
  public static HttpClient getHttpClient() {
    if (isNull(httpClient)) {
      SSLContext sslContext = null;
      try {
        sslContext = getSslContext();
      } catch (NoSuchAlgorithmException | KeyManagementException e) {
        throw new RuntimeException(e);
      }
      httpClient = HttpClient.newBuilder()
          .sslContext(sslContext)
          .build();
      return httpClient;
    } else {
      return httpClient;
    }
  }

  private static SSLContext getSslContext()
      throws NoSuchAlgorithmException, KeyManagementException {
    TrustManager[] trustManagers = new TrustManager[]{new X509TrustManager() {
      public X509Certificate[] getAcceptedIssuers() {
        return null;
      }
      public void checkClientTrusted(X509Certificate[] certs, String authType) {
      }
      public void checkServerTrusted(X509Certificate[] certs, String authType) {
      }
    }};
    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(null, trustManagers, null);
    return sslContext;
  }


}
