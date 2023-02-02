package com.iu.s1.army;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//Annotation:실행+설명 - @Component : 객체를 만드세영 / 객체만 만들고 주입은 안됨
@Component
public class Soldier {

//	@Autowired
//	private Gun gun;
	
	@Autowired
	@Qualifier("sg")
	private Gun shotGun;
	@Autowired
	@Qualifier("rf")
	private Gun rifle;
	
	private String name;
	private int age;
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	public Gun getGun() {
//		return gun;
//	}
//
//	//객체에 주입해주세영
//	
//	public void setGun(Gun gun) {
//		this.gun = gun;
//	}
//
//	public void useGun() {
//		this.gun.trigger();
//	}
	
	
}
