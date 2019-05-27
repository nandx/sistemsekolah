package com.sistem.sekolah.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kelas")
public class Kelas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, unique = true, nullable = false)
	private Integer id;

	@Column(name = "nama_kelas", length = 200)
	private String namaKelas;

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

	public String getNamaKelas() {
		return namaKelas;
	}

	public void setNamaKelas(String namaKelas) {
		this.namaKelas = namaKelas;
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
