package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.HelloDTO;

@Controller
@RequestMapping("/hello-world")
public class HelloController {

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody HelloDTO sayHello()
	{
		HelloDTO hi = new HelloDTO();
		hi.setFirstName("pit");
		hi.setLastName("bull");
		
		return hi;
	}
}
