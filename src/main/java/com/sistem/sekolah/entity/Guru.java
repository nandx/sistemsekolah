package com.sistem.sekolah.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sistem.sekolah.constant.Status;

@Entity
@Table(name = "guru")
public class Guru {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, unique = true, nullable = false)
	private Integer id;

	@Column(name = "nama_guru", length = 200)
	private String namaGuru;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", length = 20)
	private Status status;


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamaGuru() {
		return namaGuru;
	}

	public void setNamaGuru(String namaGuru) {
		this.namaGuru = namaGuru;
	}

}
