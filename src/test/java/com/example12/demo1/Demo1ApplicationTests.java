package com.example12.demo1;

import com.example12.demo1.Exceptions.TimeConversionException;
import com.example12.demo1.Service.TimeConversionService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TimeConversionServiceTest {

	@Test
	void contextLoads() {
	}
	private final TimeConversionService timeConversionService = new TimeConversionService();

	@Test
	void convertToWords_PositiveScenario() throws TimeConversionException {
		String result = timeConversionService.convertToWords("12:34");
		assertEquals("It's twelve thirty four", result);
	}

	@Test
	void convertToWords_ZeroHours() throws TimeConversionException {
		String result = timeConversionService.convertToWords("00:45");
		assertEquals("It's twelve forty five", result);
	}

	@Test
	void convertToWords_Midnight() throws TimeConversionException {
		String result = timeConversionService.convertToWords("00:00");
		assertEquals("It's twelve", result);
	}

	@Test
	void convertToWords_NegativeInvalidFormat() {
		assertThrows(TimeConversionException.class, () ->
				timeConversionService.convertToWords("24:00")
		);
	}

	@Test
	void convertToWords_NegativeInvalidTime() {
		assertThrows(TimeConversionException.class, () ->
				timeConversionService.convertToWords("invalidTime")
		);
	}
//hellow
}
