package com.fcinar.bookstore.service;

import com.fcinar.bookstore.model.Book;
import com.fcinar.bookstore.model.Order;
import com.fcinar.bookstore.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final BookService bookService;

    public OrderService(OrderRepository orderRepository, BookService bookService) {
        this.orderRepository = orderRepository;
        this.bookService = bookService;
    }

    public Order putAnOrder(List<Long> bookIdList, String userName) {
        List<Optional<Book>> bookList = bookIdList.stream().map(bookService::findBookById).collect(Collectors.toList());
        double totalPrice = bookList.stream().map(optionalBook -> optionalBook.map(Book::getPrice)
                .orElse(0.0))
                .reduce(0.0, Double::sum);

        Order order = new Order(null, userName, bookIdList, totalPrice);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
