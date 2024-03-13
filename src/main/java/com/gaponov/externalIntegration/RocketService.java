package com.gaponov.externalIntegration;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.params.HttpParams;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class RocketService {
/*    private final HttpClient httpClient;

    @Inject
    public RocketService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void createChat(String ...params) {
        HttpMethod httpMethod = new PostMethod();
        httpMethod.setPath("yandex.ru");

        HttpMethodParams httpParams = new HttpMethodParams();
        httpParams.setParameter("param1", "param2");

        httpMethod.setParams(httpParams);
//        httpMethod.setContent

        httpClient.execute

    }*/
}
