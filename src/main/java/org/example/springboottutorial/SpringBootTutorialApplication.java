
// IntelliJ Spring Tutorial: https://www.jetbrains.com/help/idea/your-first-spring-application.html

package org.example.springboottutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; // Must include to actually make the website.

@SpringBootApplication
@RestController// Must include to actually make the website.
public class SpringBootTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTutorialApplication.class, args);
        System.out.println("http://localhost:8080/");
    }

    //sayHello() method takes the name parameter and returns the world Hello + param.
    // The "@RestController" annotation marks the SpringBootTutorialApplication class as a request handler (a REST controller).
    // The "@GetMapping("/hello")" annotation maps sayHello() method to GET requests for /hello.
    // The @RequestParam annotation maps the name method paramater to the myName web request parameter.
    // If you do not provide the myName parameter in your web request, it will default to "World".
    // During runtime, the default built-in Apache Tomcat server is listening on port 8080. So go to http://localhost:8080/hello.
    // To fill out the value with a name, you just simply add it like so: http://localhost:8080/hello?myName=David and it will display.

    // Opening at hello is the only endpoint so openning the root context of the app http://localhost:8080/ will give an error
    // since we have yet to define the root source.
    // - Add a static HTML home page with links to your endpoint to solve this.

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!",name);
    }

}
