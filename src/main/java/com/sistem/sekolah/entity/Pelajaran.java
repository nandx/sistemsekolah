package com.sistem.sekolah.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "pelajaran", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "nama_pelajaran", "tingkat", "jurusan" }) })
public class Pelajaran {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, unique = true, nullable = false)
	private Integer id;

	@Column(name = "nama_pelajaran", length = 200)
	private String namaPelajaran;

	@Column(name = "tingkat", length = 2)
	private Integer tingkat;

	@Column(name = "jurusan", length = 200)
	private String jurusan;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamaPelajaran() {
		return namaPelajaran;
	}

	public void setNamaPelajaran(String namaPelajaran) {
		this.namaPelajaran = namaPelajaran;
	}

	public Integer getTingkat() {
		return tingkat;
	}

	public void setTingkat(Integer tingkat) {
		this.tingkat = tingkat;
	}

	public String getJurusan() {
		return jurusan;
	}

	public void setJurusan(String jurusan) {
		this.jurusan = jurusan;
	}

}
