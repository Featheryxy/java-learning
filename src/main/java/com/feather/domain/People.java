package com.feather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Milo
 * @date 2023/7/29 20:00
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class People{
    private String name;
    private Integer age;
    private boolean male;

    private String hobby = "play basketball";

}
