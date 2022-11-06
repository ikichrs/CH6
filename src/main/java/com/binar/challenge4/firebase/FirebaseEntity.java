package com.binar.challenge4.firebase;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Setter
@Data
@Component
public class FirebaseEntity {

    private String subject;
    private String content;
    private Map<String,String> data;
    private String image;
}
