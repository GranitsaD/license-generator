package ru.adv.licensegeneratorui.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LicenseRequest {
    private String appName;
    private String hid;
    private Date createData;
    private boolean perpetual;
    private Long numberOfMonthsOfValidity;
    private Map<String,String> dataForClientApp;
}
