package kz.kaznitu.nazym.cake_soj.models;

import javax.persistence.*;

@Entity
public class Cake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String price;
    private String deliveryPrice;   //Жеткізу(доставка) бағасы
    private String deliveryTime;    //Жеткізу(доставка) уақыты
    private Client client;


    public Cake(){ }
    public Cake(String name, String price, String deliveryPrice, String deliveryTime) {
        this.name = name;
        this.price = price;
        this.deliveryPrice = deliveryPrice;
        this.deliveryTime = deliveryTime;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }


    public String getDeliveryPrice() {
        return deliveryPrice;
    }
    public void setDeliveryPrice(String deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }


    public String getDeliveryTime() {
        return deliveryTime;
    }
    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    public Client getClient(){
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}
