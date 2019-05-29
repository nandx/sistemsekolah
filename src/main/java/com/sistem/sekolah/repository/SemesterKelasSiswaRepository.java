package com.sistem.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistem.sekolah.entity.SemesterKelas;
import com.sistem.sekolah.entity.SemesterKelasSiswa;
import com.sistem.sekolah.entity.Siswa;

public interface SemesterKelasSiswaRepository extends JpaRepository<SemesterKelasSiswa, Integer>{
	public SemesterKelasSiswa findByMasterSemesterAndSiswa(SemesterKelas masterSemester, Siswa siswa);
}
