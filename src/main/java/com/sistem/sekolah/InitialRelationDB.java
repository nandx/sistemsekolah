package com.sistem.sekolah;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sistem.sekolah.constant.SemesterEnum;
import com.sistem.sekolah.entity.Kelas;
import com.sistem.sekolah.entity.SemesterKelas;
import com.sistem.sekolah.repository.KelasRepository;
import com.sistem.sekolah.repository.SemesterKelasRepository;

@Component
public class InitialRelationDB {

	@Autowired
	private KelasRepository kelasRepository;
	@Autowired
	private SemesterKelasRepository semesterKelasRepository;

	@PostConstruct
	public void init() {
		initSemesterKelas("1A", 1, "TEKNIK MESIN", 2019, SemesterEnum.GANJIL);
		initSemesterKelas("1A", 1, "TATA BUSANA", 2019, SemesterEnum.GANJIL);
	}

	private void initSemesterKelas(String namakelas, int tingkat, String jurusan, int tahunAjaran,
			SemesterEnum semester) {
		Pageable pageable = PageRequest.of(0, 1);
		Page<Kelas> pagekelas = kelasRepository.findByNamaKelasAndTingkatAndJurusan(namakelas, tingkat, jurusan,
				pageable);
		if (pagekelas.hasContent()) {
			Kelas kelas = pagekelas.getContent().get(0);
			SemesterKelas sk = semesterKelasRepository.findByKelasAndTahunAjaranAndSemester(kelas, tahunAjaran,
					semester);
			if (sk == null) {
				sk = new SemesterKelas();
				sk.setKelas(kelas);
				sk.setSemester(SemesterEnum.GENAP);
				sk.setTahunAjaran(2019);
				semesterKelasRepository.save(sk);
			}
		}
	}

}
