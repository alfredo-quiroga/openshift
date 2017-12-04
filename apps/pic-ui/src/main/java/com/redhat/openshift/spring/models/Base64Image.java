package com.redhat.openshift.spring.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "base64_images")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Base64Image implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String base64String;

	public Base64Image() {
	}

	public void setId(Long id) {
		this.id = id;
	}

	@GeneratedValue
	@Id
	public Long getId() {
		return id;
	}

	@Column(name = "base64string", nullable = false)
	public String getBase64String() {
		return base64String;
	}

	public void setBase64String(String base64String) {
		this.base64String = base64String;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((base64String == null) ? 0 : base64String.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Base64Image other = (Base64Image) obj;
		if (base64String == null) {
			if (other.base64String != null) {
				return false;
			}
		} else if (!base64String.equals(other.base64String)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Base64Image [id=" + id + ", base64String=" + base64String + "]";
	}

}
