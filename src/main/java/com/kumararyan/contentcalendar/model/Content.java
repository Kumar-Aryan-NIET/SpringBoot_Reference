package com.kumararyan.contentcalendar.model;
import java.time.LocalDateTime;

public record Content(
    Integer id,
    String title,
    String desc,
    Status status,
    Type contentType,
    LocalDateTime dateCreated,
    LocalDateTime dataUpdated,
    String url){
}
