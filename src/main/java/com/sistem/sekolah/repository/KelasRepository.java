package com.sistem.sekolah.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.sekolah.entity.Kelas;

@Repository
public interface KelasRepository extends JpaRepository<Kelas, Integer> {

	public Page<Kelas> findByNamaKelasAndTingkatAndJurusan(String namaKelas, Integer tingkat, String jurusan,
			Pageable pageable);

}
