package com.example.otelissue;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
class SampleController {
    private final ObservationIssueService service;
    private final ObservationRegistry registry;

    public SampleController(ObservationIssueService service, ObservationRegistry registry) {
        this.service = service;
        this.registry = registry;
    }

    @PostMapping
    public String issueEndpoint() {
        return Observation.createNotStarted("issue.observation", registry).contextualName("Some Observation").observe(service::someMethod);
    }
}
