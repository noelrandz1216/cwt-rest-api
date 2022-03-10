/**
  package com.cwt.service;
  import java.util.List;
  import java.util.Optional;
  
  import org.springframework.beans.factory.annotation.Autowired; 
  import org.springframework.stereotype.Service;
  import com.cwt.entities.Order; 
  import com.cwt.persistence.OrderRepository;
  
  import lombok.extern.slf4j.Slf4j;
  
  @Service
  @Slf4j 
  public class OrderServiceImpl implements OrderService {
  
	  @Autowired 
	  private OrderRepository orderRepository;
	  
	  @Override 
	  public Order findOrderById(Integer orderId) {
	  
		  log.info("From inside the findOrderById");
		  Order order = null;
		  Optional<Order> optionalOrder = orderRepository.findById(orderId);
		  
		  if(optionalOrder.isPresent()) 
			  order = optionalOrder.get(); 
		  else 
			  throw new RuntimeException("No order found with Order ID: " + orderId);
		  
		  return order; 
	  }
	  
	  @Override 
	  public List<Order> findAllAvailableOrders() {
	  
		  return orderRepository.findAll();
		  
	  }
	  
	  @Override 
	  public void createOrderRecord(Order order) {
	  
		  orderRepository.save(order);
	  
	  }
  
	  @Override 
	  public void deleteOrderRecord(Integer orderId) {
		  
		  Order order = null; 
		  Optional<Order> optionalOrder = orderRepository.findById(orderId);
	  
		  if(optionalOrder.isPresent()) 
			  order = optionalOrder.get(); 
		  else 
			  throw new RuntimeException("No order found with Order ID: " + orderId);
	  
		  orderRepository.delete(order);
	  
	  }
	  
	  @Override 
	  public Order updateOrderRecord(Integer orderId, Order newOrder) {
	 
		  log.info("From inside the updateOrderRecord"); 
		  Order order = null; 
		  Order updatedOrder = null; 
		  Optional<Order> optionalOrder = orderRepository.findById(orderId);
		  
		  if(optionalOrder.isPresent()) { 
			  order = optionalOrder.get();
			  order.setPrice(newOrder.getPrice());
			  order.setProductDescription(newOrder.getProductDescription());
			  order.setDateOfOrder(newOrder.getDateOfOrder()); updatedOrder =
			  orderRepository.save(order); }
		  else 
			  throw new RuntimeException("No order found with Order ID: " + orderId);

		  	return updatedOrder;
	 }
	  
	  @Override 
	  public Order updateEmailRecord(Integer orderId, Order
	  newOrderDetails) { 
		  
		  	return null;
	  }
  }
 **/
