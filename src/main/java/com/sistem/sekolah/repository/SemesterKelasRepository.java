package com.sistem.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistem.sekolah.constant.SemesterEnum;
import com.sistem.sekolah.entity.Kelas;
import com.sistem.sekolah.entity.SemesterKelas;

public interface SemesterKelasRepository extends JpaRepository<SemesterKelas, Integer> {

	public SemesterKelas findByKelasAndTahunAjaranAndSemester(Kelas kelas, int tahunAjaran, SemesterEnum semester);

}
