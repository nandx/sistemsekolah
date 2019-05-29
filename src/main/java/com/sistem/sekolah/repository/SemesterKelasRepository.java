package com.sistem.sekolah.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sistem.sekolah.constant.SemesterEnum;
import com.sistem.sekolah.entity.Kelas;
import com.sistem.sekolah.entity.SemesterKelas;

public interface SemesterKelasRepository extends JpaRepository<SemesterKelas, Integer> {

	public SemesterKelas findByKelasAndTahunAjaranAndSemester(Kelas kelas, int tahunAjaran,
			SemesterEnum semester);
	public Page<SemesterKelas> findByKelasAndTahunAjaranAndSemester(Kelas kelas, int tahunAjaran, SemesterEnum semester, Pageable pageable);
	
	public Page<SemesterKelas > findByKelas(Kelas kelas, Pageable pageable);
	public SemesterKelas findByKelas(Kelas kelas);

}
