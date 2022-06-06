package antifraud.vv.model;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class VVFraudResponse {
    private String result;
}
