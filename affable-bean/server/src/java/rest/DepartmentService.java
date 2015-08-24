/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.Category;
import entity.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import session.CategoryFacade;

@Singleton
@Path("department")
public class DepartmentService {

    @EJB
    private CategoryFacade categoryFacade;
    
    public DepartmentService() {
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public List<DepartmentService.ProductJson> 
            getDepartmentProducts(@PathParam("id")Short categoryId) {
        Category selectedCategory = categoryFacade.find(categoryId);
        if (selectedCategory != null) {
            return convert(selectedCategory.getProductCollection());
        } else {
            return Collections.emptyList();
        }
    }
    
    private List<DepartmentService.ProductJson> 
            convert(Collection<Product> products) {
        List<DepartmentService.ProductJson> res = 
                new ArrayList<DepartmentService.ProductJson>();
        for (Product p : products) {
            res.add(new DepartmentService.ProductJson(p));
        }
        return res;
    }

    public static class ProductJson 
    {
        public int id;
        public String name;
        public BigDecimal price;

        public ProductJson() {
        }

        public ProductJson(int id, String name, BigDecimal price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
        
        public ProductJson(Product p) {
            this(p.getId(), p.getName(), p.getPrice());
        }

        @Override
        public String toString() {
            return "Product{" + "id=" + id + ", name=" +
                    name + ", price=" + price + '}';
        }

    }

}
