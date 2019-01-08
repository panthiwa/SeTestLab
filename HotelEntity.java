package com.example.demo.entity;
import javax.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name ="HotelEntity")
public class HotelEntity {
    @Id
    @SequenceGenerator(name="hotelId_seq",sequenceName="hotelId_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="hotelId_seq")

    private @NonNull Long hotelId;
    private @NonNull String hotelName;


//One To Many with Rooms_Furniture_ManyToMany

    protected HotelEntity(){

    }
    public HotelEntity( String hotelName){
        this.hotelName = hotelName;
    }
    public Long getHotelId() {
        return hotelId;
    }
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
