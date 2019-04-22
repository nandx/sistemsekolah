package com.sistem.sekolah.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.sekolah.entity.Kelas;

@Repository
public interface KelasRepository extends JpaRepository<Kelas, Integer> {

}
