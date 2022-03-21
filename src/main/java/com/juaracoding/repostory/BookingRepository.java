package com.juaracoding.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juaracoding.model.BookingModel;

public interface BookingRepository extends JpaRepository<BookingModel, Long>{

}
