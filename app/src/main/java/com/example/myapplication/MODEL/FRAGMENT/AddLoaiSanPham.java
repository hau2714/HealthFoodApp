package com.example.myapplication.MODEL.FRAGMENT;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MODEL.Loaisanpham;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class AddLoaiSanPham extends Fragment {

TextView ed_ten, ed_ma;
TextInputLayout til_maloai,til_tenloai;
int temp=0;
Button btnadd, btn_xoa_trang;
    View view;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.them_loai_san_pham, container, false);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.chipNavigationBar.setVisibility(View.GONE);
        anhXaView();
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maLoai = ed_ma.getText().toString();
                String tenLoai = ed_ten.getText().toString();
                if (validate(maLoai, tenLoai)) {
                    db.collection("LoaiSanPhams").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot doc : task.getResult()) {
                                    Loaisanpham lsp = doc.toObject(Loaisanpham.class);
                                    if (lsp.getMaLoai().equals(maLoai)) {
                                        Toast.makeText(getContext(), "Mã loại này đã tồn tại!", Toast.LENGTH_SHORT).show();
                                        return;
                                    }
                                }
                                Loaisanpham lsp = new Loaisanpham(maLoai, tenLoai, null);

                                db.collection("LoaiSanPhams").document(maLoai).set(lsp).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getContext(), "Thêm loại sản phẩm thành công", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }
                    });
                }

            }
        });

        btn_xoa_trang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed_ten.setText("");
                ed_ma.setText("");
            }
        });
        return view;
    }
    private void anhXaView(){
        ed_ten = view.findViewById(R.id.ed_tenloai);
        ed_ma = view.findViewById(R.id.ed_maloai);
        btnadd = view.findViewById(R.id.btn_add_loai);
        btn_xoa_trang = view.findViewById(R.id.btn_xoa_trang);
        til_maloai = view.findViewById(R.id.til_ed_ma_loai);
        til_tenloai =view.findViewById(R.id.til_ed_tenloai);
    }

    private boolean validate( String ma, String ten){
        if(ed_ma.getText().toString().trim().isEmpty()){
            til_maloai.setError("Mã loại  không đuọc để trống");
            temp++;
              }else{
            til_maloai.setError("");
        }
        if(ed_ma.getText().length()==0){
            til_tenloai.setError("Tên Loại không được để trống");
            temp++;
        }else{
            til_tenloai.setError("");
        }
        return  false;
    }


}