package com.sistem.sekolah.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sistem.sekolah.entity.SemesterKelasSiswa;

public interface MasterSemesterSiswaRepository extends JpaRepository<SemesterKelasSiswa, Integer> {
	List<SemesterKelasSiswa> findByMasterSemesterId(Integer id);
}
