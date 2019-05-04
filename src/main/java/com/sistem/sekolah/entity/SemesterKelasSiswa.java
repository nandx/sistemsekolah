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
@Table(name = "semester_kelas_siswa")
public class SemesterKelasSiswa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, unique = true, nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "master_semester_id")
	private SemesterKelas masterSemester;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "siswa_id")
	private Siswa siswa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SemesterKelas getMasterSemester() {
		return masterSemester;
	}

	public void setMasterSemester(SemesterKelas masterSemester) {
		this.masterSemester = masterSemester;
	}

	public Siswa getSiswa() {
		return siswa;
	}

	public void setSiswa(Siswa siswa) {
		this.siswa = siswa;
	}

}
