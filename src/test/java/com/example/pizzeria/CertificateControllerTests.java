package com.example.pizzeria;

import com.example.pizzeria.entity.CertificateEntity;
import com.example.pizzeria.entity.UserEntity;
import com.example.pizzeria.model.Certificate;
import com.example.pizzeria.repository.CertificateRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CertificateControllerTests {
    @Mock
    CertificateRepo certificateRepo;

    @Captor
    ArgumentCaptor<CertificateEntity> captor;

    @Test
    void certificateGet(){
        CertificateEntity certificate = new CertificateEntity(new UserEntity("someUsername1", "someName1", "someLastname1", "somePass1", "someMail1"), new UserEntity("someUsername1", "someName1", "someLastname1", "somePass1", "someMail1"), 500, "23.09.2022");
        List<CertificateEntity> certificates = new ArrayList<>();
        certificates.add(certificate);
        when(certificateRepo.findAll()).thenReturn(certificates);
        CertificateEntity neededCertificate = new CertificateEntity();
        List<CertificateEntity> newCertificates = certificateRepo.findAll();
        for (CertificateEntity itCerficateEntity : newCertificates){
            if(itCerficateEntity.getId() == certificate.getId()){
                neededCertificate = itCerficateEntity;
            }
        }
        assertEquals(certificate.getId(), neededCertificate.getId());
    }

    @Test
    void certificatePost(){
        CertificateEntity certificate = new CertificateEntity(new UserEntity("someUsername1", "someName1", "someLastname1", "somePass1", "someMail1"), new UserEntity("someUsername1", "someName1", "someLastname1", "somePass1", "someMail1"), 500, "23.09.2022");
        when(certificateRepo.save(any())).thenReturn(certificate);
        CertificateEntity newCertificate = certificateRepo.save(certificate);
        verify(certificateRepo).save(captor.capture());
        CertificateEntity newnewCertificate = captor.getValue();
        assertEquals(certificate.getId(), newCertificate.getId());
        assertEquals(certificate.getId(), newnewCertificate.getId());
    }

    @Test
    void certificateDelete(){
        CertificateEntity certificate = new CertificateEntity(new UserEntity("someUsername1", "someName1", "someLastname1", "somePass1", "someMail1"), new UserEntity("someUsername1", "someName1", "someLastname1", "somePass1", "someMail1"), 500, "23.09.2022");
        CertificateEntity certificate2 = new CertificateEntity(new UserEntity("someUsername3", "someName3", "someLastname3", "somePass3", "someMail3"), new UserEntity("someUsername4", "someName4", "someLastname4", "somePass4", "someMail4"), 500, "23.09.2022");
        List<CertificateEntity> certificates = new ArrayList<>();
        List<CertificateEntity> certificates1 = new ArrayList<>();
        List<CertificateEntity> certificates2 = new ArrayList<>();
        certificates.add(certificate);
        certificates1.add(certificate);
        certificates2.add(certificate);
        certificates.add(certificate2);
        certificates2.add(certificate2);
        when(certificateRepo.findAll()).thenReturn(certificates);
        Iterable<CertificateEntity> newCertificates = certificateRepo.findAll();
        for (CertificateEntity itCertificate : newCertificates){
            if(itCertificate == certificate){
                certificates2.remove(itCertificate);
            }
        }
        assertEquals(certificates2.get(0).getId(), certificates1.get(0).getId());
    }
}
