package org.retrofit2.automation.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Data {

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
