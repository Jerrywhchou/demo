package com.example.demo;

import com.example.demo.domain.dto.missionDetailDTO;
import com.example.demo.domain.entity.Instance;
import com.example.demo.domain.entity.Mission;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.missionType;
import com.example.demo.service.InstanceService;
import com.example.demo.service.MissionService;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Scanner;

@SpringBootTest
class DemoApplicationTests {

	private static Boolean isLogin = false;

	@Autowired
	private UserService userService;
	@Autowired
	private MissionService missionService;
	@Autowired
	private InstanceService instanceService;

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
		if (user1 == null) {
			System.out.println("user not found");
		}

		try {
			if (userService.check(user1.getPassword(), password)) {
				isLogin = true;
				System.out.println(user1.getUsername() + " " + "login success");
			} else {
				System.out.println(user1.getUsername() + " " + "login failed");
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		//查询用户可用任务
		Map<String, Mission> map = missionService.missionListForUser(user1);

		//6.查询任务详情
		for (Mission mission : map.values()) {
			missionDetailDTO detail = missionService.getMissionDetail(mission);
			System.out.println(detail.toString());
		}


		//用户输入，创建实例
		String line = scanner.nextLine();
		String[] newLine = line.split(" ");
		if (newLine[0].equals("GO")) {
			try {
				int num = Integer.parseInt(newLine[1]);
				Mission mission = missionService.getMissionById(num);
				Instance instance1 = instanceService.createInstance(mission, user1);
				System.out.println(instance1.toString());

				System.out.println(missionService.getMissionByCode(instance1.getCode()).getName() + "任务，已报名成功");


				//用户输入，完成，给奖励
				String input = scanner.nextLine();
				if (input.equals("ReadAction") && mission.getType() == missionType.read)
				{
						instanceService.processRead(instance1);

				}
				else if (input.equals("Write") && mission.getType() == missionType.write)
				{
					String inputWrite = scanner.nextLine();
					instanceService.processWrite(inputWrite,instance1);
				}
				else {
					System.out.println(mission.getName()+ "is not completed, please try again");
				}


			}
			catch (NumberFormatException e){
				System.out.println("invalid number format " + e.getMessage());
			}


		}
		else{System.out.println("invalid input. the correct one should start with GO");}
	}
}
