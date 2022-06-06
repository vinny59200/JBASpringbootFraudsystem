package antifraud.vv.controller;

import antifraud.vv.exceptions.BadRequestException;
import antifraud.vv.model.VVFraudCheck;
import antifraud.vv.model.VVFraudResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FraudController {

    @PostMapping(value={"/api/antifraud/transaction"})
    public VVFraudResponse submitFraudCheck(@RequestBody VVFraudCheck fraudCheck) {
        if (fraudCheck.getAmount() ==null || fraudCheck.getAmount() <= 0) {
            throw new BadRequestException();
        }
        if(fraudCheck.getAmount() <= 200) {
            return VVFraudResponse.builder()
                    .result("ALLOWED")
                    .build();
        } else if( fraudCheck.getAmount()>200 && fraudCheck.getAmount()<=1500) {
            return VVFraudResponse.builder()
                    .result("MANUAL_PROCESSING")
                    .build();
        }
        return VVFraudResponse.builder()
                .result("PROHIBITED")
                .build();
    }
}
