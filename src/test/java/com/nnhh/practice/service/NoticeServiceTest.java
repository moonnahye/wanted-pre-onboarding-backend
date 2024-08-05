package com.nnhh.practice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nnhh.practice.dto.NoticeSaveReqDto;
import com.nnhh.practice.model.Company;
import com.nnhh.practice.model.Notice;
import com.nnhh.practice.repository.CompanyRepository;
import com.nnhh.practice.repository.NoticeRepository;


@ExtendWith(MockitoExtension.class)
class NoticeServiceTest {

    @Mock
    private NoticeRepository noticeRepository;

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private NoticeService noticeService;


    @Test
    void testSaveNotice() {
    	//dto 값 설정
        NoticeSaveReqDto dto = new NoticeSaveReqDto();
        dto.setComId(1);
        dto.setPosition("Developer");
        dto.setCompensation(50000);
        dto.setContent("Job description");
        dto.setSkill("Java");
       
        Company company = new Company();
        company.setComId(1);
        company.setName("NH Company");
        company.setNation("Korea");
        company.setArea("Seoul");

        when(companyRepository.findById(1)).thenReturn(Optional.of(company));
        
        int result = noticeService.saveNotice(dto);
        
        assertThat(result).isEqualTo(1);
        
    }

    @Test
    void testGetNoticeList() {
        List<Notice> notices = Arrays.asList(new Notice(), new Notice());
        when(noticeRepository.findAll()).thenReturn(notices);

        List<Notice> result = noticeService.getNoticeList();

        assertThat(result).hasSize(2);
    }

    @Test
    void testGetNoticeDetail() {
        Notice notice = new Notice();
        notice.setId(1);
        when(noticeRepository.findById(1)).thenReturn(Optional.of(notice));

        Notice result = noticeService.getNoticeDetail(1);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1);
    }

    @Test
    void testDeleteNotice() {
        assertThatCode(() -> noticeService.deleteNotice(1))
            .doesNotThrowAnyException();
    }

    @Test
    void testUpdateNotice() {
    	
    	 // 설정
        Notice existingNotice = new Notice();
        existingNotice.setId(1);
        existingNotice.setPosition("Old Position");
        existingNotice.setCompensation(40000);
        existingNotice.setContent("Old Content");
        existingNotice.setSkill("Old Skill");

        when(noticeRepository.findById(1)).thenReturn(Optional.of(existingNotice));

        // 업데이트할 새로운 정보 설정
        Notice requestNotice = new Notice();
        requestNotice.setPosition("New Position");
        requestNotice.setCompensation(50000);
        requestNotice.setContent("New Content");
        requestNotice.setSkill("New Skill");

  
        noticeService.updateNotice(1, requestNotice);

        
        // 업데이트되었는지 확인
        assertThat(existingNotice.getPosition()).isEqualTo("New Position");
        assertThat(existingNotice.getCompensation()).isEqualTo(50000);
        assertThat(existingNotice.getContent()).isEqualTo("New Content");
        assertThat(existingNotice.getSkill()).isEqualTo("New Skill");
      
    }

    @Test
    void testGetNoticeByKeyword() {
        List<Notice> notices = Arrays.asList(new Notice(), new Notice());
        when(noticeRepository.findByContentContainingOrPositionContainingOrSkillContaining("Java", "Java", "Java"))
            .thenReturn(notices);

        List<Notice> result = noticeService.getNoticeByKeyword("Java");

        assertThat(result).hasSize(2);
    }

    @Test
    void testGetNoticeByComId() {
        List<Notice> notices = Arrays.asList(new Notice(), new Notice());
        when(noticeRepository.findByCompany_ComId(1)).thenReturn(notices);

        List<Notice> result = noticeService.getNoticeByComId(1);

        assertThat(result).hasSize(2);
    }
}