package com.uptoser.ssm.concurrent.dao;

import com.uptoser.ssm.concurrent.pojo.RedPacket;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RedPacketDao {
	

	public RedPacket getRedPacket(Long id);
	

	public int decreaseRedPacket(Long id);
	

	public RedPacket getRedPacketForUpdate(Long id);

	
	public int decreaseRedPacketForVersion(@Param("id") Long id, @Param("version") Integer version);
	
}