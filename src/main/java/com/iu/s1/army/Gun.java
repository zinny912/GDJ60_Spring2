package com.iu.s1.army;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//new gun

public class Gun {

	@Autowired
	private Bullet bullet;
	
	//default 생성자
	public Gun() {
		// TODO Auto-generated constructor stub
	}
	
	//생성자에 주입해주세영

	public Gun(Bullet bullet) {
		this.bullet = bullet;
	}

	public void trigger() {
		this.bullet.sound();
	}
	

}
