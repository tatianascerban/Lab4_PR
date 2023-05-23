package com.univer.shoputm.util;

import com.univer.shoputm.util.enums.HttpMethod;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Objects;

public class RequestServiceUtil {

  private final HttpClient httpClient;

  private static RequestServiceUtil requestServiceUtil;
  private final Mapper mapper;

  public static RequestServiceUtil getInstance() {
    if(Objects.isNull(requestServiceUtil)) {
      requestServiceUtil = new RequestServiceUtil();
      return requestServiceUtil;
    }
    return requestServiceUtil;
  }
  private RequestServiceUtil() {
    this.httpClient = RequestUtil.getHttpClient();
    this.mapper = Mapper.getInstance();
  }

  public String getResponseBodyByHttpRequest(HttpRequest httpRequest) {
    HttpResponse<String> httpResponse = null;
    try {
      httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
    } catch (InterruptedException | IOException e) {
      throw new RuntimeException(e);
    }
    return httpResponse.body();
  }

  public HttpRequest buildHttpRequest(String addressPath, Object object, HttpMethod method) {
    HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
        .uri(URI.create(addressPath))
        .header(RequestConstants.COOKIE, RequestConstants.SESSION_KEY)
        .header(RequestConstants.CONTENT_TYPE, RequestConstants.APPLICATION_JSON);
    switch (method) {
      case GET -> requestBuilder.GET();
      case POST -> requestBuilder.POST(mapper.mapToJson(object));
      case DELETE -> requestBuilder.DELETE();
      case PUT -> requestBuilder.PUT(mapper.mapToJson(object));
      default -> throw new IllegalArgumentException("Unsupported HTTP method: " + method);
    }
    return requestBuilder.build();
  }
}
