package com.sistem.sekolah.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sistem.sekolah.entity.Siswa;

public interface SiswaRepository extends JpaRepository<Siswa, Integer> {

	public Page<Siswa> findByNamaSiswa(String namaSiswa, Pageable pageable);

	public Siswa findByNomorInduk(String nomorInduk);
}
