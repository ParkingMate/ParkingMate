package com.app.parkingmate.service;


import com.app.parkingmate.domain.VO.UserVO;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

@Service
@Slf4j
public class KakaoService {
    public String getKaKaoAccessToken(String code){
        String accessToken = null;
        String requestURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(requestURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=1fd38d790204d58dbce4c9b70a0f5013"); // TODO REST_API_KEY 입력
            sb.append("&redirect_uri=http://localhost:10000/kakao/login"); // TODO 인가코드 받은 redirect_uri 입력
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            if(connection.getResponseCode() == 200){
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                String result = "";

                while((line = br.readLine()) != null){
                    result += line;
                }

                JsonElement element = JsonParser.parseString(result);
                accessToken = element.getAsJsonObject().get("access_token").getAsString();

                br.close();
                bw.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return accessToken;
    }

    public Optional<UserVO> getKaKaoInfo(String token){
        String requestURL = "https://kapi.kakao.com/v2/user/me";
        UserVO userVO = null;

        try {
            URL url = new URL(requestURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Bearer " + token);

            if(connection.getResponseCode() == 200){
                userVO = new UserVO();
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                String result = "";

                while((line = br.readLine()) != null){
                    result += line;
                }

                JsonElement element = JsonParser.parseString(result);
                JsonElement kakaoAccount = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
                JsonElement profile = kakaoAccount.getAsJsonObject().get("profile").getAsJsonObject();

                userVO.setKakaoEmail(kakaoAccount.getAsJsonObject().get("email").getAsString());
                userVO.setUserNickName(profile.getAsJsonObject().get("nickname").getAsString());
                userVO.setUserProfile(profile.getAsJsonObject().get("thumbnail_image_url").getAsString());
                userVO.setUserSnsLoginStatus(1);

                br.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return Optional.ofNullable(userVO);
    }
}
