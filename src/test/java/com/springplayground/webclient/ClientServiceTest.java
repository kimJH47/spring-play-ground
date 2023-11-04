package com.springplayground.webclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springplayground.webclient.dto.DocumentDto;
import com.springplayground.webclient.dto.KakaoApiResponseDto;
import com.springplayground.webclient.dto.MetaDto;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class ClientServiceTest {

    public static MockWebServer mockWebServer;
    ClientService clientService;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    public static void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll
    public static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @BeforeEach
    public void init() {
        final String baseUrl = String.format("http://localhost:%s", mockWebServer.getPort());
        final WebClient webClient = WebClient.create(baseUrl);
        clientService = new ClientService(webClient);

    }

    @Test
    @DisplayName("mocking 을 이용한 Webclient test")
    public void get() throws Exception {
        //given
        List<DocumentDto> documentDtos = List.of
                (new DocumentDto("대구 수성구", 3, 2)
                        , new DocumentDto("대구 달서구", 1, 2));
        MetaDto metaDto = new MetaDto(1);
        KakaoApiResponseDto expected = new KakaoApiResponseDto(metaDto, documentDtos);
        mockWebServer.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(expected))
                .addHeader("Content-Type", "application/json"));
        //when
        Mono<KakaoApiResponseDto> actual = clientService.callKakaoAddress("대구");
        //then
        StepVerifier.create(actual)
                .expectNextMatches(kakaoApiResponseDto -> Objects.equals(kakaoApiResponseDto.getMetaDto().getTotalCount(), 1))
                .verifyComplete();

    }

}