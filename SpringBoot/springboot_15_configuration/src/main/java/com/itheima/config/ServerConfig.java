package com.itheima.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

//@Component
@Data
@ConfigurationProperties(prefix = "servers")
@Validated
public class ServerConfig {
    private String ipAddress;
    @Max(value = 8888, message = "最大值不能超过8888")
    @Min(value = 202, message = "最小值不能低于202")
    private int port;
    private long timeout;
    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeOut;
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
}

