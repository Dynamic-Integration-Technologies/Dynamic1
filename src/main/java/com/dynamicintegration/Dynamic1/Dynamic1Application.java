package com.dynamicintegration.Dynamic1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.thingmagic.*;
@SpringBootApplication
public class Dynamic1Application {

	public static void main(String[] args) {
		D1ReaderController d1ReaderController = D1ReaderController.getInstance();
		d1ReaderController.addReader("r1", "uri");
		SpringApplication.run(Dynamic1Application.class, args);
	}

}
