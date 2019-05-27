package com.sistem.sekolah;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sistem.sekolah.constant.Status;
import com.sistem.sekolah.entity.AppUser;
import com.sistem.sekolah.entity.Guru;
import com.sistem.sekolah.entity.Kelas;
import com.sistem.sekolah.entity.Pelajaran;
import com.sistem.sekolah.entity.Siswa;
import com.sistem.sekolah.repository.GuruRepository;
import com.sistem.sekolah.repository.KelasRepository;
import com.sistem.sekolah.repository.PelajaranRepository;
import com.sistem.sekolah.repository.SiswaRepository;
import com.sistem.sekolah.repository.UserAppRepository;
import com.sistem.sekolah.service.AppUserService;

@Component
public class InitialDB {

	@Autowired
	private UserAppRepository userAppRepository;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private GuruRepository guruRepository;
	@Autowired
	private KelasRepository kelasRepository;
	@Autowired
	private SiswaRepository siswaRepository;
	@Autowired
	private PelajaranRepository pelajaranRepository;

	@PostConstruct
	public void init() {
		System.out.println("======== init data ======== " + new Date());
		initAppUser("admin", "admin", "ADMIN");
		initAppUser("guru", "guru", "GURU");
		initAppUser("siswa", "siswa", "SISWA");

		initGuru("Pak Budi");
		initGuru("Pak Yanto");
		initGuru("Bu Susi");
		initGuru("Bu Ida");

		initKelas("1A", 1, "TATA BUSANA");
		initKelas("1B", 1, "TATA BUSANA");
		initKelas("2A", 2, "TATA BUSANA");
		initKelas("2B", 2, "TATA BUSANA");
		initKelas("3A", 3, "TATA BUSANA");
		initKelas("3B", 3, "TATA BUSANA");

		initKelas("1A", 1, "TEKNIK MESIN");
		initKelas("1B", 1, "TEKNIK MESIN");
		initKelas("2A", 2, "TEKNIK MESIN");
		initKelas("2B", 2, "TEKNIK MESIN");
		initKelas("3A", 3, "TEKNIK MESIN");
		initKelas("3B", 3, "TEKNIK MESIN");

		initSiswa("Toni", "20190001");
		initSiswa("Abdul", "20190002");
		initSiswa("Sisca", "20190003");
		initSiswa("Dewi", "20190004");
		initSiswa("Dony", "20190005");

		initPelajaran("Bahasa Indonesia", 1, "TATA BUSANA");
		initPelajaran("Bahasa Indonesia", 2, "TATA BUSANA");
		initPelajaran("Bahasa Indonesia", 3, "TATA BUSANA");

		initPelajaran("Menjahit", 1, "TATA BUSANA");
		initPelajaran("Menjahit", 2, "TATA BUSANA");
		initPelajaran("Menjahit", 3, "TATA BUSANA");

		initPelajaran("Bahasa Indonesia", 1, "TEKNIK MESIN");
		initPelajaran("Bahasa Indonesia", 2, "TEKNIK MESIN");
		initPelajaran("Bahasa Indonesia", 3, "TEKNIK MESIN");

		initPelajaran("Fisika", 1, "TEKNIK MESIN");
		initPelajaran("Fisika", 2, "TEKNIK MESIN");
		initPelajaran("Fisika", 3, "TEKNIK MESIN");
	}

	private void initAppUser(String username, String password, String role) {
		AppUser user = userAppRepository.findByUsername(username);
		if (user == null) {
			user = new AppUser();
			user.setUsername(username);
			user.setPassword(password);
			user.setUserrole(role);
			appUserService.createUser(user);
		}
	}

	private void initGuru(String namaguru) {
		Pageable pageable = PageRequest.of(0, 1);
		Page<Guru> pageguru = guruRepository.findByNamaGuru(namaguru, pageable);
		if (!pageguru.hasContent()) {
			Guru guru = new Guru();
			guru.setNamaGuru(namaguru);
			guru.setStatus(Status.AKTIF);
			guruRepository.save(guru);
		}
	}

	private void initKelas(String namakelas, int tingkat, String jurusan) {
		Pageable pageable = PageRequest.of(0, 1);
		Page<Kelas> pagekelas = kelasRepository.findByNamaKelasAndTingkatAndJurusan(namakelas, tingkat, jurusan,
				pageable);
		if (!pagekelas.hasContent()) {
			Kelas kelas = new Kelas();
			kelas.setNamaKelas(namakelas);
			kelas.setTingkat(tingkat);
			kelas.setJurusan(jurusan);
			kelasRepository.save(kelas);
		}
	}

	private void initSiswa(String namasiswa, String nomorInduk) {
		Siswa data = siswaRepository.findByNomorInduk(nomorInduk);
		if (data == null) {
			Siswa siswa = new Siswa();
			siswa.setNamaSiswa(namasiswa);
			siswa.setNomorInduk(nomorInduk);
			siswa.setStatus(Status.AKTIF);
			siswaRepository.save(siswa);
		}
	}

	private void initPelajaran(String namaPelajaran, int tingkat, String jurusan) {
		Pelajaran data = pelajaranRepository.findByNamaPelajaranAndTingkatAndJurusan(namaPelajaran, tingkat, jurusan);
		if (data == null) {
			Pelajaran pelajaran = new Pelajaran();
			pelajaran.setNamaPelajaran(namaPelajaran);
			pelajaran.setJurusan(jurusan);
			pelajaran.setTingkat(tingkat);
			pelajaranRepository.save(pelajaran);
		}
	}

}
