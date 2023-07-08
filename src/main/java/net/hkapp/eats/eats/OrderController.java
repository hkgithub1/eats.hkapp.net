package net.hkapp.eats.eats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("eats")
public class OrderController {

    @Autowired
    OrderService orderService;

    @CrossOrigin
    @GetMapping("allOrders")
    public ResponseEntity<List<FoodOrder>> getAllOrders(){
        return orderService.getAllOrders();
    }

    @CrossOrigin
    @GetMapping("order/{id}")
    public ResponseEntity<?> getByOrderId(@PathVariable Integer id){
        return orderService.getByOrderId(id);
    }    

    @CrossOrigin
    @PostMapping("addOrder")
    public ResponseEntity<String> addOrder(@RequestBody FoodOrder foodOrder){
        return  orderService.addOrder(foodOrder);
    }

}