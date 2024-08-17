package model.onetomany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false)
    private Date data;

    //relação bidirecional ente CustomerOrder e ItemOrdered
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemOrdered> items = new ArrayList<>();

    public CustomerOrder() {
        this(new Date());
    }

    public CustomerOrder(Date data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemOrdered> getItems() {
        return items;
    }
    
    public void setItems(List<ItemOrdered> items) {
        this.items = items;
    }

    public void addItem(ItemOrdered item) {
        items.add(item);
        item.setOrder(this);  // Ajusta a referência bidirecional
    }

    public void removeItem(ItemOrdered item) {
        items.remove(item);
        item.setOrder(null);  // Remove a referência bidirecional
    }
}
