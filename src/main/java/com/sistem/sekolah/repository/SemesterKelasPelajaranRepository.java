package com.sistem.sekolah.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.sekolah.entity.Pelajaran;
import com.sistem.sekolah.entity.SemesterKelas;
import com.sistem.sekolah.entity.SemesterKelasPelajaran;

@Repository
public interface SemesterKelasPelajaranRepository extends JpaRepository<SemesterKelasPelajaran, Integer> {
	public Page<SemesterKelasPelajaran> findByMasterSemesterAndPelajaran(SemesterKelas masterSemester, Pelajaran pelajaran,Pageable pageable);

	public Page<SemesterKelasPelajaran> findByMasterSemester(SemesterKelas masterSemester, Pageable pageable);

	SemesterKelasPelajaran findByMasterSemesterAndPelajaran(SemesterKelas masterSemester, Pelajaran pelajaran);

}
