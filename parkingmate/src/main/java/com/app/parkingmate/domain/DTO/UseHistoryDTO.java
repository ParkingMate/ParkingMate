package com.app.parkingmate.domain.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
public class UseHistoryDTO {
//    이용내역 고유 id
//    not null
    private Integer UseHistoryId;
//    이용내역 카테고리
//    기본 값 : 이용 중
//    옵션 : 이용 중, 이용 완료, 취소
//    not null
    private String UseHistoryCategory;
//    이용내역 제목
//    1000자
//    not null
    private String UseHistoryTitle;
//    이용내역 본문
//    3000자
//    not null
    private  String UseHistoryContent;
//    이용날짜
//    not null
    private Date UseDate;
//    이용 시간
//    기본 값 : 30(분)
//    not null
    private Date UseTime;
//    생성 날짜
    private LocalDateTime CreateDate;
//    업데이트 날짜
    private LocalDateTime UpdateDate;

//    ================================ FK
//    예약 테이블 고유 id
//    not null
    private Integer ReservationId;
//    예약 테이블 예약 날짜
//    not null
    private Date ReservationDate;
    //    예약 요청 사항
//    1000자
    private String ReservationRequest;
    //    예약 번호
//    1000자
//    not null
    private String ReservationNumber;
    //    예약 상태
//    기본 값 : 결제 중
//    not null
    private String ReservationStatus;
//    ===========================================================
//    회원 테이블 회원 id
//    not null
    private Integer UserId;
    //    회원 닉네임
//    not null
    private String UserNickName;
    //    회원 이름
//    not null
    private String UserName;
    //    회원 패스워드
//    500자
//    not null
    private String UserPassword;
    //    회원 이메일
//    500자
//    not null
    private String UserEmail;
    //    회원 전화번호
//    not null
    private Integer UserPhoneNumber;
    //    회원 상태
//    기본 값 : 이용 중
//    옵션 : 이용 중, 정지, 탈퇴
//    not null
    private String UserStatus;
    //    회원 구분
//    기본 값 : 회원
//    옵션 : 회원 ,판매자
//    not null
    private String UserClass;
    //    회원 가입 날짜
//    not null
    private Date UserStartDate;
    //    회원탈퇴 일수
//    기본 값 : 0
    private Integer UserWithdrawalCount;
    //  회원 프로필
//  not null
    private  String UserProfile;
    //    SNS 로그인상태
//    기본 값 : 미사용
//    옵션 : 미사용, 카카오 로그인
    private String UserSnsLoginStatus;
//    ==========================================================
//    주차장 테이블 주차장 id
//    not null
    private Integer ParkingId;
    //    주차장 주소
//    3000자
//    not null
    private String ParkingAddress;
    //    주차장 카테고리
//    1000자
//    도시(시),(구)를 나타냄
    private String ParkingCategory;
    //    주차장 명
//    1000자
//    not null
    private String ParkingName;
    //    주차장내용(세부정보)
//    3000자
    private String ParkingContent;
    //    주차장 평점
//    기본 값 : 5
    private Integer ParkingGrade;
    //    주차장 이용 수
//    기본 값 : 0
    private  Integer ParkingUseCount;
    //    주차장 대여 금액(시간당)
//    기본 값 : 1000
    private Integer ParkingPrice;
    //    주차 면수
//    기본 값 : 5
//    not null
    private Integer Parking_Count;
}
