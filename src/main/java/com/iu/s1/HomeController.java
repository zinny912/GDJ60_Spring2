package com.iu.s1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.s1.army.Soldier;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	//변수명위에다가 해도 알아서 주입이 됨 Autowired
	@Autowired
	private Soldier soldier;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

	//	soldier.useGun();
		System.out.println(soldier.getName());
		System.out.println(soldier.getAge());
		
		
		
		
//------------------------------------------예전방식---------------------------------------------
//		Soldier soldier = new Soldier();
//		Bullet bullet = new Bullet();
//		Gun gun = new Gun(bullet);
//		soldier.setGun(gun);
//		
//		soldier.useGun();
				
		
		
		
		
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
