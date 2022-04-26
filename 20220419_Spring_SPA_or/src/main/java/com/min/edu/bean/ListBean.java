package com.min.edu.bean;

import java.util.List;

import com.min.edu.vo.BoardVo;
import com.min.edu.vo.MemberVo;

public class ListBean {
  
  private List<BoardVo> lists;
  private MemberVo mem;
  
  public void setLists(List<BoardVo> lists) {
	this.lists = lists;
}
  public void setMem(MemberVo mem) {
	this.mem = mem;
}
  
  //전체리스트
  public String getListForm() {
	  StringBuffer sb = new StringBuffer();
	  for (int i = 0; i < lists.size(); i++) {
		sb.append(listRowForm(lists.get(i)));
	}
	  return sb.toString();
  }
  
  
  //화면의 구성
  private String listRowForm(BoardVo boardVo) {
	StringBuffer sb = new StringBuffer();
    int n = mem.getAuth().equals("A")?7:5;
	sb.append("  <tr>                                                                                                      "  );
	if(mem.getAuth().equals("A")) {
		sb.append("      <td><input type='checkbox' name='chk' value='"+boardVo.getSeq()+"'></td>                                         "  );
	}
	sb.append("    <td>"+boardVo.getSeq()+"</td>                                                                                    "  );
	sb.append("    <td>                                                                                                    "  );
	sb.append("      <div class='panel-heading'>                                                                           "  );
	sb.append("      <a data-toggle='collapse' data-parent='#accordion' href='#collapse"+boardVo.getSeq()+"'>"+boardVo.getTitle()+"</a>          "  );
	sb.append("      </div>                                                                                                "  );
	sb.append("    </td>                                                                                                   "  );
	sb.append("    <td>"+boardVo.getId()+"</td>                                                                                       "  );
	sb.append("    <td>"+boardVo.getReadcount()+"</td>                                                                                "  );
	if(mem.getAuth().equals("A")) {
	sb.append("      <td>"+boardVo.getDelflag()+"</td>                                                                                "  );
	}
	sb.append("    <td>"+boardVo.getRegdate()+"</td>                                                                                  "  );
	sb.append("  </tr>                                                                                                     "  );
	sb.append("  <tr>                                                                                                      "  );
	sb.append("	<td colspan='"+n+"'>                                                                                           "  );
	sb.append("	  <div id='collapse"+boardVo.getSeq()+"' class='panel-collapse collapse'>                                             "  );
    sb.append("      <div class='form-group'>                                                                              "  );
    sb.append("        <label>내용</label>                                                                                  "  );
    sb.append("          <textarea rows='4' class='form-control' readonly>"+boardVo.getContent()+"</textarea>                         "  );
    sb.append("      </div>                                                                                                "  );
    sb.append("      <div>                                                                                                 "  );
    sb.append("        <div class='form-group'>                                                                            "  );
    
    //수정: 글이 내가 쓴 글이라면
    if(mem.getId().equals(boardVo.getId())) {
    	sb.append("              <input type='button' class='btn btn-primary' value='수정' onclick=\"modify(\'"+boardVo.getSeq()+"\')\">        "  );
    }
    
    //삭제: 내가 쓴 글 관리자 일때
    if(mem.getId().equals(boardVo.getId())||mem.getAuth().equals("A")) {
    	sb.append("              <input type='button' class='btn btn-primary' value='삭제' onclick=\"delete(\'"+boardVo.getSeq()+"\')\">        "  );
    }
    
    //답글: 나머지 U일때
    if(mem.getAuth().equals("U")) {
    	sb.append("              <input type='button' class='btn btn-primary' value='답글' onclick=\"reply(\'"+boardVo.getSeq()+"\')\"> ");
    }
    
    
    sb.append("        </div>                                                                                              "  );
    sb.append("      </div>                                                                                                "  );
    sb.append("    </div>                                                                                                  "  );
	sb.append("	</td>		                                                                                               "  );
	sb.append("  </tr>                                                                                                     "  );
	                                                                                                                    
	return sb.toString();
  }
  
  
  private String replyImage(int depth) {
	  StringBuffer sb = new StringBuffer();
	  for (int i = 0; i < depth; i++) {
		sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
	}
	  if(depth!=0) {
		  sb.append("<img src='./images/reply.png'>");
	  }
	  return sb.toString();
  }
	
}
