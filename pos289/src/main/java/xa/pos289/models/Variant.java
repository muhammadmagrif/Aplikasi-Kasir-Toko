package xa.pos289.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import javax.persistence.GenerationType;

@Entity
@Table(name="variant")
public class Variant {
	//inisiasi kolom menjadi primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	//inisiasi kolom yang memerlukan foreign key
	@ManyToOne
	@JoinColumn(name="category_id", insertable=false, updatable=false)
	public Category category;
	
	@Column(name="category_id")
	private Long category_id;
	
	//inisiasi kolom unique
	@NotNull
	@Column(name="initial", length = 10, unique=true)
	private String Initial;
	
	//inisiasi kolom unique
	@NotNull
	@Column(name="name", length=50, unique=true)
	private String Name;
	
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
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
