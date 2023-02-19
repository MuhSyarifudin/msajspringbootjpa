package com.juaracoding.msajspringbootjpa.model;/*
Created By IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author Syarifudin a.k.a. Muhamad Syarifuidn
Java Developer
Created on 19/02/2023 7:20
@Last Modified 19/02/2023 7:20
Version 1.1
*/

import com.juaracoding.msajspringbootjpa.utils.ConstantMessage;
import org.apache.tomcat.util.bcel.Const;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "MstTugasA")
public class TugasA {

    @Id
    @Column(name = "IDTugasA", nullable = false, length = 255)
    private String strIdTugasA;

    @NotEmpty(message = ConstantMessage.WARNING_TUGAS_A_NAME_CANNOT_EMPTY)
    @Length(message = ConstantMessage.WARNING_TUGAS_A_MAX_LENGTH_NAME, max = 40)
    @Column(name = "Nama", nullable = false, length = 40)
    private String strNama;
    @NotEmpty(message = ConstantMessage.WARNING_TUGAS_A_ALAMAT_CANNOT_EMPTY)
    @Length(message = ConstantMessage.WARNING_TUGAS_A_MAX_LENGTH_ALAMAT, max = 500)
    @Column(name = "Alamat", nullable = false, length = 500)
    private String strAlamat;

    @Column(name = "TanggalLahir", nullable = false)
    private LocalDate tanggalLahir;

    @Column(name = "JenisKelamin", nullable = false, length = 1)
    private Character jenisKelamin;

    @Column(name = "MasihHidup", nullable = false)
    private Boolean masihHidup;

    /*
    Start Audit
     */
    @Column(name = "CreatedDate", nullable = false, length = 7)
    private Date createdDate = new Date();

    @Column(name = "CreatedBy", nullable = false)
    private Integer createdBy;

    @Column(name = "ModifiedDate", length = 7)
    private Date modifiedDate;

    /*
    End Audit
    */
    @Column(name = "isDelete",nullable = false)
    private Short isDelete = 1;

    public void setStrIDTugasA(String strIDTugasA) {
        this.strIdTugasA = strIDTugasA;
    }

    public void setStrNama(String strNama) {
        this.strNama = strNama;
    }

    public void setStrAlamat(String strAlamat) {
        this.strAlamat = strAlamat;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public void setJenisKelamin(Character jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setMasihHidup(Boolean masihHidup) {
        this.masihHidup = masihHidup;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    public String getStrIDTugasA() {
        return strIdTugasA;
    }

    public String getStrNama() {
        return strNama;
    }

    public String getStrAlamat() {
        return strAlamat;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public Character getJenisKelamin() {
        return jenisKelamin;
    }

    public Boolean getMasihHidup() {
        return masihHidup;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public Short getIsDelete() {
        return isDelete;
    }
}
