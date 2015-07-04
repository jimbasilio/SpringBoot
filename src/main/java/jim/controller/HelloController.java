package jim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jim.dto.HelloDTO;
import jim.service.HelloService;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Value("${app.version}")
    private String version;

    @Value("${app.build.date}")
    private String buildDate;

    @Value("${hello.awesomefeature:false}")
    private boolean awesomefeature;

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody HelloDTO say() {
        HelloDTO hi = new HelloDTO();
        hi.setMyHello("go spring boot! Version " + this.version
                + " Build Date : " + this.buildDate);

        Long id = helloService.create(hi);
        hi.setMyHello(hi.getMyHello() + " " + id.toString());

        if (this.awesomefeature) {
            hi.setMyHello(
                    "awesome feature turned on " + hi.getMyHello() + " !!!!");
            System.out.println("awesome feature is ON!");
        }

        return hi;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody HelloDTO get(@PathVariable Long id) {
        return this.helloService.findById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody Long store(HelloDTO dtoToStore) {
        Long newId = helloService.create(dtoToStore);

        return newId;
    }
}
