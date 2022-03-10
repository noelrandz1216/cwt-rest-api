package com.cwt.entities;

/****
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
  
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ordertable")
public class Order {
  
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name="order_id")
	  private Integer orderId;
  
	  @NotBlank(message="Quantity must not be blank")
	  private Long quantity;
  
	  private Date dateOfOrder;
	  private String productDescription;
	  private BigDecimal price;
	  
		
  
  }***/