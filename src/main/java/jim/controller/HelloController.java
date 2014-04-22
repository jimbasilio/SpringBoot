package jim.controller;

import jim.dto.HelloDTO;
import jim.service.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    HelloService helloService;
    
	@RequestMapping(value="/", method=RequestMethod.GET)
	public @ResponseBody HelloDTO say()
	{
		HelloDTO hi = new HelloDTO();
		hi.setMyHello("go penn state");
		
		Long id = helloService.create(hi);
		hi.setMyHello(hi.getMyHello() + " " + id.toString());
		
		return hi;
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public @ResponseBody HelloDTO get(@PathVariable Long id)
	{		
		return this.helloService.findById(id);
	}	
	
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody Long store(HelloDTO dtoToStore)
    {
        Long newId = helloService.create(dtoToStore);
        
        return newId;
    }   	
}
