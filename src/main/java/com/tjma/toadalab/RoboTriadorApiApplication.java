package main.java.com.tjma.toadalab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.SystemProperties;
import org.springframework.util.SystemPropertyUtils;

import ch.qos.logback.core.util.SystemInfo;

@SpringBootApplication
public class RoboTriadorApiApplication {

	public static void main(String[] args) {
		System.out.println("Recuperando dados dos PIDs em execução...");
		String processName =
	            java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
	    Long l = Long.parseLong(processName.split("@")[0]);
	   	System.out.println(l);
		
		SpringApplication.run(RoboTriadorApiApplication.class, args);
	} 

}
