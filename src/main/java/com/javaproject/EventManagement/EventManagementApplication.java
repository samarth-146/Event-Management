package com.javaproject.EventManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.javaproject.EventManagement.entities.Venue;
import com.javaproject.EventManagement.entities.VenueRepositary;
import com.springbootcore.Springboot.SpringbootApplication;
import com.springbootcore.Springboot.jpa.UserRepo;

@SpringBootApplication
public class EventManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementApplication.class, args);
		
	}

}
