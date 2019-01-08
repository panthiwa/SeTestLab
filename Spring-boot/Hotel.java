
package com.example.demo.entity;
import javax.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Data
@Table (name = "TableHotel")
public class Hotel {
    @Id
    @SequenceGenerator(name="hotel_seq",sequenceName="hotel_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hotel_seq")
    @Column(name="HOTEL_ID",unique = true, nullable = false)
    private @NonNull Long hotelId;
    private String hotelNameThai;
    private String hotelNameEng;
    private int villageNo;
    private @NonNull String houseNo;
    private String building ;
    private String village;
    private String alleyLane;
    private String road;
    private @NonNull String subDistrictSubArea;
    private @NonNull String districtArea;
    private @NonNull int postCode;
    private @NonNull String mobilePhone;
    private @NonNull String phone;
    private @NonNull String fax;

    //One TO Many with Rooms
    /*@OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "hotel",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Rooms> rooms;*/
    //ManyToOne with Provinces
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "provincesId")
    private Province province;

    public Hotel(){ }
    public Hotel(String hotelNameThai,String hotelNameEng,int villageNo,String houseNo,
                 String building,String village,String alleyLane,String road,String subdistrictSubarea,
                 String districtArea,int postCode,String mobilePhone,String phone,String fax,Province province){
        this.alleyLane = alleyLane;
        this.building = building;
        this.districtArea = districtArea;
        this.hotelNameEng = hotelNameEng;
        this.hotelNameThai = hotelNameThai;
        this.village = village;
        this.villageNo = villageNo;
        this.road = road;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.fax = fax;
        this.postCode = postCode;
        this.subDistrictSubArea = subdistrictSubarea;
        this.houseNo = houseNo;
        this.province = province;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelNameThai() {
        return hotelNameThai;
    }

    public void setHotelNameThai(String hotelNameThai) {
        this.hotelNameThai = hotelNameThai;
    }

    public String getHotelNameEng() {
        return hotelNameEng;
    }

    public void setHotelNameEng(String hotelNameEng) {
        this.hotelNameEng = hotelNameEng;
    }

    public int getVillageNo() {
        return villageNo;
    }

    public void setVillageNo(int villageNo) {
        this.villageNo = villageNo;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getAlleyLane() {
        return alleyLane;
    }

    public void setAlleyLane(String alleyLane) {
        this.alleyLane = alleyLane;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getSubDistrictSubArea() {
        return subDistrictSubArea;
    }

    public void setSubDistrictSubArea(String subDistrictSubArea) {
        this.subDistrictSubArea = subDistrictSubArea;
    }

    public String getDistrictArea() {
        return districtArea;
    }

    public void setDistrictArea(String districtArea) {
        this.districtArea = districtArea;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    public Province getProvince(){return province;} 
    public void setProvince(Province provinces){this.province = province;}
    /*public List<Rooms> getRooms() {
        return rooms;
    }
    public void setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
    }*/
}
