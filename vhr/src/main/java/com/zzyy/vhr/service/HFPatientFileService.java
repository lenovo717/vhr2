package com.zzyy.vhr.service;

import com.zzyy.vhr.mapper2.HFPatientFileMapper;
import com.zzyy.vhr.mapper.zzyy_hf_patient_file_newMapper;
import com.zzyy.vhr.model2.HFPatientFile;
import com.zzyy.vhr.model2.Patient;
import com.zzyy.vhr.model2.zzyy_hf_patient;
import com.zzyy.vhr.model2.zzyy_hf_patient_file_new;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HFPatientFileService {

    @Autowired
    HFPatientFileMapper hfPatientFileMapper;
    @Autowired
    zzyy_hf_patient_file_newMapper zzyy_hf_patient_file_newMapper;

    public HFPatientFile getPatientFileDetail(String patient_id)
    {
        return hfPatientFileMapper.getPatientFileDetail(patient_id);
    }

    public int updateHFPatientFileById(HFPatientFile hfPatientFile) {
        return hfPatientFileMapper.updateByPrimaryKey(hfPatientFile);
    }

    public int batchInsertFile(String fileId,String patientId,String className, Map<String,String> fileMap) {
        zzyy_hf_patient_file_new file = new zzyy_hf_patient_file_new();
        //批量删除旧记录
        zzyy_hf_patient_file_newMapper.deletePatientFile(fileId,className);
        int rtn = 0;
        //批量插入新纪录
        for(Map.Entry<String, String> entry : fileMap.entrySet()){
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();

            file.setFileId(fileId);
            file.setPatientId(patientId);
            file.setClassName(className);
            file.setItem(mapKey);
            file.setValue(mapValue);
            rtn = zzyy_hf_patient_file_newMapper.insert(file);
        }
         return rtn;
        //return zzyy_hf_patient_file_newMapper.insert(hfPatientFile);
    }
    public List<HFPatientFile> getPatientFileList(HFPatientFile hfPatientFile) {
        //String message = "where JSON_EXTRACT(hzzz, '$.\"活动能力\"')='卧床'";
//        String wheresql = "where hzzz->'$.\"焦虑/抑郁\"'='无焦虑和抑郁'";
//        select * from zzyy_hf_visit_record r where 1=1 and hzzz->'$."日常活动"' LIKE '%困难%'
//        select * from zzyy_hf_visit_record r where 1=1 and JSON_EXTRACT(hzzz,'$."日常活动"') LIKE '%困难%' ;
        String message = "where JSON_CONTAINS(shfs,JSON_OBJECT('id', \"1\"))";
        return hfPatientFileMapper.getRecordsBySql(message);

    }

    public List<zzyy_hf_patient_file_new> getPatientFileInfos(String file_id) {
        return zzyy_hf_patient_file_newMapper.getPatientFileInfos(file_id);
    }

    public List<zzyy_hf_patient> getPatientQryFileList(List<String> qryCondition) {
        String condition = "";
        /*
         for (String j : qryCondition) {
            condition += j+" and ";
        }
        * */


        String[] aa={};
        for (int j = 0; j < qryCondition.size(); j++) {
                aa = qryCondition.get(j).split("\\|");
                System.out.println(aa);
                if(j<qryCondition.size()-1)
                    condition+= " item='"+aa[0]+"' and value"+aa[1]+"'"+aa[2]+"' and ";
                else
                    condition+= " item='"+aa[0]+"' and value"+aa[1]+"'"+aa[2]+"'";
        }
        List<zzyy_hf_patient> list =  zzyy_hf_patient_file_newMapper.getPatientFileByQry(condition);
        return list;
    }
}
