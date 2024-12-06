package com.uptoser.ssm.concurrent.service;


import com.uptoser.ssm.concurrent.pojo.RedPacket;

public interface RedPacketService {
	
	public RedPacket getRedPacket(Long id);

	public int decreaseRedPacket(Long id);
	
}