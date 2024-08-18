package model.onetomany;

import javax.persistence.*;

import model.basic.Product;

@Entity
public class ItemOrdered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    /*eager initialization é uma inicialização ansiosa, ou seja, 
    é uma é algo que é inicializado imediatamente no ponto de sua definição*/
    @ManyToOne(fetch = FetchType.EAGER) //EAGER é o valor default de fetch (...ToOne -> EAGER)
    @JoinColumn(name = "order_id")
    private CustomerOrder order;

    
    @ManyToOne
    private Product product;

    
    @Column(unique = false)
    private int quantity;

    
    @Column(unique = false)
    private Double price;

    
    
    public ItemOrdered() {}

    public ItemOrdered(CustomerOrder order, Product product, int quantity) {
        this.setOrder(order);
        this.setProduct(product);
        this.setQuantity(quantity);
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerOrder getOrder() {
        return order;
    }

    public void setOrder(CustomerOrder order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;

        if (product != null && this.price == null) {
            this.setPrice(product.getPrice());
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
