package com.sistem.sekolah.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.sekolah.entity.Pelajaran;

@Repository
public interface PelajaranRepository extends JpaRepository<Pelajaran, Integer> {

	public Pelajaran findByNamaPelajaranAndTingkatAndJurusan(String namaPelajaran, int tingkat, String jurusan);
	public Page<Pelajaran> findByNamaPelajaranAndTingkatAndJurusan(String namaPelajaran,
			int tingkat, String jurusan, Pageable pageable);
}
