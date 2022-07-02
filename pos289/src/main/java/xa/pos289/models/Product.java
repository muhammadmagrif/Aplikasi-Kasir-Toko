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
@Table(name="product")
public class Product {
	//inisiasi kolom menjadi primary key
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private Long Id;
		
		//inisiasi kolom yang memerlukan foreign key
		@ManyToOne
		@JoinColumn(name="variant_id", insertable=false, updatable=false)
		public Variant variant;
		
		@Column(name="variant_id")
		private Long variant_id;
		
		//inisiasi kolom unique
		@NotNull
		@Column(name="initial", length = 10, unique=true)
		private String Initial;
		
		//inisiasi kolom unique
		@NotNull
		@Column(name="name", length=50, unique=true)
		private String Name;
		
		@Nullable
		@Column(name="description", length=500)
		private String Description;
		
		@NotNull
		@Column(name="price")
		private double Price;
		
		@NotNull
		@Column(name="stock")
		private int Stock;
		
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

		public Variant getVariant() {
			return variant;
		}

		public void setVariant(Variant variant) {
			this.variant = variant;
		}

		public Long getVariant_id() {
			return variant_id;
		}

		public void setVariant_id(Long variant_id) {
			this.variant_id = variant_id;
		}

		public String getInitial() {
			return Initial;
		}

		public void setInitial(String initial) {
			Initial = initial;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}

		public double getPrice() {
			return Price;
		}

		public void setPrice(double price) {
			Price = price;
		}

		public int getStock() {
			return Stock;
		}

		public void setStock(int stock) {
			Stock = stock;
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
