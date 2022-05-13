package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import deserializer.MyDateDeserializer;
import serializer.MyDateSerializer;

import java.util.Date;

public class TestDate {

    private String event;
    @JsonSerialize(using = MyDateSerializer.class)
    @JsonDeserialize(using = MyDateDeserializer.class)
    private Date date;

    public TestDate(){}

    @Override
    public String toString() {
        return "TestDate{" +
                "event='" + event + '\'' +
                ", date=" + date +
                '}';
    }

    public TestDate(String event, Date date) {
        this.event = event;
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
