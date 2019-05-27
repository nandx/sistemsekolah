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
import javax.persistence.UniqueConstraint;

import com.sistem.sekolah.constant.SemesterEnum;

@Entity
@Table(name = "semester_kelas", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "tahun_ajaran", "semester", "kelas_id" }) })
public class SemesterKelas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, unique = true, nullable = false)
	private Integer id;

	@Column(name = "tahun_ajaran", length = 4, nullable = false)
	private Integer tahunAjaran;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "semester", length = 20)
	private SemesterEnum semester;

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

	public SemesterEnum getSemester() {
		return semester;
	}

	public void setSemester(SemesterEnum semester) {
		this.semester = semester;
	}

	public Kelas getKelas() {
		return kelas;
	}

	public void setKelas(Kelas kelas) {
		this.kelas = kelas;
	}

}
