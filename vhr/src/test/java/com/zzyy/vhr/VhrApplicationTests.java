package com.zzyy.vhr;

import com.zzyy.vhr.mapper.JoblevelMapper;
import com.zzyy.vhr.mapper2.PatientMapper;
import com.zzyy.vhr.mapper2.ZdUnitCodeMapper;
import com.zzyy.vhr.model.Joblevel;
import com.zzyy.vhr.model2.Patient;
import com.zzyy.vhr.model2.ZdUnitCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VhrApplicationTests {

    @Autowired
    JoblevelMapper mapper1 ;

    @Autowired
    ZdUnitCodeMapper mappper2;

    @Autowired
    PatientMapper mappper3;


    @Test
    void contextLoads() {
       //List<Joblevel> zc =  mapper1.getAllJobLevels();
       //System.out.println(zc);

        //List<ZdUnitCode> zz =  mappper2.getAllUnit();
        //System.out.println(zz);

        //List<Patient> p = mappper3.getPatientVisitDetailByProcedure("000880507600",-1,0);
        List<Patient> p = mappper3.getPatientDiagnosisByPage(1,10,"");
        System.out.println(p);
    }

}
