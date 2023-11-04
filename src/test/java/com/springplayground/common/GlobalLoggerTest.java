package com.springplayground.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.event.Level;

class GlobalLoggerTest {

	private static final String ERROR_FORMAT = "[ERROR] {} {} -> {}";
	GlobalLogger globalLogger = new GlobalLogger();

	@Test
	@DisplayName("")
	void logging() throws Exception {
		//given
		globalLogger.log(Level.ERROR, ERROR_FORMAT,"");
		//when

		//then

	}
}