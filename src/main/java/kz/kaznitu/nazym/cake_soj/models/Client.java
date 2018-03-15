package kz.kaznitu.nazym.cake_soj.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int mobileNumber;
    private Set<Cake> cake;

    public Client() {
    }

    public Client(String firstName, String lastName, String email, int mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    public Set<Cake> getCake() {
        return cake;
    }

    public void setCake(Set<Cake> cake) {
        this.cake = cake;
    }

    @Override
    public String toString() {
        String result = String.format("Category[id=%d, firstName='%a', email='%e', mobileNumber=%d]%n", id, firstName, lastName, email,mobileNumber);
        if(cake !=null){
            for(Cake cake : cake) {
                result += String.format("Cake[id=%d, name='%s', price='%p', deliveryPrice='g', deliveryTime='%t']%n", cake.getId(), cake.getName(), cake.getPrice(), cake.getDeliveryPrice(), cake.getDeliveryTime());
            }
        }
        return result;
    }
}
