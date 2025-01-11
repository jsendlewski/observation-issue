package com.example.otelissue;

import io.micrometer.tracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class ObservationIssueService {
    private final static Logger logger = LoggerFactory.getLogger(ObservationIssueService.class);
    private final Tracer tracer;
    private final MyRepository repository;

    public ObservationIssueService(Tracer tracer, MyRepository repository) {
        this.tracer = tracer;
        this.repository = repository;
    }

    public String someMethod() {
        logger.info("Thread: {}, span: {}", Thread.currentThread().getName(), tracer.currentSpan().context().traceId());
        return repository.save(new MyEntity()).id().toString();
    }
}
