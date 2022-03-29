package com.min.edu.dto;

public class BoardVo {

	private String seq;
	private String id;
	private String title;
	private String content;
	private String ref;
	private String step;
	private String depth;
	private String delflag;
	private String regdate;

	public BoardVo() {
	}

	public BoardVo(String seq, String id, String title, String content, String ref, String step, String depth,
			String delflag, String regdate) {
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.delflag = delflag;
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "BoardVo [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", ref=" + ref
				+ ", step=" + step + ", depth=" + depth + ", delflag=" + delflag + ", regdate=" + regdate + "]";
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
