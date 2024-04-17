package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class DemoDateTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDateTimeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			LocalDateTime localDateTime = LocalDateTime.now();
			System.out.println("localDateTime before formatting: " + localDateTime);

			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String formattedDate1 = localDateTime.format(formatter1);
			System.out.println("dd-MM-yyyy HH:mm:ss = " + formattedDate1);

			String formattedDate2 = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
			System.out.println("ISO_DATE_TIME = " + formattedDate2);

			String formattedDate3 = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			System.out.println("ISO_LOCAL_DATE_TIME = " + formattedDate3);

			/**
			 * yyyy: Represents the year in a four-digit format (e.g., 2024).
			 * MM: Represents the month in a two-digit format (e.g., 04 for April).
			 * dd: Represents the day of the month in a two-digit format (e.g., 17).
			 * 'T': Represents the literal character 'T', which is often used to separate the date from the time in ISO 8601 format.
			 * HH: Represents the hour of the day in a two-digit format using a 24-hour clock (e.g., 13 for 1 PM).
			 * mm: Represents the minute of the hour in a two-digit format.
			 * ss: Represents the second of the minute in a two-digit format.
			 * XXX: Represents the offset from UTC (Coordinated Universal Time) in an ISO 8601 format, such as -05:00 for Eastern Standard Time.
			 */
			// Create an OffsetDateTime object with the desired time zone offset (+07:00)
			ZoneOffset zoneOffset =ZoneOffset.ofHours(7);
			OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);

			System.out.println("yyyy-MM-dd'T'HH:mm:ssXXX = " +
					offsetDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")));

		};
	}

}
