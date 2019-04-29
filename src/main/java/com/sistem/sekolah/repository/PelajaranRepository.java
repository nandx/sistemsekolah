package com.sistem.sekolah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.sekolah.entity.Pelajaran;

@Repository
public interface PelajaranRepository extends JpaRepository<Pelajaran, Integer>{

}
