package com.usa.library.model.reports;


import com.usa.library.model.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportClient {

    private Long total;
    private ClientModel client;
}
