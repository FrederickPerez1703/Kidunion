package com.kidunion;

import com.kidunion.members.domain.Members;
import com.kidunion.members.domain.MemberRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KidunionApplicationTests {

    @Mock
    MemberRepository memberRepository;
    @Mock
    Members members;

    @Test
    void contextLoads() {
        MockitoAnnotations.initMocks(this);
    }



}
