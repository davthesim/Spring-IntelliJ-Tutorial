
// Controller handles HTTP requests for your spring app. The app will use /add endpoint to add Customer
// objects from the database, and the /find/{id} endpoint to find the customer with the specified ID.

package org.example.springboottutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController // @RestController Marks the DemoController class as a request handler (a REST controller).
public class DemoController {
    // @Autowired annotation tells Spring to inject the customerRepository bean, which is implemented from the repository interface.
    @Autowired // NOTE: Beans are generally just objects that are instantiated (avoids using .new() for object creation).
    private CustomerRepository customerRepository;

    @PostMapping("/add") //@PostMapping maps the addCustomer() method to POST requests for /add.
    public String addCustomer(@RequestParam String first, @RequestParam String last) {
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer); // For usernames, will want to check if user exists before saving.
        return "Added new customer to repo!";
    } // @RequestParam maps the method params to corresponding web request params.

    @GetMapping("/list") // @GetMapping("/list") maps the getCustomers() method to GET requests for /list.
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}") // Maps the findCustomerById method to GET requests for /find/{id}.
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    } // @PathVariable maps the value in place of the id variables from the URL to corresponding method param.

    @GetMapping("/findName/{FName}")
    public Customer findByFirstName(@PathVariable String FName) {
        return customerRepository.findByFirstName(FName);
    }


}