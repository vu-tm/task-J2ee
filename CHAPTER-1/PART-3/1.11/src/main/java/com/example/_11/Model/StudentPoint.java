package com.example._11.Model;

public class StudentPoint {

    private String mssv;
    private String hoTen;
    private double diemToan;
    private double diemVan;
    private double diemAnhVan;

    public StudentPoint() {}

    public StudentPoint(
            String mssv,
            String hoTen,
            double diemToan,
            double diemVan,
            double diemAnhVan
    ) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.diemToan = diemToan;
        this.diemVan = diemVan;
        this.diemAnhVan = diemAnhVan;
    }

    // Getter, Setter
    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(double diemToan) {
        this.diemToan = diemToan;
    }

    public double getDiemVan() {
        return diemVan;
    }

    public void setDiemVan(double diemVan) {
        this.diemVan = diemVan;
    }

    public double getDiemAnhVan() {
        return diemAnhVan;
    }

    public void setDiemAnhVan(double diemAnhVan) {
        this.diemAnhVan = diemAnhVan;
    }
}
