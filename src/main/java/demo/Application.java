package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
public class Application {

    public static void main(String[] args) {
    	List<String> strings = new ArrayList<>();
    	strings.add("blah");
    	strings.add("blah2");
    	
    	List<String> result = strings.stream().filter(x -> x.equals("blah")).collect(Collectors.toList());
    	
    	System.out.println(result.get(0));
    	
        SpringApplication.run(Application.class, args);
    }
}
