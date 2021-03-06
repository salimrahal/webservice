/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */
package rest;

import cart.ShoppingCart;
import entity.CustomerOrder;
import entity.Product;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import session.OrderManager;
import session.ProductFacade;

@Singleton
@Path("purchase")
public class PurchaseService {

    @EJB
    private OrderManager orderManager;
    
    @EJB
    private ProductFacade productFacade;

    public PurchaseService() {
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public OrderConfirmationJson placeOrder(OrderJson order) {
        int orderId = orderManager.placeOrder(order.name, order.email,
                order.phone, order.address, "X", order.ccNumber, convert(order.cart, order.surCharge));
        Map orderMap = orderManager.getOrderDetails(orderId);
        return new OrderConfirmationJson(((CustomerOrder)orderMap.get("orderRecord")).getConfirmationNumber());
    }
    
    private ShoppingCart convert(List<DepartmentService.ProductJson> products, BigDecimal surCharge)  {
        ShoppingCart cart = new ShoppingCart();
        for (DepartmentService.ProductJson productJson : products) {
            Product p = productFacade.find(productJson.id);
            cart.addItem(p);
        }
        cart.calculateTotal(surCharge.toPlainString());
        return cart;
    }

    public static class OrderJson {

        public String name;
        public String email;
        public String phone;
        public String address;
        public String cityRegion;
        public String ccNumber;
        public BigDecimal surCharge;
        public List<DepartmentService.ProductJson> cart;

        public OrderJson() {
        }

        @Override
        public String toString() {
            return "Order{" + "name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + ", cityRegion=" + cityRegion + ", ccNumber=" + ccNumber + ", surCharge=" + surCharge + ", cart=" + cart + '}';
        }
    }

    public static class OrderConfirmationJson {
        public int orderId;

        public OrderConfirmationJson() {
        }

        public OrderConfirmationJson(int orderId) {
            this.orderId = orderId;
        }
        
        @Override
        public String toString() {
            return "OrderConfirmation{" + "orderId=" + orderId + '}';
        }
        
        
    }
}