package edu.snappydata.offset.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StarModel {
	public String id;
	@JsonProperty("visible_magnitude")
	public String visibleMagnitude;
	@JsonProperty("bayer_naming")
	public String bayerNaming;
	public String name;
	public long distance;
	public String link;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVisibleMagnitude() {
		return visibleMagnitude;
	}
	public void setVisibleMagnitude(String visibleMagnitude) {
		this.visibleMagnitude = visibleMagnitude;
	}
	public String getBayerNaming() {
		return bayerNaming;
	}
	public void setBayerNaming(String bayerNaming) {
		this.bayerNaming = bayerNaming;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDistance() {
		return distance;
	}
	public void setDistance(long distance) {
		this.distance = distance;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
