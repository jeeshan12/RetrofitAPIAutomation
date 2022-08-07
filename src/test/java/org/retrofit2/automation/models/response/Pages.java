package org.retrofit2.automation.models.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Pages {

    private Data[] data;
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
}