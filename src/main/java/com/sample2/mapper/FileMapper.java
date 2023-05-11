package com.sample2.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sample2.model.FileDTO;

@Mapper
public interface FileMapper {

	// 파일 정보 등록
	public int insertFileInfoToDB(FileDTO fDto);
	
	// 파일 정보 가져오기
	public FileDTO getFileInfoFromDB(FileDTO fDto);
	
}
