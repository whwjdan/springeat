package com.jojeongmu.springeat.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {

    @Id
    @GeneratedValue
    private Long id;

    @Setter
    private Long restaurantId;

    private String name;

    // DB에 들어가지 않는 변수
    @Transient
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean destroy;

}
