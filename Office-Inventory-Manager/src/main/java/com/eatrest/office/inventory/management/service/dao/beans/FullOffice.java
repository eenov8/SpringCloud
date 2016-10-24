/**
 * 
 */
package com.eatrest.office.inventory.management.service.dao.beans;

import java.util.Arrays;

/**
 * @author Anurag Jain
 *
 */
public class FullOffice {
	private String title;
	private String description;
	private String details;
	private Address address;
	private AttributeParam[] amenities;
	private AttributeParam[] nearby;
	private AttributeParam[] freeFacilities;
	private AttributeParam[] paidFacilities;
	private String[] openDays;
	private String startHour;
	private String endHour;
	private String[] images;
	private String[] videos;
	private String instagramLink;
	private String fbLink;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the amenities
	 */
	public AttributeParam[] getAmenities() {
		return amenities;
	}

	/**
	 * @param amenities
	 *            the amenities to set
	 */
	public void setAmenities(AttributeParam[] amenities) {
		this.amenities = amenities;
	}

	/**
	 * @return the nearby
	 */
	public AttributeParam[] getNearby() {
		return nearby;
	}

	/**
	 * @param nearby
	 *            the nearby to set
	 */
	public void setNearby(AttributeParam[] nearby) {
		this.nearby = nearby;
	}

	/**
	 * @return the freeFacilities
	 */
	public AttributeParam[] getFreeFacilities() {
		return freeFacilities;
	}

	/**
	 * @param freeFacilities
	 *            the freeFacilities to set
	 */
	public void setFreeFacilities(AttributeParam[] freeFacilities) {
		this.freeFacilities = freeFacilities;
	}

	/**
	 * @return the paidFacilities
	 */
	public AttributeParam[] getPaidFacilities() {
		return paidFacilities;
	}

	/**
	 * @param paidFacilities
	 *            the paidFacilities to set
	 */
	public void setPaidFacilities(AttributeParam[] paidFacilities) {
		this.paidFacilities = paidFacilities;
	}

	/**
	 * @return the openDays
	 */
	public String[] getOpenDays() {
		return openDays;
	}

	/**
	 * @param openDays
	 *            the openDays to set
	 */
	public void setOpenDays(String[] openDays) {
		this.openDays = openDays;
	}

	/**
	 * @return the startHour
	 */
	public String getStartHour() {
		return startHour;
	}

	/**
	 * @param startHour
	 *            the startHour to set
	 */
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	/**
	 * @return the endHour
	 */
	public String getEndHour() {
		return endHour;
	}

	/**
	 * @param endHour
	 *            the endHour to set
	 */
	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	/**
	 * @return the images
	 */
	public String[] getImages() {
		return images;
	}

	/**
	 * @param images
	 *            the images to set
	 */
	public void setImages(String[] images) {
		this.images = images;
	}

	/**
	 * @return the videos
	 */
	public String[] getVideos() {
		return videos;
	}

	/**
	 * @param videos
	 *            the videos to set
	 */
	public void setVideos(String[] videos) {
		this.videos = videos;
	}

	/**
	 * @return the instagramLink
	 */
	public String getInstagramLink() {
		return instagramLink;
	}

	/**
	 * @param instagramLink
	 *            the instagramLink to set
	 */
	public void setInstagramLink(String instagramLink) {
		this.instagramLink = instagramLink;
	}

	/**
	 * @return the fbLink
	 */
	public String getFbLink() {
		return fbLink;
	}

	/**
	 * @param fbLink
	 *            the fbLink to set
	 */
	public void setFbLink(String fbLink) {
		this.fbLink = fbLink;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FullOffice [title=" + title + ", description=" + description + ", details=" + details + ", address="
				+ address + ", amenities=" + Arrays.toString(amenities) + ", nearby=" + Arrays.toString(nearby)
				+ ", freeFacilities=" + Arrays.toString(freeFacilities) + ", paidFacilities="
				+ Arrays.toString(paidFacilities) + ", openDays=" + Arrays.toString(openDays) + ", startHour="
				+ startHour + ", endHour=" + endHour + ", images=" + Arrays.toString(images) + ", videos="
				+ Arrays.toString(videos) + ", instagramLink=" + instagramLink + ", fbLink=" + fbLink + "]";
	}

	/**
	 * @param title
	 * @param description
	 * @param details
	 * @param address
	 * @param amenities
	 * @param nearby
	 * @param freeFacilities
	 * @param paidFacilities
	 * @param openDays
	 * @param startHour
	 * @param endHour
	 * @param images
	 * @param videos
	 * @param instagramLink
	 * @param fbLink
	 */
	public FullOffice(String title, String description, String details, Address address, AttributeParam[] amenities,
			AttributeParam[] nearby, AttributeParam[] freeFacilities, AttributeParam[] paidFacilities,
			String[] openDays, String startHour, String endHour, String[] images, String[] videos, String instagramLink,
			String fbLink) {
		super();
		this.title = title;
		this.description = description;
		this.details = details;
		this.address = address;
		this.amenities = amenities;
		this.nearby = nearby;
		this.freeFacilities = freeFacilities;
		this.paidFacilities = paidFacilities;
		this.openDays = openDays;
		this.startHour = startHour;
		this.endHour = endHour;
		this.images = images;
		this.videos = videos;
		this.instagramLink = instagramLink;
		this.fbLink = fbLink;
	}

	/**
	 * 
	 */
	public FullOffice() {
		super();
		// TODO Auto-generated constructor stub
	}

}
