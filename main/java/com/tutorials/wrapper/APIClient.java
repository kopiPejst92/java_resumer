package com.tutorials.wrapper;

import java.net.http.HttpClient;
import java.time.Duration;

public class APIClient {
    private static final int DEFAULT_TIMEOUT=10;

    // 1.Tworzymy clienta, wraz z ustaleniem timeouta
    private final HttpClient httpClient=HttpClient.newBuilder().
                                        connectTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT)).
                                        build();

}
