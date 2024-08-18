package com.example.demo.domain.dto;

import com.example.demo.domain.entity.Reward;
import com.example.demo.domain.entity.missionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class missionDetailDTO {

    private String name;

    private missionType type;

    private Integer amount;

    private Reward reward;

    @Override
    public String toString() {
        return "missionDetailDTO{" +
                "name='" + name + '\'' +
                ", type=" + type.getDescription() +
                ", amount=" + amount +
                ", reward='" + reward.getDescription() + '\'' +
                '}';
    }
}
