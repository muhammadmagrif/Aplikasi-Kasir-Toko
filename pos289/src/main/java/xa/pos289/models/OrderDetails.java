package xa.pos289.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

@Entity
@Table(name="orderdetails")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name="order_header_id", insertable=false, updatable=false)
	public OrderHeader orderheader;
	
	@NotNull
	@Column(name="order_header_id")
	private Long OrderHeaderid;
	
	@ManyToOne
	@JoinColumn(name="product_id", insertable=false, updatable=false)
	public Product product;
	
	@NotNull
	@Column(name="product_id")
	private Long ProductId;
	
	
	@NotNull
	@Column(name="quantity")
	private int Quantity;
	
	@NotNull
	@Column(name="price")
	private int Price;
	
	@NotNull
	@Column(name="active")
	private Boolean Active;
	
	@NotNull
	@Column(name="create_by", length=50)
	private String Create_by;
	
	@NotNull
	@Column(name="create_date")
	private LocalDateTime Create_date;
	
	@Nullable
	@Column(name="modify_by", length=50)
	private String Modify_by;
	
	@Nullable
	@Column(name="modify_date")
	private LocalDateTime Modify_date;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public OrderHeader getOrderheader() {
		return orderheader;
	}

	public void setOrderheader(OrderHeader orderheader) {
		this.orderheader = orderheader;
	}

	public Long getOrderHeaderid() {
		return OrderHeaderid;
	}

	public void setOrderHeaderid(Long orderHeaderid) {
		OrderHeaderid = orderHeaderid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getProductId() {
		return ProductId;
	}

	public void setProductId(Long productId) {
		ProductId = productId;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public Boolean getActive() {
		return Active;
	}

	public void setActive(Boolean active) {
		Active = active;
	}

	public String getCreate_by() {
		return Create_by;
	}

	public void setCreate_by(String create_by) {
		Create_by = create_by;
	}

	public LocalDateTime getCreate_date() {
		return Create_date;
	}

	public void setCreate_date(LocalDateTime create_date) {
		Create_date = create_date;
	}

	public String getModify_by() {
		return Modify_by;
	}

	public void setModify_by(String modify_by) {
		Modify_by = modify_by;
	}

	public LocalDateTime getModify_date() {
		return Modify_date;
	}

	public void setModify_date(LocalDateTime modify_date) {
		Modify_date = modify_date;
	}
	
	
}
