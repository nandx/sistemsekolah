package com.sistem.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistem.sekolah.entity.NilaiPelajaranSiswa;
import com.sistem.sekolah.entity.SemesterKelasPelajaran;

public interface NilaiPelajaranSiswaRepository extends JpaRepository<NilaiPelajaranSiswa, Integer>{
public NilaiPelajaranSiswa findBySemesterKelasPelajaran(SemesterKelasPelajaran semesterKelasPelajaran);
}
