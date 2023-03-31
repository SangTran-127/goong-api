package org.sangtran.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sangtran.dto.LogResponse;
import org.sangtran.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ban-check")
@AllArgsConstructor
@Slf4j
public class LogController {



        private LogService logCheckService;

        @GetMapping(path = "{customerId}")
        public LogResponse isFraudster(
                @PathVariable("customerId") Integer customerId) {
            boolean isFraudulentCustomer = logCheckService.checkFraudustomer(customerId);
            log.info("fraud check request for customer {}", customerId);
            return new LogResponse(isFraudulentCustomer);
        }

}
