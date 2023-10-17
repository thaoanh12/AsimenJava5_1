package com.example.demo.controller;

import com.example.demo.entity.ChucVu;
import com.example.demo.repository.ChucVuRepository;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Controller
public class ChucVuController {
    @Autowired
    private ChucVuService chucVuService;
    @Autowired
    private ChucVuRepository chucVuRepository;

    @GetMapping("/chuc-vu/hien-thi")
    public String chucVuHienTHi(Model model, @RequestParam(name = "p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<ChucVu> ds = chucVuRepository.findAll(pageable);
        model.addAttribute("cv", ds);
        model.addAttribute("p", ds.getTotalElements());

        return "chucvu/ChucVu";
    }

    @GetMapping("/chuc-vu/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("cvs", chucVuService.detail(id).get());
        return "chucvu/ChucVu";
    }

    @PostMapping("/chuc-vu/add")
    public String add(@RequestParam("ma") String ma,
                      @RequestParam("ten") String ten
    ) {
        ChucVu ds = ChucVu.builder()
                .ma(ma)
                .ten(ten)
                .build();
        chucVuService.add(ds);
        return "redirect:/chuc-vu/hien-thi";
    }

    @PostMapping("/chuc-vu/update")
    public String update(@RequestParam("ma") String ma,
                         @RequestParam("ten") String ten,
                         @RequestParam("id") String id
    ) {
        ChucVu ds = ChucVu.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .build();
        chucVuService.update(ds);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/chuc-vu/remover/{id}")
    public String remover(@PathVariable("id") String id, Model model) {
        chucVuService.delete(UUID.fromString(id));
        return "redirect:/chuc-vu/hien-thi";
    }

}
