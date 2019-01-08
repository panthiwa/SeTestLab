package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name ="PromotionEntity")
public class PromotionEntity {
    public Long getPromotionId() {
        return promotionId;
    }

    //@Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="Promotion_seq",sequenceName="Promotion_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Promotion_seq")
    @Column(name = "promotionId")
    @Id private @NonNull Long promotionId;

    private String promotionName;
    private Date dateStart;
    private Date dateEnd;
    private  String detail;
    public Long promotionId() {
        return promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public void promotionId(Long promotionID) {
        this.promotionId = promotionID;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }
    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDatEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public HotelEntity getHotelEntity() {
        return hotelEntity;
    }

    public void setHotelEntity(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }

    public PromotionTypeEntity getPromotionTypeEntity() {
        return promotionTypeEntity;
    }

    public void setPromotionTypeEntity(PromotionTypeEntity promotionTypeEntity) {
        this.promotionTypeEntity = promotionTypeEntity;
    }

    public RoomTypeEntity getRoomTypeEntity() {
        return roomTypeEntity;
    }

    public void setRoomTypeEntity(RoomTypeEntity roomTypeEntity) {
        this.roomTypeEntity = roomTypeEntity;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PromotionTypeEntity.class)
    @JoinColumn(name = "PromotionType_ID", insertable = true)
    private  PromotionTypeEntity promotionTypeEntity;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = AdminEntity.class)
    @JoinColumn(name = "Member_ID", insertable = true)
    private AdminEntity adminEntity;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = HotelEntity.class)
    @JoinColumn(name = "Hotel_ID", insertable = true)
    private  HotelEntity hotelEntity;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomTypeEntity.class)
    @JoinColumn(name = "RoomType_ID", insertable = true)
    private  RoomTypeEntity roomTypeEntity;
    public PromotionEntity(){

    }
    public PromotionEntity(Date dateStart,Date dateEnd,String detail,PromotionTypeEntity promotionTypeEntity,HotelEntity hotelEntity,RoomTypeEntity roomTypeEntity){
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.detail = detail;
        this.promotionTypeEntity = promotionTypeEntity;
        this.hotelEntity = hotelEntity;
        this.roomTypeEntity = roomTypeEntity;
    }
}



