package com.ethics4eu.ethics4eu.entity;

import com.ethics4eu.ethics4eu.repository.PapersAttributeRepository;
import com.ethics4eu.ethics4eu.repository.TeacherPapersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PapersAttributeTest {

    @Autowired
    private PapersAttributeRepository papersAttributeRepository;
    @Autowired
    private TeacherPapersRepository teacherPapersRepository;

    /**
     * To Test if it's possible to read and write to the database
     */
    @Test
    public void saveNewPaperTest(){
        int result = -1;
        List<TeacherPapers> teacherPapersList = teacherPapersRepository.getTeacherPapersByName("HolsteinDodig-Crnkovic18");
        if(teacherPapersList.size() == 0){
            // Test insert the reference
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
            // Save the reference in the Database
            papersAttributeRepository.save(papersAttribute);
            // Read again the reference to check if it's in the database
            teacherPapersList = teacherPapersRepository.getTeacherPapersByName("HolsteinDodig-Crnkovic18");
            if(teacherPapersList.size() == 1){
                result = 1;
            }else{
                result = 0;
            }

        }else{
            if(teacherPapersList.size() == 1){
                // Delete the actual reference because already exists
                Long idTeacherPapers = teacherPapersList.get(0).getId();
                boolean exists = teacherPapersRepository.existsById(idTeacherPapers);
                if(!exists){
                    result = 0;
                }
                papersAttributeRepository.deleteById(idTeacherPapers);
                result = 1;
            }
        }
        Assertions.assertEquals(1, result);
    }

    /**
     * To Test if the reference is generated in the correct BibTeX format
     */
    @Test
    public void bibTexGeneratorTest(){
        int result = -1;
        String rawBibtexReference = "@inproceedings{ShahriariShahriari17, title={{IEEE standard review — Ethically aligned design: A vision for prioritizing human well-being with artificial intelligence and autonomous systems}}, author={Shahriari, Kyarash and Shahriari, Mana}, booktitle={2017 IEEE Canada International Humanitarian Technology Conference (IHTC)}, isbn={1509062645}, pages={197--201}, publisher={IEEE}, year={2017}, ethics4EU={Computing: AI. Ethics: Autonomy. Industry: Military, Economics}}";
        List<TeacherPapers> teacherPapersList = teacherPapersRepository.getTeacherPapersByName("ShahriariShahriari17");
        if(teacherPapersList.size() == 0){
            // Test insert the reference
            TeacherPapers paper = TeacherPapers.builder()
                    .p_id("ShahriariShahriari17")
                    .title("{IEEE standard review — Ethically aligned design: A vision for prioritizing human well-being with artificial intelligence and autonomous systems}")
                    .authors("Shahriari, Kyarash and Shahriari, Mana")
                    .build();

            PapersAttribute papersAttribute = PapersAttribute.builder()
                    .fieldType("inproceedings")
                    .booktitle("2017 IEEE Canada International Humanitarian Technology Conference (IHTC)")
                    .pages("197--201")
                    .year("2017")
                    .publisher("IEEE")
                    .isbn("1509062645")
                    .ethics4EU("Computing: AI. Ethics: Autonomy. Industry: Military, Economics")
                    .teacherPapers(paper)
                    .build();
            // Save the reference in the Database
            papersAttributeRepository.save(papersAttribute);
            // Read again the reference to check if it's in the database
            teacherPapersList = teacherPapersRepository.getTeacherPapersByName("ShahriariShahriari17");
            if(teacherPapersList.size() == 1){
                result = 1;
            }else{
                result = 0;
            }

        }else{
            if(teacherPapersList.size() == 1){
                // Delete the actual reference because already exists
                Long idTeacherPapers = teacherPapersList.get(0).getId();
                boolean exists = teacherPapersRepository.existsById(idTeacherPapers);
                if(!exists){
                    result = 0;
                }
                papersAttributeRepository.deleteById(idTeacherPapers);
                result = 1;
            }
        }
        // first part to test if it's possible to write and read from the database
        Assertions.assertEquals(1, result);

        String bibtexReference = "";
        // Extract the bibtex reference from the TeacherPapers object
        if(teacherPapersList.size() == 1){
            for(TeacherPapers paper:teacherPapersList){
                bibtexReference = paper.paperBibTex();
            }
        }
        // first part to test if the bibtex reference is well formated
        Assertions.assertEquals(rawBibtexReference, bibtexReference);
    }
}