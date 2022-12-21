package mk.finki.ukim.mk.lab.model;


import lombok.Data;

@Data
public class Order {
    String balloonColor;
    String balloonSize;
    String clientName;
    String clientAddress;
    Long orderId;
}
