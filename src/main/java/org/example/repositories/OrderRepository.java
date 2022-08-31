package org.example.repositories;

import org.example.splitter.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Integer, Order> {

    public Order save(Order order);
}
