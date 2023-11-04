package com.springplayground.webclient;


import com.springplayground.webclient.dto.KakaoApiResponseDto;
import io.netty.util.internal.StringUtil;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {
    private final WebClient webClient;
    public Mono<KakaoApiResponseDto> callKakaoAddress(String address) {
        if (StringUtil.isNullOrEmpty(address)) {
            //return new CustomException();
            return null;
        }

        return webClient.get()
                .uri(uriBuilder -> buildUriByAddress(address, uriBuilder))
                .retrieve()
                .bodyToMono(KakaoApiResponseDto.class);

    }

    private static URI buildUriByAddress(String address, UriBuilder uriBuilder) {
        log.info("");
        return uriBuilder
                .queryParam("query", address)
                .build();
    }

}