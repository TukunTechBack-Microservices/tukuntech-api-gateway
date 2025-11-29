package com.upc.tukuntechapigateway.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @RequestMapping("/auth")
    public Mono<ResponseEntity<String>> authFallback() {
        return Mono.just(
                ResponseEntity
                        .status(HttpStatus.SERVICE_UNAVAILABLE)
                        .body("Auth service is temporarily unavailable. Please try again later.")
        );
    }

    @RequestMapping("/profiles")
    public Mono<ResponseEntity<String>> profilesFallback() {
        return Mono.just(
                ResponseEntity
                        .status(HttpStatus.SERVICE_UNAVAILABLE)
                        .body("Profiles service is temporarily unavailable. Please try again later.")
        );
    }

    @RequestMapping("/support")
    public Mono<ResponseEntity<String>> supportFallback() {
        return Mono.just(
                ResponseEntity
                        .status(HttpStatus.SERVICE_UNAVAILABLE)
                        .body("Support service is temporarily unavailable. Please try again later.")
        );
    }

    @RequestMapping("/reports")
    public Mono<ResponseEntity<String>> reportsFallback() {
        return Mono.just(
                ResponseEntity
                        .status(HttpStatus.SERVICE_UNAVAILABLE)
                        .body("Reports service is temporarily unavailable. Please try again later.")
        );
    }

    @RequestMapping("/monitoring")
    public Mono<ResponseEntity<String>> monitoringFallback() {
        return Mono.just(
                ResponseEntity
                        .status(HttpStatus.SERVICE_UNAVAILABLE)
                        .body("Monitoring service is temporarily unavailable. Please try again later.")
        );
    }

    @RequestMapping("/care")
    public Mono<ResponseEntity<String>> careFallback() {
        return Mono.just(
                ResponseEntity
                        .status(HttpStatus.SERVICE_UNAVAILABLE)
                        .body("Care service is temporarily unavailable. Please try again later.")
        );
    }
}