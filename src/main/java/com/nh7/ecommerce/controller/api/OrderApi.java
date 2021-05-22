package com.nh7.ecommerce.controller.api;

import com.nh7.ecommerce.dto.OrderDto;
import com.nh7.ecommerce.entity.UserOrder;
import com.nh7.ecommerce.service.ItemService;
import com.nh7.ecommerce.service.OrderService;
import com.nh7.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@ControllerAdvice
@RequestMapping(value = "/api/home/orders")
public class OrderApi implements ICrudApi<OrderDto, UserOrder> {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    @Override
    public ResponseEntity<List<OrderDto>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<OrderDto> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> createAll(List<UserOrder> items) {
        return null;
    }

    @Override
    public ResponseEntity<Object> create(UserOrder item) {
        return null;
    }

    @PostMapping("")
    public ResponseEntity<Object> createOrder(@RequestBody OrderDto orderDto) {
        orderService.createNewOrder(orderDto);
        return new ResponseEntity<>("OK rồi nhá", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> update(Long id, UserOrder item) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteAll() {
        return null;
    }

    @Override
    public ResponseEntity<Object> delete(Long id) {
        return null;
    }
}