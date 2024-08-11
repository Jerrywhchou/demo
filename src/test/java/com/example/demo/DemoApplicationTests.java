package com.example.demo;
import com.example.demo.domain.entity.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
class DemoApplicationTests {

	private static Boolean isLogin = false;

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		System.out.println("started");
	}

@Test
	public void testMain() {
		// 登录
		Scanner scanner = new Scanner(System.in);
		System.out.println("please input username");
		String username = scanner.nextLine();
		System.out.println("please input password");
		String password = scanner.nextLine();
		User user1 = userService.findByUsername(username);

    try {
        if(userService.check(user1.getPassword(), password)){
            isLogin = true;
            System.out.println(user1.getUsername()+" "+"login success");
        }
        else{
            System.out.println(user1.getUsername()+" "+"login failed");
        }
    } catch (NullPointerException e) {
        e.printStackTrace();
    }


    //




	}


}
