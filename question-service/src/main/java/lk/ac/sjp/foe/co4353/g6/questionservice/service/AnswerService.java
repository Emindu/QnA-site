package lk.ac.sjp.foe.co4353.g6.questionservice.service;

import lk.ac.sjp.foe.co4353.g6.questionservice.dto.LongListWrapper;
import lk.ac.sjp.foe.co4353.g6.questionservice.dto.LongLongMapWrapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class AnswerService {

    private final RestTemplate restTemplate;

    public AnswerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<Long, Long> getAnswerCounts(List<Long> questionIds) {
        final LongLongMapWrapper wrappedResponse = restTemplate.postForObject(
                "http://answer-service/answers/questions/count",
                new LongListWrapper(questionIds),
                LongLongMapWrapper.class
        );
        return Optional
                .ofNullable(wrappedResponse)
                .orElseGet(LongLongMapWrapper::new)
                .getBody();
    }

    public Long getAnswerCounts(Long questionId) {
        return getAnswerCounts(Collections.singletonList(questionId)).get(questionId);
    }
}
