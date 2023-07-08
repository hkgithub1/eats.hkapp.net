package net.hkapp.eats.eats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;

    public ResponseEntity<List<FoodOrder>> getAllOrders() {
        try {
            return new ResponseEntity<>(orderDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> getByOrderId(Integer id) {
        try {
            return new ResponseEntity<>(orderDao.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addOrder(FoodOrder foodOrder) {
        orderDao.save(foodOrder);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}
