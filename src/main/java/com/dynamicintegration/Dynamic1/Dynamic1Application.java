package com.dynamicintegration.Dynamic1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.thingmagic.*;
@SpringBootApplication
public class Dynamic1Application {

	public static void main(String[] args) {
		D1ReaderController d1ReaderController = D1ReaderController.getInstance();
		if(!d1ReaderController.addReader("reader1", "uri")){
			System.out.println("READER NOT CONNECTED");
		}
		SpringApplication.run(Dynamic1Application.class, args);
	}

}
