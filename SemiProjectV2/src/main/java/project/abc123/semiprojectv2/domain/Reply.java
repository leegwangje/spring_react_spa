package project.abc123.semiprojectv2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "replys")
@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long rno;

   @Column(nullable = false)
   private String comments;

   @Column(nullable = false)
   private String userid;

   @CreationTimestamp
   @Column(insertable = false)
   private LocalDateTime regdate;

   @Column(nullable = false)
   private int ref;

//   @Column(nullable = false,insertable = false)
//   private int pno;

   // n:1 관계 : ManyToOne 에너테이션 사용
   // 주(1) 테이블에서 대상(n) 테이블의 관계 설정, 외래키는 주(n)에 설정
   //    JoinColumn : 외래키 컬럼 이름 지정
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="pno")
   @JsonIgnore   // stackoverflow 해결책 - DTO로 변환을 더 추천
   private Board board;
}
