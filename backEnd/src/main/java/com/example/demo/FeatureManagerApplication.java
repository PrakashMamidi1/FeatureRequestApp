package com.example.demo;

import com.example.demo.model.Feature;
import com.example.demo.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@SpringBootApplication
public class FeatureManagerApplication implements CommandLineRunner  {
	private static final Logger LOG = LoggerFactory.getLogger(FeatureManagerApplication.class);

	@Autowired
	FeatureService service;
	@Override
	public void run(String... args) throws Exception {
		LOG.info("Adding sample data");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

		//'Policies', 'Billing', 'Claims', 'Reports'
		service.add( new Feature ( "Add Search" , "Add search button", "ClientA", 1,convertToLocalDateViaInstant( sdf.parse("2020-11-30")) , "Reports")  );
		service.add( new Feature ( "Generate Report" , "Add Generate Report button", "ClientA", 2, convertToLocalDateViaInstant(sdf.parse("2020-11-30")) , "Reports")  );
		service.add( new Feature ( "Create Help" , "Create Help   page", "ClientA", 3, convertToLocalDateViaInstant(sdf.parse("2020-11-30")) , "Reports")  );
		service.add( new Feature ( "Add Search" , "Add search button", "ClientB", 1,convertToLocalDateViaInstant( sdf.parse("2020-11-30")) , "Reports")  );
		service.add( new Feature ( "Generate Report" , "Add Generate Report button", "ClientB", 2, convertToLocalDateViaInstant(sdf.parse("2020-11-30")) , "Reports")  );
		service.add( new Feature ( "Create Help" , "Create Help   page", "ClientC", 1, convertToLocalDateViaInstant(sdf.parse("2020-11-30")) , "Reports")  );


	}

	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
	}

	public static void main(String[] args) {
		SpringApplication.run(FeatureManagerApplication.class, args);
	}

}
