package com.min.edu.anno03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.min.edu.anno03.bean.NickName;

@Component
public class NickNameProp {

  @Autowired
  private NickName nickName;
  
  public NickNameProp() {
	  
}

public NickName getNickName() {
	return nickName;
}

public void setNickName(NickName nickName) {
	this.nickName = nickName;
}

@Override
public String toString() {
	return "NickNameProp [nickName=" + nickName + "]";
}
  
  
	
}
