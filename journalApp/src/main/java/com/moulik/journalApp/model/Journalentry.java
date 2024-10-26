package com.moulik.journalApp.model;

import com.moulik.journalApp.Enum.Enum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "GGEZ")
public class Journalentry {

    @Id
    private String id;

    private String text;
    private String context;
    private LocalDateTime date;
    private Enum.Sentiment sentiment;
}
