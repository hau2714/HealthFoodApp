package com.example.myapplication.MODEL;

import java.util.List;

public class KhachHang extends User{
    List<DonHang> list;

    public KhachHang(String id, String name, String email, String password, String imgURL, boolean trangThaiTym, int loaiUser, int soSaoDanhGia, List<DonHang> list) {
        super(id, name, email, password, imgURL, trangThaiTym, loaiUser, soSaoDanhGia);
        this.list = list;
    }

    public List<DonHang> getList() {
        return list;
    }

    public void setList(List<DonHang> list) {
        this.list = list;
    }

    public KhachHang() {
        super();
    }

    public KhachHang(String id, String name, String email, String password, String imgURL, boolean trangThaiTym, int loaiUser, int soSaoDanhGia) {
        super(id, name, email, password, imgURL, trangThaiTym, loaiUser, soSaoDanhGia);
    }

    @Override
    public int getSoSaoDanhGia() {
        return super.getSoSaoDanhGia();
    }

    @Override
    public void setSoSaoDanhGia(int soSaoDanhGia) {
        super.setSoSaoDanhGia(soSaoDanhGia);
    }

    @Override
    public String getImgURL() {
        return super.getImgURL();
    }

    @Override
    public void setImgURL(String imgURL) {
        super.setImgURL(imgURL);
    }

    @Override
    public boolean isTrangThaiTym() {
        return super.isTrangThaiTym();
    }

    @Override
    public void setTrangThaiTym(boolean trangThaiTym) {
        super.setTrangThaiTym(trangThaiTym);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public int getLoaiUser() {
        return super.getLoaiUser();
    }

    @Override
    public void setLoaiUser(int loaiUser) {
        super.setLoaiUser(loaiUser);
    }
}