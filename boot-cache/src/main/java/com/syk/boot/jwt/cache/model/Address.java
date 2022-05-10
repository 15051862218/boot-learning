package com.syk.boot.jwt.cache.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;

import javax.websocket.PongMessage;
import java.io.Serial;
import java.io.Serializable;

/**
 * @Author 沈永康
 * @Date 2022/4/17 23:01
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EnableCaching
public class Address implements Serializable {
    @Serial
    private static final long serialVersionUID = -8985545025228238777L;
    String country;
    String city;
}
