package org.sangtran.service;
import lombok.AllArgsConstructor;
import org.sangtran.entity.Log;
import org.sangtran.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor

public class LogService {
    @Autowired
    private LogRepository fraudCheckHistoryRepository;

    public void setFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                Log.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
    }
    public Boolean checkFraudustomer(Integer customerId) {
        Optional<Log> isFraud = this.fraudCheckHistoryRepository.findByUserId(customerId);
        return isFraud.isPresent();
    }
}
