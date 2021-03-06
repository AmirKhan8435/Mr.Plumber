package project.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the feedback_tbl database table.
 */
@Entity
@Table(name="feedback_tbl")
@NamedQuery(name="FeedbackTbl.findAll", query="SELECT f FROM FeedbackTbl f")
public class FeedbackTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="feedback_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int feedbackId;

	private String comments;

	private int etiquette;

	private int overall;

	private int price;

	private int punctuality;

	private String review;

	private int service;

	//bi-directional many-to-one association to BookingServiceMapTbl
	@ManyToOne
	@JoinColumn(name="booking_service_id")
	private BookingServiceMapTbl bookingServiceMapTbl;

	public FeedbackTbl() {
	}

	public int getFeedbackId() {
		return this.feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getEtiquette() {
		return this.etiquette;
	}

	public void setEtiquette(int etiquette) {
		this.etiquette = etiquette;
	}

	public int getOverall() {
		return this.overall;
	}

	public void setOverall(int overall) {
		this.overall = overall;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPunctuality() {
		return this.punctuality;
	}

	public void setPunctuality(int punctuality) {
		this.punctuality = punctuality;
	}

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getService() {
		return this.service;
	}

	public void setService(int service) {
		this.service = service;
	}

	public BookingServiceMapTbl getBookingServiceMapTbl() {
		return this.bookingServiceMapTbl;
	}

	public void setBookingServiceMapTbl(BookingServiceMapTbl bookingServiceMapTbl) {
		this.bookingServiceMapTbl = bookingServiceMapTbl;
	}

}