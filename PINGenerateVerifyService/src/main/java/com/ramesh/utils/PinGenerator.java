package com.ramesh.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

/**
 * @author Ramesh.Yaleru
 *
 */
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PinGenerator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PinGenerator.class);
	
	private final static Random RANDOM = new SecureRandom();
    private final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static String generatedPin() {
          return generatedRandomString(6);//6 alphanumeric characters
    }

    /**
     * @param length
     * @return
     */
    private static String generatedRandomString(int length) {
    	LOGGER.info("####### start PinGenerator :: generatedRandomString ##########");
          StringBuilder returnValue = new StringBuilder(length);
          
          for (int i = 0; i < length; i++) {
                returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
          }
          LOGGER.info("####### end  PinGenerator :: generatedRandomString ##########" +returnValue);
          return returnValue.toString();
    }

    
}
