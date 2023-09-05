package com.arkademy.travel.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelDto {
    private Long id;
    private String name;
    private String email;
    private Long phoneNum;
    private String country;
    private String content;
    private LocalDateTime createdOn;


}
