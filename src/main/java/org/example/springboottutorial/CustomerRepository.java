package org.example.springboottutorial;

import org.springframework.data.repository.CrudRepository;
// ^ Spring Data interface that provides pre-built (Create, Read, Update, Delete) operations for database entities.
/*
save(entity): Creates or updates an entity.
findById(id): Retrieves an entity by its ID (returns an Optional).
findAll(): Retrieves all entities.
count(): Returns the total number of entities.
delete(entity): Removes a specific entity.
existsById(id): Checks if an entity exists by its ID.\

@Repository annotation tells Spring that the decorated class or interface is a mechanism for encapsulating storage,
retrieval, and search behavior emanating from a database. It turns your interface into a managed component within the application.
*/

// <Customer, Integer> identifies the 2 types we pass to the repo (Customer entities and Integer Id's).
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findCustomerById(Integer id);
    Customer findCustomersByFirstName(String firstName);
    Customer findByFirstName(String firstName);
    Customer findAllByIdWithin(Integer id);
}
