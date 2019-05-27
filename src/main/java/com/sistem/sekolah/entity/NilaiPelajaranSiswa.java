package com.sistem.sekolah.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nilai_pelajaran_siswa")
public class NilaiPelajaranSiswa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, unique = true, nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "semester_kelas_pelajaran_id")
	private SemesterKelasPelajaran semesterKelasPelajaran;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SemesterKelasPelajaran getSemesterKelasPelajaran() {
		return semesterKelasPelajaran;
	}

	public void setSemesterKelasPelajaran(SemesterKelasPelajaran semesterKelasPelajaran) {
		this.semesterKelasPelajaran = semesterKelasPelajaran;
	}

}
