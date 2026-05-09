package com.example.baurzhankyzy_aruzhan.AruzhanController;

import com.example.baurzhankyzy_aruzhan.AruzhanDto.BaurzhankyzyAruzhanStudentDto;
import com.example.baurzhankyzy_aruzhan.AruzhanModel.BaurzhankyzyAruzhanStudent;
import com.example.baurzhankyzy_aruzhan.AruzhanService.BaurzhankyzyAruzhanStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/aruzhan/students")
@RequiredArgsConstructor
public class BaurzhankyzyAruzhanStudentController {

    private final BaurzhankyzyAruzhanStudentService studentService;

    // Создание студента
    @PostMapping
    public ResponseEntity<BaurzhankyzyAruzhanStudentDto> createStudent(
            @Valid @RequestBody BaurzhankyzyAruzhanStudent student) { // @Valid запускает проверку
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    // Тот самый сложный эндпоинт: Пагинация, Сортировка, Поиск (заглушка для логики)
    @GetMapping
    public ResponseEntity<Page<BaurzhankyzyAruzhanStudentDto>> getAllStudents(
            @RequestParam(required = false) String firstName,
            Pageable pageable) {
        // Здесь позже добавим вызов метода поиска из сервиса
        return ResponseEntity.ok(studentService.getAllStudents(firstName, pageable));
    }
}