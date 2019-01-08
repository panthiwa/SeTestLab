package com.example.demo.Repository;

import com.example.demo.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
    @Query("SELECT t FROM Furniture t WHERE t.furnitureName = :Name")
    Furniture findByName(@Param("Name")String Name);
}