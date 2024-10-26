package com.moulik.journalApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document(collection = "Config_journalapp")
public class Weatherclass {
    private String key ;
    @Field("Value")
    private String value;

}
