package project.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the plumber_service_map_tbl database table.
 * 
 */
@Entity
@Table(name="plumber_service_map_tbl")
@NamedQuery(name="PlumberServiceMapTbl.findAll", query="SELECT p FROM PlumberServiceMapTbl p")
public class PlumberServiceMapTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="plumber_service_map_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int plumberServiceMapId;

	//bi-directional many-to-one association to BookingServiceMapTbl
	@OneToMany(mappedBy="plumberServiceMapTbl")
	private List<BookingServiceMapTbl> bookingServiceMapTbls;

	//bi-directional many-to-one association to PlumberInfoTbl
	@ManyToOne
	@JoinColumn(name="plumber_id")
	private PlumberInfoTbl plumberInfoTbl;

	
	//bi-directional many-to-one association to ServiceInfoTbl
	@ManyToOne
	@JoinColumn(name="service_id")
	private ServiceInfoTbl serviceInfoTbl;

	
	
	public PlumberServiceMapTbl() {
	}

	public int getPlumberServiceMapId() {
		return this.plumberServiceMapId;
	}

	public void setPlumberServiceMapId(int plumberServiceMapId) {
		this.plumberServiceMapId = plumberServiceMapId;
	}

	public List<BookingServiceMapTbl> getBookingServiceMapTbls() {
		return this.bookingServiceMapTbls;
	}

	public void setBookingServiceMapTbls(List<BookingServiceMapTbl> bookingServiceMapTbls) {
		this.bookingServiceMapTbls = bookingServiceMapTbls;
	}

	public BookingServiceMapTbl addBookingServiceMapTbl(BookingServiceMapTbl bookingServiceMapTbl) {
		getBookingServiceMapTbls().add(bookingServiceMapTbl);
		bookingServiceMapTbl.setPlumberServiceMapTbl(this);

		return bookingServiceMapTbl;
	}

	public BookingServiceMapTbl removeBookingServiceMapTbl(BookingServiceMapTbl bookingServiceMapTbl) {
		getBookingServiceMapTbls().remove(bookingServiceMapTbl);
		bookingServiceMapTbl.setPlumberServiceMapTbl(null);

		return bookingServiceMapTbl;
	}

	public PlumberInfoTbl getPlumberInfoTbl() {
		return this.plumberInfoTbl;
	}

	public void setPlumberInfoTbl(PlumberInfoTbl plumberInfoTbl) {
		this.plumberInfoTbl = plumberInfoTbl;
	}

	public ServiceInfoTbl getServiceInfoTbl() {
		return this.serviceInfoTbl;
	}

	public void setServiceInfoTbl(ServiceInfoTbl serviceInfoTbl) {
		this.serviceInfoTbl = serviceInfoTbl;
	}

	public PlumberServiceMapTbl(int id)
	{
		this.plumberServiceMapId = id;
	}
	
	public PlumberServiceMapTbl(PlumberInfoTbl plumberInfoTbl,ServiceInfoTbl serviceInfoTbl )
	{
		this.plumberInfoTbl= plumberInfoTbl;
		this.serviceInfoTbl = serviceInfoTbl;
	}
	
	
}