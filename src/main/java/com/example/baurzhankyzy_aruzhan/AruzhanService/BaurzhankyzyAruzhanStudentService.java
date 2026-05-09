package com.example.baurzhankyzy_aruzhan.AruzhanService;

import com.example.baurzhankyzy_aruzhan.AruzhanDto.BaurzhankyzyAruzhanStudentDto;
import com.example.baurzhankyzy_aruzhan.AruzhanModel.BaurzhankyzyAruzhanStudent;
import com.example.baurzhankyzy_aruzhan.AruzhanRepository.BaurzhankyzyAruzhanStudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import java.util.concurrent.CompletableFuture;

@Slf4j // Для логирования
@Service
@RequiredArgsConstructor
public class BaurzhankyzyAruzhanStudentService {

    private final BaurzhankyzyAruzhanStudentRepository studentRepository;

    @Transactional
    public BaurzhankyzyAruzhanStudentDto createStudent(BaurzhankyzyAruzhanStudent student) {
        log.info("Baurzhankyzy Aruzhan: Creating new student - {} {}", student.getFirstName(), student.getLastName());

        BaurzhankyzyAruzhanStudent savedStudent = studentRepository.save(student);

        // Запускаем асинхронный процесс уведомления
        sendWelcomeNotification(savedStudent.getFirstName());

        return convertToDto(savedStudent);
    }

    @Async // Асинхронный процесс №1
    public void sendWelcomeNotification(String studentName) {
        try {
            log.info("Baurzhankyzy Aruzhan: Starting async notification for {}", studentName);
            Thread.sleep(3000); // Имитируем долгую отправку письма
            log.info("Baurzhankyzy Aruzhan: Notification sent successfully to {}", studentName);
        } catch (InterruptedException e) {
            log.error("Baurzhankyzy Aruzhan: Async process failed", e);
        }
    }

    // Тот самый маппинг из Entity в DTO
    private BaurzhankyzyAruzhanStudentDto convertToDto(BaurzhankyzyAruzhanStudent student) {
        return BaurzhankyzyAruzhanStudentDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .bio(student.getProfile() != null ? student.getProfile().getBio() : "No bio")
                .departmentName(student.getDepartment() != null ? student.getDepartment().getName() : "General")
                .build();
    }

    public Page<BaurzhankyzyAruzhanStudentDto> getAllStudents(String firstName, Pageable pageable) {
        log.info("Baurzhankyzy Aruzhan: Fetching students with filter: {}", firstName);

        Specification<BaurzhankyzyAruzhanStudent> spec = (root, query, cb) -> {
            if (firstName == null || firstName.isEmpty()) return cb.conjunction();
            return cb.like(cb.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%");
        };

        return studentRepository.findAll(spec, pageable).map(this::convertToDto);
    }
}