package com.example.demo;

import com.example.demo.Repository.HotelRepository;
import com.example.demo.entity.*;
import com.example.demo.Repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.stream.Stream;
@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @Bean
    ApplicationRunner init(RoomStatusRepository roomStatusRepository,ProvinceRepository provinceRepositoy,HotelRepository hotelRepository, FurnitureRepository furnitureRepository, RoomTypeRepository roomTypeRepository, RoomsRepository roomsRepository, RoomTypeFurnitureManyToManyRepository roomType_furniture_manyToManyRepository) {
        return args -> {
            //Create RoomStatus
            Stream.of("ว่าง","จอง","พัก").forEach(roomstatus ->{
                RoomStatus rst = new RoomStatus(roomstatus); 
                roomStatusRepository.save(rst);
            });
            //Create Provinces
            Stream.of("กรุงเทพมหานคร","กระบี่","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา","ชลบุรี","ชัยนาท"
                ,"ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา","นครศรีธรรมราช"
                ,"นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บึงกาฬ","บุรีรัมย์","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี","พระนครศรีอยุธยา"
                ,"พังงา","พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","พะเยา","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน"
                ,"ยะลา","ยโสธร","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา","สตูล"
                ,"สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี","สุรินทร์","หนองคาย"
                ,"หนองบัวลำภู","อ่างทอง","อุดรธานี","อุทัยธานี","อุตรดิตถ์","อุบลราชธานี","อำนาจเจริญ").forEach(province -> {
                Province provinces = new Province(province);
                provinceRepositoy.save(provinces);
            });
            
           /* //Create hotel
            Hotel hotels = new Hotel();
            hotels.setHotelNameEng("PhimaiIn");
            hotels.setHotelNameThai("???????????");
            hotels.setAlleyLane("-");
            hotels.setBuilding("sell");
            hotels.setDistrictArea("phimai");
            hotels.setFax("044002255");
            hotels.setHouseNo("403");
            hotels.setMobilePhone("0862505906");
            hotels.setRoad("-");
            hotels.setPhone("0801669415");
            hotels.setSubdistrictSubarea("boat");
            hotels.setVillage("25");
            hotels.setPostCode(30110);
            hotels.setProvince("nakhonratchasima");
            hotels.setVillage("nongbour");
            hotelRepository.save(hotels);

            Hotel hotel2 = new Hotel();
            hotel2.setHotelNameEng("Amathara");
            hotel2.setHotelNameThai("?????????");
            hotel2.setAlleyLane("-");
            hotel2.setBuilding("sell");
            hotel2.setDistrictArea("phimai");
            hotel2.setFax("044002255");
            hotel2.setHouseNo("403");
            hotel2.setMobilePhone("0862505906");
            hotel2.setRoad("-");
            hotel2.setPhone("0801669415");
            hotel2.setSubdistrictSubarea("boat");
            hotel2.setVillageNo("25");
            hotel2.setPostCode(30110);
            hotel2.setProvince("nakhonratchasima");
            hotel2.setVillage("nongbour");
            hotelRepository.save(hotel2);
            hotelRepository.findAll().forEach(System.out::println);

            //create furniture
            Furniture Table = new Furniture("Table");
            furnitureRepository.save(Table);
            Furniture Air = new Furniture("Air");
            furnitureRepository.save(Air);
            Furniture OfficeDesk = new Furniture("OfficeDesk");
            furnitureRepository.save(OfficeDesk);

            //Create RoomType
            RoomType Standard = new RoomType("Standard","duo",1,1,2);
            roomTypeRepository.save(Standard);
            RoomType Suite = new RoomType("Suite","duo",1,1,2);
            roomTypeRepository.save(Suite);

            Stream.of("PhimaiIn","Amathara").forEach(hotel -> {
                Stream.of("Standard","Suite").forEach(roomtype -> {
                    if(roomtype == "Standard" && hotel == "PhimaiIn"){
                        Rooms no1 = new Rooms(401,"Rest",650,hotels,Standard);
                        roomsRepository.save(no1);
                        Rooms no2 = new Rooms(402,"Empty",700,hotels,Standard);
                        roomsRepository.save(no2);

                        RoomTypeFurnitureManyToMany rtf1 = new RoomTypeFurnitureManyToMany(Table,Standard);
                        roomType_furniture_manyToManyRepository.save(rtf1);
                        RoomTypeFurnitureManyToMany rtf2 = new RoomTypeFurnitureManyToMany(Air,Standard);
                        roomType_furniture_manyToManyRepository.save(rtf2);
                        RoomTypeFurnitureManyToMany rtf3 = new RoomTypeFurnitureManyToMany(OfficeDesk,Standard);
                        roomType_furniture_manyToManyRepository.save(rtf3);

                        RoomsFurnitureManyToMany rf1 = new RoomsFurnitureManyToMany(no1,Table);
                        rooms_furniture_manyToManyRepository.save(rf1);
                        RoomsFurnitureManyToMany rf2 = new RoomsFurnitureManyToMany(no1,OfficeDesk);
                        rooms_furniture_manyToManyRepository.save(rf2);
                        RoomsFurnitureManyToMany rf3 = new RoomsFurnitureManyToMany(no1,Air);
                        rooms_furniture_manyToManyRepository.save(rf3);
                        RoomsFurnitureManyToMany rf4 = new RoomsFurnitureManyToMany(no2,Table);
                        rooms_furniture_manyToManyRepository.save(rf4);
                        RoomsFurnitureManyToMany rf5 = new RoomsFurnitureManyToMany(no2,OfficeDesk);
                        rooms_furniture_manyToManyRepository.save(rf5);
                        RoomsFurnitureManyToMany rf6 = new RoomsFurnitureManyToMany(no2,Air);
                        rooms_furniture_manyToManyRepository.save(rf6);
                    }
                    if(roomtype == "Suite"){
                        RoomTypeFurnitureManyToMany rtf4 = new RoomTypeFurnitureManyToMany(Table,Standard);
                        roomType_furniture_manyToManyRepository.save(rtf4);
                        RoomTypeFurnitureManyToMany rtf5 = new RoomTypeFurnitureManyToMany(Air,Standard);
                        roomType_furniture_manyToManyRepository.save(rtf5);
                    }
                });
            });*/
        };

    }

}
