package com.sistem.sekolah;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sistem.sekolah.constant.SemesterEnum;
import com.sistem.sekolah.constant.Status;
import com.sistem.sekolah.entity.Kelas;
import com.sistem.sekolah.entity.NilaiPelajaranSiswa;
import com.sistem.sekolah.entity.Pelajaran;
import com.sistem.sekolah.entity.SemesterKelas;
import com.sistem.sekolah.entity.SemesterKelasPelajaran;
import com.sistem.sekolah.entity.SemesterKelasSiswa;
import com.sistem.sekolah.entity.Siswa;
import com.sistem.sekolah.repository.KelasRepository;
import com.sistem.sekolah.repository.NilaiPelajaranSiswaRepository;
import com.sistem.sekolah.repository.PelajaranRepository;
import com.sistem.sekolah.repository.SemesterKelasPelajaranRepository;
import com.sistem.sekolah.repository.SemesterKelasRepository;
import com.sistem.sekolah.repository.SemesterKelasSiswaRepository;
import com.sistem.sekolah.repository.SiswaRepository;

@Component
public class InitialRelationDB {

	@Autowired
	private KelasRepository kelasRepository;
	@Autowired
	private SemesterKelasRepository semesterKelasRepository;
	@Autowired
	private PelajaranRepository pelajaranRepository;
	@Autowired
	private SemesterKelasPelajaranRepository semesterKelasPelajaranRepository;
	@Autowired
	private SiswaRepository siswaRepository;
	@Autowired
	private SemesterKelasSiswaRepository semesterKelasSiswaRepository;
	@Autowired
	private NilaiPelajaranSiswaRepository nilaiPelajaranRepository;

	@PostConstruct
	public void init() {
		initSemesterKelas("1A", 1, "TEKNIK MESIN", 2019, SemesterEnum.GANJIL);
		initSemesterKelas("1A", 1, "TATA BUSANA", 2019, SemesterEnum.GANJIL);
		
		initSemesterKelasPelajaran(2019, SemesterEnum.GANJIL,
				"1A", 1, "TATA BUSANA", "Fisika", 1, "TEKNIK MESIN");
		
		initSemesterKelasPelajaran(2019, SemesterEnum.GANJIL,
				"1A", 1, "TEKNIK MESIN", "Menjahit", 1, "TATA BUSANA");
		
		initSemesterKelasSiswa(2019, SemesterEnum.GANJIL, "1A", 1,
				"TATA BUSANA", "20190004", "Dewi", Status.AKTIF);
		initSemesterKelasSiswa(2019, SemesterEnum.GANJIL, "1A", 1,
				"TEKNIK MESIN", "20190002", "Abdul", Status.AKTIF);
		initSemesterKelasSiswa(2019, SemesterEnum.GANJIL, "1A", 1,
				"TATA BUSANA", "20190001", "Toni", Status.AKTIF);
		
		nilaiPelajaranSiswa(2019, SemesterEnum.GANJIL, "1A", 1,
				"TATA BUSANA", "Menjahit", 1, "TATA BUSANA");
		nilaiPelajaranSiswa(2019, SemesterEnum.GANJIL, "1A", 1,
				"TEKNIK MESIN", "Menjahit", 1, "TATA BUSANA");
	}
	
	private void initSemesterKelasPelajaran(Integer tahunAjaran, SemesterEnum semester,
		String namaKelas, Integer tingkat, String jurusan, String namaPelajaran,
		Integer tingkatPelajaran, String jurusanPelajaran) {
		Pageable pageable = PageRequest.of(0, 1);
		
		Page<Kelas> pageKelas = kelasRepository.findByNamaKelasAndTingkatAndJurusan(namaKelas,
				tingkat, jurusan,pageable);
		
		Page<Pelajaran> pagePelajaran = pelajaranRepository.findByNamaPelajaranAndTingkatAndJurusan(
				namaPelajaran, tingkatPelajaran, jurusanPelajaran, pageable);
		
		if (pageKelas.hasContent() && pagePelajaran.hasContent()) {
			
			Pelajaran pelajaran = pagePelajaran.getContent().get(0);
			Kelas kelas = pageKelas.getContent().get(0);
			
			Page<SemesterKelas> pageSemesterKelas = semesterKelasRepository.findByKelas(kelas, pageable);
			
			if(pageSemesterKelas.hasContent()) {
				System.out.println("true kedua");
				SemesterKelas sk = pageSemesterKelas.getContent().get(0);
				SemesterKelasPelajaran skp = semesterKelasPelajaranRepository
						.findByMasterSemesterAndPelajaran(sk, pelajaran);
				if(skp == null) {
					System.out.println("true ketiga");
					SemesterKelasPelajaran skpNew = new SemesterKelasPelajaran();
					skpNew.setMasterSemester(sk);
					skpNew.setPelajaran(pelajaran);
					semesterKelasPelajaranRepository.save(skpNew);
				}
			}
		}

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
	
	private void initSemesterKelasSiswa(Integer tahunAjaran, SemesterEnum semester,
			String namaKelas, Integer tingkat, String jurusan, String noInduk, String namaSiswa,
			Status statusSiswa) {
		Pageable pageable = PageRequest.of(0, 1);
		
		Page<Kelas> pageKelas = kelasRepository.findByNamaKelasAndTingkatAndJurusan(namaKelas,
				tingkat, jurusan,pageable);
		Page<Siswa> pageSiswa = siswaRepository.findByNamaSiswa(namaSiswa, pageable);
		if(pageKelas.hasContent() && pageSiswa.hasContent()) {
			Kelas kelas = pageKelas.getContent().get(0);
			Siswa siswa = pageSiswa.getContent().get(0);
			Page<SemesterKelas> pageSemesterKelas = semesterKelasRepository.findByKelas(kelas, pageable);
			SemesterKelas sk= pageSemesterKelas.getContent().get(0);
			if (pageSemesterKelas.hasContent()) {
				SemesterKelasSiswa skw = semesterKelasSiswaRepository.findByMasterSemesterAndSiswa(sk, siswa);
				if(skw == null) {
					SemesterKelasSiswa skwNew = new SemesterKelasSiswa();
					skwNew.setMasterSemester(sk);
					skwNew.setSiswa(siswa);
					semesterKelasSiswaRepository.save(skwNew);
				}
						
			}
		}
	}
	
	private void nilaiPelajaranSiswa(Integer tahunAjaran, SemesterEnum semester,
			String namaKelas, Integer tingkat, String jurusan, String namaPelajaran,
			Integer tingkatPelajaran, String jurusanPelajaran) {

		Pageable pageable = PageRequest.of(0, 1);
		Page<Kelas> pageKelas = kelasRepository.findByNamaKelasAndTingkatAndJurusan(namaKelas,
				tingkat, jurusan,pageable);
		
		//if use Repository findBySemesterKelasAndPelajaran But not working
		Page<Pelajaran> pagePelajaran = pelajaranRepository.findByNamaPelajaranAndTingkatAndJurusan(
				namaPelajaran, tingkatPelajaran, jurusanPelajaran, pageable);
		//Pelajaran pelajaran = pagePelajaran.getContent().get(0);
		
		if (pageKelas.hasContent() && pagePelajaran.hasContent()) {

			Kelas kelas = pageKelas.getContent().get(0);
			Page<SemesterKelas> pageSemesterKelas = semesterKelasRepository.findByKelas(kelas, pageable);
			
			if(pageSemesterKelas.hasContent()) {
				System.out.println("true kedua");
				SemesterKelas sk = pageSemesterKelas.getContent().get(0);
				Page<SemesterKelasPelajaran> semesterKelasPelajaranPage = 
				semesterKelasPelajaranRepository.findByMasterSemester
						(sk, pageable);
				
				if(semesterKelasPelajaranPage.hasContent()) {
					System.out.println("true ketiga");
					SemesterKelasPelajaran skp = semesterKelasPelajaranPage.getContent().get(0);
					NilaiPelajaranSiswa nps = nilaiPelajaranRepository.findBySemesterKelasPelajaran(skp);
					if(nps == null) {
						System.out.println("true keempat");
						NilaiPelajaranSiswa np = new NilaiPelajaranSiswa();
						np.setSemesterKelasPelajaran(skp);
						nilaiPelajaranRepository.save(np);
					}
				}
			}
		}
	}

}
