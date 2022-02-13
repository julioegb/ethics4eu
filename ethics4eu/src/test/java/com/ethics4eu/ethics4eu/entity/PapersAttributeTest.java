package com.ethics4eu.ethics4eu.entity;

import com.ethics4eu.ethics4eu.repository.PapersAttributeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PapersAttributeTest {

    @Autowired
    private PapersAttributeRepository repository;

    @Test
    public void saveNewPaper(){

        TeacherPapers paper = TeacherPapers.builder()
                .p_id("HolsteinDodig-Crnkovic18")
                .title("Avoiding the intrinsic unfairness of the trolley problem")
                .authors("Holstein, Tobias and Dodig-Crnkovic, Gordana")
                .build();

        PapersAttribute papersAttribute = PapersAttribute.builder()
                .fieldType("inproceedings")
                .booktitle("Proceedings of the International Workshop on Software Fairness")
                .pages("32--37")
                .year("2018")
                .ethics4EU("Computing: AI. Ethics: Autonomy. Industry: Transport, Robotics")
                .teacherPapers(paper)
                .build();

        repository.save(papersAttribute);

//        TeacherPapers paper2 = TeacherPapers.builder()
//                .p_id("ShahriariShahriari17")
//                .title("{IEEE standard review — Ethically aligned design: A vision for prioritizing human well-being with artificial intelligence and autonomous systems}")
//                .authors("Shahriari, Kyarash and Shahriari, Mana")
//                .build();
//
//        PapersAttribute papersAttribute2 = PapersAttribute.builder()
//                .fieldType("inproceedings")
//                .booktitle("2017 IEEE Canada International Humanitarian Technology Conference (IHTC)")
//                .pages("197--201")
//                .year("2017")
//                .publisher("IEEE")
//                .isbn("1509062645")
//                .ethics4EU("Computing: AI. Ethics: Autonomy. Industry: Military, Economics")
//                .teacherPapers(paper2)
//                .build();
//
//        repository.save(papersAttribute2);
    }
}