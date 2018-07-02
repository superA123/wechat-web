package maseratikpi.maserati;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MaseratiApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(MaseratiApplication.class).web(true).run(args);
	}
}
