package net.smart.web.code.dao;

import java.util.List;

import net.smart.web.domain.CommonCode;

public interface CodeDao {
	
	public void addCode(List<CommonCode> params);
	
	public List<CommonCode> getCodeList(CommonCode param);

}
