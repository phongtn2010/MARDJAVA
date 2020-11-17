package com.nsw.backend.sbv.p01.service;

import com.nsw.backend.sbv.p01.model.*;
import java.util.List;

public interface GPTienTe1Service {

	public GPTienTe1 createGPTienTe1(GPTienTe1 pGPTienTe1);
	public GPTienTe1 updateGPTienTe1(long primaryKey, GPTienTe1 pGPTienTe1);
	public boolean deleteGPTienTe1(GPTienTe1 pGPTienTe1);
	public GPTienTe1 getGPTienTe1(long primaryKey);
	public List<GPTienTe1> getByIdCapGXNHoSo();
}