package info.thecodinglive.member.model;

import javax.jdo.annotations.Unique;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "tbl_member")
@ToString
public class Member extends AbstractEntityModel{

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
  private String username;

  private String password;
  private String passwordConfirm;
  @Unique
  private String email;

  @Column(name = "role_name")
  @Enumerated(EnumType.STRING)
  private MemberRole role;
}
