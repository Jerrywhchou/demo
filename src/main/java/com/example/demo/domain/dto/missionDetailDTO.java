package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class missionDetailDTO {

    private String name;

    private Integer type;

    private Integer amount;

    private String reward;

    @Override
    public String toString() {
        return "missionDetailDTO{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                ", reward='" + reward + '\'' +
                '}';
    }
}
