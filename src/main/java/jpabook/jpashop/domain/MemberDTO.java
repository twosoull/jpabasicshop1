package jpabook.jpashop.domain;

public class MemberDTO {

    private String username;

    public MemberDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
