package com.sistem.sekolah.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.sekolah.entity.Guru;

@Repository
public interface GuruRepository extends JpaRepository<Guru, Integer> {

	public Page<Guru> findByNamaGuru(String namaGuru, Pageable pageable);

}
