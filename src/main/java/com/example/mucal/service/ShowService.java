package com.example.mucal.service;

import com.example.mucal.domain.Show;
import com.example.mucal.domain.ShowSchedule;
import com.example.mucal.dto.ShowDto;
import com.example.mucal.repository.ShowRepository;
import com.example.mucal.repository.ShowScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;
    private final ShowScheduleRepository showScheduleRepository;

    @Transactional
    public void readJsonFile() throws Exception{

        JSONParser parser=new JSONParser();

        // JSON 파일 읽기
        Reader reader=new FileReader("C:\\Users\\82102\\Desktop\\논병아리\\인크\\instagram_extract.json");

        JSONArray jsonArray=(JSONArray) parser.parse(reader);
        List<String> img_list=new ArrayList<>();
        for (int i=0; i<jsonArray.size(); i++){
            JSONObject jsonObject=(JSONObject) jsonArray.get(i);
            String title=(String) jsonObject.get("title");
            String category=(String) jsonObject.get("category");
//            LocalDateTime pre_rsv=(LocalDateTime) jsonObject.get("pre_rsv");
//            LocalDateTime rsv=(LocalDateTime) jsonObject.get("rsv");
            String pre_rsv=(String) jsonObject.get("pre_rsv");
            String rsv=(String) jsonObject.get("rsv");
            List<String> pre_site= (List<String>) jsonObject.get("pre_site");
            List<String> site= (List<String>) jsonObject.get("site");
            List<String>img= (List<String>) jsonObject.get("img");
            for (Object s:img){
                img_list.add((String)s);
            }

            Show show;

            if (showRepository.existsByTitle(title)){
                System.out.println("이미 있어용");
                show=showRepository.findByTitle(title);
//                throw new Exception("이미 있어용");
            } else{
                show=new Show(title, category);
                showRepository.save(show);
            }

            if (pre_rsv!=null){
                System.out.println("adfs");
                ShowSchedule showSchedule1=new ShowSchedule(show, 1, pre_rsv, pre_site, img);
                showScheduleRepository.save(showSchedule1);
            }
            if (rsv!=null){
                ShowSchedule showSchedule2=new ShowSchedule(show, 0, rsv, site, img);
                showScheduleRepository.save(showSchedule2);
            }
        }
    }
}
