package xa.pos289.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;

@Entity
@Table(name="orderheader")
public class OrderHeader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	@NotNull
	@Column(name="reference", length = 15)
	private String Reference;
	
	@NotNull
	@Column(name="amount")
	private int Amount;
	
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

	public String getReference() {
		return Reference;
	}

	public void setReference(String reference) {
		Reference = reference;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
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
