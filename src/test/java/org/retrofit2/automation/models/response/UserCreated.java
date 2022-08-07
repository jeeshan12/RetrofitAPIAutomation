package org.retrofit2.automation.models.response;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserCreated {

    private String name;
    private String job;
    private String id;
    private String createdAt;
}
