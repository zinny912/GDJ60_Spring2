package com.iu.s1.member;


public class MemberDTO {
   
   private String id;
   private String pw;
   private String name;
   private String phone;
   private String email;
   private String address;
   private RoleDTO roleDTO;
   
   
   public String getAddress() {
	   return address;
   }
	public void setAddress(String address) {
		this.address = address;
	}
	   
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPw() {
      return pw;
   }
   public void setPw(String pw) {
      this.pw = pw;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getPhone() {
      return phone;
   }
   public void setPhone(String phone) {
      this.phone = phone;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public RoleDTO getRoleDTO() {
      return roleDTO;
   }
   public void setRoleDTO(RoleDTO roleDTO) {
      this.roleDTO = roleDTO;
   }

   

   

}