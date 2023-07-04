package org.example.jms.messaging.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person{
    private String code;
    private String name;
    private Integer age;
    private String occupation;
    private Gender gender;
}
