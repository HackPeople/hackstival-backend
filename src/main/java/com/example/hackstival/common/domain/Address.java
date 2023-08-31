package com.example.hackstival.common.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    public String doName;
    public String siName;
    public String dongName;
}
