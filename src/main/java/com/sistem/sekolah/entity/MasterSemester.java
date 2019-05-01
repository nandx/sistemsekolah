package com.sistem.sekolah.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sistem.sekolah.entity.enumEntity.Semester;

@Entity
@Table(name = "master_semester")
public class MasterSemester {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, unique = true, nullable = false)
	private Integer id;

	@Column(name = "tahun_ajaran", length = 4, nullable = false)
	private Integer tahunAjaran;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Semester", length = 20)
	private Semester semester;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pelajaran_id")
	private Pelajaran pelajaran;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guru_id")
	private Guru guru;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kelas_id")
	private Kelas kelas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTahunAjaran() {
		return tahunAjaran;
	}

	public void setTahunAjaran(Integer tahunAjaran) {
		this.tahunAjaran = tahunAjaran;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Pelajaran getPelajaran() {
		return pelajaran;
	}

	public void setPelajaran(Pelajaran pelajaran) {
		this.pelajaran = pelajaran;
	}

	public Guru getGuru() {
		return guru;
	}

	public void setGuru(Guru guru) {
		this.guru = guru;
	}

	public Kelas getKelas() {
		return kelas;
	}

	public void setKelas(Kelas kelas) {
		this.kelas = kelas;
	}

}
