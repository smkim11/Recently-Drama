package com.example.jpa1105;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class CrudController {

    @Autowired
    DramaService dramaService;

    // 드라마 목록 페이지
    @RequestMapping("/drama")
    public String list(Model model) {
        // 드라마 데이터와 장르 데이터를 모델에 추가
        model.addAttribute("dramas", dramaService.findAll());
        model.addAttribute("genres", dramaService.getUniqueGenres()); // 장르 데이터 추가
        return "list";
    }

    @RequestMapping("/drama/{idx}")
    public String read(@PathVariable long idx, Model model) {
        model.addAttribute("drama", dramaService.findById(idx));
        return "read";
    }


    @RequestMapping("/drama/search")
    public String search(@ModelAttribute("title") String title, Model model) {
        List<DramaDTO> dramas = dramaService.search(title);

        if (dramas.isEmpty()) {
            model.addAttribute("errorMessage", "검색 결과가 없습니다.");
        }

        model.addAttribute("dramas", dramas);
        model.addAttribute("genres", dramaService.getUniqueGenres()); // 장르 데이터 추가
        return "list";
    }

    @RequestMapping("/drama/genre")
    public String searchByGenre(@RequestParam("genre") String genre, Model model) {
        List<DramaDTO> dramas = dramaService.searchByGenre(genre);

        if (dramas.isEmpty()) {
            model.addAttribute("errorMessage", "검색 결과가 없습니다.");
        }

        model.addAttribute("dramas", dramas);
        model.addAttribute("genres", dramaService.getUniqueGenres()); // 장르 데이터 추가
        return "list";
    }

    @RequestMapping("/director/{directorId}")
    public String read(@PathVariable String directorId, Model model) {
        model.addAttribute("director", dramaService.findByDirectorId(directorId));
        return "director";
    }
}
