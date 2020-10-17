package com.nsw.backend.mard.p07.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p07.model.TbdDanhmuc07;
import com.nsw.backend.mard.p07.repositories.TbdDanhmuc07Repository;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mard/07/danhmuc")
public class CategoryController extends BaseController {
    private static final String LOAI = "LOAI";
    private static final String DANH_MUC_HANG_HOA = "DANH_MUC_HANG_HOA";
    private static final String PHAN_LOAI = "PHAN_LOAI";
    private static final String PHUONG_THUC_BAO_QUAN = "PHUONG_THUC_BAO_QUAN";

    private final TbdDanhmuc07Repository categoryRepository;

    @Autowired
    public CategoryController(TbdDanhmuc07Repository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("")
    public ResponseEntity<ResponseJson> getCategories(@RequestParam String type) {
        return createSuccessResponse(categoryRepository.findAllByFiTypeOrderByFiName(type), HttpStatus.OK);
    }

    @GetMapping("/init")
    @Profile("blameo_test")
    public ResponseEntity<ResponseJson> initCategories() {
        List<TbdDanhmuc07> listCategory = new ArrayList<>();
        listCategory.add(new TbdDanhmuc07(LOAI, "bo", "Bò"));
        listCategory.add(new TbdDanhmuc07(LOAI, "ca", "Cá"));
        listCategory.add(new TbdDanhmuc07(LOAI, "cuu", "Cừu"));
        listCategory.add(new TbdDanhmuc07(LOAI, "ga", "Gà"));
        listCategory.add(new TbdDanhmuc07(LOAI, "lon", "Lợn"));
        listCategory.add(new TbdDanhmuc07(LOAI, "lua", "Lừa"));
        listCategory.add(new TbdDanhmuc07(LOAI, "muc", "Mực"));
        listCategory.add(new TbdDanhmuc07(LOAI, "trau", "Trâu"));
        listCategory.add(new TbdDanhmuc07(LOAI, "vit", "Vịt"));

        listCategory.add(new TbdDanhmuc07(DANH_MUC_HANG_HOA, "thit", "Thịt"));
        listCategory.add(new TbdDanhmuc07(DANH_MUC_HANG_HOA, "pp_an_duoc", "Phụ phẩm ăn được"));
        listCategory.add(new TbdDanhmuc07(DANH_MUC_HANG_HOA, "pp__khong_an_duoc", "Phụ phẩm không ăn được"));


        listCategory.add(new TbdDanhmuc07(PHAN_LOAI, "thit", "Thịt"));
        listCategory.add(new TbdDanhmuc07(PHAN_LOAI, "da", "Da"));
        listCategory.add(new TbdDanhmuc07(PHAN_LOAI, "gan", "Gan"));
        listCategory.add(new TbdDanhmuc07(PHAN_LOAI, "luoi", "Lưỡi"));
        listCategory.add(new TbdDanhmuc07(PHAN_LOAI, "mo", "Mỡ"));
        listCategory.add(new TbdDanhmuc07(PHAN_LOAI, "sung", "Sừng"));
        listCategory.add(new TbdDanhmuc07(PHAN_LOAI, "chan", "Chân"));
        listCategory.add(new TbdDanhmuc07(PHAN_LOAI, "tim", "Tim"));
        listCategory.add(new TbdDanhmuc07(PHAN_LOAI, "xuong", "Xương"));

        listCategory.add(new TbdDanhmuc07(PHUONG_THUC_BAO_QUAN, "freeze", "Đông lạnh"));
        listCategory.add(new TbdDanhmuc07(PHUONG_THUC_BAO_QUAN, "room", "Nhiệt độ thường"));
        listCategory.add(new TbdDanhmuc07(PHUONG_THUC_BAO_QUAN, "fresh", "Tươi sống"));

        categoryRepository.deleteAll();
        categoryRepository.save(listCategory);
        return createSuccessResponse("", HttpStatus.OK);
    }

}
